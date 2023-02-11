package com.sg.posti20r

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class FlipCardTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.apply {
            val screenWidth = context.resources.displayMetrics.widthPixels
            val screenCenter = screenWidth / 2

            pivotX = screenCenter.toFloat()
            pivotY = height * 0.5f

            rotationY = 90f * position
        }
    }
}


/*
class FlipCardTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.apply {
            val screenWidth = context.resources.displayMetrics.widthPixels
            val center = screenWidth / 2

            pivotX = center.toFloat()
            pivotY = height * 0.5f

            rotationY = 90f * position
        }
    }
}*/

/*

class FlipCardTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.apply {
            val screenWidth = context.resources.displayMetrics.widthPixels
            val center = screenWidth / 2

            val absPos = Math.abs(position)
            pivotX = center.toFloat()
            pivotY = height * 0.5f

            if (position <= -1) {
                rotationY = -90f
                translationX = -screenWidth * position
            } else if (position >= 1) {
                rotationY = 90f
                translationX = -screenWidth * position
            } else {
                rotationY = 90f * position
                translationX = 0f
            }
        }
    }
}
*/





/*

class FlipCardTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.apply {
            val screenWidth = context.resources.displayMetrics.widthPixels
            val center = screenWidth / 2

            val absPos = Math.abs(position)
            pivotX = center.toFloat()
            pivotY = height * 0.5f

            if (position <= -1) {
                rotationY = -90f
            } else if (position >= 1) {
                rotationY = 90f
            } else {
                rotationY = 90f * position
            }
        }
    }
}
*/


