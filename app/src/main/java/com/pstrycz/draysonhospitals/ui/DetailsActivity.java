package com.pstrycz.draysonhospitals.ui;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

import com.pstrycz.draysonhospitals.R;
import com.pstrycz.draysonhospitals.database.HospitalContract.HospitalEntry;

import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String URL_KEY = "CLICKED_HOSPITAL";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        Uri clickedHospital = getIntent().getData();

        Bundle bundle = new Bundle();
        bundle.putString(URL_KEY, clickedHospital.toString());
        getSupportLoaderManager().initLoader(1, bundle, this);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {
                HospitalEntry._ID,
                HospitalEntry.ORGANISATIONID,
                HospitalEntry.ORGANISATIONCODE,
                HospitalEntry.ORGANISATIONTYPE,
                HospitalEntry.SUBTYPE,
                HospitalEntry.SECTOR,
                HospitalEntry.ORGANISATIONSTATUS,
                HospitalEntry.ISPIMSMANAGED,
                HospitalEntry.ORGANISATIONNAME,
                HospitalEntry.ADDRESS1,
                HospitalEntry.ADDRESS2,
                HospitalEntry.ADDRESS3,
                HospitalEntry.CITY,
                HospitalEntry.COUNTY,
                HospitalEntry.POSTCODE,
                HospitalEntry.LATITUDE,
                HospitalEntry.LONGITUDE,
                HospitalEntry.PARENTODSCODE,
                HospitalEntry.PARENTNAME,
                HospitalEntry.PHONE,
                HospitalEntry.EMAIL,
                HospitalEntry.WEBSITE,
                HospitalEntry.FAX};

        switch (id) {
            case 1:
                Uri uri = Uri.parse(args.getString(URL_KEY));
                return new CursorLoader(this, uri, projection, null, null, null);
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

}
