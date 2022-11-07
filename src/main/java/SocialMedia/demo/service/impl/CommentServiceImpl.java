package SocialMedia.demo.service.impl;

import SocialMedia.demo.Repo.CommentRepo;
import SocialMedia.demo.model.Comment;
import SocialMedia.demo.model.Post;
import SocialMedia.demo.model.User;
import SocialMedia.demo.service.CommentService;
import SocialMedia.demo.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo ;
    @Autowired
    UserService userService;
    @Autowired
    PostServiceImpl postService ;

    public Comment SaveComment(String email ,Long post_id,Comment comment){
        User user=userService.findUserByEmail(email);
        Post post=postService.findPostById(post_id);
        comment.setUser(user);
        comment.setPost(post);
        return commentRepo.save(comment);
    }
    public Comment getCommentById(Long id ){
        return commentRepo.findById(id).orElseThrow(()->new IllegalArgumentException("comment not found "));
    }

    public List<Comment> findCommentByPostId(Long postId){
        return commentRepo.findByPostPostId(postId);

    }


    public List<Comment>  getCommentByUsername(String email){
        return commentRepo.findByUserEmail(email) ;

    }
    public void deleteCommentById(Long comtId){
       Optional<Comment> comment=commentRepo.findById(comtId);
       if (comment.isPresent()){
           commentRepo.delete(comment.get());

       }else {
           throw new RuntimeException("commment Not exist");
       }
    }



    
    // update comment by user and post
    public void updateComment(Comment comment){
        long id=comment.getComtId();
        Comment oldComment=commentRepo.findById(id).orElseThrow(()->new IllegalArgumentException("not exist"));
        oldComment.builder()
                .text(comment.getText())
                .build();
        commentRepo.save(oldComment);


    }



}
