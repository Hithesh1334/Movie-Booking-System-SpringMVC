package com.moviebookingsystem.moviebooking.Model;

import jakarta.persistence.*;

@Entity
@Table(name="bookedmovie")
public class addUserBooking {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private int movieId;
    
    private String movieName;

    private String userName;

    private String email;

    private String phoneNo;

    public int getId() {
        return id;
    }

    public addUserBooking(){
        
    }

    public addUserBooking(int id, int movieId, String movieName, String userName, String email, String phoneNo) {
        this.id = id;
        this.movieId = movieId;
        this.movieName = movieName;
        this.userName = userName;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
}
