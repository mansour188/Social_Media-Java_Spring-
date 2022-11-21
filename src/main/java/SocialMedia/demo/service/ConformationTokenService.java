package SocialMedia.demo.service;

import SocialMedia.demo.model.Token;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public interface ConformationTokenService {
    public Optional<Token> getToken(String token);
    public int setConfirmedAt(String token);
}
