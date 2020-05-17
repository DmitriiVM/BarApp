package com.example.barapp.extensions

import android.content.Context
import android.util.TypedValue

fun Context.dpToPx(px: Int): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px.toFloat(), this.resources.displayMetrics)
}