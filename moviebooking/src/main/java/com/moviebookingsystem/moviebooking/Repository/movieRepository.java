package com.moviebookingsystem.moviebooking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingsystem.moviebooking.Model.model;

@Repository
public interface movieRepository extends JpaRepository<model,Integer> {
    List<model> findById(int id);
}
