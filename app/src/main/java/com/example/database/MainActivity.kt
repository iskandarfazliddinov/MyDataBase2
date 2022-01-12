package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.database.db.MyDbManger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val myDbManger = MyDbManger(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onResume() {
        super.onResume()
        myDbManger.openDb()

    }

    fun saveButtonClilc(view: android.view.View) {


        textViewTest.text = ""

        myDbManger.insertDb(editTitle.text.toString(),editContent.text.toString())

        val dataList = myDbManger.readData()

        for (item in dataList){
            textViewTest.append(item)
            textViewTest.append("\n")
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManger.closeDb()
    }
}