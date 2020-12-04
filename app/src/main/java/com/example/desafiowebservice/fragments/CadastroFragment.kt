package com.example.desafiowebservice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.desafiowebservice.R
import kotlinx.android.synthetic.main.layout_cadastro_center.view.*


class CadastroFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.activity_cadastro, container, false)
        view.btCadastro.setOnClickListener{
            findNavController().navigate(R.id.action_cadastroFragment_to_homeFragment)
        }
        return view
    }


}