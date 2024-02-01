package com.example.mathspuzzle

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mathspuzzle.MainActivity.Companion.sp

class Myadapter1(
    var openstages: openstages,
    var arraystage: Array<String>,
) :
    BaseAdapter() {

    override fun getCount(): Int = arraystage.size

    override fun getItem(position: Int): Any = arraystage[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var ad1textview: TextView
        var imagelock: ImageView

        var view = LayoutInflater.from(openstages).inflate(R.layout.onemyadapterview, parent, false)

        ad1textview = view.findViewById(R.id.ad1textview)
        imagelock = view.findViewById(R.id.imagelock)

        var lavel = sp.getInt("lavel", 0)

        var levelstatus = MainActivity.statuslist[position]


        Log.e("ppp---TAG", "getView----lavel ::: $lavel")

        if (lavel == position) {
            imagelock.setImageResource(0)
            ad1textview.setText("${position + 1}")
            ad1textview.setOnClickListener {
                openstages.startActivity(
                    Intent(openstages, opengame::class.java).putExtra(
                        "cnt",
                        position
                    )
                )
                openstages.finish()
            }
        } else {

            if (levelstatus.equals(MainActivity.Isclear)) {

                imagelock.setImageResource(R.drawable.tick)
                ad1textview.setText("${position + 1}")


                ad1textview.setOnClickListener {

                    openstages.startActivity(
                        Intent(
                            openstages,
                            opengame::class.java
                        ).putExtra("cnt", position)
                    )
                    openstages.finish()

                }

            } else if (levelstatus.equals(MainActivity.Isskip)) {

                imagelock.setImageResource(0)
                ad1textview.setText("${position + 1}")

                ad1textview.setOnClickListener {

                    openstages.startActivity(
                        Intent(
                            openstages,
                            opengame::class.java
                        ).putExtra("cnt", position)
                    )
                    openstages.finish()

                }
            }
        }


        var anim1 = AnimationUtils.loadAnimation(openstages, R.anim.myanim)
        view.startAnimation(anim1)

        return view


    }
}