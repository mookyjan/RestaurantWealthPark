package com.mudassir.restaurantwealthpark.ui.list.adapter

import com.mudassir.restaurantwealthpark.R
import com.mudassir.restaurantwealthpark.databinding.HeaderItemBinding
import com.xwray.groupie.databinding.BindableItem

class HeaderItem (private val title:String) : BindableItem<HeaderItemBinding>() {

    override fun getLayout() = R.layout.header_item

    override fun bind(viewBinding: HeaderItemBinding, position: Int) {
        viewBinding.tvHeader.text = title
    }
}