package com.moviebookingsystem.moviebooking.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "login")
public class loginAuth {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String password;

    @Column
    private String name;

    public loginAuth(){
        
    }

    public String getPassword() {
        return password;
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

    public loginAuth(String password, String name) {
        this.password = password;
        this.name = name;
    }

}
