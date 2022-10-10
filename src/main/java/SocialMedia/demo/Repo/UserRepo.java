package SocialMedia.demo.Repo;

import SocialMedia.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    public User findByEmail(String email);
    Optional<User> findByUsername(String username);}
