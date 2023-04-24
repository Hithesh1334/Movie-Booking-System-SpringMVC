package com.moviebookingsystem.moviebooking.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.moviebookingsystem.moviebooking.Model.listMovies;
import com.moviebookingsystem.moviebooking.Services.movieServiceimp;
@Controller
public class movieController {
    
    @Autowired
    private movieServiceimp service;
    
    // MOVIE PAGE
    @GetMapping("/movie")
    public ModelAndView movie(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<listMovies> data = service.findAllMovies(); //getting movies from database
        modelAndView.setViewName("movie");
        // listMovies d = data.get(0);
        model.addAttribute("data",data);    // sending it to the frontend
        return modelAndView;
    }

}
