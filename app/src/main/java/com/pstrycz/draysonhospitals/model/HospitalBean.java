package com.pstrycz.draysonhospitals.model;

public class HospitalBean {
    String OrganisationID;
    String OrganisationCode;
    String OrganisationType;
    String SubType;
    String Sector;
    String OrganisationStatus;
    String IsPimsManaged;
    String OrganisationName;
    String Address1;
    String Address2;
    String Address3;
    String City;
    String County;
    String Postcode;
    String Latitude;
    String Longitude;
    String ParentODSCode;
    String ParentName;
    String Phone;
    String Email;
    String Website;
    String Fax;

    public HospitalBean() {}

    public HospitalBean(String organisationID, String organisationCode, String organisationType, String subType,
                        String sector, String organisationStatus, String isPimsManaged, String organisationName,
                        String address1, String address2, String address3, String city, String county, String
                                postcode, String latitude, String longitude, String parentODSCode, String parentName,
                        String phone, String email, String website, String fax) {
        OrganisationID = organisationID;
        OrganisationCode = organisationCode;
        OrganisationType = organisationType;
        SubType = subType;
        Sector = sector;
        OrganisationStatus = organisationStatus;
        IsPimsManaged = isPimsManaged;
        OrganisationName = organisationName;
        Address1 = address1;
        Address2 = address2;
        Address3 = address3;
        City = city;
        County = county;
        Postcode = postcode;
        Latitude = latitude;
        Longitude = longitude;
        ParentODSCode = parentODSCode;
        ParentName = parentName;
        Phone = phone;
        Email = email;
        Website = website;
        Fax = fax;
    }

    public String getOrganisationID() {
        return OrganisationID;
    }

    public void setOrganisationID(String organisationID) {
        OrganisationID = organisationID;
    }

    public String getOrganisationCode() {
        return OrganisationCode;
    }

    public void setOrganisationCode(String organisationCode) {
        OrganisationCode = organisationCode;
    }

    public String getOrganisationType() {
        return OrganisationType;
    }

    public void setOrganisationType(String organisationType) {
        OrganisationType = organisationType;
    }

    public String getSubType() {
        return SubType;
    }

    public void setSubType(String subType) {
        SubType = subType;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String sector) {
        Sector = sector;
    }

    public String getOrganisationStatus() {
        return OrganisationStatus;
    }

    public void setOrganisationStatus(String organisationStatus) {
        OrganisationStatus = organisationStatus;
    }

    public String getIsPimsManaged() {
        return IsPimsManaged;
    }

    public void setIsPimsManaged(String isPimsManaged) {
        IsPimsManaged = isPimsManaged;
    }

    public String getOrganisationName() {
        return OrganisationName;
    }

    public void setOrganisationName(String organisationName) {
        OrganisationName = organisationName;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public String getAddress3() {
        return Address3;
    }

    public void setAddress3(String address3) {
        Address3 = address3;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String county) {
        County = county;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getParentODSCode() {
        return ParentODSCode;
    }

    public void setParentODSCode(String parentODSCode) {
        ParentODSCode = parentODSCode;
    }

    public String getParentName() {
        return ParentName;
    }

    public void setParentName(String parentName) {
        ParentName = parentName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }
}
