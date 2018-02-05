package com.karim.moneytrackerpro;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by karim on 2/5/2018.
 */

public class databaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MoneyTrackerPro.db";
    private static final String TABLE_NAME = "User";
    private static final String COLOUMN_ID = "id";
    private static final String COLOUMN_USERNAME = "username";
    private static final String COLOUMN_PASSWORD = "password";
    private static final String COLOUMN_EMAIL = "email";
    private static final String COLOUMN_TARGET = "target";

    SQLiteDatabase db;
    private static final String CREATE_TABLE = "create table User (id_user INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
            " "+ " username TEXT NOT NULL, password TEXT NOT NULL, email TEXT NOT NULL, target TEXT NOT NULL)";

    public databaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXCIST" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertUser(User user){
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLOUMN_EMAIL,user.getEmail());
        contentValues.put(COLOUMN_USERNAME,user.getUsername());
        contentValues.put(COLOUMN_PASSWORD,user.getPassword());
        contentValues.put(COLOUMN_TARGET,user.getTarget());

        db.insert(TABLE_NAME, null, contentValues);
    }
}
