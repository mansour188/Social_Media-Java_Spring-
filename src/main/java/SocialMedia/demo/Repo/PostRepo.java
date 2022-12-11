package SocialMedia.demo.Repo;

import SocialMedia.demo.model.Post;
import SocialMedia.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
   public List<Post> findPostByUser(User user);

   List<Post> findByUser(User user);

}
