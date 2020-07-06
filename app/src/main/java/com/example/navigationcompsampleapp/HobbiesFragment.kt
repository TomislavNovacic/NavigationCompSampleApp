package com.example.navigationcompsampleapp

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.parcel.Parcelize

class HobbiesFragment : Fragment() {
    private lateinit var hobbyList: ArrayList<Hobby>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hobbyList = ArrayList()
        hobbyList.add(Hobby("Trčanje"))
        hobbyList.add(Hobby("Planinarenje"))
        hobbyList.add(Hobby("Biciklizam"))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_hobbies, container, false)
        val rv = rootView.findViewById<RecyclerView>(R.id.container)
        val adapter = HobbiesAdapter(hobbyList)
        rv.adapter = adapter
        return rootView
    }
}

@Parcelize
data class Hobby(val name: String) : Parcelable
