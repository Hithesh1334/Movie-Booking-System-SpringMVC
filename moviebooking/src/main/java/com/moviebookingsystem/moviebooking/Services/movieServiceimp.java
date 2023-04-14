package com.moviebookingsystem.moviebooking.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moviebookingsystem.moviebooking.Model.addUser;
import com.moviebookingsystem.moviebooking.Model.listMovies;
import com.moviebookingsystem.moviebooking.Model.loginAuth;
import com.moviebookingsystem.moviebooking.Repository.addUserRepository;
import com.moviebookingsystem.moviebooking.Repository.listMovieRepository;
import com.moviebookingsystem.moviebooking.Repository.loginAuthRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class movieServiceimp implements movieService{
    private final listMovieRepository movieRepository;
    private final loginAuthRepository loginAuthRepository;
    private final addUserRepository addUserRepository;

    public movieServiceimp(listMovieRepository movieRepository,loginAuthRepository loginAuthRepository,addUserRepository addUserRepository) {
        System.out.println("SERVICEIMP");
        this.movieRepository = movieRepository;
        this.loginAuthRepository = loginAuthRepository;
        this.addUserRepository =  addUserRepository;
    }

    //getting MOVIES data
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<listMovies> findAllMovies() {
        System.out.println("SELECT");
        return movieRepository.findAll();
    }

    //getting USER data
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<loginAuth> findAllUser() {
        System.out.println("SELECT user");
        return loginAuthRepository.findAll();
    }

    
    public addUser saveUser(String name,String password,String email) {
        System.out.println(name+password);
        addUser user = new addUser();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        return addUserRepository.save(user);
    }

    @Override
    public addUser save() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    
    
}
