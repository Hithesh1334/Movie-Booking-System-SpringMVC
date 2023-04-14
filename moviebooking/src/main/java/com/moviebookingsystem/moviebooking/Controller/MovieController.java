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
    
    // These variables are used for authentication 
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

    // SERVICE part
    @Autowired
    private movieServiceimp service;


    // MOVIE PAGE
    @GetMapping("/movie")
    public ModelAndView movie(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<listMovies> data = service.findAllMovies(); //getting movies from database
        modelAndView.setViewName("movie");
        model.addAttribute("data",data);    // sending it to the frontend
        return modelAndView;
    }
    
    // When clicked on browse movie button in home page redirect it to movies page
    @PostMapping("/movies-page")
    public String handleButtonClick(){
            return "redirect:/movie";
    }
   
    //Login authentication part 
    @PostMapping("/login")
    public void loginAuthentication(@RequestParam("username") String username, @RequestParam("password") String ppassword){
        List<loginAuth> data = service.findAllUser(); // getting all the users form the database

        for(int i=0;i<data.size();i++){
            loginAuth login = data.get(i);

            // names and password form the database
            name = login.getName();
            password = login.getPassword();

            // System.out.println("name" +name+" password " +password);
            // System.out.println("name "+username+" password "+ppassword);
            // System.out.println(name+password);
            // System.out.println(status);
            if ((name.equals(username)) && (password.equals(ppassword))){
                status = 1;
            }
            // System.out.println(status);
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
        
        //Checking if user has logined or not 
        if (status == 1){
            modelAndView.setViewName("book"); //if yes then open booking page
            return modelAndView;
        }
        else{
            modelAndView.setViewName("login"); //if no then open login page
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
