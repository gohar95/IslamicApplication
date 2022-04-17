package com.invotech.mrsmofficial.Activities


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.invotech.mrsmofficial.R
import kotlinx.android.synthetic.main.activity_membership.*

class ActivityMembership : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membership)
        btn_back.setOnClickListener {
            startActivity(Intent(this@ActivityMembership, MainActivity::class.java))
            finish()
        }
        btn_register.setOnClickListener {
            if (TextUtils.isEmpty(edt_name.text.toString()) || TextUtils.isEmpty(edt_fathers_name.text.toString()) || TextUtils.isEmpty(
                    edt_age.text.toString()
                ) || TextUtils.isEmpty(edt_qualification.text.toString()) || TextUtils.isEmpty(
                    edt_email.text.toString()
                ) || TextUtils.isEmpty(edt_city.text.toString()) || TextUtils.isEmpty(edt_phone.text.toString()) || TextUtils.isEmpty(
                    edt_address.text.toString()
                )
            ) {
                if (TextUtils.isEmpty(edt_name.text.toString())) {
                    Toast.makeText(applicationContext, "Please Enter Your Name", Toast.LENGTH_SHORT)
                        .show()
                } else if (TextUtils.isEmpty(edt_fathers_name.text.toString())) {
                    Toast.makeText(
                        applicationContext,
                        "Please Enter Your Fathers Name",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (TextUtils.isEmpty(edt_age.text.toString())) {
                    Toast.makeText(
                        applicationContext,
                        "Please Enter Your Age",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (TextUtils.isEmpty(edt_qualification.text.toString())) {
                    Toast.makeText(
                        applicationContext,
                        "Please Re-Enter Your Qualification",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (TextUtils.isEmpty(edt_email.text.toString())) {
                    Toast.makeText(
                        applicationContext,
                        "Please Enter Your Email",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (TextUtils.isEmpty(edt_city.text.toString())) {
                    Toast.makeText(
                        applicationContext,
                        "Please Enter Your City",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (TextUtils.isEmpty(edt_phone.text.toString())) {
                    Toast.makeText(
                        applicationContext,
                        "Please Enter Your Phone Number",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (TextUtils.isEmpty(edt_address.text.toString())) {
                    Toast.makeText(
                        applicationContext,
                        "Please Enter Your Address",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            } else {
                Toast.makeText(
                    applicationContext,
                    "Please Enter All Credentials ",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    override fun onBackPressed() {

    }
}