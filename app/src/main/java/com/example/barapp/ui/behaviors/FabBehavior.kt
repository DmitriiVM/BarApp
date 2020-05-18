package com.example.barapp.ui.behaviors

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.marginRight
import com.example.barapp.extensions.dpToPx
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FabBehavior(): CoordinatorLayout.Behavior<FloatingActionButton>() {

    constructor(ctx: Context, attrs: AttributeSet): this()

//    override fun layoutDependsOn(
//        parent: CoordinatorLayout,
//        child: FloatingActionButton,
//        dependency: View
//    ): Boolean {
//        return dependency is LinearLayout
//    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: FloatingActionButton,
        dependency: View
    ): Boolean {
        child.translationY = child.context.dpToPx(30) - dependency.translationY
        val fraction = dependency.translationY/ child.context.dpToPx(50)
        child.translationX = (child.width + child.marginRight) * fraction
        return super.onDependentViewChanged(parent, child, dependency)
    }
}