package com.pstrycz.draysonhospitals.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

import com.pstrycz.draysonhospitals.R;

public class FiltersDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialog_filters, null))
                .setPositiveButton("OK", (dialog, id) -> {
                    //TODO
                });
        return builder.create();
    }

    @Override
        public void onAttach(Context context) {
            super.onAttach(context);
        }

}
