package com.example.heeeeeeelper.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.heeeeeeelper.sqlTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class dbHelperTest extends SQLiteOpenHelper {

    public dbHelperTest(Context context) {
        super(context, "Anketirovanie.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table AnkInfo(ID INTEGER primary key autoincrement, " +
                "noproblem INTEGER DEFAULT 0, " +
                "paranoik INTEGER DEFAULT 0, " +
                "shizik INTEGER DEFAULT 0, " +
                "isterik INTEGER DEFAULT 0, " +
                "astenik INTEGER DEFAULT 0, " +
                "emocionloh INTEGER DEFAULT 0," +
                "data TEXT not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists AnkInfo");
    }

    public Boolean insert(int noproblem, int paranoik, int shizik, int isterik, int astenik, int emocionloh){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("noproblem", noproblem);
        contentValues.put("paranoik", paranoik);
        contentValues.put("shizik", shizik);
        contentValues.put("isterik", isterik);
        contentValues.put("astenik", astenik);
        contentValues.put("emocionloh", emocionloh);
        Date curent = new Date();
        SimpleDateFormat simpForm = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        contentValues.put("data", simpForm.format(curent));
        long result = DB.insert("AnkInfo", null, contentValues);
        return result != -1;
    }

    public Boolean delete(){
        SQLiteDatabase DB = this.getWritableDatabase();
        DB.execSQL("DELETE FROM AnkInfo");
        return true;
    }


    public ArrayList<sqlTest> getData (){
        ArrayList<sqlTest> list = new ArrayList<>();
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from AnkInfo", null);
        while (cursor.moveToNext()){
            sqlTest test = new sqlTest();
            test.setAllgood(cursor.getInt(1));
            test.setParanoik(cursor.getInt(2));
            test.setShizik(cursor.getInt(3));
            test.setIsterik(cursor.getInt(4));
            test.setAstenik(cursor.getInt(5));
            test.setEmocloh(cursor.getInt(6));
            test.setDate(cursor.getString(7));

            list.add(test);
        }
        return list;
    }

}
