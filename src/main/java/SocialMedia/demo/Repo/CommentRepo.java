package SocialMedia.demo.Repo;

import SocialMedia.demo.model.Comment;
import com.sun.jdi.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    public List<Comment> findByPostPostId(Long postId);
    public List<Comment> findByUserEmail(String email);

}
