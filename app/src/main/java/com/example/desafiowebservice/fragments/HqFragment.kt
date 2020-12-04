package com.example.desafiowebservice.fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.desafiowebservice.R
import com.example.desafiowebservice.enitities.ResultsHq
import com.example.desafiowebservice.services.repository
import com.example.desafiowebservice.ui.MainViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_hq_details.view.*
import java.io.Serializable


class HqFragment : Fragment() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel by viewModels<MainViewModel> {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return MainViewModel(repository) as T
                }
            }
        }

        val view = inflater.inflate(R.layout.fragment_hq_details, container, false)

        var mBundle =  Bundle();
        if(mBundle != null ) {
            mBundle = requireArguments();
        }
        var arrayHq =  mBundle.getSerializable("array") as ResultsHq


        Picasso.get().load(arrayHq.thumbnail.path + "." + arrayHq.thumbnail.extension).fit().into(view.imageHqDetail)

        Log.i("array", arrayHq.dates[0].date)
        view.textTitleHq.text = arrayHq.title

        view.textPrice.text = "$ ${arrayHq.prices[0].price}"
        view.textPages.text = arrayHq.pageCount.toString()
        view.textData.text = viewModel.dateFormat(arrayHq.dates[0].date)

        view.backArrow.setOnClickListener {
            (activity as AppCompatActivity).onBackPressed()
        }

        if(arrayHq.description != null) {
            view.textDescriptionHq.text = arrayHq.description
        } else {
            view.textDescriptionHq.text = "Sorry, this comic doesn't have a description it moment!"
        }


        view.imageHqDetail.setOnClickListener{
            val bundle = Bundle()
            bundle.putSerializable("array", arrayHq as Serializable)
            arguments = bundle

            findNavController().navigate(R.id.action_hqFragment_to_thumbDetailFragment, bundle)
        }

        return view
    }

}