package com.invotech.mrsmofficial.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.invotech.mrsmofficial.R
import kotlinx.android.synthetic.main.activity_mureed.*

class ActivityMureed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mureed)
        btn_back.setOnClickListener {
            startActivity(Intent(this@ActivityMureed, MainActivity::class.java))
            finish()
        }

    }
    override fun onBackPressed() {

    }
}