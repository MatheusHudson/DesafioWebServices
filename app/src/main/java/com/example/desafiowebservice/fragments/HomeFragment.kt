package com.example.desafiowebservice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiowebservice.R
import com.example.desafiowebservice.adapter.HqAdapter
import com.example.desafiowebservice.services.repository
import com.example.desafiowebservice.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment(), HqAdapter.OnclickThumbnail {
    lateinit var adapterResult: HqAdapter
    lateinit var linearLayoutManager: LinearLayoutManager



    val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel.thumbList(requireActivity())
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        adapterResult = HqAdapter(this)

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        view.recyclerView.adapter = adapterResult
        view.recyclerView.layoutManager =
            GridLayoutManager(activity, 3, GridLayoutManager.VERTICAL, false)
        view.recyclerView.hasFixedSize()

        viewModel.listaThumb.observe(viewLifecycleOwner) {

            adapterResult.addList(it)

        }

        return view
    }

    override fun onClickThumbnail(position: Int) {
        val bundle = Bundle()
        var array = viewModel.retornarLista()[position]
        bundle.putSerializable("array", array)
        arguments = bundle
        findNavController().navigate(R.id.action_homeFragment_to_hqFragment, bundle)
    }
}