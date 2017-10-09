package com.pstrycz.draysonhospitals.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pstrycz.draysonhospitals.database.HospitalContract.HospitalEntry;

public class HospitalDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "hospitals.db";
    private static final int DATABASE_VERSION = 1;

    public HospitalDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_TABLE =  "CREATE TABLE " + HospitalEntry.TABLE_NAME + " ("
                + HospitalEntry._ID +  "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HospitalEntry.ORGANISATIONID + " INTEGER NOT NULL, "
                + HospitalEntry.ORGANISATIONCODE + " TEXT, "
                + HospitalEntry.ORGANISATIONTYPE + " TEXT, "
                + HospitalEntry.SUBTYPE + " TEXT, "
                + HospitalEntry.SECTOR + " TEXT, "
                + HospitalEntry.ORGANISATIONSTATUS + " TEXT, "
                + HospitalEntry.ISPIMSMANAGED + " TEXT, "
                + HospitalEntry.ORGANISATIONNAME + " TEXT, "
                + HospitalEntry.ADDRESS1 + " TEXT, "
                + HospitalEntry.ADDRESS2 + " TEXT, "
                + HospitalEntry.ADDRESS3 + " TEXT, "
                + HospitalEntry.CITY + " TEXT, "
                + HospitalEntry.COUNTY + " TEXT, "
                + HospitalEntry.POSTCODE + " TEXT, "
                + HospitalEntry.LATITUDE + " TEXT, "
                + HospitalEntry.LONGITUDE + " TEXT, "
                + HospitalEntry.PARENTODSCODE + " TEXT, "
                + HospitalEntry.PARENTNAME + " TEXT, "
                + HospitalEntry.PHONE + " TEXT, "
                + HospitalEntry.EMAIL + " TEXT, "
                + HospitalEntry.WEBSITE + " TEXT, "
                + HospitalEntry.FAX + " TEXT);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + HospitalEntry.TABLE_NAME);
        onCreate(db);
    }
}
