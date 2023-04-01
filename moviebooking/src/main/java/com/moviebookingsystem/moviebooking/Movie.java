package com.moviebookingsystem.moviebooking;

import javax.persistence.*;


@Entity
@Table(name="movie")
public class Movie {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    

    public Movie(int id, String name) {
        System.out.println("ins");
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

}
