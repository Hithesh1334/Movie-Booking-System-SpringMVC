package com.moviebookingsystem.moviebooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingsystem.moviebooking.Model.admin;

@Repository
public interface adminRepository extends JpaRepository<admin,Integer> {
    
}
