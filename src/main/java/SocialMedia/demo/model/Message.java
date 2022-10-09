package SocialMedia.demo.model;

import javax.persistence.*;
import java.util.UUID;


public abstract class Message  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_msg ;
}
