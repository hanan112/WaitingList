package com.hanan_ali.myapplicationwaitinglist.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WaitlistDBHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "waitlist.db";

    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + WaitlistContract.WaitlistEntry.TABLE_NAME + " (" +
                    WaitlistContract.WaitlistEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    WaitlistContract.WaitlistEntry.COLUMN_GUEST_NAME + " TEXT NOT NULL, " +
                    WaitlistContract.WaitlistEntry.COLUMN_PARTY_SIZE + " TEXT NOT NULL, " +
                    WaitlistContract.WaitlistEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                    "); ";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + WaitlistContract.WaitlistEntry.TABLE_NAME;

    public WaitlistDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
