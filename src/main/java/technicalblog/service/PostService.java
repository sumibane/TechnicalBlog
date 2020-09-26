package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

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
        newpost.setDate(new Date());
        repository.createPost(newpost);
        System.out.println(newpost);
    }

    public Post getPost(Integer postId){
        return repository.getPost(postId);
    }

    public void updatePost(Post updatedPost){
        updatedPost.setDate(new Date());
        repository.updatePost(updatedPost);
    }

    public void deletePost(Integer postId){
        repository.deletePost(postId);
    }
}
