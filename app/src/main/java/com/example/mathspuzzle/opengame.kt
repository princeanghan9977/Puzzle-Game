package com.example.mathspuzzle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.mathspuzzle.MainActivity.Companion.editior
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

class opengame : AppCompatActivity() {


    lateinit var addbanner: LinearLayout


    lateinit var ognext: ImageView
    lateinit var ogmaintextview1: TextView
    lateinit var oghint: ImageView

    lateinit var imageviewgame: ImageView

    lateinit var ogtextview2: TextView
    lateinit var berase: ImageView
    lateinit var submit: TextView

    lateinit var b1: Button
    lateinit var b2: Button
    lateinit var b3: Button
    lateinit var b4: Button
    lateinit var b5: Button
    lateinit var b6: Button
    lateinit var b7: Button
    lateinit var b8: Button
    lateinit var b9: Button
    lateinit var b0: Button


    var arrayimage = arrayOf(
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4,
        R.drawable.p5,
        R.drawable.p6,
        R.drawable.p7,
        R.drawable.p8,
        R.drawable.p9,
        R.drawable.p10,
        R.drawable.p11,
        R.drawable.p12,
        R.drawable.p13,
        R.drawable.p14,
        R.drawable.p15,
        R.drawable.p16,
        R.drawable.p17,
        R.drawable.p18,
        R.drawable.p19,
        R.drawable.p20,
        R.drawable.p21,
        R.drawable.p22,
        R.drawable.p23,
        R.drawable.p24,
        R.drawable.p25,
        R.drawable.p26,
        R.drawable.p27,
        R.drawable.p28,
        R.drawable.p29,
        R.drawable.p30,
        R.drawable.p31,
        R.drawable.p32,
        R.drawable.p33,
        R.drawable.p34,
        R.drawable.p35,
        R.drawable.p36,
        R.drawable.p37,
        R.drawable.p38,
        R.drawable.p39,
        R.drawable.p40,
        R.drawable.p41,
        R.drawable.p42,
        R.drawable.p43,
        R.drawable.p44,
        R.drawable.p45,
        R.drawable.p46,
        R.drawable.p47,
        R.drawable.p48,
        R.drawable.p49,
        R.drawable.p50,
        R.drawable.p51,
        R.drawable.p52,
        R.drawable.p53,
        R.drawable.p54,
        R.drawable.p55,
        R.drawable.p56,
        R.drawable.p57,
        R.drawable.p58,
        R.drawable.p59,
        R.drawable.p60,
        R.drawable.p61,
        R.drawable.p62,
        R.drawable.p63,
        R.drawable.p64,
        R.drawable.p65,
        R.drawable.p66,
        R.drawable.p67,
        R.drawable.p68,
        R.drawable.p69,
        R.drawable.p70,
        R.drawable.p71,
        R.drawable.p72,
        R.drawable.p73,
        R.drawable.p74,
        R.drawable.p75
    )
    var arraystagewin = arrayOf(
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
    var level = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opengame)

        ognext = findViewById(R.id.ognext)
        ogmaintextview1 = findViewById(R.id.ogmaintextview1)
        oghint = findViewById(R.id.oghint)

        imageviewgame = findViewById(R.id.imageviewgame)

        ogtextview2 = findViewById(R.id.ogtextview2)
        berase = findViewById(R.id.berase)
        submit = findViewById(R.id.submit)


        addbanner = findViewById(R.id.addbanner)

        var adView = AdView(this)
        adView.setAdSize(AdSize.BANNER)
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
        var adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        addbanner.addView(adView)


        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4 = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6 = findViewById(R.id.b6)
        b7 = findViewById(R.id.b7)
        b8 = findViewById(R.id.b8)
        b9 = findViewById(R.id.b9)
        b0 = findViewById(R.id.b0)


        level = intent.getIntExtra("cnt", 0)
        ogmaintextview1.text = "Puzzle ${level + 1}"


        imageviewgame.setImageResource(arrayimage[level])

        ognext.setOnClickListener {

            MainActivity.statuslist[level] = MainActivity.Isskip
            MainActivity.editior.putString("status$level", MainActivity.Isskip)


            Log.e("====", "onCreate:${MainActivity.statuslist} ")

            level++

            editior.putInt("lavel", level)
            editior.apply()

            startActivity(Intent(this@opengame, opengame::class.java).putExtra("cnt", level))

            finish()
        }
        oghint.setOnClickListener {


        }

//        ogtextview2.setOnClickListener { }


        b1.setOnClickListener {
            press("1")
        }
        b2.setOnClickListener {
            press("2")
        }
        b3.setOnClickListener {
            press("3")
        }
        b4.setOnClickListener {
            press("4")
        }
        b5.setOnClickListener {
            press("5")
        }
        b6.setOnClickListener {
            press("6")
        }
        b7.setOnClickListener {
            press("7")
        }
        b8.setOnClickListener {
            press("8")
        }
        b9.setOnClickListener {
            press("9")
        }
        b0.setOnClickListener {
            press("0")
        }


        berase.setOnClickListener {
            if (ogtextview2.text.isNotEmpty())
                ogtextview2.text =
                    ogtextview2.text.toString().substring(0, ogtextview2.text.toString().length - 1)
        }


        submit.setOnClickListener {
            if (ogtextview2.text.toString() == arraystagewin[level]) {


                var levelstatus = MainActivity.statuslist[level]

                if (levelstatus.equals(MainActivity.Isclear)) {

                    MainActivity.statuslist[level] = MainActivity.Isclear
                    MainActivity.editior.putString("status$level", MainActivity.Isclear)
                    MainActivity.editior.apply()


                    var get4 = Intent(this@opengame, winpage::class.java)
                    get4.putExtra("cnt", level)
                    startActivity(get4)
                    finish()


                } else if (levelstatus.equals(MainActivity.Isskip)) {

                    MainActivity.statuslist[level] = MainActivity.Isclear
                    MainActivity.editior.putString("status$level", MainActivity.Isclear)
                    MainActivity.editior.apply()


                    var get4 = Intent(this@opengame, winpage::class.java)
                    get4.putExtra("cnt", level)
                    startActivity(get4)
                    finish()


                } else {

                    MainActivity.statuslist[level] = MainActivity.Isclear
                    MainActivity.editior.putString("status$level", MainActivity.Isclear)

                    Log.w("==1==1==1==1==", "onCreate:${MainActivity.statuslist}")

                    level++

                    MainActivity.editior.putInt("lavel", level)
                    MainActivity.editior.apply()

                    var get4 = Intent(this@opengame, winpage::class.java)
                    get4.putExtra("cnt", (level - 1))
                    startActivity(get4)
                    finish()
                }
            } else {

                if (ogtextview2.text.isNotEmpty())
                    Toast.makeText(this@opengame, "WORNG ANSWER", Toast.LENGTH_LONG).show()

            }
        }

        ogtextview2.text = ""
    }

    fun press(press: String) {
        ogtextview2.text = ogtextview2.text.toString() + press
    }

    override fun onBackPressed() {
        super.onBackPressed()

        startActivity(Intent(this@opengame, MainActivity::class.java))
        finish()
    }

}


