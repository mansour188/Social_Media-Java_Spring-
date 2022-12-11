package SocialMedia.demo.service;

import SocialMedia.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface UserService {
    public User SaveUser(User user);
    public void deleteUser(Long id );
    public List<User> findUserByUsername(String name);
    public List<User>  allUser();
    public String signUpUser(User user);
    public int enableUser(String email);

    User findUserByEmail(String email);

    User findUserByid(Long id);
    public UserDetails loadUserByUsername(String email);
    public List<User> findUserStartingWith(String ch);
    public User getCurrentUser();

    List<User> getfriendofcurrentUser();
}
