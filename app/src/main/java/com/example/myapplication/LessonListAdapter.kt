package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LessonListAdapter(private val list: List<Lesson>) : RecyclerView.Adapter<LessonListAdapter.MyVH>() {

    class MyVH(val view: View) : RecyclerView.ViewHolder(view) {
        val ttime : TextView = view.findViewById(R.id.tv_time)
        val name : TextView = view.findViewById(R.id.tv_name)
        val cclass : TextView = view.findViewById(R.id.tv_class)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val layout = when(viewType) {
            LESSON_P_TYPE -> R.layout.plesson_item
            LESSON_L_TYPE -> R.layout.llesson_item
            else -> {
                Log.d("test", "!!!!!")
            }
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return MyVH(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        val ttype = list[position].type
        return when(ttype) {
            0 -> LESSON_L_TYPE
            1 -> LESSON_P_TYPE
            else -> {
                LESSON_UNKCNOW_TYPE}
        }
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        val elem = list[position]
        holder.cclass.text = elem.cclass
        holder.name.text = elem.name
        holder.ttime.text = elem.time
    }
    companion object {
        private const val LESSON_P_TYPE = 100
        private const val LESSON_L_TYPE = 101
        private const val LESSON_UNKCNOW_TYPE = 102
    }
}