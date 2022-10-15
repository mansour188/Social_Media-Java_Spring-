package SocialMedia.demo.service;

import SocialMedia.demo.cntr.RegestrationUser;
import SocialMedia.demo.model.UseerRole;
import SocialMedia.demo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    @Autowired
    private EmailValidator emailValidator;
    @Autowired
    private UserService userService;

    public String registre(RegestrationUser request) {

        boolean isvalidEmail=emailValidator.test(request.getEmail());

        if (!isvalidEmail){
            throw new IllegalStateException("email not valid") ;
        }

        return userService.signUpUser(
                new User(
                        request.getName(),
                        request.getEmail(),
                        request.getPassword(),
                        UseerRole.USER


                )
        )  ;
    }
}
