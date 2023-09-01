package com.nic.insp.adhoc;

import android.net.Uri;

public class AdHocDetails {

    private String adhoccontent;
    private String adhocans;
    private String adhocimagereq;
    private Uri adhocimageUri;

    public AdHocDetails() {
    }

    public AdHocDetails(String adhoccontent, String adhocans, String adhocimagereq, Uri adhocimageUri) {
        this.adhoccontent = adhoccontent;
        this.adhocans = adhocans;
        this.adhocimagereq = adhocimagereq;
        this.adhocimageUri = adhocimageUri;
    }

    public String getAdhoccontent() {
        return adhoccontent;
    }

    public void setAdhoccontent(String adhoccontent) {
        this.adhoccontent = adhoccontent;
    }

    public String getAdhocans() {
        return adhocans;
    }

    public void setAdhocans(String adhocans) {
        this.adhocans = adhocans;
    }

    public String getAdhocimagereq() {
        return adhocimagereq;
    }

    public void setAdhocimagereq(String adhocimagereq) {
        this.adhocimagereq = adhocimagereq;
    }

    public Uri getAdhocimageUri() {
        return adhocimageUri;
    }

    public void setAdhocimageUri(Uri adhocimageUri) {
        this.adhocimageUri = adhocimageUri;
    }
}
