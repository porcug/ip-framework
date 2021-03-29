package com.university.ip.util.filters

import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.university.ip.R
import com.university.ip.model.Photo


class FilterAdapter(context: Context,var obj:List<Filter>):
    ArrayAdapter<Filter>(context, R.layout.filter_items,obj) {

    override public fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
      var inflater= LayoutInflater.from(context).inflate(R.layout.filter_items,parent);
       var text: TextView = inflater.findViewById(R.id.filter_name)
       text.text = obj[position].Title()

        return inflater;
    }
    interface OnItemClickListener {
        fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long)

    }
}