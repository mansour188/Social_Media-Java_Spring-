package SocialMedia.demo.service;

import SocialMedia.demo.controllers.RegestrationUser;

public interface RegistrationService {
    String registre(RegestrationUser request);
    String confirmToken(String token);

}
