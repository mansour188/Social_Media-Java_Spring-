package SocialMedia.demo.service;

import SocialMedia.demo.dto.CommentRequest;
import SocialMedia.demo.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommentService {


    void save(CommentRequest commentRequest);

    List<Comment> getAllCommentForPost(Long postId);;

    List<Comment> getAllCommentForUser(String username);
}
