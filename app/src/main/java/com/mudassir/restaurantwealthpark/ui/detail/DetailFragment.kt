package com.mudassir.restaurantwealthpark.ui.detail

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.mudassir.restaurantwealthpark.R
import com.mudassir.restaurantwealthpark.databinding.DetailFragmentBinding
import com.mudassir.restaurantwealthpark.di.module.ViewModelFactory
import com.mudassir.restaurantwealthpark.ui.list.RestaurantListViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: DetailViewModel by viewModels { viewModelFactory }
    val args: DetailFragmentArgs by navArgs()
    private lateinit var mBinding: DetailFragmentBinding

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
            R.layout.detail_fragment,
            container,
            false
        )

        mBinding.lifecycleOwner=this
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding.viewModel = viewModel
        setupIntentData()
    }

    fun setupIntentData(){
        viewModel.cityModel.value = args.city
    }

    fun observeEvents(){

    }

}