package SocialMedia.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.lang.Nullable;

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
    @Nullable
    private String url;
    private Integer voteCount=0 ;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user ;
    private Instant createdDate;
    @OneToMany(mappedBy = "post")
    private List<Comment> commentList=new ArrayList<>();


    @JsonBackReference
    public List<Comment> getCommentList() {
        return commentList;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }
}
