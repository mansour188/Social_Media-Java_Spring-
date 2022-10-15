package SocialMedia.demo.Repo;

import SocialMedia.demo.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface TokenRepo extends JpaRepository<Token,Long> {

    Optional<Token> findByToken(String token);
}
