package com.pstrycz.draysonhospitals.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import static com.pstrycz.draysonhospitals.database.HospitalContract.HospitalEntry.TABLE_NAME;
import static com.pstrycz.draysonhospitals.database.HospitalContract.HospitalEntry;

public class HospitalProvider extends ContentProvider {

    public static final int HOSPITALS = 100;
    public static final int HOSPITAL_ID = 101;

    private static final String LOG_TAG = HospitalProvider.class.getSimpleName();
    private static final UriMatcher hUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        hUriMatcher.addURI(HospitalContract.CONTENT_AUTHORITY, HospitalContract.PATH_HOSPITALS, HOSPITALS);
        hUriMatcher.addURI(HospitalContract.CONTENT_AUTHORITY, HospitalContract.PATH_HOSPITALS + "/#", HOSPITAL_ID);
    }

    private HospitalDbHelper dbHelper;

    @Override
    public boolean onCreate() {
        dbHelper = new HospitalDbHelper(this.getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable
            String[] selectionArgs, @Nullable String sortOrder) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor;
        int match = hUriMatcher.match(uri);
        switch (match) {
            case HOSPITALS:
                cursor = db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case HOSPITAL_ID:
                selection = HospitalEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }


        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {

        int match = hUriMatcher.match(uri);
        switch (match) {
            case HOSPITALS:
                return insertHospital(uri, contentValues);
            default:
                throw new IllegalArgumentException("Doesn't work for different URI");
        }
    }

    private Uri insertHospital(Uri uri, ContentValues contentValues) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        long rowId = db.insert(TABLE_NAME, null, contentValues);

        if (rowId == -1) {
            Log.e(LOG_TAG, "Failed to insert row for " + uri);
            return null;
        }

        getContext().getContentResolver().notifyChange(uri, null);

        return ContentUris.withAppendedId(uri, rowId);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[]
            strings) {
        return 0;
    }
}
