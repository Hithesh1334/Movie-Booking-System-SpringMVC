package com.moviebookingsystem.moviebooking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.Model;

@Controller
public class MovieController {
    
    @GetMapping("/")
    public ModelAndView home(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello"); // the name of the HTML template
        // model.addAttribute("message","hello");
        model.addAttribute("message", "Hello World!"); // add any data you want to pass to the HTML template
        return modelAndView;
    }
}
