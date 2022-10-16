package SocialMedia.demo.service;

import SocialMedia.demo.cntr.RegestrationUser;
import SocialMedia.demo.email.EmailNotification;
import SocialMedia.demo.email.EmailSender;
import SocialMedia.demo.model.Token;
import SocialMedia.demo.model.UseerRole;
import SocialMedia.demo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {
    @Autowired
    private final EmailNotification emailNotification;
    @Autowired
    private final EmailValidator emailValidator;
    @Autowired
    private final UserService userService;
    @Autowired
    private final EmailSender emailSender;
    @Autowired
    final private ConformationTokenService conformationTokenService;


    public String registre(RegestrationUser request) {

        boolean isvalidEmail=emailValidator.test(request.getEmail());

        if (!isvalidEmail){
            throw new IllegalStateException("email not valid") ;
        }

        String token = userService.signUpUser(
                new User(
                        request.getName(),
                        request.getEmail(),
                        request.getPassword(),
                        UseerRole.USER


                )
        );
        String link="http://localhost:8080/apir/registration/confirm?token=" + token;
        emailSender.send(request.getEmail(),
                emailNotification.buildEmail(request.getName(),link));
        return token;
    }
    public String confirmToken(String token) {
        Token confirmationToken = conformationTokenService.getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getConfirmedAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        conformationTokenService.setConfirmedAt(token);
        userService.enableUser(
                confirmationToken.getUser().getEmail());
        return "confirmed";
    }}


