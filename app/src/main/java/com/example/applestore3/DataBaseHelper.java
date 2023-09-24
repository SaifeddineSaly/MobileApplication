package com.example.applestore3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MobileAppWorkshop";
    private static final String TABLE_NAME = "store";
    private static final int VERSION  = 1;

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (client_id INTEGER not null PRIMARY KEY, password TEXT, name TEXT, email TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
    }

    public boolean validate(int id, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from store "+
                "where client_id = ? and password = ?";
        Cursor c = db.rawQuery(query, new String[]{String.valueOf(id), password});
        return c.getCount() == 1;
    }

    public boolean validate(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from store "+
                "where client_id = ?";
        Cursor c = db.rawQuery(query, new String[]{String.valueOf(id)});
        return c.getCount() == 1;
    }

    public boolean insertNewClient (int clientid, String pass, String cname,String cemail) {
        if(validate(clientid) == false) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("client_id", clientid);
            values.put("password", pass);
            values.put("name", cname);
            values.put("email", cemail);
            return db.insert("store", null, values) > 0;
        }
        return false;
    }
}
