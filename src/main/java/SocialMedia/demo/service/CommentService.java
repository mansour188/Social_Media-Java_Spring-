package SocialMedia.demo.service;

import SocialMedia.demo.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommentService {
     Comment SaveComment(String email , Long post_id, Comment comment);
     Comment getCommentById(Long id );
     List<Comment> findCommentByPostId(Long postId);
     List<Comment>  getCommentByUsername(String email);
     void deleteCommentById(Long comtId);
     void updateComment(Comment comment);


}
