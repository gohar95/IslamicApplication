package com.invotech.mrsmofficial.Activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.animation.*
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.invotech.mrsmofficial.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    private val SPLASH_TIME: Long = 3000
    private lateinit var topAnim: Animation
    private lateinit var bottomAnim: Animation
    private lateinit var imageLogo: ImageView
    private lateinit var imageName: ImageView
    private lateinit var settings: SharedPreferences
    private var bMusic: Boolean = false
    private  lateinit var progressbar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        setSecondAnimation()



        /*val mediaPlayer: MediaPlayer? = MediaPlayer.create(applicationContext, R.raw.splashmusic)
        settings = getSharedPreferences("Settings", MODE_PRIVATE)
        bMusic = settings.getBoolean("Music", true)
        if (bMusic) {
            mediaPlayer?.start()
        } else {
            mediaPlayer?.stop()
        }*/







    }

    private fun firstAnimation() {
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = DecelerateInterpolator() //add this
        fadeIn.duration = 1000

        val fadeOut = AlphaAnimation(1f, 0f)
        fadeOut.interpolator = AccelerateInterpolator() //and this
        fadeOut.startOffset = 1000
        fadeOut.duration = 1000

        val animation = AnimationSet(false) //change to false
        animation.addAnimation(fadeIn)
        animation.addAnimation(fadeOut)


    }

    private fun setSecondAnimation() {

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
        imageLogo = findViewById(R.id.img_logo)
        imageName = findViewById(R.id.img_name)
        progressbar = findViewById(R.id.progress_bar)

        imageLogo.animation = topAnim
        img_name.animation = bottomAnim
        progressbar.animation = bottomAnim
        Handler().postDelayed(
            {

                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, SPLASH_TIME
        )

    }

}