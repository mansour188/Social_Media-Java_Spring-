package SocialMedia.demo.service.impl;

import SocialMedia.demo.dto.RegestrationRequest;
import SocialMedia.demo.email.EmailNotification;
import SocialMedia.demo.email.EmailSender;
import SocialMedia.demo.model.Token;
import SocialMedia.demo.model.UseerRole;
import SocialMedia.demo.model.User;
import SocialMedia.demo.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl  implements RegistrationService {
    @Autowired
    private final EmailNotification emailNotification;
    @Autowired
    private final EmailValidatorImpl emailValidator;
    @Autowired
    private final UserServiceImpl userService;
    @Autowired
    private final EmailSender emailSender;
    @Autowired
    final private ConformationTokenServiceImpl conformationTokenService;


    public String registre(RegestrationRequest request) {

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
        String link="http://localhost:8080/api/registration/confirm?token=" + token;
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

        LocalDateTime expiredAt = confirmationToken.getExpireDate();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        conformationTokenService.setConfirmedAt(token);
        userService.enableUser(
                confirmationToken.getUser().getEmail());
        return "confirmed";
    }}


