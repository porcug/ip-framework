package com.university.ip.ui.editor

import android.graphics.Bitmap
import com.university.ip.repository.Operators
import com.university.ip.ui.base.BasePresenter
import org.opencv.core.Scalar

class EditorPresenter : BasePresenter<EditorContract.View>(), EditorContract.Presenter {

    private val operators = Operators()
    private var bitmap:Bitmap= Bitmap.createBitmap(1,1,Bitmap.Config.ARGB_8888)
    override fun brightness(bitmap: Bitmap, value: Int) {
        val result = operators.modifyBrightness(bitmap, value)
        this.bitmap =result
        getView()?.setBitmap(result)
    }

    override fun brightness(bitmap: Bitmap, red: Int, green: Int,blue:Int) {
        val result = operators.modifyRGBBrightness(bitmap, red, green, blue)
        this.bitmap =result
        getView()?.setBitmap(result)
    }

    override fun contrast(bitmap: Bitmap, value: Double) {
        val result = operators.modifyContrast(bitmap, value)
        this.bitmap =result
        getView()?.setBitmap(result)
    }

    override fun contrast(bitmap: Bitmap, red: Double, green:Double,blue: Double) {
        val result = operators.modifyRGBContrast(bitmap, red,green, blue)
        this.bitmap =result
        getView()?.setBitmap(result)
    }

    override fun sepia(bitmap: Bitmap) {
        val result = operators.toSepia(bitmap)
        this.bitmap =result
        getView()?.setBitmap(result)
    }

    override fun histogram(bitmap: Bitmap,start:Int,stop:Int): Bitmap {
        return operators.histogram(bitmap,start, stop)
    }



    override fun setBitmap(bitmap: Bitmap) {
        getView()?.setBitmap(bitmap)
        this.bitmap =bitmap
    }

    override fun chopImage(bitmap: Bitmap, start: Int, stop: Int) {
        val result = operators.chopimage(bitmap,start, stop)
        this.bitmap =result
        getView()?.setBitmap(result)
    }

    override fun bilateralFilter(bitmap: Bitmap, d: Int, sigmaColor: Int, sigmaSpace: Int) {
        val result = operators.bilateralFilter(bitmap,d,sigmaColor.toDouble(),sigmaSpace.toDouble())
        this.bitmap =result
        getView()?.setBitmap(result)
    }

    override fun median(bitmap: Bitmap,ksize:Int) {
        val result = operators.median(bitmap, ksize)
        this.bitmap =result
        getView()?.setBitmap(result)
    }
    override fun mean(bitmap: Bitmap,ksize:Int) {
        val result = operators.mean(bitmap, ksize)
        this.bitmap =result
        getView()?.setBitmap(result)
    }

    override fun gausian(bitmap: Bitmap, ksize: Int, sigma: Int) {
        val result = operators.gausian(bitmap, ksize,sigma)
        this.bitmap =result
        getView()?.setBitmap(result)
    }

    fun getBitmap():Bitmap {return bitmap}
}