package SocialMedia.demo.Repo;

import SocialMedia.demo.model.Post;
import SocialMedia.demo.model.User;
import SocialMedia.demo.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepo  extends JpaRepository<Vote,Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
