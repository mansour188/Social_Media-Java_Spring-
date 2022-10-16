package SocialMedia.demo.cntr;

import SocialMedia.demo.model.User;
import SocialMedia.demo.service.RegistrationService;
import SocialMedia.demo.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@RestController
@RequestMapping(path = "/apiu")
public class UserCtrl {
    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.allUser();
    }
    @GetMapping("/getUser/{id}")
    public User findUserById(@RequestBody @PathVariable Long id ){
        return userService.findUserByid(id);
    }

    @GetMapping("/getUser/{name}")
    public List<User> getUserByname(@RequestBody @PathVariable String name) {
        return userService.findUserByUsername(name);

    }
    @GetMapping("/getUser/{email}")
    public  User getUserByEmail(@RequestBody @PathVariable String email){
        return userService.findUserByEmail(email);
    }
}

