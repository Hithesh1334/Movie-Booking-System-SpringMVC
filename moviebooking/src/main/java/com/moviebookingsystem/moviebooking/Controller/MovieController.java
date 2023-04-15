package com.moviebookingsystem.moviebooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.moviebookingsystem.moviebooking.Model.addUserBooking;
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
    public ModelAndView loginAuthentication(@RequestParam("username") String username, @RequestParam("password") String ppassword,Model model){
        List<loginAuth> data = service.findAllUser(); // getting all the users form the database
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
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
                if (status == 0){
                    status = 1;
                    modelAndView.setViewName("loginSuccess");
                // System.out.println(status);
                    model.addAttribute("loginMessage","Successfully Logined!");
                    model.addAttribute("loginMessage2","You have successfully logged in.");
                    return modelAndView;
                }
                else{
                    modelAndView.setViewName("loginSuccess");
                // System.out.println(status);
                    model.addAttribute("loginMessage","Already Logged In");
                    model.addAttribute("loginMessage2","😀");
                    return modelAndView;
                }

            }   
            
        }
        return modelAndView;
        
    }


    // LOGIN PAGE 
    @GetMapping("/login")
    public ModelAndView login(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    

    // on clicking on book directing to booking page with the infomation of the movie
    @PostMapping("/book")
    public ModelAndView bookingData(@RequestParam("id") int id,Model model){
        ModelAndView modelAndView = new ModelAndView();

        String name="";

        List<listMovies> data = service.findAllMovies(); // listing all movies 

        //code to assign the movie 
        for(int i=0;i<data.size();i++){
            System.out.println(data.get(i));
            listMovies movie = data.get(i);
            int i_id = movie.getId();
            String movieName = movie.getName();
            if (id == i_id){
                name = movieName;
            }
        }
        if (status == 1){
            modelAndView.setViewName("book");
            model.addAttribute("movieName",name);
            model.addAttribute("id",id);
            return modelAndView;
        }
        else{
            modelAndView.setViewName("login"); //if no then open login page
            return modelAndView;
        }
        
    }

    // Direct to booking page
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

    @PostMapping("/book-movie")
    public ModelAndView bookmovie(@RequestParam("movieName") String movieName, @RequestParam("movieId") int movieId,@RequestParam("username") String username,@RequestParam("email") String email,@RequestParam("phoneNo") String phoneNo,Model model){
        ModelAndView modelAndView = new ModelAndView();
        service.saveUserBooking(movieName, movieId, username,email, phoneNo);
        modelAndView.setViewName("payment");
        // model.addAttribute("bookedmessage","Done");
        // model.addAttribute("bookedmessage2","Happy watching!");
        model.addAttribute("movieid",movieId);
        return modelAndView;
    }

    // CANCEL PAGE
    @GetMapping("/cancel")
    public ModelAndView cancel(Model model){
        ModelAndView modelAndView = new ModelAndView();
        if (status == 1){
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


    //Registeration
    @GetMapping("/register")
    public ModelAndView register(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/register")
    public void registerData(@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("email") String email){
        service.saveUser(name,password,email);
        System.out.println(name+password);
    }

    @PostMapping("/payment")
    public ModelAndView paymentdata(@RequestParam("cardno") String cardno,@RequestParam("expirydate") String expirydate,@RequestParam("cvv") int cvv,@RequestParam("cardtype") String cardtype,@RequestParam("nameoncard") String nameoncard,@RequestParam("id") int id,Model model){
        ModelAndView modelAndView = new ModelAndView();
        service.saveTransaction(cardno,expirydate,cvv,cardtype,id,nameoncard);
        modelAndView.setViewName("booked");
        model.addAttribute("bookedmessage", "Success");
        model.addAttribute("bookedmessage2", "!");
        return modelAndView;
    }
}
