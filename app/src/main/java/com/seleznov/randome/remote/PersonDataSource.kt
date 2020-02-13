package com.seleznov.randome.remote

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.seleznov.randome.remote.dto.PersonModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

private const val START_PAGE = 1
private const val SEED = "abc"

class PersonDataSource(private val api: ApiService) : PageKeyedDataSource<Int, PersonModel>() {

    private val disposableBag = CompositeDisposable()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, PersonModel>
    ) {
        api.getPersons(START_PAGE, params.requestedLoadSize, SEED)
            .subscribe({ resp ->
                resp.results?.let { callback.onResult(it, null, 0) }
            }, {
                Log.v("__ERROR", "Throwable $it")
            })
            .addTo(disposableBag)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, PersonModel>) {
        api.getPersons(params.key, params.requestedLoadSize, SEED)
            .subscribe({ resp ->
                resp.results?.let { callback.onResult(it, params.key + 1) }
            }, {
                Log.v("__ERROR", "Throwable $it")
            })
            .addTo(disposableBag)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, PersonModel>) {

    }

    fun clear() {
        disposableBag.clear()
    }
}