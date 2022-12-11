package SocialMedia.demo.controllers;

import SocialMedia.demo.dto.RegestrationRequest;
import SocialMedia.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin("*")
public class RegstrationCntrollers {
    @Autowired
    RegistrationService registrationService;
    @PostMapping("/registration")
    public ResponseEntity<String> saveUser(@RequestBody RegestrationRequest request){
        registrationService.registre(request);
        return new ResponseEntity<>("user registration secsesful", HttpStatus.OK);

    }
    @GetMapping(path = "/registration/confirm")
    @ResponseBody
    public ResponseEntity confirm(@RequestParam("token") String token) {
        System.out.println(token);
        registrationService.confirmToken(token);
        return new ResponseEntity<>("Account Activated ",HttpStatus.OK);
    }



}
