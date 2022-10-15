package SocialMedia.demo.service;

import SocialMedia.demo.Repo.PostRepo;
import SocialMedia.demo.model.Comment;
import SocialMedia.demo.model.Post;
import SocialMedia.demo.model.User;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@NoArgsConstructor

public class PostService {
    @Autowired
    PostRepo postRepo;
    @Autowired
    UserService userService;
    //this  partie of service for admin
    public List<Post> getAllPost(){
        return postRepo.findAll();
    }
   public Post savePost(String email ,Post post){
        User user=userService.findUserByEmail(email);
        post.setUser(user);
        return postRepo.save(post);

   }
   public  Post findPostById(Long id){
        return postRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Post not found"));
   }
   public void deletePostById(Long post_id ){
        postRepo.deleteById(post_id);
   }
   public List<Post> getPostByusername(String username){
        return postRepo.findByUserEmail(username);
   }




}
