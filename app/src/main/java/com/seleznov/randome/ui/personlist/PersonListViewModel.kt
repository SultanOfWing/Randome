package com.seleznov.randome.ui.personlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ccom.seleznov.randome.remote.DataSourceFactory
import com.seleznov.randome.remote.ApiService
import com.seleznov.randome.remote.dto.PersonModel

private const val PERSON_COUNT = 10

class PersonListViewModel : ViewModel() {
    private val personDataSourceFactory: DataSourceFactory
    private val networkService = ApiService.getService()

    var personList: LiveData<PagedList<PersonModel>>

    init {
        personDataSourceFactory = DataSourceFactory(networkService)
        val config = PagedList.Config.Builder()
            .setPageSize(PERSON_COUNT)
            .setInitialLoadSizeHint(PERSON_COUNT * 2)
            .build()

        personList = LivePagedListBuilder<Int, PersonModel>(personDataSourceFactory, config).build()
    }

    override fun onCleared() {
        super.onCleared()
        personDataSourceFactory.clear()
    }
}