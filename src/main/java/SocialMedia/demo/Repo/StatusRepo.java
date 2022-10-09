package SocialMedia.demo.Repo;

import SocialMedia.demo.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface StatusRepo extends JpaRepository<Status,Long> {

}
