package com.example.desafiowebservice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.desafiowebservice.R
import com.example.desafiowebservice.enitities.ResultsHq
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_hq_details.view.*
import kotlinx.android.synthetic.main.fragment_thumb_detail.view.*


class ThumbDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_thumb_detail, container, false)

        var mBundle =  Bundle();
        if(mBundle != null ) {
            mBundle = requireArguments();
        }
        var arrayHq =  mBundle.getSerializable("array") as ResultsHq
        Picasso.get().load(arrayHq.thumbnail.path + "." + arrayHq.thumbnail.extension).fit().into(view.imageDetail)

        view.close.setOnClickListener{
            (activity as AppCompatActivity).onBackPressed()
        }
        return view
    }
}