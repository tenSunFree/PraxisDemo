package com.home.praxisdemo.list.viewmodel

import androidx.lifecycle.MutableLiveData
import com.home.praxisdemo.common.base.BaseHeaderAdapter
import com.home.praxisdemo.common.base.BaseViewModel
import com.home.praxisdemo.common.injection.scope.ActivityScope
import com.home.praxisdemo.home.model.HomePojo
import com.home.praxisdemo.list.model.ListMultiItemEntity
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@ActivityScope
class ListViewModel @Inject constructor() : BaseViewModel() {

    val jokeStringLiveData = MutableLiveData<String>()
    val listMutableLiveData =
        MutableLiveData<ArrayList<ListMultiItemEntity<HomePojo.Result.Results>>>()

    fun showJoke(jokeList: ArrayList<HomePojo.Result.Results>) {
        val results = jokeList[0]
        val arrayList = ArrayList<ListMultiItemEntity<HomePojo.Result.Results>>()
        val sortNumber = 1
        var pinnedHeaderName = 'A'
        pinnedHeaderName = addHeaders(pinnedHeaderName, arrayList, results, sortNumber)
        addDatas(jokeList, arrayList, pinnedHeaderName)
        // 依Integer排序
        arrayList.sortWith(Comparator { p0,
                                        p1 ->
            p0!!.sortNumber - p1!!.sortNumber
        })
        listMutableLiveData.postValue(arrayList)
    }

    private fun addDatas(
        jokeList: ArrayList<HomePojo.Result.Results>,
        arrayList: ArrayList<ListMultiItemEntity<HomePojo.Result.Results>>,
        pinnedHeaderName: Char
    ) {
        for (joke in jokeList) {
            when (joke.F_Name_En.substring(0, 1)) {
                "A" -> add(arrayList, joke, pinnedHeaderName, 2)
                "B" -> add(arrayList, joke, pinnedHeaderName, 4)
                "C" -> add(arrayList, joke, pinnedHeaderName, 6)
                "D" -> add(arrayList, joke, pinnedHeaderName, 8)
                "E" -> add(arrayList, joke, pinnedHeaderName, 10)
                "F" -> add(arrayList, joke, pinnedHeaderName, 12)
                "G" -> add(arrayList, joke, pinnedHeaderName, 14)
                "H" -> add(arrayList, joke, pinnedHeaderName, 16)
                "I" -> add(arrayList, joke, pinnedHeaderName, 18)
                "J" -> add(arrayList, joke, pinnedHeaderName, 20)
                "K" -> add(arrayList, joke, pinnedHeaderName, 22)
                "L" -> add(arrayList, joke, pinnedHeaderName, 24)
                "M" -> add(arrayList, joke, pinnedHeaderName, 26)
                "N" -> add(arrayList, joke, pinnedHeaderName, 28)
                "O" -> add(arrayList, joke, pinnedHeaderName, 30)
                "P" -> add(arrayList, joke, pinnedHeaderName, 32)
                "Q" -> add(arrayList, joke, pinnedHeaderName, 34)
                "R" -> add(arrayList, joke, pinnedHeaderName, 36)
                "S" -> add(arrayList, joke, pinnedHeaderName, 38)
                "T" -> add(arrayList, joke, pinnedHeaderName, 40)
                "U" -> add(arrayList, joke, pinnedHeaderName, 42)
                "V" -> add(arrayList, joke, pinnedHeaderName, 44)
                "W" -> add(arrayList, joke, pinnedHeaderName, 46)
                "X" -> add(arrayList, joke, pinnedHeaderName, 48)
                "Y" -> add(arrayList, joke, pinnedHeaderName, 50)
                "Z" -> add(arrayList, joke, pinnedHeaderName, 52)
            }
        }
    }

    private fun addHeaders(
        pinnedHeaderName: Char,
        arrayList: ArrayList<ListMultiItemEntity<HomePojo.Result.Results>>,
        results: HomePojo.Result.Results,
        sortNumber: Int
    ): Char {
        var pinnedHeaderName1 = pinnedHeaderName
        var sortNumber1 = sortNumber
        while (pinnedHeaderName1 <= 'Z') {
            arrayList.add(
                ListMultiItemEntity(
                    results,
                    BaseHeaderAdapter.TYPE_HEADER,
                    pinnedHeaderName1.toString(),
                    sortNumber1
                )
            )
            pinnedHeaderName1++
            sortNumber1 += 2
        }
        return pinnedHeaderName1
    }

    private fun add(
        aArrayList: ArrayList<ListMultiItemEntity<HomePojo.Result.Results>>,
        joke: HomePojo.Result.Results,
        item: Char,
        sortNumber: Int
    ) {
        aArrayList.add(
            ListMultiItemEntity(
                joke,
                BaseHeaderAdapter.TYPE_DATA,
                item.toString(),
                sortNumber
            )
        )
    }
}