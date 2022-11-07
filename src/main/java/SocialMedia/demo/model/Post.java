package SocialMedia.demo.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@Builder
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;
    private String title ;

    private String contenu ;
    private String Url;
    private Integer voteCount=0 ;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user ;
    private Instant createdDate;
    @OneToMany(mappedBy = "post")
    private List<Comment> commentList=new ArrayList<>();






}
