package com.moviebookingsystem.moviebooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.moviebookingsystem.moviebooking.Services.movieServiceimp;
import com.moviebookingsystem.moviebooking.Model.loginAuth;
import com.moviebookingsystem.moviebooking.Model.listMovies;


@Controller
public class adminController {

    loginVariables loginData = loginVariables.getInstance();

    int status = loginData.getStatus();

    @Autowired
    private movieServiceimp service;

    
    @GetMapping("/admin")
    public ModelAndView admin(Model model){
        ModelAndView modelAndView = new ModelAndView();
        
        if(loginData.getStatus()==2){
            List<loginAuth> loginAuthData = service.findAllUser();
            List<listMovies> listMoviesData = service.findAllMovies();
            System.out.println(loginAuthData.size()+""+listMoviesData.size());
            
            modelAndView.setViewName("admin");
            model.addAttribute("noOfUsers", loginAuthData.size());
            model.addAttribute("noOfBookings", listMoviesData.size());
            model.addAttribute("data",listMoviesData);
            return modelAndView;
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/addMovie")
    public String addMoive(@RequestParam("movieName") String movieName, @RequestParam("movieId") int movieId,@RequestParam("releaseDate") String releaseDate){
        System.out.println(movieName+" "+movieId+" "+releaseDate);
        service.saveMovies(movieName, movieId, releaseDate);
        return "redirect:/admin";
    }

    @PostMapping("/logout")
    public String logout(){
        loginData.setStatus(0);
        return "redirect:/login";
    }
}
