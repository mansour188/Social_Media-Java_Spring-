package SocialMedia.demo.service;

import SocialMedia.demo.Repo.UserRepo;
import SocialMedia.demo.model.User;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public User SaveUser(User user){
        return userRepo.save(user);
    }

    public void delateUser(Long id ){
        userRepo.deleteById(id);
    }
    @SneakyThrows
    public User findUserByUsername(String username){
        return userRepo
                .findByUsername(username)
                .orElseThrow(()->  new IllegalArgumentException("User Not found "));
    }

    public List<User>  allUser(){
        return userRepo.findAll();
    }
    @SneakyThrows
    public User  findUserByEmail(String email){
        return userRepo
                .findByEmail(email);
    }
    @SneakyThrows
    public User findUserByid(Long id){
        return userRepo
                .findById(id)
                .orElseThrow(()->  new IllegalArgumentException("User Not found ")) ;
    }



}
