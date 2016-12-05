package com.example.nicole.nicoleferreirasilverio_pset4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.attr.value;
import static com.example.nicole.nicoleferreirasilverio_pset4.R.string.todo;

/**
 * Created by Nicole on 22-11-2016.
 */

public class DBhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "myDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE = "todo";

    String todo_id = "task";

    // constructor
    public DBhelper (Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    // onCreate
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE + " ( _id INTEGER PRIMARY KEY AUTOINCREMENT, " + todo_id + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    // onUpgrade
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int I, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(sqLiteDatabase);
    }

    // create
    public void create(TodoElement todo_element){
        SQLiteDatabase db  = getWritableDatabase();
        ContentValues values = new ContentValues();
        todo_element.setId("_id");
        values.put(todo_id, todo_element.task);
        db.insert(TABLE, null, values);
        db.close();
    }

    // read
    public Cursor read() {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = new String[] { "_id", "todo_id" };
        Cursor cursor = db.rawQuery("SELECT  * FROM todo", null);
        //Cursor cursor = db.query(TABLE, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;

    }
//    public ArrayList<TodoElement> read () {
//        SQLiteDatabase db = getReadableDatabase();
//        String query = "SELECT _id , " + todo_id + " FROM " + TABLE;
//        ArrayList<TodoElement> todolist = new ArrayList<>();
//        Cursor cursor = db.rawQuery(query, null);
//        if (cursor.moveToFirst()) {
//            do {
//                TodoElement todo_element = new TodoElement();
//                todo_element.setId(cursor.getString(cursor.getColumnIndex("_id")));
//                todo_element.setTask(cursor.getString(cursor.getColumnIndex("task")));
//                todolist.add(todo_element);
//            }
//            while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return todolist;
//    }

    //update
    public void update(String todo_new, int ID) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(todo_id, todo_new);
        db.update(TABLE, values, " _id = ? ", new String[] {String.valueOf(ID)});
        db.close();
    }


    //delete
    public void delete(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE, " _id = ? ", new String[] {String.valueOf(id)});
        db.close();
    }

}
