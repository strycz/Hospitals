package com.pstrycz.draysonhospitals.ui;

import android.Manifest;
import android.app.DownloadManager;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.pstrycz.draysonhospitals.R;
import com.pstrycz.draysonhospitals.database.HospitalContract.HospitalEntry;
import com.pstrycz.draysonhospitals.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    private static final int LOADER_ID = 1;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.hospitals_list_view)
    ListView hospitalsListView;
    @BindView(R.id.empty_view)
    LinearLayout emptyView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private HospitalCursorAdapter hospitalCursorAdapter;

    @OnClick(R.id.download_button)
    public void onDownloadButtonClick() {
        if (checkDownloadPermission()) {
            resumeDownload();
        }
    }

    private boolean checkDownloadPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager
                    .PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted");
                return true;
            } else {
                Log.v(TAG, "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                return false;
            }
        } else {
            Log.v(TAG, "Permission is granted");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                resumeDownload();
            }
        }
    }

    private void resumeDownload() {
        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse("https://data.gov" + "" + "" + "" +
                "" + ".uk/data/resource/nhschoices/Hospital.csv"));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, Constants.CSV_NAME);

        progressBar.setVisibility(View.VISIBLE);
        downloadManager.enqueue(request);

    }

    public void showDownload() {
        Intent i = new Intent();
        i.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        hospitalsListView.setEmptyView(emptyView);

        hospitalCursorAdapter = new HospitalCursorAdapter(this, null, true);
        hospitalsListView.setAdapter(hospitalCursorAdapter);
        hospitalsListView.setOnItemClickListener(onListItemClickListener);

        getSupportLoaderManager().initLoader(LOADER_ID, null, this);
    }

    AdapterView.OnItemClickListener onListItemClickListener = (adapterView, view, position, id) -> {
        Intent intent = new Intent(this, DetailsActivity.class);

        Uri currentPetUri = ContentUris.withAppendedId(HospitalEntry.CONTENT_URI, id);
        intent.setData(currentPetUri);

        startActivity(intent);
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_show_filters:
                showFilters();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showFilters() {
        FiltersDialogFragment newFragment = new FiltersDialogFragment();
        newFragment.show(getSupportFragmentManager(), "filters");
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {HospitalEntry._ID, HospitalEntry.ORGANISATIONNAME, HospitalEntry.CITY};

        switch (id) {
            case LOADER_ID:
                return new CursorLoader(this, HospitalEntry.CONTENT_URI, projection, null, null, null);
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        hospitalCursorAdapter.swapCursor(cursor);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        hospitalCursorAdapter.swapCursor(null);
    }
}
