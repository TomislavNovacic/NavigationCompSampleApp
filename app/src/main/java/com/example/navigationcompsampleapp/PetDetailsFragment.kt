package com.example.navigationcompsampleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class PetDetailsFragment : Fragment() {

    private val args: PetDetailsFragmentArgs by navArgs()
    private lateinit var petDetails: PetDetails

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        petDetails = args.petDetails
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_pet_details, container, false)
        rootView.findViewById<TextView>(R.id.name).text = petDetails.name
        rootView.findViewById<TextView>(R.id.breed).text = petDetails.breed
        rootView.findViewById<TextView>(R.id.color).text = petDetails.color
        rootView.findViewById<TextView>(R.id.weight).text = petDetails.weight
        rootView.findViewById<TextView>(R.id.height).text = petDetails.height
        return rootView
    }
}
