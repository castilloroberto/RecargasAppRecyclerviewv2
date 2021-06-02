package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.adapters.RefillsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val refillsJSON = getJSONFromFile("refills.json",this)
        fillList(refillsJSON,"super",list_view1)
    }

    private fun fillList(json:JSONObject,objName:String,listView: RecyclerView){
        listView.layoutManager = LinearLayoutManager(this)
        val wholeList = getRefillsArray(json,objName)
        val adapter = RefillsAdapter(this, wholeList)
        listView.adapter = adapter


        /*
        val stringList = arrayOfNulls<String>(wholeList.size)
        for (i in 0 until wholeList.size){
            val refill = wholeList[i]
            stringList[i] = refill.title
        }
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,stringList)
        listView.adapter = adapter*/
    }
    fun clearEdit(v: View){
        et_num2.setText("")
    }
}