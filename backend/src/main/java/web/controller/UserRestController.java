package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import web.model.User;
import web.service.UserServiceImp;

import java.util.List;

@RestController("/users")
public class UserRestController {
    @Autowired
    UserServiceImp userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return users;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes="application/json")
    public void addUser(@RequestBody @Validated User user){
        userService.addUser(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT, produces = "application/json")
    public void updateUser(@RequestBody @Validated User user){
        userService.updateUser(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE, consumes="application/json")
    public void deleteUser( @RequestBody String id) {
        userService.deleteUser(userService.findUserByID(Long.parseLong(id)));
    }

    @RequestMapping(value = "/users/autorize", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@RequestBody String email){
        String s = email.replaceAll("\"","");
        User user = userService.findUserByEmail(s);
        return user;
    }
}
