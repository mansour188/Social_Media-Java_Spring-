package SocialMedia.demo.controllers;

import SocialMedia.demo.dto.VoteDto;
import SocialMedia.demo.model.Vote;
import SocialMedia.demo.service.VoteService;
import SocialMedia.demo.service.impl.VoteServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/votes/")
@AllArgsConstructor
public class VoteControllers {

    @Autowired
    private VoteServiceImpl voteService;
    @PostMapping
    public ResponseEntity<Void> vote( @RequestBody VoteDto voteDto){
        voteService.vote(voteDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
