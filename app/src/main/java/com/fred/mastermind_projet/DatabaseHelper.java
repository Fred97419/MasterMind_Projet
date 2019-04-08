package com.fred.mastermind_projet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "score.db";
    public static final String TABLE_NAME = "score_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "NOM";
    public static final String COL3 = "SCORE";

    public DatabaseHelper(Context context){

        super(context , DATABASE_NAME , null ,1);

    }

    public void onCreate(SQLiteDatabase db){


        String createTable = "CREATE TABLE "+ TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "NOM TEXT, "+
                "SCORE TEXT)";

        db.execSQL(createTable);


    }

    public void onUpgrade (SQLiteDatabase db , int oldVersion , int newVersion ){

        String drop = "DROP IF TABLE EXISTS ";

        db.execSQL(drop+ TABLE_NAME);

    }

    public boolean addData(String nom , String score){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2 , nom);
        contentValues.put(COL3 , score);

        long result = db.insert(TABLE_NAME , null , contentValues);

        if (result == -1){

            return false;
        }

        else {

            return true;
        }

    }

    public Cursor getListContents(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " +TABLE_NAME,null );

        return data;

    }


}
