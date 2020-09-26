package technicalblog.service;

import org.springframework.stereotype.Service;
import technicalblog.model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    public ArrayList<Post> getAllPosts(){

        ArrayList<Post> posts = new ArrayList<>(); //Created to add all the posts in the collection

        /*Post post1 = new Post();
        post1.setTitle("Post 1");
        post1.setBody("Post Body 1");
        post1.setDate(new Date());

        Post post2 = new Post();
        post2.setTitle("Post 2");
        post2.setBody("Post Body 2");
        post2.setDate(new Date());

        Post post3 = new Post();
        post3.setTitle("Post 3");
        post3.setBody("Post Body 3");
        post3.setDate(new Date());

        *//* Individual post creation ends here*//*

        //Adds the posts in the ArrayList collection
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);*/
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/technicalblog","postgres","12345");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM POSTS ORDER BY ID");
            while(rs.next()){
                Post post = new Post();
                post.setDate(rs.getDate("date"));
                post.setBody(rs.getString("body"));
                post.setTitle(rs.getString("title"));

                posts.add(post);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return posts;
    }

    public ArrayList<Post> getOnePost(){

        ArrayList<Post>  posts = new ArrayList<>();

        /*Post post1 = new Post();
        post1.setTitle("This is your post");
        post1.setBody("This is your Post. It has some valid contents");
        post1.setDate(new Date());

        posts.add(post1);*/

        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/technicalblog","postgres","12345");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM POSTS where id <= 2 ORDER BY ID");
            while(rs.next()){
                Post post = new Post();
                post.setDate(rs.getDate("date"));
                post.setBody(rs.getString("body"));
                post.setTitle(rs.getString("title"));

                posts.add(post);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return posts;
    }

    public void createPost(Post newpost){

    }
}
