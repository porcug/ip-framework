package com.university.ip.util.filters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.university.ip.R
import org.opencv.android.OpenCVLoader.initDebug

class ContrastBritness : AppCompatActivity(),Filter {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        initDebug()
    }

    override fun Title(): String {
        return "Contrast Britness"
    }

    override fun Launch(context: Activity,bitmap: Bitmap):Bitmap {
        val intent: Intent = Intent(context.baseContext,ContrastBritness::class.java)

        context.startActivity(intent)

        return bitmap

    }
}