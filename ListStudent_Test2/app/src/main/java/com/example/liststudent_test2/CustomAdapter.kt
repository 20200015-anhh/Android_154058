package com.example.liststudent_test2

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(val activity: Activity, var list: List<OutData>) : ArrayAdapter<OutData>(activity, R.layout.list_item) {

    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = activity.layoutInflater
        val rowView = convertView ?: inflater.inflate(R.layout.list_item, parent, false)

        val name = rowView.findViewById<TextView>(R.id.name)
        val mssv = rowView.findViewById<TextView>(R.id.mssv)

        name.text = list[position].name
        mssv.text = list[position].mssv

        return rowView
    }
    fun updateList(newList: List<OutData>) {
        list = newList
        notifyDataSetChanged()
    }
}