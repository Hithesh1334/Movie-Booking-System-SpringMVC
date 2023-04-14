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
    
    private int status = 0;
    private String name  ;
    private String password ;
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
    public void loginAuthentication(@RequestParam("username") String username, @RequestParam("password") String ppassword){
        List<loginAuth> data = service.findAllUser();
        System.out.println(data);
        for(int i=0;i<data.size();i++){
            loginAuth login = data.get(i);
            name = login.getName();
            password = login.getPassword();
            System.out.println("name" +name+" password " +password);
            System.out.println("name "+username+" password "+ppassword);
            System.out.println(name+password);
            System.out.println(status);
            if ((name.equals(username)) && (password.equals(ppassword))){
                status = 1;
            }
            System.out.println(status);
        }
        
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
        if (status == 1){
            modelAndView.setViewName("book");
            return modelAndView;
        }
        else{
            modelAndView.setViewName("login");
            return modelAndView;
        }
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
