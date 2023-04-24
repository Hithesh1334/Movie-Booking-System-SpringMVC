package com.moviebookingsystem.moviebooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.moviebookingsystem.moviebooking.Model.listMovies;
// import com.moviebookingsystem.moviebooking.Model.listMovies;
import com.moviebookingsystem.moviebooking.Services.movieServiceimp;

@Controller
public class paymentController {

    @Autowired
    private movieServiceimp service;

    @PostMapping("/book-movie")
    public ModelAndView bookmovie(@RequestParam("movieName") String movieName, @RequestParam("movieId") int movieId,@RequestParam("username") String username,@RequestParam("email") String email,@RequestParam("phoneNo") String phoneNo,@RequestParam("quantity") int quantity,Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<listMovies> movies = service.findAllMovies();
        int q_val=0;
        String date="";
        for(int i=0;i<movies.size();i++){
            listMovies movieData = movies.get(i);
            int mId = movieData.getId();
            if (movieId == mId){
                System.out.println("movieId"+mId);
                q_val = movieData.getAvailability();
                date = movieData.getDate();
                System.out.println(q_val+" "+date);
            }
            
        }
        q_val = q_val - quantity;
        service.updateMovie(q_val,movieId,movieName,date);
        service.saveUserBooking(movieName, movieId, username,email, phoneNo,q_val);
        modelAndView.setViewName("payment");
        // model.addAttribute("bookedmessage","Done");
        // model.addAttribute("bookedmessage2","Happy watching!");
        model.addAttribute("movieid",movieId);
        return modelAndView;
    }

    @PostMapping("/payment")
    public ModelAndView paymentdata(@RequestParam("cardno") String cardno,@RequestParam("expirydate") String expirydate,@RequestParam("cvv") int cvv,@RequestParam("cardtype") String cardtype,@RequestParam("nameoncard") String nameoncard,@RequestParam("id") int id,Model model){
        ModelAndView modelAndView = new ModelAndView();
        service.saveTransaction(cardno,expirydate,cvv,cardtype,id,nameoncard);
        modelAndView.setViewName("booked");
        model.addAttribute("bookedmessage", "Success");
        model.addAttribute("bookedmessage2", "!");
        return modelAndView;
    }
}
