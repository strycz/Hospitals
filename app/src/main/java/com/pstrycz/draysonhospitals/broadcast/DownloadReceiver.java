package com.pstrycz.draysonhospitals.broadcast;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import static android.app.DownloadManager.ACTION_DOWNLOAD_COMPLETE;
import static android.app.DownloadManager.ACTION_NOTIFICATION_CLICKED;

/**
 * Created by User on 2017-10-08.
 */

public class DownloadReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case ACTION_DOWNLOAD_COMPLETE:
                //TODO parse CSV
                break;
            case ACTION_NOTIFICATION_CLICKED:
                //TODO if needed
                break;
        }
    }
}