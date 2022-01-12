package com.example.database.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class MyDbManger(context: Context) {
    val myDbHeleper = MyDbHeleper(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        db = myDbHeleper.readableDatabase
    }

    fun insertDb(title: String, content: String) {

        val values = ContentValues().apply {
            put(MyDbNameClass.COLUMN_NAME_TITLE, title)
            put(MyDbNameClass.COLUMN_NAME_CONTENT, content)
        }
        db?.insert(MyDbNameClass.TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun readData(): ArrayList<String> {

        val dataList = ArrayList<String>()

        val cursor = db?.query(
            MyDbNameClass.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null

        )
        with(cursor){
            while (this?.moveToNext()!!){
                val dataText_one = cursor?.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_TITLE))
                val dataText_two = cursor?.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_CONTENT))

                dataList.add(dataText_one.toString().plus("  $dataText_two"))
            }
        }
        cursor?.close()
        return dataList

    }
    fun closeDb(){
        myDbHeleper.close()
    }

}