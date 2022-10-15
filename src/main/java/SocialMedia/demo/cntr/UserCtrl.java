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
@RequestMapping(path = "/api")
public class UserCtrl {
    @Autowired
    UserService userService;
    @Autowired
    RegistrationService regestrationService;
    @PostMapping("/registration")
    public String saveUser(@RequestBody RegestrationUser request){
        return regestrationService.registre(request);

    }
    @GetMapping("/get")
    public List<User> getUsers(){
        return userService.allUser();
    }
    @GetMapping("/get/{id}")
    public User findUserById(@RequestBody @PathVariable Long id ){
        return userService.findUserByid(id);
    }
}
