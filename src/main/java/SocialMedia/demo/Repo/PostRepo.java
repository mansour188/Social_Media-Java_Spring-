package SocialMedia.demo.Repo;

import SocialMedia.demo.model.Post;
import SocialMedia.demo.model.User;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {

   public Optional<Post> findById(Long postId);
   public List<Post> findByUser(User user);
}
