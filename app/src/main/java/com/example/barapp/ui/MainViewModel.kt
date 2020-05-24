package com.example.barapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barapp.data.FirebaseDataSource
import com.example.barapp.util.ResponseResult

class MainViewModel : ViewModel() {

    private val repository = FirebaseDataSource()

    private val _menuLiveData = MutableLiveData<ResponseResult>()
    val menuLiveData: LiveData<ResponseResult>
        get() = _menuLiveData

    init {
        Log.d("mmm", "MainViewModel :   --  ${this.hashCode()}")
        _menuLiveData.value = ResponseResult.Loading(true)
        repository.getMenu { result ->
            _menuLiveData.value = ResponseResult.Loading(false)
            _menuLiveData.value = result
        }
    }
}