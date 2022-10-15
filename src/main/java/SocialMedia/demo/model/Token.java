package SocialMedia.demo.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   @Column(nullable = false)
    private String token;
    @Column(nullable = false)

    private LocalDateTime createdDate;
    @Column(nullable = false)

    private LocalDateTime expireDate;
    private  LocalDateTime  conformedDate;

    @ManyToOne
    @JoinColumn( nullable = false,
            name = "user_id")
   private User  user ;

    public Token(String token, LocalDateTime createdDate, LocalDateTime expireDate, User user) {
        this.token = token;
        this.createdDate = createdDate;
        this.expireDate = expireDate;
        this.user = user;
    }
}
