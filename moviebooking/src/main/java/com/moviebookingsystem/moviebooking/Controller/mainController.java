package com.moviebookingsystem.moviebooking.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.ui.Model;

@Controller
public class mainController {
    
    loginVariables loginData = loginVariables.getInstance();
    int status = loginData.getStatus();
    // String name = loginData.getName();
    // String password = loginData.getPassword();

    // HOME PAGE
    @GetMapping("/")
    public ModelAndView home(Model model) {
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home"); // the name of the HTML template
        return modelAndView;
    }

    
    // When clicked on browse movie button in home page redirect it to movies page
    @PostMapping("/movies-page")
    public String handleButtonClick(){
            return "redirect:/movie";
    }
   

    
}
