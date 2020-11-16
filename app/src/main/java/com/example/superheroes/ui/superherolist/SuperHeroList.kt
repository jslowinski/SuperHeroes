package com.example.superheroes.ui.superherolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.superheroes.R
import com.example.superheroes.databinding.FragmentSuperHeroDetailBinding
import com.example.superheroes.databinding.FragmentSuperHeroListBinding


class SuperHeroList : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSuperHeroListBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.showdetail.setOnClickListener {
            findNavController().navigate(SuperHeroListDirections.actionSuperHeroListToSuperHeroDetail())
        }

        return binding.root
    }

}