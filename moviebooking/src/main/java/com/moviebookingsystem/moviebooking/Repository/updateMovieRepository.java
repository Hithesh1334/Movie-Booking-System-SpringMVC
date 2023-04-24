package com.moviebookingsystem.moviebooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingsystem.moviebooking.Model.listMovies;

@Repository
public interface updateMovieRepository extends JpaRepository<listMovies,Integer> {
    
}
