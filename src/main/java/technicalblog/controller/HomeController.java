package technicalblog.controller;
import technicalblog.service.PostService;
import technicalblog.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String getAllPosts(Model model){

        //Dependency injection
        List<Post> posts = postService.getAllPosts();

        //Add the Collection in the Model Object
        model.addAttribute("posts", posts);

        return "index";
    }
}
