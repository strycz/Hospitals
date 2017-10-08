package com.pstrycz.draysonhospitals.utils;

import android.util.Log;

import com.pstrycz.draysonhospitals.model.HospitalBean;

import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ParseCsvUtil {
    private static final String TAG = ParseCsvUtil.class.getSimpleName();

    public static void parseCsv(File file) throws IOException {
        ICsvBeanReader beanReader = null;
        try {
            File csvFile = new File(file + "/" + Constants.CSV_NAME);
            beanReader = new CsvBeanReader(new FileReader(csvFile), CsvPreference.TAB_PREFERENCE);

            final String[] header;
            header = beanReader.getHeader(true);

            HospitalBean hospital;
            while ((hospital = beanReader.read(HospitalBean.class, header)) != null) {
                Log.v(TAG, String.format("lineNo=%s, rowNo=%s, customer=%s", beanReader.getLineNumber(), beanReader
                        .getRowNumber(), hospital));
            }
        } finally {
            if (beanReader != null) {
                beanReader.close();
            }
        }
    }

}
