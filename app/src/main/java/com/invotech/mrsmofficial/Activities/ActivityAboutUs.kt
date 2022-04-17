package com.invotech.mrsmofficial.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.invotech.mrsmofficial.R
import kotlinx.android.synthetic.main.activity_about_us.*

class ActivityAboutUs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        btn_back.setOnClickListener {
            startActivity(Intent(this@ActivityAboutUs , MainActivity::class.java))
            finish()
        }
    }

    override fun onBackPressed() {

    }
}