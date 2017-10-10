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

import butterknife.BindView;
import butterknife.ButterKnife;


public class HospitalCursorAdapter extends CursorAdapter {

    public HospitalCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.simple_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.bind(cursor);
    }

    static class ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.city)
        TextView city;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void bind(Cursor cursor) {
            String nameValue = cursor.getString(cursor.getColumnIndexOrThrow(HospitalEntry.ORGANISATIONNAME));
            String cityValue = cursor.getString(cursor.getColumnIndexOrThrow(HospitalEntry.CITY));

            name.setText(nameValue);
            city.setText(cityValue);
        }
    }
}
