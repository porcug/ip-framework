package com.university.ip.ui.editor.filters

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.university.ip.ui.editor.FiltersAdapter

class FiltersAdapter(context: Context, val itemClickListener: FiltersAdapter.ItemClickListener) :
        RecyclerView.Adapter<Filters.ViewHolder>(){
    var context=context
   var  Filters:ArrayList<Filters> = com.university.ip.ui.editor.filters.Filters.GetFilters()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Filters.ViewHolder {

       return Filters[viewType].GetViewHolder(context,parent)
    }



    override fun getItemCount(): Int {
        return Filters.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
    override fun onBindViewHolder(holder: Filters.ViewHolder, position: Int) {
        Filters[position].Bind(holder)
    }
}