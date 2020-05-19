package com.example.barapp.temp_for_upload

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


private const val COLLECTION_MENU = "menu"

class MenuUploader {

    private val menuRef = Firebase.firestore.collection(COLLECTION_MENU)

    fun uploadMenuTEMP() {

        menuRef.document("snack_french_fries").set(MenuGenerator.snackFrenchFries)
        menuRef.document("snack_idaho").set(MenuGenerator.snackIdaho)
        menuRef.document("snack_chickenStrips").set(MenuGenerator.snackChickenStrips)
        menuRef.document("snack_quesadilla").set(MenuGenerator.snackQuesadilla)
        menuRef.document("snack_roast_beef").set(MenuGenerator.snackRoastBeef)

        menuRef.document("salad_with_beetroot").set(MenuGenerator.saladWithBeetroot)
        menuRef.document("salad_caesar").set(MenuGenerator.saladCaesar)
        menuRef.document("salad_with_roastbeef").set(MenuGenerator.saladWithRoastBeef)

        menuRef.document("soup_cheese_soup").set(MenuGenerator.soupCheeseSoup)

        menuRef.document("burger_pulled_pork").set(MenuGenerator.burgerWithPulledPork)
        menuRef.document("burger").set(MenuGenerator.burger)
        menuRef.document("chickenburger").set(MenuGenerator.chickenburger)

        menuRef.document("pizza_chicken").set(MenuGenerator.pizzaWithChicken)
        menuRef.document("pizza_quadro").set(MenuGenerator.pizzaQuadroFormagio)
        menuRef.document("pizza_pepperoni").set(MenuGenerator.pizzaPepperoni)
        menuRef.document("pizza_mexican").set(MenuGenerator.pizzaMexican)

    }
}