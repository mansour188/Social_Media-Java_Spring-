package SocialMedia.demo.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter

@EqualsAndHashCode
@ToString
public class RegestrationRequest {
    private final String name;
    private final String password ;
    private final String email ;
    public RegestrationRequest(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
