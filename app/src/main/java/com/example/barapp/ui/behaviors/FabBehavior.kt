package com.example.barapp.ui.behaviors

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.marginRight
import com.example.barapp.R
import com.example.barapp.extensions.dpToPx
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FabBehavior(): CoordinatorLayout.Behavior<FloatingActionButton>() {

    constructor(ctx: Context, attrs: AttributeSet): this()

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: FloatingActionButton,
        dependency: View
    ): Boolean {

        val offsetY = child.resources.getDimension(R.dimen.fab_offset)
        child.translationY = offsetY - dependency.translationY

        val offsetX = child.resources.getDimension(R.dimen.bottomsheet_peek_height).toInt()
        val fraction = dependency.translationY/ offsetX
        child.translationX = (child.width + child.marginRight) * fraction
        return super.onDependentViewChanged(parent, child, dependency)
    }
}