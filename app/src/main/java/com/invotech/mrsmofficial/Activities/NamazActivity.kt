package com.invotech.mrsmofficial.Activities


import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.azan.Azan
import com.azan.astrologicalCalc.Location
import com.azan.astrologicalCalc.SimpleDate
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.Task
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode
import com.invotech.mrsmofficial.R
import kotlinx.android.synthetic.main.activity_namaz.*
import java.text.SimpleDateFormat
import java.util.*

class NamazActivity : AppCompatActivity() {
    var queriedLocation: LatLng? = null
    var lat: Double? = null
    var lng: Double? = null
    var utc: Double? = null
    private lateinit var destination: LatLng
    private var DEST_PLACE = 10001
    private val PERMISSION_CODE = 101
    var placeFields = Arrays.asList(
        Place.Field.ID,
        Place.Field.NAME,
        Place.Field.ADDRESS,
        Place.Field.LAT_LNG,
        Place.Field.UTC_OFFSET
    )
    private var REQUEST_CODE = 101
    private lateinit var location: Location
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_namaz)



        Places.initialize(this, getString(R.string.places_api))
        sharedPreferences = getSharedPreferences("Value", MODE_PRIVATE)
        txt_date.text = sharedPreferences.getString("date","")
        FajarTV.text = sharedPreferences.getString("fajar","")
        ZuharTV.text = sharedPreferences.getString("zuhar","")
        AsrTv.text = sharedPreferences.getString("asr","")
        MaghribTV.text = sharedPreferences.getString("maghrib","")
        IshaTV.text = sharedPreferences.getString("isha","")



        /*  println("date ---> " + today.day + " / " + today.month + " / " + today.year)
          println("imsaak ---> $imsaak")*/


        btn_custom_location.setOnClickListener {
            val intent: Intent = Autocomplete.IntentBuilder(
                AutocompleteActivityMode.FULLSCREEN, placeFields
            )
                .build(this)
            startActivityForResult(intent, DEST_PLACE)
        }
        btn_back.setOnClickListener {
            startActivity(Intent(this@NamazActivity, MainActivity::class.java))
            finish()
        }


    }

    @SuppressLint("SimpleDateFormat")
    private fun getNamazTimings() {

        val azan = Azan(location, com.azan.Method.KARACHI_SHAF)
        val today = SimpleDate(GregorianCalendar())
        val prayerTimes = azan.getPrayerTimes(today)
        val code12Hours = SimpleDateFormat("hh:mm")

        var dateFajar: Date? = null
        var dateZuhar: Date? = null
        var dateAsr: Date? = null
        var dateMaghrib: Date? = null
        var dateIsha: Date? = null
        val fajartime = prayerTimes.fajr()
        val zuhartime = prayerTimes.thuhr()
        val asrtime = prayerTimes.assr()
        val maghribtime = prayerTimes.maghrib()
        val ishatime = prayerTimes.ishaa()

        val date = fajartime
        val z = zuhartime
        val a = asrtime
        val m = maghribtime
        val i = ishatime
        dateFajar = code12Hours.parse(date.toString())
        dateZuhar = code12Hours.parse(z.toString())
        dateAsr = code12Hours.parse(a.toString())
        dateMaghrib = code12Hours.parse(m.toString())
        dateIsha = code12Hours.parse(i.toString())


        val FajarT = code12Hours.format(dateFajar);
        val ZuharT = code12Hours.format(dateZuhar)
        val AsrT = code12Hours.format(dateAsr)
        val MaghribT = code12Hours.format(dateMaghrib)
        val IshaT = code12Hours.format(dateIsha)


        val imsaak = azan.getImsaak(today)

        txt_date.text = "Date: " + today.day + " / " + today.month + " / " + today.year
        FajarTV.text = FajarT + " AM"
        ZuharTV.text = ZuharT + " PM"
        AsrTv.text = AsrT + " PM"
        MaghribTV.text = MaghribT + " PM"
        IshaTV.text = IshaT + " PM"
        editor = sharedPreferences.edit()
        editor.putString("date", txt_date.text.toString())
        editor.putString("fajar", FajarTV.text.toString())
        editor.putString("asr", AsrTv.text.toString())
        editor.putString("maghrib", MaghribTV.text.toString())
        editor.putString("zuhar", ZuharTV.text.toString())
        editor.putString("isha", IshaTV.text.toString())
        editor.apply()



        //formatting the given time to new format with AM/PM
        /*System.out.println("Given time in AM/PM: " + sdf2.format(date3))*/


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == DEST_PLACE && resultCode == Activity.RESULT_OK) {
            val destplace = Autocomplete.getPlaceFromIntent(data!!)
            queriedLocation = destplace.latLng
            utc = destplace.utcOffsetMinutes?.div(60)!!.toDouble()
            lat = queriedLocation!!.latitude
            lng = queriedLocation!!.longitude
            destination = LatLng(queriedLocation!!.latitude, queriedLocation!!.longitude)
            getlocation(lat!!, lng!!, utc!!)
            getNamazTimings()
        }
    }

    private fun getCurrentLocation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSION_CODE
            )
        }

        val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            AlertDialog.Builder(this)
                .setTitle("Location Permission Needed")
                .setMessage("This app needs the Location permission, please accept to use location functionality")
                .setPositiveButton("OK", object : DialogInterface.OnClickListener {
                    override fun onClick(dialogInterface: DialogInterface?, i: Int) {
                        //Prompt the user once explanation has been shown
                        ActivityCompat.requestPermissions(
                            this@NamazActivity,
                            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                            REQUEST_CODE
                        )
                    }
                })
                .create()
                .show()


        }


        val task: Task<android.location.Location> = fusedLocationProviderClient.lastLocation
        task.addOnSuccessListener { locateUser ->
            val lng = locateUser.latitude.toInt()
            /*getLocation = LatLng(locateUser?.latitude!!, locateUser.longitude)*/
            Toast.makeText(this@NamazActivity, lng, Toast.LENGTH_LONG).show()

        }


    }

    private fun getlocation(lattitude: Double, longitude: Double, offset: Double) {
        location = Location(lattitude, longitude, offset, 0)
    }
    override fun onBackPressed() {

    }
}