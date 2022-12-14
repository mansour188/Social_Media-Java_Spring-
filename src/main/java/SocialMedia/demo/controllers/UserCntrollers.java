package SocialMedia.demo.controllers;

import SocialMedia.demo.model.User;
import SocialMedia.demo.service.UserService;
import SocialMedia.demo.service.impl.UserServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@RestController
@RequestMapping(path = "/api")
public class UserCntrollers {
    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.allUser();
    }
    @GetMapping("/search/")
    @ResponseBody
    public  List<User> searchUserByname(@RequestParam(value = "ch", required = false) String ch){
        return userService.findUserStartingWith(ch);

    }
    @GetMapping("/getUser/by_id/{id}")
    public User findUserById( @PathVariable Long id ){
        return userService.findUserByid(id);
    }

    @GetMapping("/getUser/by_name/{name}")
    public List<User> getUserByname(@PathVariable String name) {
        return userService.findUserByUsername(name);

    }
    @GetMapping("/getUser/by_email/{email}")
    public  User getUserByEmail(@RequestBody @PathVariable String email){
        return userService.findUserByEmail(email);
    }

    @GetMapping(path = "/friends")
    public List<User> getUserFriends(){
        return userService.getfriendofcurrentUser();
    }

}

