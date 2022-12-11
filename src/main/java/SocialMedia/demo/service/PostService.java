package SocialMedia.demo.service;

import SocialMedia.demo.dto.PostRequest;
import SocialMedia.demo.dto.PostResponse;
import SocialMedia.demo.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;
@Service


public interface PostService {


    public void save(PostRequest post);

    List<PostResponse> getAllPost();

    Post getPostById(Long id);

    List<Post> getPostByUsername(String username);

}
