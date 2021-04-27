package com.mudassir.restaurantwealthpark.ui.list.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.github.ajalt.timberkt.Timber
import com.mudassir.domain.entity.City
import com.mudassir.domain.entity.Food
import com.mudassir.restaurantwealthpark.R
import com.mudassir.restaurantwealthpark.databinding.SingleItemFoodBinding
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.OnItemLongClickListener
import com.xwray.groupie.databinding.BindableItem
import com.xwray.groupie.databinding.GroupieViewHolder

class FoodItem(private val food: Food,foodListener: Callbacks?=null) : BindableItem<SingleItemFoodBinding>() {
    override fun getLayout() = R.layout.single_item_food

    override fun bind(viewBinding: SingleItemFoodBinding, position: Int) {
        viewBinding.tvTitle.text = food.name
        viewBinding.ivFood.apply {
            Glide.with(this)
                .load(food.image)
                .into(this)
        }

        viewBinding.root.setOnClickListener (onClickListener)

    }

//    override fun bind(
//        viewBinding: SingleItemFoodBinding,
//        position: Int,
//        payloads: MutableList<Any>
//    ) {
//       payloads.forEach {
//           viewBinding.tvTitle.text = food.name
//           viewBinding.ivFood.apply {
//               Glide.with(this)
//                   .load(food.image)
//                   .into(this)
//           }
//
//       }
//    }

    private var callbacks: Callbacks? = null
    fun setupListener(listener: Callbacks?) {
        this.callbacks = listener
    }

    private val onClickListener = View.OnClickListener {
        foodListener?.onFoodItemClick(it, food)
    }

}

interface Callbacks {
    fun onFoodItemClick(view: View, item: Food)
}