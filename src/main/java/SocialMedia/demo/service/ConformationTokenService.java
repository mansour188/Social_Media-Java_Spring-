package SocialMedia.demo.service;

import SocialMedia.demo.Repo.TokenRepo;
import SocialMedia.demo.model.Token;
import org.springframework.beans.factory.annotation.Autowired;

public class ConformationTokenService {
    @Autowired
    TokenRepo  tokenRepo;
    public void saveToken(Token token){
        tokenRepo.save(token);

    }
}
