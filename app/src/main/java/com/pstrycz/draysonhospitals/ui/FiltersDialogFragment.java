package com.pstrycz.draysonhospitals.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.pstrycz.draysonhospitals.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FiltersDialogFragment extends DialogFragment {

    public static final String SUBTYPE_BUNDLE_KEY = "SUBTYPE_BUNDLE_KEY";
    public static final String SECTOR_BUNDLE_KEY = "SECTOR_BUNDLE_KEY";
    public static final String PIMS_BUNDLE_KEY = "PIMS_BUNDLE_KEY";

    @BindView(R.id.subtype)
    Spinner subtype;
    @BindView(R.id.sector)
    Spinner sector;
    @BindView(R.id.pims)
    Spinner pims;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_filters, null);
        ButterKnife.bind(this, view);

        ArrayList<String> spinner1 = getArguments().getStringArrayList(SUBTYPE_BUNDLE_KEY);
        ArrayList<String> spinner2 = getArguments().getStringArrayList(SECTOR_BUNDLE_KEY);
        ArrayList<String> spinner3 = getArguments().getStringArrayList(PIMS_BUNDLE_KEY);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, spinner1);
        adapter1.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        subtype.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, spinner2);
        adapter2.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        sector.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, spinner3);
        adapter3.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        pims.setAdapter(adapter3);

        builder.setView(view).setPositiveButton("OK", (dialog, id) -> {
            //TODO
        });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
