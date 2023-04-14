package com.moviebookingsystem.moviebooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingsystem.moviebooking.Model.addUser;

@Repository
public interface addUserRepository extends JpaRepository<addUser,String> {
    
}
