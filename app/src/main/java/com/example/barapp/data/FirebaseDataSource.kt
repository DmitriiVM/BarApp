package com.example.barapp.data

import com.example.barapp.models.MenuItem
import com.example.barapp.util.ResponseResult
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirebaseDataSource {

    private val db = Firebase.firestore

    fun getMenu(result: (ResponseResult) -> Unit) {

        db.collection(COLLECTION_MENU).get()
            .addOnSuccessListener { querySnapshot ->
                if (!querySnapshot.isEmpty) {
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

    companion object {
        private const val COLLECTION_MENU = "menu"
    }
}
