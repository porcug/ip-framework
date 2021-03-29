package com.university.ip.ui.editor

import android.graphics.Bitmap
import com.university.ip.ui.base.BaseContract

interface EditorContract {

    interface View : BaseContract.View {
        //view functions for each change of activity
        fun setBitmap(bitmap: Bitmap)
    }

    interface Presenter {
        //functions that are going to use our library
        fun brightness(bitmap: Bitmap, value:Int)
        fun brightness(bitmap: Bitmap,red: Int,green:Int,blue:Int)
        fun contrast(bitmap: Bitmap, value: Double)
        fun contrast(bitmap: Bitmap, red: Double,green:Double,blue:Double)
        fun  sepia(bitmap: Bitmap)
        fun histogram(bitmap: Bitmap,start:Int,stop:Int):Bitmap

        fun setBitmap(bitmap:Bitmap)
        fun chopImage(bitmap: Bitmap,start:Int,stop:Int)
        fun bilateralFilter(bitmap: Bitmap,d:Int,sigmaColor:Int,sigmaSpace:Int)
        fun median(bitmap: Bitmap,ksize:Int)
        fun mean(bitmap: Bitmap,ksize:Int)
        fun gausian(bitmap: Bitmap,ksize:Int,sigma:Int)
    }
}