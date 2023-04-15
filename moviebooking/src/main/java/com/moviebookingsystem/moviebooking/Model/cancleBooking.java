package com.moviebookingsystem.moviebooking.Model;

import jakarta.persistence.*;

@Entity
@Table(name="bookedmovie")
public class cancleBooking {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int movieId;

    
    public cancleBooking(int movieId) {
        this.movieId = movieId;
    }

    public cancleBooking(){

    }

    

    public int getmovieId() {
        return movieId;
    }

    public void setmovieId(int movieId) {
        this.movieId = movieId;
    }

    

}
