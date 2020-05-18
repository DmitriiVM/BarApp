package com.example.barapp.ui.behaviors

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.math.MathUtils
import androidx.core.view.ViewCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior

class BottomSheetBehavior(): BottomSheetBehavior<LinearLayout>() {

    constructor(ctx: Context, attrs: AttributeSet): this()

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: LinearLayout,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: LinearLayout,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {
        child.translationY = MathUtils.clamp(child.translationY + dy, 0f, child.height.toFloat())
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
    }

}