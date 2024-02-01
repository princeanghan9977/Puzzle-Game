package com.example.mathspuzzle

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.log

class MainActivity : AppCompatActivity() {


    // Shareprefrnce = get  // key , Value
    // Editior = Set

//    companion object{
//        var lavel = 0
//
//        lateinit var sp : SharedPreferences     // Value Get
//        lateinit var editior : SharedPreferences.Editor   // Value Set
//    }

    companion object {


        lateinit var sp: SharedPreferences
        lateinit var editior: SharedPreferences.Editor

        var Isclear = "clear"
        var Isskip = "skip"
        var IsPending = "pending"

        var statuslist = ArrayList<String>()


    }

    var lavel = 0;

    lateinit var txcontinue: TextView
    lateinit var txpuzzles: TextView
    lateinit var txbuypro: TextView

    lateinit var share: ImageView
    lateinit var email: ImageView
    lateinit var privacypolicy: TextView

    lateinit var addbanner: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        txcontinue = findViewById(R.id.txcontinue)
        txpuzzles = findViewById(R.id.txpuzzles)
        txbuypro = findViewById(R.id.txbuypro)

        share = findViewById(R.id.share)
        email = findViewById(R.id.email)

        privacypolicy = findViewById(R.id.privacypolicy)

        addbanner = findViewById(R.id.addbanner)

        var adView = AdView(this)
        adView.setAdSize(AdSize.BANNER)
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
        var adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        addbanner.addView(adView)


        sp = getSharedPreferences("get", MODE_PRIVATE)  // MODE_PRIVATE = 0 by default value
        editior = sp.edit()

        lavel = sp.getInt("lavel",0)


        for(index in 0..74)
        {
            var levelstatus = sp.getString("status$index", IsPending)!!
            statuslist.add(levelstatus)
        }

        Log.d("=====", "onCreate: "+ statuslist)


        txcontinue.setOnClickListener {

            var get0 = Intent(this@MainActivity, opengame::class.java)
            get0.putExtra("cnt",lavel)
            startActivity(get0)
            finish();

         //short   startActivity(Intent(this@MainActivity,opengame::class.java))

        }

        txpuzzles.setOnClickListener {
            var get1 = Intent(this@MainActivity, openstages::class.java)
//            get1.putExtra("cnt",lavel)
            startActivity(get1)
            finish()

        }

    }
}