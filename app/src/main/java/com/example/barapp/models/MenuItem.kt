package com.example.barapp.models

data class MenuItem @JvmOverloads constructor(
    val id : Int = 0,
    val name: String = "",
    val imageUrl: String = "",
    val description: String = "",
    val price: Int = 0,
    val weight: Int = 0,
    val category: String = ""
)

enum class Category{

}