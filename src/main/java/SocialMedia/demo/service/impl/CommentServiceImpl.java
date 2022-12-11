package SocialMedia.demo.service.impl;

import SocialMedia.demo.Repo.CommentRepo;
import SocialMedia.demo.Repo.PostRepo;
import SocialMedia.demo.Repo.UserRepo;
import SocialMedia.demo.dto.CommentRequest;
import SocialMedia.demo.exception.PostNotFoundException;
import SocialMedia.demo.model.Comment;
import SocialMedia.demo.model.Post;
import SocialMedia.demo.model.User;
import SocialMedia.demo.service.CommentService;
import SocialMedia.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo ;
    @Autowired
    UserService userService;
    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepo userRepo;


    @Override
    public void save(CommentRequest commentRequest) {
        Post post=postRepo.findById(commentRequest.getPostId())
                .orElseThrow(()-> new PostNotFoundException("post id="+commentRequest.getPostId()+"not found"));
        Comment comment=new Comment();
        User user=userService.getCurrentUser();
        System.out.println(user.toString());
        comment.setPost(post);
        comment.setUser(user);
        comment.setText(commentRequest.getText());
        comment.setCreatedDate(Instant.now());
        commentRepo.save(comment);



    }

    @Override
    public List<Comment> getAllCommentForPost(Long postId) {

        System.out.println("************************************");
        Post post=postRepo.findById(postId).orElseThrow(()->new RuntimeException("post not exist"));
        System.out.println(post.getPostId());
        List<Comment> comments=commentRepo.findByPost(post);
        System.out.println(comments);

        System.out.println("************************************************************************");



        return comments;
    }

    @Override
    public List<Comment> getAllCommentForUser(String username) {
        User user=userRepo.findByEmail(username)
                .orElseThrow(()->new RuntimeException("user username:"+username+" not exist"));
        return commentRepo.findAllByUser(user);

    }
}
