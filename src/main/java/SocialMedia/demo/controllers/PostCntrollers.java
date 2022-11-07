package SocialMedia.demo.controllers;

import SocialMedia.demo.model.Post;
import SocialMedia.demo.model.User;
import SocialMedia.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class PostCntrollers {

    @Autowired
    PostService postService;
    @PostMapping(path = "/makePost")
    String addPost(@RequestBody  Post post,@RequestBody String email){
        postService.savePost(email, post);
        return "succes";
    }

    @DeleteMapping(path = "/delatePost/{id}")
    String delatePost(@PathVariable long id){
        postService.deletePostById(id);
        return "post delated" ;
    }

    @PutMapping(path ="/updatePost")
    void updatePost(@RequestBody Post post){
        postService.updatePost(post);

    }

}
