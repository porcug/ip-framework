package com.university.ip.ui.editor.filters

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.SeekBar
import com.university.ip.R

class Binarizare:Filters() {
    override fun Show() {
        TODO("Not yet implemented")
    }

    override fun Hide() {
        TODO("Not yet implemented")
    }

    override fun GetViewHolder(context: Context, parent: ViewGroup): ViewHolder {
        var view= LayoutInflater.from(context).inflate(R.layout.binarizare,parent,false)

        return ViewHolder(view)
    }
    var start_val=0;
    var stop_val=255;
    override fun Bind(view: ViewHolder) {
        var reset:Button=view.itemView.findViewById(R.id.reset_button)
        var prevew:Button=view.itemView.findViewById(R.id.prevew_button)
        var apply:Button=view.itemView.findViewById(R.id.apply_button)

      var histogram:ImageView =view.itemView.findViewById(R.id.image_histogram)
        histogram.setOnClickListener(View.OnClickListener {


            histogram.setImageBitmap( editor!!.histogram(bitmap,start_val,stop_val))
        })
        histogram.setImageBitmap( editor!!.histogram(bitmap,start_val,stop_val))
        var start:SeekBar =view.itemView.findViewById(R.id.seekBar_start)
        var stop:SeekBar =view.itemView.findViewById(R.id.seekBar_stop)
        start.progress=start_val
        stop.progress=stop_val
        start.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                start_val=p1
                histogram.setImageBitmap( editor!!.histogram(bitmap,start_val,stop_val))
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        stop.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                stop_val=p1
                histogram.setImageBitmap( editor!!.histogram(bitmap,start_val,stop_val))
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        reset.setOnClickListener(View.OnClickListener {
            editor?.setBitmap(bitmap)
            start_val=0
            start.progress=start_val
            stop_val=255
            stop.progress=stop_val
            histogram.setImageBitmap( editor!!.histogram(bitmap,start_val,stop_val))

        })

        prevew.setOnClickListener(View.OnClickListener {
            editor?.chopImage(bitmap,start_val,stop_val)
        })
        apply.setOnClickListener(View.OnClickListener {
            editor?.chopImage(bitmap,start_val,stop_val)
            bitmap= editor?.getBitmap()!!
        })

    }

}