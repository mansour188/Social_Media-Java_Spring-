package SocialMedia.demo.controllers;

import SocialMedia.demo.dto.RegestrationRequest;
import SocialMedia.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class RegstrationCntrollers {
    @Autowired
    RegistrationService registrationService;
    @PostMapping("/registration")
    public String saveUser(@RequestBody RegestrationRequest request){
      
        return registrationService.registre(request);

    }
    @GetMapping(path = "/registration/confirm")
    @ResponseBody
    public String confirm(@RequestParam("token") String token) {
        System.out.println(token);
        return registrationService.confirmToken(token);
    }



}
