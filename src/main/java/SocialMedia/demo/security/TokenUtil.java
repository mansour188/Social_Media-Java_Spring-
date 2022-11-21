package SocialMedia.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class TokenUtil {
    private final String claims_sub="sub";
    private final String claims_creted="creted";

    @org.springframework.beans.factory.annotation.Value("${auth.expiration}")
    private final Long token_validaty=604800L;
    @Value("${auth.secret}")
    private String token_secret;

    public String gnerateToken(UserDetails userDetails){

            //claims
            //expiration
            //sign
            //compact
            Map<String,Object> claims=new HashMap<>();
            claims.put(claims_sub,userDetails.getUsername());
            claims.put(claims_creted,new Date());
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpiration())
                .signWith(SignatureAlgorithm.HS256,token_secret)
                .compact();

        }

    private Date generateExpiration() {
        return new Date(System.currentTimeMillis()+token_validaty*1000);

    }
    public  String getUserNameFromToken(String token){
        try{
           Claims claims= getClaims(token);
           return claims.getSubject();

        }catch (Exception e){
            return null ;
        }

    }


    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username=getUserNameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));

    }

    private boolean isTokenExpired(String token) {
        Date expiration=getClaims(token).getExpiration();
        return expiration.before(new Date());


    }

    private Claims getClaims(String token){
        Claims claims;
        try {
             claims = Jwts.parser().setSigningKey(token_secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            claims=null;
        }
        return claims;
    }
}
