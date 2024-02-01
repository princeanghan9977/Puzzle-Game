package com.example.mathspuzzle

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.R.color.material_blue_grey_800
import com.example.mathspuzzle.MainActivity.Companion.sp

class mytask : AppCompatActivity() {

    lateinit var lll: LinearLayout
    lateinit var edt: EditText
    lateinit var btset: Button
    lateinit var tx: TextView
    lateinit var btget: Button

    lateinit var sp1: SharedPreferences
    lateinit var editor1: SharedPreferences.Editor

    var pass = ""
    var data = ""
    var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mytask)

        lll = findViewById(R.id.lll)
        edt = findViewById(R.id.edt)
        btset = findViewById(R.id.btset)
        tx = findViewById(R.id.tx)
        btget = findViewById(R.id.btget)

        sp1 = getSharedPreferences("get", MODE_PRIVATE)
        editor1 = sp1.edit()

        pass = sp1.getString("set", "hello")!!
        count = sp1.getInt("setcolour", 0)

        btset.setOnClickListener {

            if (edt.text.isNotEmpty()) {

                data = edt.text.toString()

            } else Toast.makeText(this@mytask, "Enter Value", Toast.LENGTH_SHORT).show()
        }
        btget.setOnClickListener {

            if (edt.text.isNotEmpty()) {
                tx.text = data
                editor1.putString("set", tx.text as String)
                editor1.apply()
            } else {
                tx.text = pass
                editor1.putString("set", tx.text as String)
                editor1.apply()
            }
        }

        count++
        editor1.putInt("setcolour", count)
        editor1.apply()

        Log.d("==============", "${count}")
        if (count % 2 == 0) {
            lll.setBackgroundResource(R.color.red)

            count = 0
            editor1.putInt("setcolour", count)
            editor1.apply()

        } else {
            lll.setBackgroundResource(R.color.green)
        }
    }
}