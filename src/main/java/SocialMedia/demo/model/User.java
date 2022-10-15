package SocialMedia.demo.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "s_user")



public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long userId;
    @NotBlank(message = "name is required")

    private String name;
    @NotEmpty(message = "Email is required")
    @Email
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    @Enumerated(EnumType.STRING)
    private UseerRole userRole;
    private Boolean locked=false;
    private Boolean enabled=false ;
    private String ImageUrl;

    public User(String username, String email, String password, UseerRole userRole) {
        this.name = username;
        this.email = email;
        this.password = password;
        this.userRole=userRole;

    }

    @OneToMany(mappedBy = "user")
    List<Post> posts=new ArrayList<>();



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority=new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
