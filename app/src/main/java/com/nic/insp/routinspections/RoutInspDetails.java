package com.nic.insp.routinspections;

import android.net.Uri;

public class RoutInspDetails {
    private String routInspContent;
    private String routInspAns;
    private String imgReq;
    private Uri imageUri; // Updated field

    public RoutInspDetails() {
    }

    public RoutInspDetails(String routInspContent, String routInspAns, String imgReq, Uri imageUri) {
        this.routInspContent = routInspContent;
        this.routInspAns = routInspAns;
        this.imgReq = imgReq;
        this.imageUri = imageUri;
    }

    public String getRoutInspContent() {
        return routInspContent;
    }

    public void setRoutInspContent(String routInspContent) {
        this.routInspContent = routInspContent;
    }

    public String getRoutInspAns() {
        return routInspAns;
    }

    public void setRoutInspAns(String routInspAns) {
        this.routInspAns = routInspAns;
    }

    public String getImgReq() {
        return imgReq;
    }

    public void setImgReq(String imgReq) {
        this.imgReq = imgReq;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }
}
