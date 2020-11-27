package com.example.superheroes.ui.superherolist

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.superheroes.R
import com.example.superheroes.databinding.ItemSuperHeroBinding
import com.example.superheroes.model.SuperHero
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class SuperHeroListBindingItem(private val callback: HeroClick): AbstractBindingItem<ItemSuperHeroBinding>() {
    var model: SuperHero? = null

    fun setModel(model: SuperHero): SuperHeroListBindingItem{
        this.model = model
        return this
    }

    override val type: Int
        get() = R.id.superHeroListAdapterItemId

    override fun bindView(binding: ItemSuperHeroBinding, payloads: List<Any>) {
        binding.also {
            it.hero = model
            it.heroCallback = callback
        }
    }

    override fun unbindView(binding: ItemSuperHeroBinding) {
        binding.listTitle.text = null
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ItemSuperHeroBinding {
        return ItemSuperHeroBinding.inflate(inflater, parent, false)
    }
}

class HeroClick(val block: (SuperHero) -> Unit){
    fun onClick(superHero: SuperHero) = block(superHero)
}