package SocialMedia.demo.service.impl;

import SocialMedia.demo.dto.JwtResponse;
import SocialMedia.demo.dto.RefreshTokenRequest;
import SocialMedia.demo.dto.SignInRequest;
import SocialMedia.demo.security.TokenUtil;
import SocialMedia.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthServiceImpl {
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    RefreshTokenService refreshTokenService;

    public JwtResponse signIn(@RequestBody SignInRequest signInRequest) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),
                        signInRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userService.loadUserByUsername(signInRequest.getEmail());
        String token = tokenUtil.gnerateToken(userDetails);
        ;
        return JwtResponse.builder()
                .Authtoken(token)
                .refreshToken(refreshTokenService.generateRefreshToken().getToken())
                .expiresAt(Instant.now().plusMillis(tokenUtil.getJwtExpirationInMillis()))
                .email(signInRequest.getEmail())
                .build();
    }
    public JwtResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
        String token = tokenUtil.generateTokenWithUserName(refreshTokenRequest.getUsername());
        return JwtResponse.builder()
                .Authtoken(token)
                .refreshToken(refreshTokenRequest.getRefreshToken())
                .expiresAt(Instant.now().plusMillis(tokenUtil.getJwtExpirationInMillis()))
                .email(refreshTokenRequest.getUsername())
                .build();
    }
}
