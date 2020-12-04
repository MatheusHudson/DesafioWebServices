package com.example.desafiowebservice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.desafiowebservice.R
import com.example.desafiowebservice.ui.MainViewModel
import kotlinx.android.synthetic.main.layout_login_center.view.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.activity_main, container, false)
        view.btCadastro.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment2_to_homeFragment)
        }

        view.textCreateAccount.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment2_to_cadastroFragment)
        }

        return view
    }

}