package com.home.praxisdemo.list.view

import android.os.Bundle
import androidx.lifecycle.Observer
import com.home.praxisdemo.R
import com.home.praxisdemo.common.base.ActivityNavigator
import com.home.praxisdemo.common.base.BaseActivity
import com.home.praxisdemo.common.base.BaseHeaderAdapter
import com.home.praxisdemo.databinding.ActivityListBinding
import com.home.praxisdemo.home.model.HomePojo
import com.home.praxisdemo.list.model.ListMultiItemEntity
import com.home.praxisdemo.list.viewmodel.ListViewModel
import com.oushangfeng.pinnedsectionitemdecoration.PinnedHeaderItemDecoration

class ListActivity : BaseActivity<ActivityListBinding, ListViewModel>() {

    companion object {
        const val LIST_ACTIVITY = "LIST_ACTIVITY"
    }

    override fun layoutId(): Int {
        return R.layout.activity_list
    }

    override fun getViewModelClass(): Class<ListViewModel> = ListViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        observeLiveData()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun observeLiveData() {
        val jokeList =
            intent.getParcelableArrayListExtra<HomePojo.Result.Results>(LIST_ACTIVITY)
        binding.lifecycleOwner = this
        viewModel.showJoke(jokeList)
        var adapter: BaseHeaderAdapter<ListMultiItemEntity<HomePojo.Result.Results>>?
        viewModel.listMutableLiveData.observe(this, Observer {
            adapter = ListBaseHeaderAdapter(it)
            binding.recyclerView.addItemDecoration(
                PinnedHeaderItemDecoration
                    .Builder(BaseHeaderAdapter.TYPE_HEADER)
                    .setDividerId(R.drawable.divider)
                    .enableDivider(true)
                    .create()
            )
            binding.recyclerView.adapter = adapter
        })
    }

    override fun onBackPressed() {
        ActivityNavigator.finishActivityWithAnimation(
            R.anim.slide_right_in, R.anim.slide_right_out, this
        )
    }
}
