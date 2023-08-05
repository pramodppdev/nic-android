package com.nic.insp.inspection;

public class InspectionModel {
    //     private int userId;
//     private int id;
//     private  String title;
//     private String body;
//
//     public int getUserId() {
//          return userId;
//     }
//
//     public int getId() {
//
//          return id;
//     }
//
//     public String getTitle() {
//
//          return title;
//     }
//
//     public String getBody() {
//
//          return body;
//     }
    private String inspId;
    private String taluk;
    private String department;
    private String description;
    private String lastDate;
    //     private String officeAssigned;
    private String status;

    private String assignedOfficer;

    private String createdAt;

    private String createdBy;

    private String distric;

    public String getStatus() {
        return status;
    }

    public String getAssignedOfficer() {
        return assignedOfficer;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getDistric() {
        return distric;
    }

    public String getInspId() {
        return inspId;
    }

    public String getTaluk() {
        return taluk;
    }

    public String getDepartment() {
        return department;
    }

    public String getDescription() {
        return description;
    }

    public String getLastDate() {
        return lastDate;
    }



//     public String getOfficeAssigned() {
//          return officeAssigned;
//     }

     /*public void setUserId(int userId) {
          this.userId = userId;
     }

     public void setId(int id) {
          this.id = id;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public void setBody(String body) {
          this.body = body;
     }*/
}