package com.pstrycz.draysonhospitals.database;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by User on 2017-10-09.
 */

public final class HospitalContract {
    //CONTENT PROVIDER
    static final String CONTENT_AUTHORITY = "com.pstrycz.draysonhospitals";
    static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    static final String PATH_HOSPITALS = "hospitals";

    private HospitalContract() {
    }

    public static final class HospitalEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_HOSPITALS);

        public final static String TABLE_NAME = "hospitals";

        //COLUMS
        public final static String ORGANISATIONID = "OrganisationID";
        public final static String ORGANISATIONCODE = "OrganisationCode";
        public final static String ORGANISATIONTYPE = "OrganisationType";
        public final static String SUBTYPE = "SubType";
        public final static String SECTOR = "Sector";
        public final static String ORGANISATIONSTATUS = "OrganisationStatus";
        public final static String ISPIMSMANAGED = "IsPimsManaged";
        public final static String ORGANISATIONNAME = "OrganisationName";
        public final static String ADDRESS1 = "Address1";
        public final static String ADDRESS2 = "Address2";
        public final static String ADDRESS3 = "Address3";
        public final static String CITY = "City";
        public final static String COUNTY = "County";
        public final static String POSTCODE = "Postcode";
        public final static String LATITUDE = "Latitude";
        public final static String LONGITUDE = "Longitude";
        public final static String PARENTODSCODE = "ParentODSCode";
        public final static String PARENTNAME = "ParentName";
        public final static String PHONE = "Phone";
        public final static String EMAIL = "Email";
        public final static String WEBSITE = "Website";
        public final static String FAX = "Fax";
    }

}
