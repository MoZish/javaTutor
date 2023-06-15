package fact.it.demorest.controller;

import fact.it.demorest.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    List<User> userList = new ArrayList<>();

    @GetMapping("/getUsers")
    public List<User> getAllUsers() {
        return userList;
    }

    @PostMapping("/addusers")
    public String addUsers(@RequestBody List<User> users) {

        boolean success = userList.addAll(users);

        if(success) {
            return "Successfully added";
        }
        return "Add failed";
    }

}
