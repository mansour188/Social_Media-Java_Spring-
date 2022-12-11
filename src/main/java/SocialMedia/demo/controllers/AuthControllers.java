package SocialMedia.demo.controllers;

import SocialMedia.demo.dto.JwtResponse;
import SocialMedia.demo.dto.RefreshTokenRequest;
import SocialMedia.demo.dto.SignInRequest;
import SocialMedia.demo.service.impl.AuthServiceImpl;
import SocialMedia.demo.service.impl.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/auth")
@CrossOrigin("*")

public class AuthControllers {
    @Autowired
    AuthServiceImpl authService;
    @Autowired
    RefreshTokenService refreshTokenService;

    @PostMapping(value = {"","/login"})
    public JwtResponse signIn(@RequestBody SignInRequest signInRequest){
        return authService.signIn(signInRequest) ;

    }
    @PostMapping("/refresh/token")
    public JwtResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body("Refresh Token Deleted Successfully!!");
    }



}
