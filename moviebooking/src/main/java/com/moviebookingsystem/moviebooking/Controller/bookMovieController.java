package com.moviebookingsystem.moviebooking.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.moviebookingsystem.moviebooking.Model.listMovies;
// import com.moviebookingsystem.moviebooking.Model.listMovies;
import com.moviebookingsystem.moviebooking.Services.movieServiceimp;


@Controller
public class bookMovieController {
    
    loginVariables loginData = loginVariables.getInstance();
    int status = loginData.getStatus();
    // String name = loginData.getName();
    // String password = loginData.getPassword();

    @Autowired
    private movieServiceimp service;
    // on clicking on book directing to booking page with the infomation of the movie
    @PostMapping("/book")
    public ModelAndView bookingData(@RequestParam("id") int id,Model model){
        ModelAndView modelAndView = new ModelAndView();

        String name="";

        List<listMovies> data = service.findAllMovies(); // listing all movies 

        //code to assign the movie 
        for(int i=0;i<data.size();i++){
            System.out.println(data.get(i));
            listMovies movie = data.get(i);
            int i_id = movie.getId();
            String movieName = movie.getName();
            if (id == i_id){
                name = movieName;
            }
        }
        if ( loginData.getStatus()== 1){
            modelAndView.setViewName("book");
            model.addAttribute("movieName",name);
            model.addAttribute("id",id);
            return modelAndView;
        }
        else{
            modelAndView.setViewName("login"); //if no then open login page
            return modelAndView;
        }
        
    }

    // Direct to booking page
    @GetMapping("/book")
    public ModelAndView book(Model model){
        ModelAndView modelAndView = new ModelAndView();
        
        //Checking if user has logined or not 
        if (loginData.getStatus() == 1){
            modelAndView.setViewName("book"); //if yes then open booking page
            return modelAndView;
        }
        else{
            modelAndView.setViewName("login"); //if no then open login page
            return modelAndView;
        }
    }

}
