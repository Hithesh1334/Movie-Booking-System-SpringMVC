package com.moviebookingsystem.moviebooking.Model;

import jakarta.persistence.*;

@Entity
@Table(name="login")
public class addUser {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id; 
    
    private String password;

    private String name;
    
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public addUser(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public addUser(String password, String name,int id,String email) {
        this.password = password;
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
