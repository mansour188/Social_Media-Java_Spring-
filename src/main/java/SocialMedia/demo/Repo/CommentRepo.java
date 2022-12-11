package SocialMedia.demo.Repo;

import SocialMedia.demo.model.Comment;
import SocialMedia.demo.model.Post;
import SocialMedia.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    public List<Comment> findByPostPostId(Long postId);
    public List<Comment> findByUserEmail(String email);
    public List<Comment> findByPost(Post post);

   public List<Comment> findAllByUser(User user);
}
