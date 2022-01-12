package com.example.database.db

import android.provider.BaseColumns

object MyDbNameClass {

    const val TABLE_NAME = "my_table"
    const val COLUMN_NAME_TITLE = "title"
    const val COLUMN_NAME_CONTENT = "content"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "myDbKotlin.db"

    const val SQL_CREATE_ENTRIES =
        "CREAT TABLE $TABLE_NAME("+
                "${BaseColumns._ID} INTGER PRIMARY KEY, " +
                "$COLUMN_NAME_TITLE TEXT," +
                "$COLUMN_NAME_CONTENT TEXT )"
    const val SQL_DELETE_ENTERIES = "DROP TABLE IF EXISTS $TABLE_NAME"


}