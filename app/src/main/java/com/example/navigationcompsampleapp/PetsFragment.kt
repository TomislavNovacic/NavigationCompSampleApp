package com.example.navigationcompsampleapp

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.parcel.Parcelize

class PetsFragment : Fragment(), OnPetClick {
    private lateinit var petList: ArrayList<Pet>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        petList = ArrayList()
        petList.add(Pet("Ben", "Pitbull"))
        petList.add(Pet("Max", "American stafford"))
        petList.add(Pet("Rocky", "Husky"))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_pets, container, false)
        val rv = rootView.findViewById<RecyclerView>(R.id.container)
        val adapter = PetsAdapter(petList, this)
        rv.adapter = adapter
        return rootView
    }

    override fun onPetClick(pet: Pet) {
        val petDetails = PetDetails("Ben", "Pitbull", "white", "50lbs", "45cm")
        val action = PetsFragmentDirections.actionPetsFragmentToPetDetailsFragment(petDetails)
        NavHostFragment.findNavController(this).navigate(action)
    }
}

@Parcelize
data class Pet(val name: String, val breed: String) : Parcelable

@Parcelize
data class PetDetails(val name: String, val breed: String, val color: String, val weight: String, val height: String) : Parcelable


