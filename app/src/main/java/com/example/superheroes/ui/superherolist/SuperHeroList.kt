package com.example.superheroes.ui.superherolist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.superheroes.databinding.FragmentSuperHeroListBinding
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.mikepenz.fastadapter.adapters.GenericFastItemAdapter
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class SuperHeroList : Fragment() {

    private lateinit var fastItemAdapter: GenericFastItemAdapter

    private val viewModel: SuperHeroListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSuperHeroListBinding.inflate(inflater)

        fastItemAdapter = FastItemAdapter()
        val gridLayoutManager = GridLayoutManager(context, 2)
        binding.rv.layoutManager = gridLayoutManager
        binding.rv.adapter = fastItemAdapter

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

//        viewModel.list.observe(viewLifecycleOwner, Observer { list ->
//            val model = ArrayList<SuperHeroListBindingItem>()
//            for (item in list) {
//                Log.e("Tag", item.toString())
//                val oneItem = SuperHeroListBindingItem()
//                oneItem.setModel(item)
//                model.add(oneItem)
//            }
//            fastItemAdapter.setNewList(model)
//        })

//        binding.showdetail.setOnClickListener {
//            viewModel.getList()
//            Log.e("Tag", viewModel.list.value.toString())
//        }

        viewModel.list.observe(viewLifecycleOwner, { date ->
            date?.apply {
                val model = ArrayList<SuperHeroListBindingItem>()
                for (item in date) {
                    val oneItem = SuperHeroListBindingItem()
                    oneItem.setModel(item)
                    model.add(oneItem)
                }
                fastItemAdapter.setNewList(model)
            }
        })

        fastItemAdapter.onClickListener = { _, _, item, _ -> onItemClicked(item as SuperHeroListBindingItem)}

        return binding.root
    }

    private fun onItemClicked(item: SuperHeroListBindingItem): Boolean {
        val superHero = item.model
        val action = SuperHeroListDirections.actionSuperHeroListToSuperHeroDetail(superHero!!.id.toString(), superHero.url)
        findNavController().navigate(action)
        return true
    }
}