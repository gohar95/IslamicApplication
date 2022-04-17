package com.invotech.mrsmofficial.Activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.invotech.mrsmofficial.R
import kotlinx.android.synthetic.main.activity_first_splash.*

class FirstSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_splash)
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = DecelerateInterpolator()
        fadeIn.duration = 1500

        val fadeOut = AlphaAnimation(1f, 0f)
        fadeOut.interpolator = AccelerateInterpolator()
        fadeOut.startOffset = 1000
        fadeOut.duration = 1000

        val animation = AnimationSet(false)
        animation.addAnimation(fadeIn)
        animation.addAnimation(fadeOut)
        img_idara.animation = fadeIn
        img_idara.animation = fadeOut
        Handler().postDelayed(
            {

                startActivity(Intent(this, SplashScreen::class.java))
                finish()
            }, 1500
        )
    }
}