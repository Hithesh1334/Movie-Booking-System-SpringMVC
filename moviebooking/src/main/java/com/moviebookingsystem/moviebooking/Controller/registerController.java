package com.moviebookingsystem.moviebooking.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// import com.moviebookingsystem.moviebooking.Model.listMovies;
import com.moviebookingsystem.moviebooking.Services.movieServiceimp;


@Controller
public class registerController {

    @Autowired
    private movieServiceimp service;

     //Registeration
     @GetMapping("/register")
     public ModelAndView register(Model model){
         ModelAndView modelAndView = new ModelAndView();
         modelAndView.setViewName("register");
         return modelAndView;
     }
 
     @PostMapping("/register")
     public void registerData(@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("email") String email){
        System.out.println(name+password); 
        service.saveUser(name,password,email);
        System.out.println(name+password);
     }
}
