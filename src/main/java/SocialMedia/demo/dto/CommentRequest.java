package SocialMedia.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CommentRequest {


    private Long postId;
   
    private String text;

}
