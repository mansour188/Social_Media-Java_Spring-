package SocialMedia.demo.service;

import SocialMedia.demo.model.Token;

import java.util.Optional;

public interface ConformationTokenService {
    public Optional<Token> getToken(String token);
    public int setConfirmedAt(String token);
}
