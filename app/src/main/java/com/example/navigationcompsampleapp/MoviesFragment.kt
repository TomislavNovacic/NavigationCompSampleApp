package com.example.navigationcompsampleapp

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.parcel.Parcelize

class MoviesFragment : Fragment() {

    private lateinit var movieList: ArrayList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieList = ArrayList()
        movieList.add(Movie("Terminator", "1992"))
        movieList.add(Movie("Terminator 2", "1995"))
        movieList.add(Movie("Terminator 3", "1999"))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_movies, container, false)
        val rv = rootView.findViewById<RecyclerView>(R.id.container)
        val adapter = MoviesAdapter(movieList)
        rv.adapter = adapter
        return rootView
    }
}

@Parcelize
data class Movie(val title: String, val year: String) : Parcelable
