package com.example.barapp.models

data class MenuItem (
    var id : Int = 0,   // ---------------------------------------
    val name: String = "",
    val imageUrl: String = "",
    val description: String = "",
    var price: Int = 0,   // ------
    val weight: Int = 0,
    val category: String = ""
)