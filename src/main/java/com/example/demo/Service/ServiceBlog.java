package com.example.demo.Service;


import com.example.demo.ApiException.ApiException;
import com.example.demo.Model.Blog;
import com.example.demo.Repository.BlogRepsitry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceBlog {
  private final BlogRepsitry blogRepsitry;
  public List<Blog>getAllBlog(){
      return blogRepsitry.findAll();
  }

  public void addBlog(Blog blog){
     blogRepsitry.save(blog);
    }

     public void updateBlog(Integer id,Blog blog) {
         Blog oldBlog = blogRepsitry.getById(id);
         if (oldBlog == null) {
             throw new ApiException("not illegal");
         }
         oldBlog.setTitle(blog.getTitle());
         oldBlog.setBody(blog.getBody());
         oldBlog.setCategory(blog.getCategory());
         oldBlog.setPublished(blog.isPublished());

     }
     public Void deleteBlog( Integer id) {
         Blog oldblog = blogRepsitry.getById(id);
         if (oldblog == null) {
             throw new ApiException("blog delete");

         }
         blogRepsitry.delete(oldblog);
       return deleteBlog(id);
   }
   public Blog getBlogById(Integer id){
      Blog blog=blogRepsitry.findBlogById(id);
      if (blog==null){
         throw new  ApiException("not exist");
      }
      return blog;
   }
   public Blog getBlogByTitle(String title) {
        Blog blogs = blogRepsitry.findBlogByTitle(title);
            if (blogs == null){
                throw new ApiException("not exist");
        }
        return blogs;
    }
    public List<Blog> getBlogByCategory(String category) {
     List  <Blog> blogs = blogRepsitry.findBlogByCategory(category);
        if (blogs == null){
            throw new ApiException("not exist");
        }
        return blogs;
    }

    public  Blog changePublished(Integer id){
     Blog oldblog=blogRepsitry.findBlogById(id);
      if (oldblog==null){
          throw new ApiException("not blog to change status");
      }
      oldblog.setPublished(true);
      blogRepsitry.save(oldblog);
return oldblog;
    }

}
