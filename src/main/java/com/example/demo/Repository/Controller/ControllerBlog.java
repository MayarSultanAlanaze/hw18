package com.example.demo.Controller;


import com.example.demo.Model.Blog;
import com.example.demo.Service.ServiceBlog;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/blog")
public class ControllerBlog {

  private final ServiceBlog serviceBlog ;

  @GetMapping("/get")
    public ResponseEntity getAllBlog(){
        List<Blog>blogList=serviceBlog.getAllBlog();
        return ResponseEntity.status(200).body(blogList);
    }
    @PostMapping("/add")
    public ResponseEntity addBlog(@Valid @RequestBody Blog blog, Errors errors){
         serviceBlog.addBlog(blog);
          return ResponseEntity.status(200).body("add Blog");
      }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@Valid @RequestBody Blog blog, @PathVariable Integer id,Errors errors){
          serviceBlog.updateBlog(id,blog);
          return ResponseEntity.status(200).body("update blog");
      }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity dleleteBloge(@PathVariable Integer id){
     serviceBlog.deleteBlog(id);
        return ResponseEntity.status(200).body("delete blog");
      }
      @GetMapping("/get-id/{id}")
      public ResponseEntity getBlogById(@PathVariable Integer id){
      return  ResponseEntity.status(200).body("sucssuflly");
      }
      @GetMapping("/get-title/{id}")
      public ResponseEntity getBlogById(@PathVariable String title){
      Blog blog=serviceBlog.getBlogByTitle(title);
      return ResponseEntity.status(200).body(blog);
      }
      @GetMapping("/get-Category/{id}")
      public ResponseEntity getBlogByCategory(@PathVariable String category){
      List<Blog >blog=serviceBlog.getBlogByCategory(category);
         return ResponseEntity.status(200).body(blog);
          }
          public ResponseEntity  changePublished(@PathVariable Integer id){
      Blog blog=serviceBlog.changePublished(id);
      return ResponseEntity.status(200).body("Your blog has been published succefully congrats");
          }
      }

