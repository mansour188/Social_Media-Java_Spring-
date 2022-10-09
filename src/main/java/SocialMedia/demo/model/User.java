package SocialMedia.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity



public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long userId;


    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    @NotBlank(message = "user name is required ")
    private String nom;
    @NotBlank(message = "Password is required")


    private String password;
    private UseerRole userRole;
    String ImageUrl;




    
}
