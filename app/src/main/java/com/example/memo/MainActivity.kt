package com.example.memo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val userData:EditText = findViewById(R.id.user_data)
        val button: Button = findViewById(R.id.button)

        val todos:MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,todos)
        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView,view,i,l ->
            val text = listView.getItemAtPosition(i).toString()
            adapter.remove(text)

            Toast.makeText(this,"Deleted:$text",Toast.LENGTH_SHORT).show()
        }
        button.setOnClickListener {
            var text = userData.text.toString().trim()
            if(text!= "")
                adapter.insert(text,0)
        }
    }
}