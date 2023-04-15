package com.moviebookingsystem.moviebooking.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.moviebookingsystem.moviebooking.Model.loginAuth;

@Repository
public interface loginAuthRepository extends JpaRepository<loginAuth,Integer> {
    Optional<loginAuth> findById(int id);
}
