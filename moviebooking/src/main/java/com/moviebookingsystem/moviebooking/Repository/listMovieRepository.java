package com.moviebookingsystem.moviebooking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingsystem.moviebooking.Model.listMovies;

@Repository
public interface listMovieRepository extends JpaRepository<listMovies,Integer> {
    List<listMovies> findById(int id);

}
