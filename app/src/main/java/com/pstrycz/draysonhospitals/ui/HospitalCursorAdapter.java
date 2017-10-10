package com.pstrycz.draysonhospitals.ui;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pstrycz.draysonhospitals.R;
import com.pstrycz.draysonhospitals.database.HospitalContract.HospitalEntry;


public class HospitalCursorAdapter extends CursorAdapter {

    public HospitalCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.simple_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = view.findViewById(R.id.name);
        TextView city = view.findViewById(R.id.city);

        String nameValue = cursor.getString(cursor.getColumnIndexOrThrow(HospitalEntry.ORGANISATIONNAME));
        String cityValue = cursor.getString(cursor.getColumnIndexOrThrow(HospitalEntry.CITY));

        name.setText(nameValue);
        city.setText(cityValue);
    }
}
