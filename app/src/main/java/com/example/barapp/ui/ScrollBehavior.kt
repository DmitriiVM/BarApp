package com.example.barapp.ui

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.example.barapp.R
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.motion_layout_header.view.*

class ScrollBehavior() : AppBarLayout.Behavior() {

    constructor(ctx: Context, attrs: AttributeSet) : this()

    private lateinit var imageView: View

    private var targetHeight: Int = 0
    private var initialHeight: Int = 0
    private var isStopped = true
    private var lastHeight = 0
    private var totalDy = 0

    var offset: Int = 0


    override fun onLayoutChild(
        parent: CoordinatorLayout,
        abl: AppBarLayout,
        layoutDirection: Int
    ): Boolean {
        val superLayout = super.onLayoutChild(parent, abl, layoutDirection)
        if (!::imageView.isInitialized){
            imageView = abl.findViewById(R.id.imageView)
            initialHeight = abl.height
            lastHeight = abl.height
        }
        return superLayout
    }

    override fun onStartNestedScroll(
        parent: CoordinatorLayout,
        child: AppBarLayout,
        directTargetChild: View,
        target: View,
        nestedScrollAxes: Int,
        type: Int
    ): Boolean {
        isStopped = false
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: AppBarLayout,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {

        val offset = initialHeight - child.bottom
//        Log.d(
//            "mmm",
//            "    totalDy : $totalDy    offset $offset    imageView.translationY ${imageView.translationY}   child.bottom ${child.bottom}         $type    ${consumed[0]}"
//        )


        if (child.bottom == initialHeight) {
            totalDy = 0
            imageView.translationY = totalDy.toFloat()
            Log.d("mmm", "Внизу  totalDy $totalDy  --imageView.translationY  ${imageView.translationY}    offset $offset  ")
        } else if (child.bottom == 126) {
            totalDy = initialHeight - 126
            imageView.translationY = totalDy.toFloat()
            Log.d("mmm", "Вверху  totalDy $totalDy  --imageView.translationY  ${imageView.translationY}    offset $offset ")
        } else {
//            Log.d("mmm", " start totalDy $totalDy")
            totalDy += dy
            if (totalDy >= 0) {
                if (dy >= 0) {
//
//
                    Log.d("mmm", "ScrollBehavior : totalDy $totalDy --imageView.translationY  ${imageView.translationY}  offset $offset     up")
                    imageView.translationY = totalDy.toFloat()
//                    imageView.translationY = offset.toFloat()

                } else {
                    imageView.translationY = totalDy.toFloat()
//                    imageView.translationY = offset.toFloat()
                    Log.d("mmm", "ScrollBehavior : totalDy $totalDy  --imageView.translationY  ${imageView.translationY}    offset $offset   down")
                }

            } else {
                totalDy = 0
                imageView.translationY = 0f
            }
        }


//        if (!isStopped && isOffsetConsumed) {
////            if (child.bottom != initialHeight ) {
//            if (child.bottom == initialHeight || child.bottom == 126) {
//                totalDy = 0
//                imageView.translationY = 0f
//            } else if (totalDy >= 0) {
//                val appBarLayoutBottom = child.bottom
//                if (dy > 0) {
//                    totalDy += dy
//                    imageView.translationY = totalDy.toFloat() / 2
//                } else if (dy < 0
//                    && appBarLayoutBottom < initialHeight
//                ) {
//                    totalDy += dy
//                    imageView.translationY = totalDy.toFloat() / 2
//                }
//            }
//            else {
//                totalDy = 0
//                imageView.translationY = 0f
//            }
//        }
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
    }


    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: AppBarLayout,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {
        Log.d(
            "mmm",
            "ScrollBehavior :  onNestedScroll -                                                                           -  $dyConsumed    $dyUnconsumed       -----------------------------------------------"
        )

//        if (dyUnconsumed < 0) {
//            val tt = initialHeight - child.bottom
//            imageView.translationY = tt.toFloat()
//        }


//        if (dyUnconsumed < 0 && child.bottom != initialHeight) {
//            totalDy += dyUnconsumed
//            imageView.translationY = totalDy.toFloat()
//        }
//        if (child.bottom == initialHeight){
//            totalDy = 0
//            imageView.translationY = 0f
//        }

//        if (
////            child.bottom > initialHeight - 100 &&
//            dyUnconsumed < 100) {
//            Log.d("mmm", "ScrollBehavior :  onNestedScroll -- child.bottom ${child.bottom} initialHeight $initialHeight ")
////            totalDy += dyUnconsumed
////            imageView.translationY = totalDy.toFloat()
//            totalDy = 0
//            imageView.translationY = 0f
//        }

        super.onNestedScroll(
            coordinatorLayout,
            child,
            target,
            dxConsumed,
            dyConsumed,
            dxUnconsumed,
            dyUnconsumed,
            type,
            consumed
        )
    }

    override fun onStopNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        abl: AppBarLayout,
        target: View,
        type: Int
    ) {
        isStopped = true
//        Log.d("mmm", "ScrollBehavior :  onStopNestedScroll --  ")
        super.onStopNestedScroll(coordinatorLayout, abl, target, type)
    }

    // ----------------------------------------------------

//    override fun onNestedScroll(
//        coordinatorLayout: CoordinatorLayout,
//        child: AppBarLayout,
//        target: View,
//        dxConsumed: Int,
//        dyConsumed: Int,
//        dxUnconsumed: Int,
//        dyUnconsumed: Int
//    ) {
//        super.onNestedScroll(
//            coordinatorLayout,
//            child,
//            target,
//            dxConsumed,
//            dyConsumed,
//            dxUnconsumed,
//            dyUnconsumed
//        )
//    }
//
//    override fun onNestedScroll(
//        coordinatorLayout: CoordinatorLayout,
//        child: AppBarLayout,
//        target: View,
//        dxConsumed: Int,
//        dyConsumed: Int,
//        dxUnconsumed: Int,
//        dyUnconsumed: Int,
//        type: Int
//    ) {
//        super.onNestedScroll(
//            coordinatorLayout,
//            child,
//            target,
//            dxConsumed,
//            dyConsumed,
//            dxUnconsumed,
//            dyUnconsumed,
//            type
//        )
//    }
//
//    override fun onNestedPreFling(
//        coordinatorLayout: CoordinatorLayout,
//        child: AppBarLayout,
//        target: View,
//        velocityX: Float,
//        velocityY: Float
//    ): Boolean {
//        Log.d("mmm", "ScrollBehavior :  onNestedPreFling --  $velocityY")
//        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY)
//    }

//    override fun onNestedScrollAccepted(
//        coordinatorLayout: CoordinatorLayout,
//        child: AppBarLayout,
//        directTargetChild: View,
//        target: View,
//        axes: Int
//    ) {
//        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, axes)
//    }
//
//    override fun onNestedScrollAccepted(
//        coordinatorLayout: CoordinatorLayout,
//        child: AppBarLayout,
//        directTargetChild: View,
//        target: View,
//        axes: Int,
//        type: Int
//    ) {
//        super.onNestedScrollAccepted(
//            coordinatorLayout,
//            child,
//            directTargetChild,
//            target,
//            axes,
//            type
//        )
//    }
//
//    override fun onNestedFling(
//        coordinatorLayout: CoordinatorLayout,
//        child: AppBarLayout,
//        target: View,
//        velocityX: Float,
//        velocityY: Float,
//        consumed: Boolean
//    ): Boolean {
//        Log.d("mmm", "ScrollBehavior :  onNestedFling --  $velocityY     $consumed")
//        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed)
//    }
}