package com.moviebookingsystem.moviebooking.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moviebookingsystem.moviebooking.Model.model;
import com.moviebookingsystem.moviebooking.Repository.movieRepository;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class movieServiceimp implements movieService{
    private final movieRepository movieRepository;

    public movieServiceimp(movieRepository movieRepository) {
        System.out.println("SERVICEIMP");
        this.movieRepository = movieRepository;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<model> findAllMovies() {
        System.out.println("SELECT");
        return movieRepository.findAll();
    }
    
}
