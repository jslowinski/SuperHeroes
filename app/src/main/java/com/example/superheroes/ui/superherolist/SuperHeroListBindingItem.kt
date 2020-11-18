package com.example.superheroes.ui.superherolist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.superheroes.R
import com.example.superheroes.databinding.ItemSuperHeroBinding
import com.example.superheroes.model.SuperHero
import com.mikepenz.fastadapter.IExpandable
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.mikepenz.fastadapter.binding.BindingViewHolder

class SuperHeroListBindingItem: AbstractBindingItem<ItemSuperHeroBinding>() {
    var model: SuperHero? = null

    fun setModel(model: SuperHero): SuperHeroListBindingItem{
        this.model = model
        return this
    }

    override val type: Int
        get() = R.id.superHeroListAdapterItemId

    override fun bindView(binding: ItemSuperHeroBinding, payloads: List<Any>) {
        binding.listTitle.text = model?.name
        Glide.with(binding.listImage.context).load(model!!.url).fitCenter().into(binding.listImage)
    }

    override fun unbindView(binding: ItemSuperHeroBinding) {
        binding.listTitle.text = null
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ItemSuperHeroBinding {
        return ItemSuperHeroBinding.inflate(inflater, parent, false)
    }
}