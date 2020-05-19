package com.example.barapp.extensions

import android.animation.*
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

const val ANIMATION_DURATION = 200L

fun View.animateOpen(startDelay: Long) {

    ValueAnimator.ofFloat(0f, 1f).apply {
        duration = ANIMATION_DURATION
        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                this@animateOpen.isVisible = true
            }
        })
        addUpdateListener {
            this@animateOpen.scaleX = it.animatedFraction
            this@animateOpen.scaleY = it.animatedFraction
            this@animateOpen.alpha = it.animatedFraction
        }
        this.startDelay = startDelay
        start()
    }
}

fun View.animateClose(startDelay: Long) {

    ValueAnimator.ofFloat(0f, 1f).apply {
        duration = ANIMATION_DURATION
        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                this@animateClose.isVisible = false
            }
        })
        addUpdateListener {
            this@animateClose.scaleX = 1 - it.animatedFraction
            this@animateClose.scaleY = 1 - it.animatedFraction
            this@animateClose.alpha = 1 - it.animatedFraction
        }
        this.startDelay = startDelay
        start()
    }
}