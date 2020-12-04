package com.example.desafiowebservice.ui

import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiowebservice.enitities.ResultsHq
import com.example.desafiowebservice.services.Repository
import kotlinx.coroutines.launch
import java.lang.Exception
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class MainViewModel(val repository: Repository) : ViewModel() {

    val listaThumb = MutableLiveData<ArrayList<ResultsHq>>()


    fun thumbList(cont: Context) {
        viewModelScope.launch {
            try {
                var lista = repository.getResults(
                    1009610,
                    1,
                    10,
                    "1604590916",
                    "c05c5fe7cba8d491758c229c05533692",
                    "57dff3345e41bec1dbe6bef3476c0603"
                )
                listaThumb.value = lista.data.results
            } catch (e: Exception) {
                Toast.makeText(cont, "Verifique sua conexão com a internet", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun retornarLista(): ArrayList<ResultsHq> {
        return ArrayList<ResultsHq>(listaThumb.value)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun dateFormat(date: String): String? {
        val inputFormatter: DateTimeFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss-SSSS", Locale.ENGLISH)
        val outputFormatter: DateTimeFormatter =
            DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH)
        val date: LocalDate = LocalDate.parse(date, inputFormatter)

        return outputFormatter.format(date)
    }
}

