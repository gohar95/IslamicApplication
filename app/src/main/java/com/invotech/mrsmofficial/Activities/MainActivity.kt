package com.invotech.mrsmofficial.Activities


import android.app.FragmentManager
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.invotech.mrsmofficial.Fragments.MenuListFragment
import com.invotech.mrsmofficial.R
import com.mxn.soul.flowingdrawer_core.ElasticDrawer
import com.mxn.soul.flowingdrawer_core.ElasticDrawer.OnDrawerStateChangeListener
import com.mxn.soul.flowingdrawer_core.FlowingDrawer
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : BaseActivity() {
    var con: Context? = null
    private lateinit var mDrawer: FlowingDrawer
    private lateinit var arr: ArrayList<String>
    private var onIndex: Int = 0
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor : SharedPreferences.Editor
    private var bMusic: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupMenu()


        mDrawer = findViewById(R.id.drawerlayout)


        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL)
        btn_toggle.setOnClickListener {
            mDrawer.toggleMenu()
        }

        mDrawer.setOnDrawerStateChangeListener(object : OnDrawerStateChangeListener {
            override fun onDrawerStateChange(oldState: Int, newState: Int) {
                if (newState == ElasticDrawer.STATE_CLOSED) {
                    Log.i("MainActivity", "Drawer STATE_CLOSED")
                }
            }

            override fun onDrawerSlide(openRatio: Float, offsetPixels: Int) {

            }
        })
    }




    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Exit")
            .setMessage("Press OK to Exit")
            .setNegativeButton(android.R.string.no, null)
            .setPositiveButton(android.R.string.yes, object : DialogInterface.OnClickListener {
                override fun onClick(arg0: DialogInterface?, arg1: Int) {
                    super@MainActivity.onBackPressed()
                }
            }).create().show()

    }


    private fun setupMenu() {
        val fm: FragmentManager = fragmentManager
        var mMenuFragment = fm.findFragmentById(R.id.id_container_menu)
        if (mMenuFragment == null) {
            mMenuFragment =
                MenuListFragment()
            fm.beginTransaction().add(R.id.id_container_menu, mMenuFragment).commit()
        }


    }

    public fun closeDrawer() {
        mDrawer.closeMenu()
    }

    override fun updateLocale(locale: Locale) {
        super.updateLocale(locale)
    }

    private fun playBismillah() {
        val mediaPlayer: MediaPlayer? = MediaPlayer.create(applicationContext, R.raw.splashmusic)
        mediaPlayer?.start()
        mediaPlayer?.stop()
    }

    /* private fun showOpeningScreen() {

         val viewOpening : ViewStub = findViewById(R.id.view_opening)
         viewOpening.visibility = View.VISIBLE

     }*/
}