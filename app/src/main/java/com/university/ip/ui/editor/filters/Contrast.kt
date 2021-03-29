package com.university.ip.ui.editor.filters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.recyclerview.widget.RecyclerView
import com.university.ip.R
import com.university.ip.ui.editor.FiltersAdapter

class Contrast: Filters() {
    override fun Show() {
        TODO("Not yet implemented")
    }

    override fun Hide() {
        TODO("Not yet implemented")
    }
    var contrast_red:Int=200
    var contrast_green:Int=200
    var contrast_blue:Int=200
    var contrast_all:Int=200
    override fun GetViewHolder(context: Context, parent: ViewGroup): ViewHolder {
        var view= LayoutInflater.from(context).inflate(R.layout.contrast,parent,false)

        return ViewHolder(view)
    }

    override fun Bind(holder :ViewHolder) {
        var all:SeekBar= holder.itemView.findViewById(R.id.seekBar_all)
        var red:SeekBar= holder.itemView.findViewById(R.id.seekBar_red)
        var green:SeekBar= holder.itemView.findViewById(R.id.seekBar_green)
        var blue:SeekBar= holder.itemView.findViewById(R.id.seekBar_blue)
        var reset: Button =holder.itemView.findViewById(R.id.reset_button)
        var apply: Button = holder.itemView.findViewById(R.id.apply_button)
        reset.setOnClickListener(View.OnClickListener {
            contrast_red=200
            contrast_green=200
            contrast_blue=200
            contrast_all=200
            red.progress=contrast_red
            green.progress=contrast_green
            blue.progress=contrast_blue
            all.progress=contrast_all
        })
        apply.setOnClickListener(View.OnClickListener {
            bitmap= editor?.getBitmap() ?: bitmap
        })
        all.progress=contrast_all;
        red.progress=contrast_red;
        green.progress=contrast_green;
        blue.progress=contrast_blue;
        all.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
               contrast_all=p1;

                editor?.contrast(bitmap,p1.toDouble()/200)

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        red.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                contrast_red=p1;
                editor?.contrast(bitmap,contrast_red.toDouble()/200,contrast_green.toDouble()/200,contrast_blue.toDouble()/200)

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        green.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                contrast_green=p1;
                editor?.contrast(bitmap,contrast_red.toDouble()/200,contrast_green.toDouble()/200,contrast_blue.toDouble()/200)

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        blue.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                contrast_blue=p1;
                editor?.contrast(bitmap,contrast_red.toDouble()/200,contrast_green.toDouble()/200,contrast_blue.toDouble()/200)

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

    }

}


