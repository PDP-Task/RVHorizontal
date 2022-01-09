package com.example.rvhorizontal

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.MemoryFile
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rvhorizontal.adapter.CustomAdapter
import com.example.rvhorizontal.model.Member

class MainActivity : AppCompatActivity() {
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        initViews()

        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun initViews() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun refreshAdapter(member: ArrayList<Member>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = CustomAdapter(context, member)
        recyclerView.adapter = adapter
    }

    private fun prepareMemberList(): ArrayList<Member> {
        val members = ArrayList<Member>()

        for (i in 0..50) {
            members.add(Member("Android", "$i"))
        }
        return members
    }

    private fun randomList(): String {
        val array = arrayListOf("Android", "Java", "Kotlin")
        return array[(0 until array.size).random()]
    }
}