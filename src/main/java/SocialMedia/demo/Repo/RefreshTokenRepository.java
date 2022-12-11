package SocialMedia.demo.Repo;

import SocialMedia.demo.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
    Optional<Object> findByToken(String token);

    void deleteByToken(String token);
}
