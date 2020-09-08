package technicalblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    //For Logging Redirection
    @RequestMapping("users/login")
    public String login(){
        return "users/login";
    }
    //For Registration Redirection
    @RequestMapping("users/registration")
    public String registration(){
        return "users/Registration";
    }
}
