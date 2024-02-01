//package com.example.mathspuzzle
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import androidx.viewpager.widget.PagerAdapter
//
//class Viewpageradapter(var opengame: opengame,var arrayimage: Array<Int>) : PagerAdapter() {
//
//    override fun getCount(): Int = arrayimage.size
//
//    override fun isViewFromObject(view: View, `object`: Any): Boolean {
//
//        return view == `object`
//    }
//
//    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        container.removeView(`object` as View)
//    }
//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//
//     var pgvimage: ImageView
//
//     var view = LayoutInflater.from(opengame).inflate(R.layout.viewpageradapter,container,false)
//
//        pgvimage = view.findViewById(R.id.pgvimage)
//
//        pgvimage.setImageResource(arrayimage[position])
//
//        container.addView(view)
//
//        return view
//    }
//
//}
