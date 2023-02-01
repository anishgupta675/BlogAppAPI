package com.example.blogappapi.repositories;

import com.example.blogappapi.entities.Category;
import com.example.blogappapi.entities.Post;
import com.example.blogappapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    /*
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    */
    @Query("SELECT p FROM Post p WHERE title LIKE :key")
    List<Post> searchByTitle(@Param("key") String title);
}