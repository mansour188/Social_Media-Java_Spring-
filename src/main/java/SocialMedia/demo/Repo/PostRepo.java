package SocialMedia.demo.Repo;

import SocialMedia.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {

    Post findById(String post_id);
}
