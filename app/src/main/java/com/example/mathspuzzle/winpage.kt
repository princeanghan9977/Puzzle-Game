package com.example.mathspuzzle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class winpage : AppCompatActivity() {

    lateinit var addbanner: LinearLayout
    lateinit var wintextview: TextView

    lateinit var wincontinue: Button
    lateinit var winmainmenu: Button

    lateinit var winshear: ImageView

    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winpage)

        InterAdd()

        wintextview = findViewById(R.id.wintextview)
        wincontinue = findViewById(R.id.wincontinue)
        winmainmenu = findViewById(R.id.winmainmenu)
        winshear = findViewById(R.id.winshear)

        addbanner = findViewById(R.id.addbanner)



        var adView = AdView(this)
        adView.setAdSize(AdSize.BANNER)
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"

        var adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        addbanner.addView(adView)





        var level = intent.getIntExtra("cnt", 0)

        wintextview.text = "Puzzle ${level + 1} Completed"



        wincontinue.setOnClickListener {


            var get5 = Intent(this@winpage, opengame::class.java)
            get5.putExtra("cnt", (level + 1))
            startActivity(get5)
            finish()


            if (mInterstitialAd != null) {
                mInterstitialAd!!.show(this@winpage)
            }

        }


        winmainmenu.setOnClickListener {

            var get6 = Intent(this@winpage, MainActivity::class.java)
            startActivity(get6)
            finish()
        }


    }

    fun InterAdd() {


        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712",
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    adError?.toString()?.let { Log.d("=====", it) }
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d("=====", "Ad was loaded.")
                    mInterstitialAd = interstitialAd

                }
            })
    }
}