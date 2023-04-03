package com.moviebookingsystem.moviebooking.Model;

import jakarta.persistence.*;

@Entity
@Table(name="movie")
public class model {
    
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String date;
    @Column 
    private int availability;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getAvailability() {
        return availability;
    }
    public void setAvailability(int availability) {
        this.availability = availability;
    }
    public model(){

    }
    public model(int id,String name,String date,int availability) {
        System.out.println("CONSTRUCTOR---------------------");
        this.id = id;
        this.name = name;
        this.date = date;
        this.availability = availability;
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
