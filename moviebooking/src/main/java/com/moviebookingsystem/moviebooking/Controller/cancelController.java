package com.moviebookingsystem.moviebooking.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.moviebookingsystem.moviebooking.Model.addUserBooking;
// import com.moviebookingsystem.moviebooking.Model.listMovies;
import com.moviebookingsystem.moviebooking.Services.movieServiceimp;


@Controller
public class cancelController {
 
    loginVariables loginData = loginVariables.getInstance();
    int status = loginData.getStatus();
    // String name = loginData.getName();
    // String password = loginData.getPassword();
    
    @Autowired
    private movieServiceimp service;

    @GetMapping("/cancel")
    public ModelAndView cancel(Model model){
        ModelAndView modelAndView = new ModelAndView();
        if (loginData.getStatus() == 1){
            modelAndView.setViewName("cancel"); //if yes then open booking page
            return modelAndView;
        }
        else{
            modelAndView.setViewName("login"); //if no then open login page
            return modelAndView;
        }

    }

    @PostMapping("/cancel")
    public ModelAndView cancleBooking(@RequestParam("id") int id,Model model){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(id);
        List<addUserBooking> data =  service.findAllBookings();
        for(int i=0;i<data.size();i++){
            addUserBooking userbooking = data.get(i);
            int idd = userbooking.getMovieId();
            if(idd == id){
                service.deleteBooking(id);
                modelAndView.setViewName("booked");
                model.addAttribute("bookedmessage","Cancled successfully");
                model.addAttribute("bookedmessage2","!");
                return modelAndView;
            }
        }
        modelAndView.setViewName("booked");
        model.addAttribute("bookedmessage","No booking available");
        model.addAttribute("bookedmessage2","!");
        return modelAndView;
    }

}
