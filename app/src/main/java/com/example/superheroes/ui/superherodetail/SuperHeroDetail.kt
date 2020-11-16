package com.example.superheroes.ui.superherodetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.superheroes.R
import com.example.superheroes.databinding.FragmentSuperHeroDetailBinding


class SuperHeroDetail : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSuperHeroDetailBinding.inflate(inflater)

        return binding.root
    }

}