package com.boostudy.danielarguello.boostudy.registro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by karla on 08/04/2017.
 */

public class DBHelper extends SQLiteOpenHelper{
    public static final String TAG = DBHelper.class.getSimpleName();

    public static final String DB_NAME= "elenakey.db";
    public static final int DB_VERSION= 1;

    public static final String USER_TABLE= "users";
    public static final String COLUMN_ID= "_id";
    public static final String COLUMN_NAME= "name";
    public static final String COLUMN_PASS= "password";



    /*
        create table users(
        id integer primary key autoincrement,
        name text,
        password text,

     */

    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME + " TEXT,"
            + COLUMN_PASS + " TEXT)";


    public DBHelper(Context context) {
        super(context, DB_NAME , null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + USER_TABLE);
        onCreate(db);

    }
    /**
     * Storing user detail in db
     */
    public void addUser(String name, String password){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_PASS, password);

        long id = db.insert(USER_TABLE, null, values);
        db.close();
        Log.d(TAG,"user inserted" + id );

    }
    public boolean getUser(String name, String password){
        String selectQuery = "select * from  " + USER_TABLE + " where " +
                COLUMN_NAME + " = " + "'"+name+"'" + " and " + COLUMN_PASS + " = " + "'"+password+"'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {

            return true;
        }
        cursor.close();
        db.close();

        return false;
    }

}
