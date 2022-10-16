package SocialMedia.demo.cntr;

import SocialMedia.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/apir")
public class RegstrationCntr {
    @Autowired
    RegistrationService registrationService;
    @PostMapping("/registration")
    public String saveUser(@RequestBody RegestrationUser request){
        return registrationService.registre(request);

    }
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }



}
