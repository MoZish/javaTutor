package fact.it.apiexercise.controller;

import fact.it.apiexercise.model.User;
import fact.it.apiexercise.model.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private UserService userService;

    @PostConstruct
    public void createUserService(){
        userService = new UserService();
    }

    @PostMapping("users/add")
    public List<User> addUsers(@RequestBody List<User> users){
        for (User user : users){
            userService.addUser(user);
        }
        return userService.getUserList();
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getUserList();
    }
}
