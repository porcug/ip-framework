package com.university.ip.ui.editor.filters

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.university.ip.R
import com.university.ip.ui.editor.EditorPresenter
import com.university.ip.ui.editor.FiltersAdapter

abstract class Filters
{


    abstract  fun Show()
   abstract fun  Hide()
   abstract fun GetViewHolder(context: Context, parent: ViewGroup): ViewHolder
  companion object {
  fun GetFilters():ArrayList<Filters> {
      var elements:ArrayList<Filters> = arrayListOf();
       elements.add(Brighness())
       elements.add(Contrast())
      elements.add(Binarizare())
      elements.add(LowpassFilters())
       return elements
  }
      fun SetEditorPresenter(preseter:EditorPresenter)
      {
          editor=preseter

      }
      fun SetImage(image:Bitmap)
      {
          bitmap=image
      }
     var editor: EditorPresenter? =null
      var bitmap: Bitmap= Bitmap.createBitmap(1,1,Bitmap.Config.ARGB_8888)
  }
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    abstract fun Bind(view:ViewHolder)


}