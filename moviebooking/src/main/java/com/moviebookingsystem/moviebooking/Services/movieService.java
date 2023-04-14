package com.moviebookingsystem.moviebooking.Services;

import java.util.List;

import com.moviebookingsystem.moviebooking.Model.addUser;
import com.moviebookingsystem.moviebooking.Model.listMovies;
import com.moviebookingsystem.moviebooking.Model.loginAuth;

public interface movieService {
    public List<listMovies> findAllMovies(); 
    public List<loginAuth> findAllUser();
    public addUser save();
}
