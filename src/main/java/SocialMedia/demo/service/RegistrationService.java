package SocialMedia.demo.service;

import SocialMedia.demo.dto.RegestrationRequest;
import SocialMedia.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface RegistrationService {
    String registre(RegestrationRequest request);
    String confirmToken(String token);


}
