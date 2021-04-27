package com.mudassir.restaurantwealthpark.ui.list.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.mudassir.domain.entity.City
import com.mudassir.domain.entity.Food
import com.mudassir.restaurantwealthpark.R
import com.mudassir.restaurantwealthpark.databinding.SingleItemCityBinding
import com.xwray.groupie.databinding.BindableItem

class CityItem (private val city: City,cityListener: CityCallbacks?=null) : BindableItem<SingleItemCityBinding>() {

    override fun getLayout() = R.layout.single_item_city

    override fun bind(viewBinding: SingleItemCityBinding, position: Int) {
        viewBinding.tvTitle.text = city.name
        viewBinding.tvDescription.text =city.description
        viewBinding.ivCity.apply {
            Glide.with(this)
                .load(city.image)
                .into(this)
        }
        viewBinding.root.setOnClickListener (onClickListener)
    }

    private val onClickListener = View.OnClickListener {
        cityListener?.onCityItemClick(city)
    }
}

interface CityCallbacks {
    fun onCityItemClick( item: City)
}