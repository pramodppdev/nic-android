package com.nic.insp.routinspections;

import java.sql.Blob;

public class RoutInspDetails {
    private String routInspContent;
    private String routInspAns;
    private String imgReq;
    private Blob image;

    public RoutInspDetails() {
    }

    public RoutInspDetails(String routInspContent, String routInspAns, String imgReq, Blob image) {
        this.routInspContent = routInspContent;
        this.routInspAns = routInspAns;
        this.imgReq = imgReq;
        this.image = image;
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

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
