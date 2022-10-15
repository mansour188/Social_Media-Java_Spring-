package SocialMedia.demo.cntr;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegestrationUser {
    private final String name;
    private final String password ;
    private final String email ;

}
