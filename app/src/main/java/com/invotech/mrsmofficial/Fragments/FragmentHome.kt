package com.invotech.mrsmofficial.Fragments

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.invotech.mrsmofficial.Activities.ActivityDonation
import com.invotech.mrsmofficial.Activities.ActivityQazaNamaz
import com.invotech.mrsmofficial.Activities.CompassActivity
import com.invotech.mrsmofficial.R
import com.invotech.mrsmofficial.YoutubeAPI.PlaylistActivity
import de.hdodenhof.circleimageview.CircleImageView


class FragmentHome : android.app.Fragment() {

    /* private lateinit var imgbtnPlaylist : AppCompatImageView
     private lateinit var imgbtnQibla : AppCompatImageView
     private lateinit var imgbtnQazaCalculator : AppCompatImageView
     private lateinit var imgbtnShare : AppCompatImageView
     private lateinit var imgbtnDonate : AppCompatImageView*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("LongLogTag")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val imgbtnPlaylist = view.findViewById<LinearLayout>(R.id.imgbtn_playlist)

        imgbtnPlaylist.setOnClickListener {
            startActivity(Intent(activity, PlaylistActivity::class.java))
            activity.finish()
        }
        val imgbtnDonate = view.findViewById<LinearLayout>(R.id.imgbtn_donation)
        imgbtnDonate.setOnClickListener {
            startActivity(Intent(activity, ActivityDonation::class.java))
            activity.finish()


        }
        val imgbtnQazaCalculator = view.findViewById<LinearLayout>(R.id.imgbtn_qaza_calculator)
        imgbtnQazaCalculator.setOnClickListener {
            startActivity(Intent(activity, ActivityQazaNamaz::class.java))
            activity.finish()
        }

        val imgbtnShare = view.findViewById<LinearLayout>(R.id.imgbtn_share)
        imgbtnShare.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(
                Intent.EXTRA_TEXT,
                "AssalamOAlikum, Please Download Our Application from link https://drive.google.com/drive/u/0/folders/1p47h424ONjcOL12yiHT-IvAUQwGjh-z9"
            )
            sendIntent.type = "text/plain"
            startActivity(Intent.createChooser(sendIntent, "Share"))

        }
        val imgbtnQibla = view.findViewById<LinearLayout>(R.id.imgbtn_qibla)
        imgbtnQibla.setOnClickListener {
            startActivity(Intent(activity, CompassActivity::class.java))
            activity.finish()

        }
        val btnInsta = view.findViewById<CircleImageView>(R.id.btn_insta)
        btnInsta.setOnClickListener {
            val uri: Uri = Uri.parse("https://www.instagram.com/muhammadrazasaqibmustafai/?igshid=1kuvg6juiwyoh")
            val i = Intent(Intent.ACTION_VIEW, uri)
            i.setPackage("com.instagram.android")
            try {
                startActivity(i)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/xxx")
                    )
                )
            }
        }
        val btnFacebook = view.findViewById<CircleImageView>(R.id.btn_facebook)
        btnFacebook.setOnClickListener {
            /*try {
                val followIntent =
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/MRSMofficial/"))
                followIntent.setPackage("com.facebook.android")
                startActivity(followIntent)

            } catch (e: Exception) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com/<user_name>")
                    )
                )
                val errorMessage = if (e.message == null) "Message is empty" else e.message!!
                Log.e("Unlock_ScreenActivity:FacebookAppNotFound", errorMessage)
            }*/

            val uri: Uri = Uri.parse("https://www.facebook.com/MRSMofficial/")
            val i = Intent(Intent.ACTION_VIEW, uri)
            i.setPackage("com.facebook.katana")
            try {
                startActivity(i)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com/MRSMofficial/")
                    )
                )
            }

        }
        val btnTwitter = view.findViewById<CircleImageView>(R.id.btn_twitter)
        btnTwitter.setOnClickListener {
            val uri: Uri = Uri.parse("https://twitter.com/mrsmofficial")
            val i = Intent(Intent.ACTION_VIEW, uri)
            i.setPackage("com.twitter.android")
            try {
                startActivity(i)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com/MRSMofficial/")
                    )
                )
            }
        }


        /*val imageList: MutableList<Int> = ArrayList()
        imageList.add(R.drawable.bismillah_white)
        imageList.add(R.drawable.bismillah_white)

        val myAdapter = MyAdapter(imageList)
        val viewVideo : ViewPager= view.findViewById(R.id.view_pager_videos)
        viewVideo.adapter = myAdapter
*/




        return view
    }


}


