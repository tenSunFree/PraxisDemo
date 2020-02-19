package com.home.praxisdemo.home.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.home.praxisdemo.R
import com.home.praxisdemo.common.base.ActivityNavigator
import com.home.praxisdemo.common.base.BaseActivity
import com.home.praxisdemo.databinding.ActivityHomeBinding
import com.home.praxisdemo.home.viewmodel.HomeViewModel
import com.home.praxisdemo.list.view.ListActivity

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    override fun layoutId(): Int = R.layout.activity_home

    override fun getViewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeLiveData()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadHomePojo()
    }

    private fun observeLiveData() {
        viewModel.loadingLiveData.observe(this, Observer {
            handleDataLoadingUi(it!!)
        })
        viewModel.homePojoLiveData.observe(this, Observer { it ->
            it?.let {
                val bundle = Bundle()
                bundle.putParcelableArrayList(ListActivity.LIST_ACTIVITY, it.result.results)
                showListActivity(bundle)
            }
        })
    }

    private fun showListActivity(bundle: Bundle) {
        ActivityNavigator.startActivityWithDataAndAnimation(
            ListActivity::class.java, bundle,
            R.anim.slide_left_in, R.anim.slide_left_out, this
        )
    }

    private fun handleDataLoadingUi(loading: Boolean) {
        binding.progressBar.visibility = if (loading) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }
    }
}