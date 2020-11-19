package com.example.superheroes.ui.superherodetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.superheroes.NavGraphArgs
import com.example.superheroes.databinding.FragmentSuperHeroDetailBinding
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
        val binding = FragmentSuperHeroDetailBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.hero = viewModel

        viewModel.selectedProperty.observe(viewLifecycleOwner, {
            it?.apply {
                binding.intelligence.progress = it.powerStats.intelligence.toFloat()
                binding.intelligence.progressText = it.powerStats.intelligence
                binding.strength.progress = it.powerStats.strength.toFloat()
                binding.strength.progressText = it.powerStats.strength
                binding.speed.progress = it.powerStats.speed.toFloat()
                binding.speed.progressText = it.powerStats.speed
                binding.durability.progress = it.powerStats.durability.toFloat()
                binding.durability.progressText = it.powerStats.durability
                binding.power.progress = it.powerStats.power.toFloat()
                binding.power.progressText = it.powerStats.power
                binding.combat.progress = it.powerStats.combat.toFloat()
                binding.combat.progressText = it.powerStats.combat
            }
        })

        return binding.root
    }

}