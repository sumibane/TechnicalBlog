package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.model.Post;
import technicalblog.model.User;
import technicalblog.model.UserProfile;
import technicalblog.service.PostService;
import technicalblog.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    //For Logging Landing page
    @RequestMapping("users/login")
    public String login(){
        return "users/login";
    }

    //For Logging Redirection
    @RequestMapping(value = "users/login", method = RequestMethod.POST)
    public String loginUser(User user, HttpSession session){
        User loginUser = userService.login(user);
        if(loginUser != null) {
            session.setAttribute("loggeduser", loginUser);
            return "redirect:/posts";
        }
        else
            return "users/login";
    }

    //For Registration Landing page
    @RequestMapping("users/registration")
    public String registration(Model model){
        User user = new User();
        UserProfile profile = new UserProfile();
        user.setProfile(profile);

        model.addAttribute("User", user);
        return "users/registration";
    }

    //For Registration Redirection
    @RequestMapping(value = "users/registration", method = RequestMethod.POST)
    public String registerUser(User user){
        userService.registerUser(user);
        return "redirect:/users/login";
    }

    //For Logout
    @RequestMapping(value = "users/logout", method = RequestMethod.POST)
    public String logout(Model model, HttpSession session){
        session.invalidate(); //Doesn't work need clarification
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }
}
