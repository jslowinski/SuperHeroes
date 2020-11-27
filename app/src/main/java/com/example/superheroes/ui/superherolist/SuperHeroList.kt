package com.example.superheroes.ui.superherolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.superheroes.databinding.FragmentSuperHeroListBinding
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.mikepenz.fastadapter.adapters.GenericFastItemAdapter
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class SuperHeroList : Fragment() {

    private lateinit var fastItemAdapter: GenericFastItemAdapter

    private val viewModel: SuperHeroListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSuperHeroListBinding.inflate(inflater)

        fastItemAdapter = FastItemAdapter()
        val gridLayoutManager = GridLayoutManager(context, 2)
        binding.rv.layoutManager = gridLayoutManager
        binding.rv.adapter = fastItemAdapter

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.list.observe(viewLifecycleOwner, { data ->
            data?.apply {
                val model = ArrayList<SuperHeroListBindingItem>()
                for (item in data) {
                    val oneItem = SuperHeroListBindingItem(HeroClick {
                        val action = SuperHeroListDirections.actionSuperHeroListToSuperHeroDetail(it.id.toString(), it.url)
                        findNavController().navigate(action)
                    })
                    oneItem.setModel(item)
                    model.add(oneItem)
                }
                fastItemAdapter.setNewList(model)
            }
        })

        return binding.root
    }
}