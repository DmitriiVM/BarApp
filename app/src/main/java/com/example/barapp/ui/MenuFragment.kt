package com.example.barapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.barapp.R
import com.example.barapp.ui.adapters.MenuRecyclerViewAdapter
import com.example.barapp.util.ResponseResult
import kotlinx.android.synthetic.main.fragment_category.*
class MenuFragment : Fragment(R.layout.fragment_category) {

    private var category: String? = null

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MenuRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        arguments?.let {
            category = it.getString(ARG_CATEGORY)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecyclerView()
        subscribeForMenu()
    }

    private fun initRecyclerView() {
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        adapter = MenuRecyclerViewAdapter()
        recycleView.adapter = adapter
    }

    private fun subscribeForMenu() {
        viewModel.menuLiveData.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
//                is ResponseResult.Loading -> {
//
//                }
                is ResponseResult.Data -> {
                    adapter.setMenu(result.menu)
                }
//                is ResponseResult.Error -> {
//
//                }
            }
        })
    }

    companion object {
        private const val ARG_CATEGORY = "category"

        fun newInstance(category: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_CATEGORY, category)
                }
            }
    }
}