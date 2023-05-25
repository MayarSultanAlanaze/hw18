package com.example.demo.Repository;

import com.example.demo.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogRepsitry extends JpaRepository<Blog,Integer> {

    Blog findBlogById(Integer id);
    List<Blog> findBlogByCategory(String category);

    Blog findBlogByTitle(String title);

    List<Blog>findBlogByBody(String body);

    Blog findBlogByPublished(boolean isPublished);
}

