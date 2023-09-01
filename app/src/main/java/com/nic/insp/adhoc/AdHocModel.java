package com.nic.insp.adhoc;

import java.util.List;

public class AdHocModel {

    private String adhocid;
    private String adhoctaluk;
    private String adhocdepartment;
    private String adhoclastdate;
    private List<AdHocDetails> adhocdescription;
    private String adhocstatus;
    private String adhocassignedOfficer;
    private String adhoccreatedAt;
    private String adhoccreatedby;
    private String adhocdistrict;

    public AdHocModel() {
    }

    public AdHocModel(String adhocid, String adhoctaluk, String adhocdepartment, String adhoclastdate, List<AdHocDetails> adhocdescription, String adhocstatus, String adhocassignedOfficer, String adhoccreatedAt, String adhoccreatedby, String adhocdistrict) {
        this.adhocid = adhocid;
        this.adhoctaluk = adhoctaluk;
        this.adhocdepartment = adhocdepartment;
        this.adhoclastdate = adhoclastdate;
        this.adhocdescription = adhocdescription;
        this.adhocstatus = adhocstatus;
        this.adhocassignedOfficer = adhocassignedOfficer;
        this.adhoccreatedAt = adhoccreatedAt;
        this.adhoccreatedby = adhoccreatedby;
        this.adhocdistrict = adhocdistrict;
    }

    public String getAdhocid() {
        return adhocid;
    }

    public void setAdhocid(String adhocid) {
        this.adhocid = adhocid;
    }

    public String getAdhoctaluk() {
        return adhoctaluk;
    }

    public void setAdhoctaluk(String adhoctaluk) {
        this.adhoctaluk = adhoctaluk;
    }

    public String getAdhocdepartment() {
        return adhocdepartment;
    }

    public void setAdhocdepartment(String adhocdepartment) {
        this.adhocdepartment = adhocdepartment;
    }

    public String getAdhoclastdate() {
        return adhoclastdate;
    }

    public void setAdhoclastdate(String adhoclastdate) {
        this.adhoclastdate = adhoclastdate;
    }

    public List<AdHocDetails> getAdhocdescription() {
        return adhocdescription;
    }

    public void setAdhocdescription(List<AdHocDetails> adhocdescription) {
        this.adhocdescription = adhocdescription;
    }

    public String getAdhocstatus() {
        return adhocstatus;
    }

    public void setAdhocstatus(String adhocstatus) {
        this.adhocstatus = adhocstatus;
    }

    public String getAdhocassignedOfficer() {
        return adhocassignedOfficer;
    }

    public void setAdhocassignedOfficer(String adhocassignedOfficer) {
        this.adhocassignedOfficer = adhocassignedOfficer;
    }

    public String getAdhoccreatedAt() {
        return adhoccreatedAt;
    }

    public void setAdhoccreatedAt(String adhoccreatedAt) {
        this.adhoccreatedAt = adhoccreatedAt;
    }

    public String getAdhoccreatedby() {
        return adhoccreatedby;
    }

    public void setAdhoccreatedby(String adhoccreatedby) {
        this.adhoccreatedby = adhoccreatedby;
    }

    public String getAdhocdistrict() {
        return adhocdistrict;
    }

    public void setAdhocdistrict(String adhocdistrict) {
        this.adhocdistrict = adhocdistrict;
    }
}
