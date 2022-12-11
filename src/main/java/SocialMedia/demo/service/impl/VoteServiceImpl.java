package SocialMedia.demo.service.impl;


import SocialMedia.demo.Repo.PostRepo;
import SocialMedia.demo.Repo.VoteRepo;
import SocialMedia.demo.dto.VoteDto;
import SocialMedia.demo.model.Post;
import SocialMedia.demo.model.Vote;
import SocialMedia.demo.service.UserService;
import SocialMedia.demo.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static SocialMedia.demo.model.VoteType.UPVOTE;


@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    PostRepo postRepo;
    @Autowired
    VoteRepo voteRepo;
    @Autowired
    UserService userService;


    @Transactional
    public void vote(VoteDto voteDto) {

        Post post = postRepo.findById(voteDto.getPostId())
                .orElseThrow(() -> new RuntimeException("Post Not Found with ID - " + voteDto.getPostId()));
        System.out.println("################################# POst Id  ###################################################");
        System.out.println(post.getPostId());
        System.out.println("#######################################################################################");
        Optional<Vote> voteByPostAndUser = voteRepo.findTopByPostAndUserOrderByVoteIdDesc(post, userService.getCurrentUser());

        System.out.println("#######################################################################################");


        if (voteByPostAndUser.isPresent() &&
                voteByPostAndUser.get().getVoteType()
                        .equals(voteDto.getVoteType())) {
            throw new RuntimeException("You have already "
                    + voteDto.getVoteType() + "'d for this post");
        }
        if (UPVOTE.equals(voteDto.getVoteType())) {
            post.setVoteCount(post.getVoteCount() + 1);
        } else {
            post.setVoteCount(post.getVoteCount() - 1);
        }
        voteRepo.save(mapToVote(voteDto, post));
        postRepo.save(post);
    }

    private Vote mapToVote(VoteDto voteDto, Post post) {
        return Vote.builder()
                .voteType(voteDto.getVoteType())
                .post(post)
                .user(userService.getCurrentUser())
                .build();
    }

    }


