package com.moviebookingsystem.moviebooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.moviebookingsystem.moviebooking.Model.admin;
import com.moviebookingsystem.moviebooking.Model.loginAuth;
import com.moviebookingsystem.moviebooking.Services.movieServiceimp;

@Controller
public class loginController {
    
    loginVariables loginData = loginVariables.getInstance();

    int status = loginData.getStatus();
    String name = loginData.getUserName();
    String password = loginData.getUserPassword();
    String adminName = loginData.getAdminName();
    String adminPassword = loginData.getAdminPassword();

    @Autowired 
    private movieServiceimp service;

     // LOGIN PAGE 
     @GetMapping("/login")
     public ModelAndView login(Model model){
         ModelAndView modelAndView = new ModelAndView();
         modelAndView.setViewName("login");
         return modelAndView;
     }


      //Login authentication part 
    @PostMapping("/login")
    public ModelAndView loginAuthentication(@RequestParam("username") String username, @RequestParam("password") String ppassword,Model model){
        List<loginAuth> data = service.findAllUser(); // getting all the users form the database
        //admin
        List<admin> adminList = service.getAdminData();
        // System.out.println(adminList.get(0));
        System.out.println(username+"g"+ppassword);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        for(int i=0;i<data.size();i++){
            loginAuth login = data.get(i);
            // names and password form the database
            name = login.getName();
            password = login.getPassword();

            // System.out.println("name" +name+" password " +password);

            if ((name.equals(username)) && (password.equals(ppassword))){
                if (status == 0){
                    loginData.setStatus(1);
                    loginData.getStatus();
                    System.out.println(loginData.getStatus());
                    modelAndView.setViewName("booked");

                    model.addAttribute("bookedmessage","Successfully Logined!");
                    model.addAttribute("bookedmessage2","You have successfully logged in.");
                    return modelAndView;
                }
                else{
                    modelAndView.setViewName("booked");
                    model.addAttribute("bookedmessage","Already Logged In");
                    model.addAttribute("bookedmessage2","😀");
                    return modelAndView;
                }

            }   
            
            
        }
        for(int i=0;i<adminList.size();i++){
            admin adminLogin = adminList.get(i);

            //admin
            adminName = adminLogin.getName();
            adminPassword = adminLogin.getPassword();
            System.out.println(adminName + " " + adminPassword);
 
            if((adminName.equals(username)) && (adminPassword.equals(ppassword))){
                System.out.println(adminName + " " + adminPassword);

                if (status == 0){
                    System.out.println(adminName + " " + adminPassword);

                    loginData.setStatus(2);
                    loginData.getStatus();
                    modelAndView.setViewName("adminDashboard");
                    return modelAndView;
                }
                else{
                    modelAndView.setViewName("booked");
                    model.addAttribute("bookedmessage","Already Logged In");
                    model.addAttribute("bookedmessage2","😀");
                    return modelAndView;
                }
            }
            
        }
        
        return modelAndView;
        
    }

}
