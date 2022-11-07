package SocialMedia.demo.service.impl;

import SocialMedia.demo.Repo.TokenRepo;
import SocialMedia.demo.model.Token;
import SocialMedia.demo.service.ConformationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
public class ConformationTokenServiceImpl implements ConformationTokenService {
    @Autowired
    TokenRepo  tokenRepo;
    public void saveToken(Token token){
        tokenRepo.save(token);

    }
    public Optional<Token> getToken(String token){
        return tokenRepo.findByToken(token);
    }
    public int setConfirmedAt(String token){
        return tokenRepo.updateConfirmedAt(token, LocalDateTime.now());
    }

}
