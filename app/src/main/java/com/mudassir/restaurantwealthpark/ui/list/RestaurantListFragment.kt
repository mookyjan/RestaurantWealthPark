package com.mudassir.restaurantwealthpark.ui.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mudassir.domain.entity.City
import com.mudassir.domain.entity.Food
import com.mudassir.restaurantwealthpark.R
import com.mudassir.restaurantwealthpark.databinding.RestaurantListFragmentBinding
import com.mudassir.restaurantwealthpark.di.module.ViewModelFactory
import com.mudassir.restaurantwealthpark.ui.list.adapter.*
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.Section
import dagger.android.support.AndroidSupportInjection
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class RestaurantListFragment : Fragment(),CityCallbacks {

    companion object {
        fun newInstance() = RestaurantListFragment()
    }

    private lateinit var mBinding: RestaurantListFragmentBinding
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: RestaurantListViewModel by viewModels { viewModelFactory }
    private var mAdapter = GroupieAdapter()
    private lateinit var mSection: Section
    private lateinit var mCitySection: Section
    private lateinit var mFoodSection:Section
    private lateinit var mCityList : ArrayList<CityItem>
    private lateinit var mFoodList : ArrayList<FoodItem>

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.restaurant_list_fragment,
            container,
            false
        )
        mBinding.viewModel = viewModel
        mBinding.lifecycleOwner=this
        return mBinding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViews()
        initRecycler()
        populateAdapter()

        observeEvents()

        mBinding.lySwipeRefresh.setProgressViewOffset(false, mBinding.root.height / 2, 500)

    }

    fun initViews(){
        mAdapter = GroupieAdapter()
        mAdapter.setOnItemClickListener(onItemClickListener)
    }

    private fun initRecycler() {
        mBinding.rvRestaurants.apply {
            this.layoutManager =
                LinearLayoutManager(context)
            layoutManager = this.layoutManager
//            mSection = Section()
//            mAdapter.add(mSection)
            adapter = mAdapter
        }
    }


    fun observeEvents(){
        viewModel.cityList.observe(viewLifecycleOwner, Observer {
//            mSection.add(HeaderItem(getString(R.string.txt_city_header)))
//            it.cities.forEach {
//                mSection.add(CityItem(it))
//            }
//            mSection.add(HeaderItem(getString(R.string.txt_food_header)))

            val cityItemList: MutableList<CityItem> = mutableListOf<CityItem>()
            it.cities.forEach {
                cityItemList.add(CityItem(it,this))
            }

            mCitySection.update(cityItemList)

            val foodItemList: MutableList<FoodItem> = mutableListOf<FoodItem>()
            it.foods.forEach {
                foodItemList.add(FoodItem(it))
            }

            mFoodSection.update(foodItemList)

        })
    }

    private fun populateAdapter(){
        // Update in place group

        // Update in place group
        val updatingCitySection = Section()
        val cityHeader = HeaderItem(getString(R.string.txt_city_header))
        updatingCitySection.setHeader(cityHeader)
        mCitySection = Section()
        mCityList = ArrayList()
        mCitySection.update(mCityList)
        updatingCitySection.add(mCitySection)
        mAdapter.add(updatingCitySection)

        val updatingFoodSection = Section()
        val foodItemHeader =HeaderItem(getString(R.string.txt_food_header))
        updatingFoodSection.setHeader(foodItemHeader)

        mFoodSection = Section()
        mFoodList = ArrayList()
        mFoodSection.update(mFoodList)
        updatingFoodSection.add(mFoodSection)
        mAdapter.add(updatingFoodSection)
    }

    override fun onCityItemClick(item: City) {

        viewModel.navigateToDetail(item)
    }

    private val onItemClickListener =
        OnItemClickListener { item, view ->
            if (item is FoodItem) {
                val cardItem: FoodItem = item as FoodItem
                Toast.makeText(requireContext(), "Item CLiekced $cardItem", Toast.LENGTH_SHORT).show()
//                viewModel.navigateToDetail()
            }
        }

}