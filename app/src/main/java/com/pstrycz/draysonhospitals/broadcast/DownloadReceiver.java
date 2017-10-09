package com.pstrycz.draysonhospitals.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;

import com.pstrycz.draysonhospitals.utils.ParseCsvUtil;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.IOException;

import static android.app.DownloadManager.ACTION_DOWNLOAD_COMPLETE;
import static android.app.DownloadManager.ACTION_NOTIFICATION_CLICKED;

public class DownloadReceiver extends BroadcastReceiver {

    public static final String TAG = DownloadReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case ACTION_DOWNLOAD_COMPLETE:
                File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

                try {
                    ParseCsvUtil.parseCsv(context, path);
                } catch (IOException e) {
                    Log.v(TAG, "CSV parsing error");
                    e.printStackTrace();
                }
                break;
            case ACTION_NOTIFICATION_CLICKED:
                //TODO if needed
                break;
        }
    }
}