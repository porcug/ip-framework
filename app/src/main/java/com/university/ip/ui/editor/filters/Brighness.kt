package com.university.ip.ui.editor.filters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import com.university.ip.R

class Brighness:Filters() {
    override fun Show() {
        TODO("Not yet implemented")
    }

    override fun Hide() {
        TODO("Not yet implemented")
    }

    override fun GetViewHolder(context: Context,parent: ViewGroup): ViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.brightness,parent,false)

        return ViewHolder(view)
    }

    var brighness_red:Int=200
    var brighness_green:Int=200
    var brighness_blue:Int=200
    var brighness_all:Int=200
    override fun Bind(holder:ViewHolder) {
        var all: SeekBar = holder.itemView.findViewById(R.id.seekBar_all)
        var red: SeekBar = holder.itemView.findViewById(R.id.seekBar_red)
        var green: SeekBar = holder.itemView.findViewById(R.id.seekBar_green)
        var blue: SeekBar = holder.itemView.findViewById(R.id.seekBar_blue)
        var reset:Button =holder.itemView.findViewById(R.id.reset_button)
        var apply:Button= holder.itemView.findViewById(R.id.apply_button)
        reset.setOnClickListener(View.OnClickListener {
            brighness_red=200
             brighness_green=200
             brighness_blue=200
             brighness_all=200
            red.progress=brighness_red
            green.progress=brighness_green
            blue.progress=brighness_blue
            all.progress=brighness_all
        })
        apply.setOnClickListener(View.OnClickListener {
            bitmap= editor?.getBitmap() ?: bitmap
        })
        red.progress=brighness_red;
        green.progress=brighness_green;
        blue.progress=brighness_blue;
        all.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                brighness_all=p1;

                bitmap?.let { editor?.brightness(it,p1-200) }

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        red.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                brighness_red=p1;
                bitmap?.let{ editor?.brightness(it,brighness_red-200,brighness_green-200,brighness_blue-200)}

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        green.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                brighness_green=p1;
                bitmap?.let{ editor?.brightness(it,brighness_red-200,brighness_green-200,brighness_blue-200)}

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        blue.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                brighness_blue=p1;
                bitmap?.let{ editor?.brightness(it,brighness_red-200,brighness_green-200,brighness_blue-200)}

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

    }

}