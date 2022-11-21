package SocialMedia.demo.service.impl;

import SocialMedia.demo.Repo.PostRepo;
import SocialMedia.demo.model.Post;
import SocialMedia.demo.model.User;
import SocialMedia.demo.service.PostService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@NoArgsConstructor

public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;
    @Autowired
    UserServiceImpl userService;
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
   public List<Post> getPostByEmail(String email) {
       User user= userService.findUserByEmail(email);
       List <Post> posts=user.getPosts();

       return posts;
   }

   public void updatePost(Post post){
        long id =post.getPostId();
        Post oldPost=postRepo.findById(id).get();
        oldPost.builder()
                .title(post.getTitle())
                .Url(post.getUrl())
                .contenu(post.getContenu())
                .build()
                ;
        postRepo.save(oldPost);
   }




}
