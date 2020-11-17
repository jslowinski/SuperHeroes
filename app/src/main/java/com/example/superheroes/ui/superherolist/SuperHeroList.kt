package com.example.superheroes.ui.superherolist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.superheroes.databinding.FragmentSuperHeroListBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.*


@AndroidEntryPoint
class SuperHeroList : Fragment() {

    private val viewModel: SuperHeroListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSuperHeroListBinding.inflate(inflater)

        binding.lifecycleOwner = this

        viewModel.list.observe(viewLifecycleOwner, Observer { list ->
            binding.testText.text = list.toString()

        })

        binding.showdetail.setOnClickListener {
            viewModel.getList()
            Log.e("Tag", viewModel.list.value.toString())
        }

        return binding.root
    }
}