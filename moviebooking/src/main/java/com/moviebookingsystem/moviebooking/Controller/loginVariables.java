package com.moviebookingsystem.moviebooking.Controller;

public class loginVariables {
    // These variables are used for authentication 

    private static loginVariables instance;

    private loginVariables(){

    }

    public static loginVariables getInstance(){
        if (instance == null){
            instance = new loginVariables();
        }
        
        return instance;
    }

    private int status;
    private String UserName  ;
    private String UserPassword ;
    private String adminName;
    private String adminPassword;

    

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public int getStatus() {
        System.out.println("getStatus: "+status);
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
