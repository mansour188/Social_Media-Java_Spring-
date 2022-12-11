package SocialMedia.demo.controllers;

import SocialMedia.demo.dto.PostRequest;
import SocialMedia.demo.dto.PostResponse;
import SocialMedia.demo.model.Post;
import SocialMedia.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(path = "/api/posts")
@CrossOrigin("*")

public class PostCntrollers {
    @Autowired
    PostService postService;
    @PostMapping("/save")
    public ResponseEntity createPost(@RequestBody PostRequest postRequest){
        postService.save(postRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id){
        return  status(HttpStatus.OK).body(postService.getPostById(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<PostResponse>> getAllPosts(){
        return status(HttpStatus.OK).body( postService.getAllPost());
    }
    @GetMapping("/by_user/{username}")
    public ResponseEntity<List<Post>> getPostsByUsername( @PathVariable String username){
        return  status(HttpStatus.OK).body(postService.getPostByUsername(username));

    }


}
