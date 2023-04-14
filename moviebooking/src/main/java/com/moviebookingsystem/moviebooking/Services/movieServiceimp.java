package com.moviebookingsystem.moviebooking.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebookingsystem.moviebooking.Model.listMovies;
import com.moviebookingsystem.moviebooking.Model.loginAuth;
import com.moviebookingsystem.moviebooking.Repository.listMovieRepository;
import com.moviebookingsystem.moviebooking.Repository.loginAuthRepository;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class movieServiceimp implements movieService{
    private final listMovieRepository movieRepository;

    @Autowired
    private loginAuthRepository loginAuthRepository;

    public movieServiceimp(listMovieRepository movieRepository) {
        System.out.println("SERVICEIMP");
        this.movieRepository = movieRepository;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<listMovies> findAllMovies() {
        System.out.println("SELECT");
        return movieRepository.findAll();
    }

    public void saveUser(loginAuth user){
        loginAuthRepository.save(user);
    }
    
}
