package SocialMedia.demo.service.impl;

import SocialMedia.demo.Repo.TokenRepo;
import SocialMedia.demo.Repo.UserRepo;
import SocialMedia.demo.model.Token;
import SocialMedia.demo.model.UseerRole;
import SocialMedia.demo.model.User;
import SocialMedia.demo.service.UserService;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
   private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private TokenRepo tokenRepo;

    public User SaveUser(User user){
        return userRepo.save(user);
    }

    public void deleteUser(Long id ){
        userRepo.deleteById(id);
    }
    @SneakyThrows
    public List<User> findUserByUsername(String name){
        return userRepo
                .findByName(name);

    }

    public List<User>  allUser(){
        return userRepo.findAll();
    }
    @SneakyThrows
    public User  findUserByEmail(String email){
        return userRepo
                .findByEmail(email).orElseThrow(()->new IllegalArgumentException("user with email "+email+"not exist"));
    }
    public  List<User>  findUserStartingWith(String ch){
        return userRepo.findUserStartWith(ch);

    }
    public User findUserByid(Long id) throws IllegalArgumentException{
        return userRepo
                .findById(id)
                .orElseThrow(()->  new IllegalArgumentException("User Not found ")) ;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user= userRepo.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("user Not found "));
        return user;

    }
    @Transactional
    public String signUpUser(User user){
      Boolean userExist= userRepo.findByEmail(user.getEmail()).isPresent();
       if (userExist){
           throw new IllegalStateException("email déjà exist");
       }

      String encodePassword= bCryptPasswordEncoder.encode(user.getPassword());

       user.setPassword(encodePassword);
       user.setUserRole(UseerRole.USER);
       user.setEnabled(false);


        userRepo.save(user);
        String token= UUID.randomUUID().toString();
        tokenRepo.save(new Token(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        ));


        return  token;
    }
    public int enableUser(String email) {
        return userRepo.enableUser(email);
    }


    @Transactional(readOnly = true)
    public User getCurrentUser() {
        UserDetails principal = (UserDetails) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return userRepo.findByEmail(principal.getUsername()).orElseThrow(()-> new ExpressionException("not found"));
    }

    @Override
    public List<User> getfriendofcurrentUser() {
        User user=getCurrentUser();
        List<User> friends=user.getFriends();

        return friends;
    }


}
