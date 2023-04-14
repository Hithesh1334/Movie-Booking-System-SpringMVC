package com.moviebookingsystem.moviebooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.moviebookingsystem.moviebooking.Model.listMovies;
import com.moviebookingsystem.moviebooking.Model.loginAuth;
import com.moviebookingsystem.moviebooking.Services.movieServiceimp;

import org.springframework.ui.Model;

@Controller
public class MovieController {
    
    // HOME PAGE
    @GetMapping("/")
    public ModelAndView home(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home"); // the name of the HTML template
        return modelAndView;
    }
    @PostMapping("/home-page")
    public String handleHomeButton(){
        return "redirect:/";
    }

    @Autowired
    private movieServiceimp service;


    // MOVIE PAGE
    @GetMapping("/movie")
    public ModelAndView movie(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<listMovies> data = service.findAllMovies(); 
        modelAndView.setViewName("movie");
        model.addAttribute("data",data);
        System.out.println(data);
        return modelAndView;
    }
    @PostMapping("/movie-page")
    public String handleMovieButton(){
        return "redirect:/movie";
    }
    @PostMapping("/button-click")
    public String handleButtonClick(){
            System.out.println("Button Click");
            return "redirect:/movie";
    }
    @PostMapping("/login")
    public String addUser(@RequestParam loginAuth user){
        System.out.println("LOGIIN");
        service.saveUser(user);
        return "redirect:/movie";
    }

    // LOGIN PAGE 
    @GetMapping("/login")
    public ModelAndView login(Model model){
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    

    // BOOKING PAGE
    @GetMapping("/book")
    public ModelAndView book(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book");
        return modelAndView;
    }
    @PostMapping("/booking-page")
    public String handleBookButton(){
        return "redirect:/book";
    }

    // CANCEL PAGE
    @GetMapping("/cancel")
    public ModelAndView cancel(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cancel");
        return modelAndView;
    }
}
