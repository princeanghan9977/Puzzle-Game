package com.example.mathspuzzle

import android.os.Bundle
import android.text.Layout
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView


class openstages : AppCompatActivity() {


    lateinit var addbanner: LinearLayout


    lateinit var ostextview: TextView

    lateinit var gridview1: GridView

    var arraystage = arrayOf(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
        "13",
        "14",
        "15",
        "16",
        "17",
        "18",
        "19",
        "20",
        "21",
        "22",
        "23",
        "24",
        "25",
        "26",
        "27",
        "28",
        "29",
        "30",
        "31",
        "32",
        "33",
        "34",
        "35",
        "36",
        "37",
        "38",
        "39",
        "40",
        "41",
        "42",
        "43",
        "44",
        "45",
        "46",
        "47",
        "48",
        "49",
        "50",
        "51",
        "52",
        "53",
        "54",
        "55",
        "56",
        "57",
        "58",
        "59",
        "60",
        "61",
        "62",
        "63",
        "64",
        "65",
        "66",
        "67",
        "68",
        "69",
        "70",
        "71",
        "72",
        "73",
        "74",
        "75"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_openstages)

        ostextview = findViewById(R.id.ostextview)
        gridview1 = findViewById(R.id.gridview1)

        addbanner = findViewById(R.id.addbanner)

        var myadepter1 = Myadapter1(this@openstages, arraystage)
        gridview1.adapter = myadepter1

        var adView = AdView(this)
        adView.setAdSize(AdSize.LARGE_BANNER)
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
        var adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        addbanner.addView(adView)



    }
}