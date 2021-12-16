package com.example.google_maps.Retrofit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AvtorListViewModel(application: Application): AndroidViewModel(application) {

    private val compositeDist = CompositeDisposable()

    override fun onCleared() {
        compositeDist.dispose()

        super.onCleared()
    }

    fun fetchQuestList(AvtorAPI: AvtorAPI?){

        AvtorAPI?.let {

            compositeDist.add(AvtorAPI.getAvtorList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                },{

                }))
        }

    }
}