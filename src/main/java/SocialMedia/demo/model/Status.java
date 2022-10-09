package SocialMedia.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.Timestamp;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@Builder
@Table(name = "STATUS")
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long post_id;
    private String title ;

    private String contenu ;
    private String Url;
    private Integer voteCount=0 ;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
   private User user ;
    private Instant createdDate;






}
