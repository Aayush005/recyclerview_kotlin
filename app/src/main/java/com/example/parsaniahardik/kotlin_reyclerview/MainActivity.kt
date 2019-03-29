package com.example.parsaniahardik.kotlin_reyclerview

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.Log
import android.widget.Toast
import java.util.ArrayList

class MainActivity : AppCompatActivity(),
NotesRecyclerAdapter.OnNoteListener{


    private var recyclerView: RecyclerView? = null
    private var imageModelArrayList: ArrayList<Note>? = null
    private var adapter: NotesRecyclerAdapter? = null
    private val mNotes = ArrayList<Note>()

    private val myImageList = intArrayOf(R.drawable.agra, R.drawable.vanc, R.drawable.mumbai, R.drawable.tor, R.drawable.agra, R.drawable.vanc, R.drawable.mumbai, R.drawable.tor)
    private val myImageNameList = arrayOf("Agra", "Vancuver", "Mumbai", "Toronto", "Agra", "Vancuver", "Mumbai", "Toronto")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler) as RecyclerView

        imageModelArrayList = populateList()
        Log.d("hjhjh", imageModelArrayList!!.size.toString() + "")

      initRecyclerView()

    }

    private fun initRecyclerView() {
        recyclerView!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView)
        adapter = NotesRecyclerAdapter(imageModelArrayList!!,this)
        recyclerView!!.adapter = adapter
    }

    private fun populateList(): ArrayList<Note> {

        val list = ArrayList<Note>()

        for (i in 0..7) {
            val imageModel = Note()
            imageModel.setNames(myImageNameList[i])
            imageModel.setImage_drawables(myImageList[i])
            list.add(imageModel)
        }

        return list
    }

    override fun onNoteClick(position: Int) {

        Toast.makeText(this,imageModelArrayList?.get(position)?.name, Toast.LENGTH_SHORT).show()

    }

    internal var itemTouchHelperCallback: ItemTouchHelper.SimpleCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

        }
    }
}
