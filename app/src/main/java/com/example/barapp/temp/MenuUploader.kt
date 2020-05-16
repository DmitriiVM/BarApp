package com.example.barapp.temp

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


private const val COLLECTION_MENU = "menu"
//private const val ROOT_DOCUMENT_MENU = "menu"
//
//private const val CATEGORY_SNACK = "snack"
//private const val CATEGORY_SALAD = "salad"
//private const val CATEGORY_SOUP = "soup"
//private const val CATEGORY_MAIN_COURSE = "main_course"
//private const val CATEGORY_DESSERT = "dessert"
//private const val CATEGORY_SOFT_DRINK = "soft_drink"
//private const val CATEGORY_HOT_DRINK = "hot_drink"
//private const val CATEGORY_ALCOHOLIC_DRINK = "alcoholic_drink"

class MenuUploader {


    private val menuRef = Firebase.firestore.collection(COLLECTION_MENU)

    fun uploadMenuTEMP() {

        menuRef.document("pizza_pepperoni").set(MenuGenerator.pizzaPepperoni)
        menuRef.document("pizza_chicken").set(MenuGenerator.pizzaWithChicken)
        menuRef.document("pizza_quadro").set(MenuGenerator.pizzaQuadroFormagio)
        menuRef.document("pizza_mexican").set(MenuGenerator.pizzaMexican)

        menuRef.document("salad_with_beetroot").set(MenuGenerator.saladWithBeetroot)
        menuRef.document("salad_caesar").set(MenuGenerator.saladCaesar)
        menuRef.document("salad_with_roastbeef").set(MenuGenerator.saladWithRoastBeef)

        menuRef.document("burger_pulled_pork").set(MenuGenerator.burgerWithPulledPork)
        menuRef.document("burger").set(MenuGenerator.burger)
        menuRef.document("chickenburger").set(MenuGenerator.chickenburger)
        menuRef.document("pizza_chicken").set(MenuGenerator.pizzaWithChicken)
        menuRef.document("pizza_quadro").set(MenuGenerator.pizzaQuadroFormagio)
        menuRef.document("pizza_pepperoni").set(MenuGenerator.pizzaPepperoni)
        menuRef.document("pizza_mexican").set(MenuGenerator.pizzaMexican)

    }

}