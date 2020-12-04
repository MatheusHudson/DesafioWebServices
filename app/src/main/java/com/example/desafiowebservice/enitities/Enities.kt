package com.example.desafiowebservice.enitities

import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

data class Res(val data: Data)

data class Data(val offset: Int, var results: ArrayList<ResultsHq>)

data class ResultsHq(val title: String,
                     val description: String,
                     val pageCount: Int,
                     val dates: ArrayList<DataComic>,
                     val prices: ArrayList<PrecoComic>,
                     val thumbnail: Images,
                   ) :Serializable

data class DataComic(val date: String) :Serializable

data class PrecoComic(val price: Float) :Serializable

data class Images(val path: String, val extension: String) :Serializable