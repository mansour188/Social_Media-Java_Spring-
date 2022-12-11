package SocialMedia.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class JwtResponse {
    private String Authtoken;
    private String refreshToken;
    private Instant expiresAt;
    private String email;


}
