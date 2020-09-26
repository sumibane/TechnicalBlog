package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;
    //For All Posts
    public List<Post> getAllPosts(){
        return repository.getAllPosts();
    }

    public Post getOnePost(){
        return repository.getLatestPost();
    }

    public void createPost(Post newpost){

    }
}
