package com.moviebookingsystem.moviebooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.moviebookingsystem.moviebooking.Model.model;
import com.moviebookingsystem.moviebooking.Services.movieServiceimp;

import org.springframework.ui.Model;

@Controller
public class MovieController {
    
    @GetMapping("/")
    public ModelAndView home(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home"); // the name of the HTML template
        // model.addAttribute("message","hello");
        // model.addAttribute("message", "Hello World this is movie!"); // add any data you want to pass to the HTML template
        return modelAndView;
    }

    @Autowired
    private movieServiceimp service;

    @GetMapping("/movie")
    public ModelAndView movie(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<model> data = service.findAllMovies(); 
        modelAndView.setViewName("movie");
        model.addAttribute("data",data);
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(Model model){
        System.out.println("INSIDE");
        List<model> data = service.findAllMovies();//findallmovies
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        System.out.println(data);
        model.addAttribute("data",data);
        System.out.println("THis is data "+data);
        return modelAndView;
    }

    @GetMapping("/book")
    public ModelAndView book(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book");
        return modelAndView;
    }
    @GetMapping("/cancel")
    public ModelAndView cancel(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cancel");
        return modelAndView;
    }
}
