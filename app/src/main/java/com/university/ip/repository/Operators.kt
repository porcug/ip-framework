package com.university.ip.repository

import android.graphics.Bitmap
import org.opencv.android.Utils
import org.opencv.core.*
import org.opencv.imgproc.Imgproc


class Operators {
    fun modifyBrightness(bitmap: Bitmap, value: Int): Bitmap {
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        src.convertTo(src, -1, 1.0, value.toDouble())
        val result = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }
    fun modifyRGBBrightness(bitmap: Bitmap, red: Int, green: Int, blue: Int): Bitmap {

        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        val dst: ArrayList<Mat> = ArrayList(3)
        Core.split(src, dst)
        dst[0].convertTo(dst[0], -1, 1.0, red.toDouble())
        dst[1].convertTo(dst[1], -1, 1.0, green.toDouble())
        dst[2].convertTo(dst[2], -1, 1.0, blue.toDouble())

        Core.merge(dst, src)
        val result = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }
    fun modifyContrast(bitmap: Bitmap, value: Double): Bitmap {
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)

        src.convertTo(src, -1, value.toDouble(), 0.0)
        val result = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }
    fun modifyRGBContrast(bitmap: Bitmap, red: Double, green: Double, blue: Double): Bitmap {

        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        val dst: ArrayList<Mat> = ArrayList(3)
        Core.split(src, dst)

        dst[0].convertTo(dst[0], -1, red.toDouble(), 0.0)
        dst[1].convertTo(dst[1], -1, green.toDouble(), 0.0)
        dst[2].convertTo(dst[2], -1, blue.toDouble(), 0.0)
        Core.merge(dst, src)
        val result = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }
    fun toSepia(bitmap: Bitmap) :Bitmap {
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        var dest = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        val filter=Mat(3, 3, CvType.CV_32F)
        filter.put(0, 0, .131, .534, .272)
        filter.put(1, 0, .168, .686, .349)
        filter.put(2, 0, .189, .769, .393)
        Utils.bitmapToMat(bitmap, src);
        Core.transform(src, dest, filter)
        val result = Bitmap.createBitmap(dest.cols(), dest.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(dest, result)
        return result
    }
    fun histogram(bitmap: Bitmap,start:Int,stop:Int):Bitmap {
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        val bgrPlanes: List<Mat> = ArrayList()
        Core.split(src, bgrPlanes)
        val histSize = 256
        val range = floatArrayOf(0f, 256f) //the upper boundary is exclusive

        val histRange = MatOfFloat(*range)
        val accumulate = false
        val bHist = Mat()
        val gHist = Mat()
        val rHist = Mat()
        Imgproc.calcHist(bgrPlanes, MatOfInt(0), Mat(), bHist, MatOfInt(histSize), histRange, accumulate)
        Imgproc.calcHist(bgrPlanes, MatOfInt(1), Mat(), gHist, MatOfInt(histSize), histRange, accumulate)
        Imgproc.calcHist(bgrPlanes, MatOfInt(2), Mat(), rHist, MatOfInt(histSize), histRange, accumulate)
        val histW = 512
        val histH = 512
        val binW = Math.round(histW.toDouble() / histSize).toInt()
        val histImage = Mat(histH, histW, CvType.CV_8UC4, Scalar(.0, .0, .0,15.0))
        Core.normalize(bHist, bHist, 0.0, histImage.rows().toDouble(), Core.NORM_MINMAX)
        Core.normalize(gHist, gHist, 0.0, histImage.rows().toDouble(), Core.NORM_MINMAX)
        Core.normalize(rHist, rHist, 0.0, histImage.rows().toDouble(), Core.NORM_MINMAX)
        val bHistData = FloatArray((bHist.total() * bHist.channels()).toInt())
        bHist[0, 0, bHistData]
        val gHistData = FloatArray((gHist.total() * gHist.channels()).toInt())
        gHist[0, 0, gHistData]
        val rHistData = FloatArray((rHist.total() * rHist.channels()).toInt())
        rHist[0, 0, rHistData]
        for (i in 1 until histSize) {
            Imgproc.line(histImage, Point((binW * (i - 1)).toDouble(), (histH - Math.round(bHistData[i - 1])).toDouble()),
                    Point((binW * i).toDouble(), (histH - Math.round(bHistData[i])).toDouble()), Scalar(255.0, .0, .0,255.0), 2)
            Imgproc.line(histImage, Point((binW * (i - 1)).toDouble(), (histH - Math.round(gHistData[i - 1])).toDouble()),
                    Point((binW * i).toDouble(), (histH - Math.round(gHistData[i])).toDouble()), Scalar(.0, 255.0, .0,255.0), 2)
            Imgproc.line(histImage, Point((binW * (i - 1)).toDouble(), (histH - Math.round(rHistData[i - 1])).toDouble()),
                    Point((binW * i).toDouble(), (histH - Math.round(rHistData[i])).toDouble()), Scalar(.0, .0, 255.0,255.0), 2)
        }

        val result = Bitmap.createBitmap(histImage.cols(), histImage.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(histImage, result)
        return result
    }
    fun addline(bitmap: Bitmap, position: Int, color: Scalar):Bitmap {
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        Imgproc.line(src, Point(position.toDouble() * 2, 0.0), Point(position.toDouble() * 2, bitmap.getWidth().toDouble()), color)
        val result = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }
    fun chopimage(bitmap: Bitmap, start: Int, stop: Int):Bitmap {
        val src =Mat(bitmap.height, bitmap.width, CvType.CV_8UC1)
        val tmp = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U)
        val alpha = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8U)
        Utils.bitmapToMat(bitmap, src)
       Imgproc.cvtColor(src, tmp, Imgproc.COLOR_BGR2GRAY)
        Imgproc.threshold(tmp, alpha, start.toDouble(), 255.0, Imgproc.THRESH_BINARY_INV)
       // Imgproc.threshold(alpha, alpha, stop.toDouble(), 255.0, Imgproc.THRESH_BINARY)
        val bgra: ArrayList<Mat> = ArrayList(4)
        Core.split(src, bgra)
       bgra.drop(3)
        bgra.add(alpha);
        var dst = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC4)
        Core.merge(bgra, dst);
        val output = Bitmap.createBitmap(alpha.cols(),alpha.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(dst, output)

        return output
    }
    fun bilateralFilter(bitmap: Bitmap,d:Int,sigmaColor:Double,sigmaSpace:Double):Bitmap{
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        var dst=src.clone()
        Imgproc.cvtColor(dst,src,Imgproc.COLOR_BGRA2BGR)
        dst=src.clone()
        Imgproc.bilateralFilter(src,dst,d,sigmaColor,sigmaSpace)
        val result = Bitmap.createBitmap(dst.cols(), dst.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(dst, result)
        return result
    }
    fun median(bitmap: Bitmap,ksize:Int):Bitmap{
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        var dst=src.clone()
        Imgproc.medianBlur(src, dst, ksize*2+1)
        val result = Bitmap.createBitmap(dst.cols(), dst.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(dst, result)
        return result
    }
    fun mean(bitmap: Bitmap,ksize:Int):Bitmap{
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        var dst=src.clone()
        var size=Size()
        size.height=ksize.toDouble()*2+1
        size.width=ksize.toDouble()*2+1
        Imgproc.blur(src,dst,size)
        val result = Bitmap.createBitmap(dst.cols(), dst.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(dst, result)
        return result
    }
    fun gausian(bitmap: Bitmap,ksize:Int,sigma:Int):Bitmap{
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        var dst=src.clone()
        var size=Size()
        size.height=ksize.toDouble()*2+1
        size.width=ksize.toDouble()*2+1
        Imgproc.GaussianBlur(src,dst,size,sigma.toDouble())
        val result = Bitmap.createBitmap(dst.cols(), dst.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(dst, result)
        return result
    }
}