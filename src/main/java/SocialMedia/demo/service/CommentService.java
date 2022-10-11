package SocialMedia.demo.service;

import SocialMedia.demo.Repo.CommentRepo;
import SocialMedia.demo.model.Comment;
import SocialMedia.demo.model.Post;
import SocialMedia.demo.model.User;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class CommentService {
    @Autowired
    CommentRepo commentRepo ;
    @Autowired
    UserService userService;
    @Autowired
    PostService postService ;
    public Comment SaveComment(String username ,Long post_id,Comment comment){
        User user=userService.findUserByUsername(username);
        Post post=postService.findPostById(post_id);
        comment.setUser(user);
        comment.setPost(post);
        return commentRepo.save(comment);
    }

    public List<Comment>  getCommentByUser(String username){
        return null ;

    }
    // update comment by user and post



}
