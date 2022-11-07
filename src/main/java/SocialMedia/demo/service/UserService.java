package SocialMedia.demo.service;

import SocialMedia.demo.model.User;

import java.util.List;

public interface UserService {
    public User SaveUser(User user);
    public void delateUser(Long id );
    public List<User> findUserByUsername(String name);
    public List<User>  allUser();
    public String signUpUser(User user);
    public int enableUser(String email);

    User findUserByEmail(String email);

    User findUserByid(Long id);
}
