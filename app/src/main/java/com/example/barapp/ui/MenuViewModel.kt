package com.example.barapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barapp.data.FirebaseDataSource
import com.example.barapp.util.ResponseResult

class MenuViewModel : ViewModel() {

    // inject
    private val repository = FirebaseDataSource()

    private val _menuLiveData = MutableLiveData<ResponseResult>()
    val menuLiveData: LiveData<ResponseResult>
        get() = _menuLiveData

    init {
        _menuLiveData.value = ResponseResult.Loading(true)
        repository.getMenu { result ->
            _menuLiveData.value = ResponseResult.Loading(false)
            _menuLiveData.value = result
        }
    }


}