package SocialMedia.demo.service;

import SocialMedia.demo.dto.VoteDto;
import org.springframework.stereotype.Service;

@Service
public interface VoteService{
    public void vote(VoteDto voteDto);

}
