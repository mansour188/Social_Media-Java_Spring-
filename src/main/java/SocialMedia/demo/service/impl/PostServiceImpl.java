package SocialMedia.demo.service.impl;

import SocialMedia.demo.Repo.CommentRepo;
import SocialMedia.demo.Repo.PostRepo;
import SocialMedia.demo.Repo.UserRepo;
import SocialMedia.demo.dto.PostRequest;
import SocialMedia.demo.dto.PostResponse;
import SocialMedia.demo.model.Post;
import SocialMedia.demo.model.User;
import SocialMedia.demo.service.PostService;
import SocialMedia.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@Service
@NoArgsConstructor
@AllArgsConstructor


public class PostServiceImpl implements PostService {
  @Autowired
  private  UserRepo userRepo;
  @Autowired
   private  PostRepo postRepo;
  @Autowired
  private UserService userService;
  @Autowired
    CommentRepo commentRepo;


    @Override
    public void save(PostRequest postRequest) {
        Post post=new Post();
        User user=userService.getCurrentUser();
        post.setUser(user);
        post.setTitle(postRequest.getTitle());
        post.setUrl(postRequest.getUrl());
        post.setContenu(postRequest.getContenu());
        post.setCreatedDate(Instant.now());
        postRepo.save(post);


    }


    @Transactional(readOnly = true)
    @Override
    public List<PostResponse> getAllPost() {
        List<Post> posts=postRepo.findAll();
        List<PostResponse> postResponses = new ArrayList<>();
        for (Post post:posts
             ) {
            PostResponse postResponse=new PostResponse();
            postResponse.setId(post.getPostId());
            postResponse.setPostName(post.getTitle());
            postResponse.setUrl(post.getUrl());
            postResponse.setDescription(post.getContenu());
            postResponse.setDuration(post.getCreatedDate());
            postResponse.setVoteCount(post.getVoteCount());
           User user= userRepo.findUserByPosts(post).get();
            postResponse.setUsername(user.getEmail());
            Integer commentCount=commentRepo.findByPost(post).size();
            postResponse.setCommentCount(commentCount);
            postResponses.add(postResponse);


        }
        return postResponses;
    }


    @Transactional(readOnly = true)
    @Override
    public Post getPostById(Long id) {
        return postRepo.findById(id).orElseThrow(()->new RuntimeException(""));
    }

   @Transactional(readOnly = true)
    @Override
    public List<Post> getPostByUsername(String username) {
        User user =userRepo.findByEmail(username).orElseThrow(()-> new RuntimeException("user "+username+"not exist"));

        return postRepo.findByUser(user);
    }
}
