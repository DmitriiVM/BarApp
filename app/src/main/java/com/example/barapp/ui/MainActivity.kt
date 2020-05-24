package com.example.barapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.barapp.R
import com.example.barapp.util.ResponseResult
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.bottom_sheet.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.menuLiveData.observe(this, Observer { result ->
            when (result) {
                is ResponseResult.Loading -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.splashFragment)
                }
                is ResponseResult.Data -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.action_splashFragment_to_homeFragment)
                }
                is ResponseResult.Error -> {
                    Snackbar.make(view, "Не удалось загрузить данные", Snackbar.LENGTH_SHORT).show()
                }
            }
        })
    }

}