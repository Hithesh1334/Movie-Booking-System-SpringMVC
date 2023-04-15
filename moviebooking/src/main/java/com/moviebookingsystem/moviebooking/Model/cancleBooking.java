package com.moviebookingsystem.moviebooking.Model;

import jakarta.persistence.*;

@Entity
@Table(name="bookedmovie")
public class cancleBooking {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    public cancleBooking(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public cancleBooking(int id) {
        this.id = id;
    }

    

}
