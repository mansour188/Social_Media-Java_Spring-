package SocialMedia.demo.controllers;

import SocialMedia.demo.dto.CommentRequest;
import SocialMedia.demo.model.Comment;
import SocialMedia.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentCntrollers {
    @Autowired
   private CommentService commentService;
    @PostMapping("/save")
    public ResponseEntity saveComment(@RequestBody CommentRequest commentRequest){
        commentService.save(commentRequest);
        return new ResponseEntity(HttpStatus.CREATED);

    }
    @GetMapping("/by_postId/{postId}")
    public ResponseEntity<List<Comment>> getAllCommentForPost(@PathVariable  Long postId){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getAllCommentForPost(postId)) ;
    }
    @GetMapping("/by_username/{username}")
    public ResponseEntity<List<Comment>> getAllCommentForUser(@PathVariable String username){
       return ResponseEntity.status(HttpStatus.OK).body( commentService.getAllCommentForUser(username));
    }



}
