package com.moviebookingsystem.moviebooking.Model;

import jakarta.persistence.*;

@Entity
@Table(name="movie")
public class model {
    
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    public model(){
        
    }

    public model(int id) {
        System.out.println("CONSTRUCTOR---------------------");
        this.id = id;
    }

    public int getId() {
        System.out.println("GETTER---------------------");
        return id;
    }

    public void setId(int id) {
        System.out.println("SETTER---------------------");
        this.id = id;
    }

}
