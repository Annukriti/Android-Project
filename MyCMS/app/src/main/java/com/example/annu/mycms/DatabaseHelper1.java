package com.example.annu.mycms;

/**
 * Created by annu on 28/12/17.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELL son 15/04/2017.
 */
public class DatabaseHelper1 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Music.db";
    public static final String TABLE_NAME = "music";
    public static final String COL_1 = "TYPE";
    public static final String COL_2 = "TITLE";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "FIR";

    public DatabaseHelper1(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(TYPE TEXT  , TITLE TEXT, DESCRIPTION TEXT,  FIR TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String type, String title, String description , String fir) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,type);
        contentValues.put(COL_2, title);
        contentValues.put(COL_3, description);
        contentValues.put(COL_4, fir);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public Cursor getAlbums() {SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" WHERE "+COL_3+"='Album' AND "+COL_4+"=10",null);
        return res;
    }
    public boolean Update(String id,String rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_4, rating);
        long result = db.update(TABLE_NAME, contentValues, COL_1 + "=" + id, null);
        if (result == -1)
            return false;
        else
            return true;
    }
}