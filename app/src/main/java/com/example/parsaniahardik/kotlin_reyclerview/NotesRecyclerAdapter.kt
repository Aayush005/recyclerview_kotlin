package com.example.parsaniahardik.kotlin_reyclerview

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

class NotesRecyclerAdapter(mNotes: ArrayList<Note>, private val mOnNoteListener: OnNoteListener) : RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder>() {

    private var mNotes = ArrayList<Note>()

    init {
        this.mNotes = mNotes
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(view, mOnNoteListener)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        try {
            holder.tv.text = mNotes.get(position).name
            holder.iv.setImageResource(mNotes.get(position).image_drawable)
        } catch (e: NullPointerException) {
            Log.e(TAG, "onBindViewHolder: Null Pointer: " + e.message)
        }

    }


    override fun getItemCount(): Int {
        return mNotes.size
    }

    inner class ViewHolder(itemView: View, internal var mOnNoteListener: OnNoteListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        internal var tv: TextView
        internal var iv: ImageView

        init {
            tv = itemView.findViewById(R.id.tv)
            iv = itemView.findViewById(R.id.iv)

            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            Log.d(TAG, "onClick: $adapterPosition")
            mOnNoteListener.onNoteClick(adapterPosition)

        }
    }

    interface OnNoteListener {
        fun onNoteClick(position: Int)
    }


    companion object {
        private val TAG = "NotesRecyclerAdapter"
    }

}













