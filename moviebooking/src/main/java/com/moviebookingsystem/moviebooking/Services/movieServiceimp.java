package com.moviebookingsystem.moviebooking.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moviebookingsystem.moviebooking.Model.addPayment;
import com.moviebookingsystem.moviebooking.Model.addUser;
import com.moviebookingsystem.moviebooking.Model.addUserBooking;
import com.moviebookingsystem.moviebooking.Model.listMovies;
import com.moviebookingsystem.moviebooking.Model.loginAuth;
import com.moviebookingsystem.moviebooking.Repository.addPaymentRepository;
import com.moviebookingsystem.moviebooking.Repository.addUserBookingRepository;
import com.moviebookingsystem.moviebooking.Repository.addUserRepository;
import com.moviebookingsystem.moviebooking.Repository.cancleBookingRepository;
import com.moviebookingsystem.moviebooking.Repository.listMovieRepository;
import com.moviebookingsystem.moviebooking.Repository.loginAuthRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class movieServiceimp implements movieService{
    private final listMovieRepository movieRepository;
    private final loginAuthRepository loginAuthRepository;
    private final addUserRepository addUserRepository;
    private final addUserBookingRepository addUserBookingRepository;
    private final cancleBookingRepository cancleBookingRepository;
    private final addPaymentRepository addPaymentRepository;

    public movieServiceimp(listMovieRepository movieRepository,loginAuthRepository loginAuthRepository,addUserRepository addUserRepository,addUserBookingRepository addUserBookingRepository,cancleBookingRepository cancleBookingRepository,addPaymentRepository addPaymentRepository) {
        System.out.println("SERVICEIMP");
        this.movieRepository = movieRepository;
        this.loginAuthRepository = loginAuthRepository;
        this.addUserRepository =  addUserRepository;
        this.addUserBookingRepository = addUserBookingRepository;
        this.cancleBookingRepository = cancleBookingRepository;
        this.addPaymentRepository = addPaymentRepository;
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


    public addUserBooking saveUserBooking(String movieName,int movieId,String userName,String email,String phoneNo) {
        addUserBooking userBooking = new addUserBooking();
        userBooking.setMovieName(movieName);
        userBooking.setMovieId(movieId);
        userBooking.setUserName(userName);
        userBooking.setEmail(email);
        userBooking.setPhoneNo(phoneNo);
        return addUserBookingRepository.save(userBooking);
    }

    @Override
    public addUser saveUser() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveUser'");
    }

    @Override
    public addUserBooking saveUserBooking() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveUserBooking'");
    }
    
    
    public void deleteBooking(int id){
        cancleBookingRepository.deleteById(id);
    }

    @Override
    public void deleteBooking() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletBooking'");
    }


    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<addUserBooking> findAllBookings() {
        System.out.println("SELECT");
        return addUserBookingRepository.findAll();
    }

    public addPayment saveTransaction(String cardno,String expirydate,int cvv,String cardtype,int id,String nameoncard){
        addPayment payment = new addPayment();
        payment.setCardno(cardno);
        payment.setExpirydate(expirydate);
        payment.setCvv(cvv);
        payment.setId(id);
        payment.setNameoncard(nameoncard);
        payment.setCardtype(cardtype);
        return addPaymentRepository.save(payment);
    }

    @Override
    public addPayment saveTransaction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveTransaction'");
    }

}
