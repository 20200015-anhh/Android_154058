package com.example.liststudent_test2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var customAdapter: CustomAdapter
    var list = mutableListOf<OutData>()
    var filteredList = mutableListOf<OutData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editText = findViewById<EditText>(R.id.editText)

        list.add(OutData("Nguyễn Văn A", "20201234"))
        list.add(OutData("Nguyễn Văn B", "20202342"))
        list.add(OutData("Nguyễn Văn C", "20205467"))
        list.add(OutData("Nguyễn Văn D", "20213456"))
        list.add(OutData("Nguyễn Văn E", "20213456"))

        customAdapter = CustomAdapter(this, list)
        val lvSinhVien = findViewById<ListView>(R.id.lvSinhVien)
        lvSinhVien.adapter = customAdapter

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val searchText = s.toString().lowercase()
                filteredList.clear()
                for (item in list) {
                    if (item.name.lowercase().contains(searchText) || item.mssv.contains(searchText)) {
                        filteredList.add(item)
                    }
                }

                customAdapter.updateList(filteredList)
            }
        })
    }
}