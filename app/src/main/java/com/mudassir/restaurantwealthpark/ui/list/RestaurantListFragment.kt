package com.mudassir.restaurantwealthpark.ui.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mudassir.domain.entity.City
import com.mudassir.restaurantwealthpark.R
import com.mudassir.restaurantwealthpark.databinding.RestaurantListFragmentBinding
import com.mudassir.restaurantwealthpark.di.module.ViewModelFactory
import com.mudassir.restaurantwealthpark.ui.list.adapter.*
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.Section
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.restaurant_list_fragment.*
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
    lateinit var mAdapter : GroupieAdapter
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
        initRecycler()
        populateAdapter()
        observeEvents()
        mBinding.lySwipeRefresh.setProgressViewOffset(false, mBinding.root.height / 2, 500)

    }


    private fun initRecycler() {
        mAdapter= GroupieAdapter()
        mBinding.rvRestaurants.apply {
            this.layoutManager =
                LinearLayoutManager(context)
            layoutManager = this.layoutManager
            adapter = mAdapter
        }
    }


    fun observeEvents(){
        viewModel.cityList.observe(viewLifecycleOwner, Observer {
            val cityItemList: MutableList<CityItem> = mutableListOf<CityItem>()
            it.cities.forEach {
                cityItemList.add(CityItem(it, this))
            }

            mCitySection.update(cityItemList)

            val foodItemList: MutableList<FoodItem> = mutableListOf<FoodItem>()
            it.foods.forEach {
                foodItemList.add(FoodItem(it))
            }

            mFoodSection.update(foodItemList)

            // You can also do this by forcing a change with payload
            mBinding.rvRestaurants.post { mBinding.rvRestaurants.invalidateItemDecorations() }

        })

        viewModel.loading.observe(viewLifecycleOwner, Observer {
            showHideProgress(it)
        })
        viewModel.error.observe(viewLifecycleOwner, Observer {
            //TODO setup for error
            Toast.makeText(requireContext(),"Error $it", Toast.LENGTH_SHORT).show()
        })

        viewModel.empty.observe(viewLifecycleOwner, Observer {
            when (it) {
                true -> ly_offline.visibility = View.VISIBLE
                false -> ly_offline.visibility = View.GONE
            }
        })
    }

    fun showHideProgress(isShow: Boolean) {
        mBinding.lySwipeRefresh.isRefreshing = isShow
    }

    private fun populateAdapter(){

        // Update in city group
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

}