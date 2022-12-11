package SocialMedia.demo.dto;

import lombok.Data;
import org.springframework.lang.Nullable;
@Data
public class PostRequest {
    private String title ;

    private String contenu ;

    private String url;
}
