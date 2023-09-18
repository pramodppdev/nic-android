
package com.nic.insp.auth;
public class AuthenticationRequest {
    private String officerName;
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String officerName, String password) {
        this.officerName = officerName;
        this.password = password;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


