package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceImp;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserServiceImp userService;

    @Autowired
    public UserRestController(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return users;
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/user")
    public User getUser(@RequestParam String email){
        User user = userService.findUserByEmail(email);
        return user;
    }
}
