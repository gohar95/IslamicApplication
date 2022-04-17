package com.invotech.mrsmofficial.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewStub
import androidx.appcompat.app.AppCompatActivity
import com.invotech.mrsmofficial.R
import kotlinx.android.synthetic.main.activity_donation.*

class ActivityDonation : AppCompatActivity() {
    private var onIndex: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donation)
        val viewImage = findViewById<ViewStub>(R.id.view_image)


        btn_back.setOnClickListener {
            startActivity(Intent(this@ActivityDonation, MainActivity::class.java))
            finish()
        }
        btn_donation.setOnClickListener {
            if (onIndex == 0) {
                viewImage.visibility = View.VISIBLE
                img_eng.visibility = View.INVISIBLE
                btn_donation.text = "ENG"
                onIndex = 1
            } else {
                viewImage.visibility = View.INVISIBLE
                img_eng.visibility = View.VISIBLE
                btn_donation.text = "URDU"
                onIndex = 0
            }


        }

    }
    override fun onBackPressed() {

    }


}
