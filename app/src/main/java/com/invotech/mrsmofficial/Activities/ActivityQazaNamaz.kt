package com.invotech.mrsmofficial.Activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.invotech.mrsmofficial.R
import kotlinx.android.synthetic.main.activity_membership.*
import kotlinx.android.synthetic.main.activity_qaza_namaz.*
import kotlinx.android.synthetic.main.activity_qaza_namaz.btn_back

class ActivityQazaNamaz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qaza_namaz)
        val txtFajar = findViewById<TextView>(R.id.txt_fajar)
        val txtZuhar = findViewById<TextView>(R.id.txt_zuhar_namaz)
        val edtQaza = findViewById<EditText>(R.id.edt_qaza_namaz)
        val txtAsr = findViewById<TextView>(R.id.txt_asar_namaz)
        val txtMaghrib = findViewById<TextView>(R.id.txt_maghrib_namaz)
        val btnCheckQaza = findViewById<Button>(R.id.btn_check_qaza)
        val txtIsha = findViewById<TextView>(R.id.txt_isha_namaz)
        val edtDuaration = findViewById<EditText>(R.id.edt_duarion_completion)
        val chkFajar = findViewById<CheckBox>(R.id.chk_fajar)
        val chkZuhar = findViewById<CheckBox>(R.id.chk_zuhar)
        val chkAsr = findViewById<CheckBox>(R.id.chk_asr)
        val chkMaghrib = findViewById<CheckBox>(R.id.chk_maghrib)
        val chkIsha = findViewById<CheckBox>(R.id.chk_isha)
        val txtQazaFajarNamaz = findViewById<TextView>(R.id.txt_fajar_qaza_namaz)
        val txtQazaZuharNamaz = findViewById<TextView>(R.id.txt_zuhar_qaza_namaz)
        val txtQazaAsrNamaz = findViewById<TextView>(R.id.txt_asar_qaza_namaz)
        val txtQazaMaghribNamaz = findViewById<TextView>(R.id.txt_qaza_maghrib_namaz)
        val txtQazaIshaNamaz = findViewById<TextView>(R.id.txt_qaza_isha_namaz)

        btnCheckQaza.setOnClickListener {


            if (TextUtils.isEmpty(edtQaza.text.toString()) || TextUtils.isEmpty(edtDuaration.text.toString()))
            {
                if (TextUtils.isEmpty(edtQaza.text.toString())) {
                    Toast.makeText(applicationContext, "Please Enter Your Age", Toast.LENGTH_SHORT)
                        .show()
                } else if (TextUtils.isEmpty(edtDuaration.text.toString())) {
                    Toast.makeText(
                        applicationContext,
                        "Please Enter Your Duration",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            } else {
                chkFajar.isEnabled = true
                chkZuhar.isEnabled = true
                chkAsr.isEnabled = true
                chkMaghrib.isEnabled = true
                chkIsha.isEnabled = true
                txtFajar.text =
                    (((edt_qaza_namaz.text.toString()
                        .toInt() - 10) * 730)).toString()
                txtZuhar.text =
                    (((edt_qaza_namaz.text.toString()
                        .toInt() - 10) * 1460)).toString()
                txtAsr.text =
                    (((edt_qaza_namaz.text.toString()
                        .toInt() - 10) * 1460)).toString()
                txtMaghrib.text =
                    (((edt_qaza_namaz.text.toString()
                        .toInt() - 10) * 1095)).toString()
                txtIsha.text =
                    (((edt_qaza_namaz.text.toString()
                        .toInt() - 10) * 2555)).toString()
                txtQazaFajarNamaz.text = ((((edt_qaza_namaz.text.toString()
                    .toInt() - 10)) * 365) / (edtDuaration.text.toString()
                    .toInt() * 365)).toString()
                txtQazaZuharNamaz.text = ((((edt_qaza_namaz.text.toString()
                    .toInt() - 10)) * 365) / (edtDuaration.text.toString()
                    .toInt() * 365)).toString()
                txtQazaAsrNamaz.text = ((((edt_qaza_namaz.text.toString()
                    .toInt() - 10)) * 365) / (edtDuaration.text.toString()
                    .toInt() * 365)).toString()
                txtQazaMaghribNamaz.text = ((((edt_qaza_namaz.text.toString()
                    .toInt() - 10)) * 365) / (edtDuaration.text.toString()
                    .toInt() * 365)).toString()
                txtQazaIshaNamaz.text = ((((edt_qaza_namaz.text.toString()
                    .toInt() - 10)) * 365) / (edtDuaration.text.toString()
                    .toInt() * 365)).toString()


            }

        }

        chkFajar.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                if (chkFajar.isChecked) {
                    txtFajar.text =
                        (((edt_qaza_namaz.text.toString()
                            .toInt() - 10) * 730)).toString()
                    txtQazaFajarNamaz.text = ((((edt_qaza_namaz.text.toString()
                        .toInt() - 10)) * 365) / (edtDuaration.text.toString()
                        .toInt() * 365)).toString()
                } else {
                    txtFajar.text = "0"
                    txtQazaFajarNamaz.text = "0"
                }
            }

        })
        chkZuhar.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                if (chkZuhar.isChecked) {
                    txtZuhar.text =
                        (((edt_qaza_namaz.text.toString()
                            .toInt() - 10) * 1460)).toString()
                    txtQazaZuharNamaz.text = ((((edt_qaza_namaz.text.toString()
                        .toInt() - 10)) * 365) / (edtDuaration.text.toString()
                        .toInt() * 365)).toString()
                } else {
                    txtZuhar.text = "0"
                    txtQazaZuharNamaz.text = "0"
                }
            }

        })

        txt_vitr.setOnClickListener {
            Toast.makeText(
                this@ActivityQazaNamaz,
                "Isha Namaz Including Vitr Also",
                Toast.LENGTH_LONG
            ).show()
        }
        chkAsr.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                if (chkAsr.isChecked) {
                    txtAsr.text =
                        (((edt_qaza_namaz.text.toString()
                            .toInt() - 10) * 1460)).toString()
                    txtQazaAsrNamaz.text = ((((edt_qaza_namaz.text.toString()
                        .toInt() - 10)) * 365) / (edtDuaration.text.toString()
                        .toInt() * 365)).toString()
                } else {
                    txtAsr.text = "0"
                    txtQazaAsrNamaz.text = "0"
                }
            }

        })
        chkMaghrib.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                if (chkMaghrib.isChecked) {
                    txtMaghrib.text =
                        (((edt_qaza_namaz.text.toString()
                            .toInt() - 10) * 1095)).toString()
                    txtQazaMaghribNamaz.text = ((((edt_qaza_namaz.text.toString()
                        .toInt() - 10)) * 365) / (edtDuaration.text.toString()
                        .toInt() * 365)).toString()

                } else {
                    txtMaghrib.text = "0"
                    txtQazaMaghribNamaz.text = "0"
                }
            }

        })
        chkIsha.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                if (chkIsha.isChecked) {
                    txtIsha.text =
                        (((edt_qaza_namaz.text.toString()
                            .toInt() - 10) * 2555)).toString()
                    txtQazaIshaNamaz.text = ((((edt_qaza_namaz.text.toString()
                        .toInt() - 10)) * 365) / (edtDuaration.text.toString()
                        .toInt() * 365)).toString()


                } else {
                    txtIsha.text = "0"
                    txtQazaIshaNamaz.text = "0"
                }
            }

        })
        btn_back.setOnClickListener {
            startActivity(Intent(this@ActivityQazaNamaz, MainActivity::class.java))
            finish()
        }
    }
    override fun onBackPressed() {

    }


}