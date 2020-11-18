package com.example.superheroes.ui.superherodetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.superheroes.NavGraphArgs
import com.example.superheroes.R
import com.example.superheroes.databinding.FragmentSuperHeroDetailBinding
import com.example.superheroes.repository.SuperHeroDetailRepository
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuperHeroDetail : Fragment() {

    private val args: NavGraphArgs by navArgs()

    private val viewModel: SuperHeroDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSuperHeroDetailBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.image.setOnClickListener{
            viewModel.show()
        }

        return binding.root
    }

}