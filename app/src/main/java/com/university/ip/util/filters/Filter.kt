package com.university.ip.util.filters

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import com.university.ip.ui.editor.EditorActivity

interface Filter {
    public fun Title():String
    public fun Launch(activity: Activity, bitmap: Bitmap):Bitmap
}