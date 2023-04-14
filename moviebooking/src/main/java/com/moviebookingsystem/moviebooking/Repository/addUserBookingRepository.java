package com.moviebookingsystem.moviebooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebookingsystem.moviebooking.Model.addUserBooking;

@Repository
public interface addUserBookingRepository extends JpaRepository<addUserBooking,String> {
     
}
