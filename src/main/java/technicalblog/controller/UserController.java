package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.model.Post;
import technicalblog.model.User;
import technicalblog.service.PostService;

import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    private PostService postService;

    //For Logging Landing page
    @RequestMapping("users/login")
    public String login(){
        return "users/login";
    }
    //For Logging Redirection
    @RequestMapping(value = "users/login", method = RequestMethod.POST)
    public String loginUser(User user){
        return "redirect:/posts";
    }
    //For Registration Landing page
    @RequestMapping("users/registration")
    public String registration(){
        return "users/Registration";
    }
    //For Registration Redirection
    @RequestMapping(value = "users/registration", method = RequestMethod.POST)
    public String registerUser(User user){
        return "users/login";
    }
    //For Logout
    @RequestMapping(value = "users/logout", method = RequestMethod.POST)
    public String logout(Model model){
        ArrayList<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }
}
