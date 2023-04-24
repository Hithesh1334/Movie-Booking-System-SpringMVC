package com.moviebookingsystem.moviebooking.Services;

import java.util.List;

import com.moviebookingsystem.moviebooking.Model.addPayment;
import com.moviebookingsystem.moviebooking.Model.addUser;
import com.moviebookingsystem.moviebooking.Model.addUserBooking;
import com.moviebookingsystem.moviebooking.Model.admin;
import com.moviebookingsystem.moviebooking.Model.listMovies;
import com.moviebookingsystem.moviebooking.Model.loginAuth;

public interface movieService {
    public List<listMovies> findAllMovies(); 
    public List<loginAuth> findAllUser();
    public addUser saveUser();
    public addUserBooking saveUserBooking();
    public void deleteBooking();
    public List<addUserBooking> findAllBookings();
    public addPayment saveTransaction();
    public List<admin> getAdminData();
    public listMovies saveMovie();
    public listMovies updateMovie();
}

