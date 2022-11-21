package SocialMedia.demo.service;

import SocialMedia.demo.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;
@Service


public interface PostService {
    public List<Post> getAllPost();
    public Post savePost(String email ,Post post);
    public  Post findPostById(Long id);
    public void deletePostById(Long post_id );
    public List<Post> getPostByEmail(String username);
    public void updatePost(Post post);

}
