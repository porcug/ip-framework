package com.university.ip.ui.editor.filters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import com.university.ip.R

class LowpassFilters: Filters() {
    override fun Show() {
        TODO("Not yet implemented")
    }

    override fun Hide() {
        TODO("Not yet implemented")
    }

     override fun GetViewHolder(context: Context,parent: ViewGroup): ViewHolder {
         var view= LayoutInflater.from(context).inflate(R.layout.lowpassfilter,parent,false)

         return ViewHolder(view)
     }

     var mean_ksize:Int=0
     var gausian_ksize:Int=0
    var gausian_sigma:Int=0
    var median_ksize:Int=0
    var bilateral_ksize=0
    var bilateral_color=0
    var bilateral_space=0
     override fun Bind(view: ViewHolder) {
      var  seek:SeekBar =view.itemView.findViewById(R.id.seekBar_media)
         seek.progress=mean_ksize
         seek.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
             override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
               mean_ksize=p1;
                 editor?.mean(bitmap,p1)
             }

             override fun onStartTrackingTouch(p0: SeekBar?) {

             }

             override fun onStopTrackingTouch(p0: SeekBar?) {

             }

         })
         seek =view.itemView.findViewById(R.id.seekBar_gaus_size)
         seek.progress=gausian_ksize
         seek.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
             override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                 gausian_ksize=p1;
                 editor?.gausian(bitmap,gausian_ksize,gausian_sigma)
             }

             override fun onStartTrackingTouch(p0: SeekBar?) {

             }

             override fun onStopTrackingTouch(p0: SeekBar?) {

             }

         })
         seek =view.itemView.findViewById(R.id.seekBar_gaus_sigma)
         seek.progress=gausian_ksize
         seek.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
             override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                 gausian_sigma=p1;
                 editor?.gausian(bitmap,gausian_ksize,gausian_sigma)
             }

             override fun onStartTrackingTouch(p0: SeekBar?) {

             }

             override fun onStopTrackingTouch(p0: SeekBar?) {

             }

         })
         seek =view.itemView.findViewById(R.id.seekBar_gaus_sigma)
         seek.progress=gausian_ksize
         seek.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
             override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                 gausian_sigma=p1;
                 editor?.gausian(bitmap,gausian_ksize,gausian_sigma)
             }

             override fun onStartTrackingTouch(p0: SeekBar?) {

             }

             override fun onStopTrackingTouch(p0: SeekBar?) {

             }

         })
         seek =view.itemView.findViewById(R.id.seekBar_median_size)
         seek.progress=median_ksize
         seek.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
             override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                 median_ksize=p1;
                 editor?.median(bitmap,median_ksize)
             }

             override fun onStartTrackingTouch(p0: SeekBar?) {

             }

             override fun onStopTrackingTouch(p0: SeekBar?) {

             }

         })

         seek =view.itemView.findViewById(R.id.seekBar_bilateral_d)
         seek.progress=bilateral_ksize
         seek.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
             override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                 bilateral_ksize=p1;
                 editor?.bilateralFilter(bitmap,bilateral_ksize,bilateral_color,bilateral_space)
             }

             override fun onStartTrackingTouch(p0: SeekBar?) {

             }

             override fun onStopTrackingTouch(p0: SeekBar?) {

             }

         })
         seek =view.itemView.findViewById(R.id.seekBar_bilateral_color)
         seek.progress=bilateral_color
         seek.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
             override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                 bilateral_color=p1;
                 editor?.bilateralFilter(bitmap,bilateral_ksize,bilateral_color,bilateral_space)
             }

             override fun onStartTrackingTouch(p0: SeekBar?) {

             }

             override fun onStopTrackingTouch(p0: SeekBar?) {

             }

         })
         seek =view.itemView.findViewById(R.id.seekBar_bilateral_space)
         seek.progress=bilateral_space
         seek.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
             override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                 bilateral_space=p1;
                 editor?.bilateralFilter(bitmap,bilateral_ksize,bilateral_color,bilateral_space)
             }

             override fun onStartTrackingTouch(p0: SeekBar?) {

             }

             override fun onStopTrackingTouch(p0: SeekBar?) {

             }

         })
         var btn: Button = view.itemView.findViewById(R.id.button_media_apply)
         btn.setOnClickListener{
             bitmap=editor!!.getBitmap()
             var  seek:SeekBar =view.itemView.findViewById(R.id.seekBar_media)
             mean_ksize=0;
             seek.progress=mean_ksize

         }
          btn = view.itemView.findViewById(R.id.button_media_reset)
         btn.setOnClickListener{
             var  seek:SeekBar =view.itemView.findViewById(R.id.seekBar_media)
             mean_ksize=0;
             seek.progress=mean_ksize

         }
         btn = view.itemView.findViewById(R.id.button_median_reset)
         btn.setOnClickListener{
             var  seek:SeekBar =view.itemView.findViewById(R.id.seekBar_media)
             median_ksize=0;
             seek.progress=mean_ksize

         }
         btn = view.itemView.findViewById(R.id.button_median_apply)
         btn.setOnClickListener{
             bitmap=editor!!.getBitmap()
             var  seek:SeekBar =view.itemView.findViewById(R.id.seekBar_median_size)
             median_ksize=0;
             seek.progress=mean_ksize

         }
         btn = view.itemView.findViewById(R.id.button_gaussian_applay)
         btn.setOnClickListener{
             bitmap=editor!!.getBitmap()
             var  seek:SeekBar =view.itemView.findViewById(R.id.seekBar_gaus_size)
             gausian_ksize=0;
             seek.progress=gausian_ksize
             seek =view.itemView.findViewById(R.id.seekBar_gaus_sigma)
             gausian_sigma=0;
             seek.progress=gausian_sigma

         }
         btn = view.itemView.findViewById(R.id.button_gaussian_reset)
         btn.setOnClickListener{
             var  seek:SeekBar =view.itemView.findViewById(R.id.seekBar_gaus_size)
             gausian_ksize=0;
             seek.progress=gausian_ksize
             seek =view.itemView.findViewById(R.id.seekBar_gaus_sigma)
             gausian_sigma=0;
             seek.progress=gausian_sigma

             editor!!.setBitmap(bitmap)
         }
         btn=view.itemView.findViewById(R.id.button_bilateral_aply)
         btn.setOnClickListener{
             bitmap=editor!!.getBitmap()
             var  seek:SeekBar =view.itemView.findViewById(R.id.seekBar_bilateral_space)
             bilateral_space=0;
             seek.progress=bilateral_space
             seek =view.itemView.findViewById(R.id.seekBar_bilateral_color)
             bilateral_color=0;
             seek.progress=bilateral_color
             seek =view.itemView.findViewById(R.id.seekBar_bilateral_d)
             bilateral_ksize=0;
             seek.progress=bilateral_ksize

         }
         btn=view.itemView.findViewById(R.id.button_bilateral_reset)
         btn.setOnClickListener{
             var  seek:SeekBar =view.itemView.findViewById(R.id.seekBar_bilateral_space)
             bilateral_space=0;
             seek.progress=bilateral_space
             seek =view.itemView.findViewById(R.id.seekBar_bilateral_color)
             bilateral_color=0;
             seek.progress=bilateral_color
             seek =view.itemView.findViewById(R.id.seekBar_bilateral_d)
             bilateral_ksize=0;
             seek.progress=bilateral_ksize
             editor!!.setBitmap(bitmap)
         }
    }
}