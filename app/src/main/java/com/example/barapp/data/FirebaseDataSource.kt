package com.example.barapp.data

import com.example.barapp.models.MenuItem
import com.example.barapp.util.ResponseResult
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


const val COLLECTION_MENU = "menu"
//const val ROOT_DOCUMENT_MENU = "menu"
//
//const val CATEGORY_SNACK = "snack"
//const val CATEGORY_SALAD = "salad"
//const val CATEGORY_SOUP = "soup"
//const val CATEGORY_MAIN_COURSE = "main_course"
//const val CATEGORY_DESSERT = "dessert"
//const val CATEGORY_SOFT_DRINK = "soft_drink"
//const val CATEGORY_HOT_DRINK = "hot_drink"
//const val CATEGORY_ALCOHOLIC_DRINK = "alcoholic_drink"

class FirebaseDataSource {

    // inject
    private val db = Firebase.firestore


    fun getMenu(result: (ResponseResult) -> Unit) {

        db.collection(COLLECTION_MENU).get()
            .addOnSuccessListener {querySnapshot ->
                if (!querySnapshot.isEmpty){
                    val menuItemList = querySnapshot.toObjects(MenuItem::class.java)
                    result(ResponseResult.Data(menuItemList))
                }

            }
            .addOnFailureListener { exception ->
                exception.localizedMessage?.let {
                    result(ResponseResult.Error(it))
                }
            }
    }


}
