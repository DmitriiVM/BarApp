package com.example.barapp.util

import com.example.barapp.models.MenuItem

sealed class ResponseResult {
    class Loading(val isLoading: Boolean) : ResponseResult()
    class Error(val errorMessage: String) : ResponseResult()
    class Data(val menu: List<MenuItem>) : ResponseResult()
}