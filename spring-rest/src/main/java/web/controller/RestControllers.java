package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.restClient.RestClient;
import web.service.UserServiceImp;
import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
public class RestControllers {

    @Autowired
    private RestClient restClient;

    @CrossOrigin
    @GetMapping("/api/authenticate")
    public ResponseEntity<User> authenticate(Principal principal) {
        User authorizedUser = restClient.findUserByEmail(principal.getName());
        return ResponseEntity.ok(authorizedUser);
    }

    @CrossOrigin
    @GetMapping("/admin/allusers")
    public ResponseEntity <List<User>> getAllUsers(){
        List<User> users = restClient.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/admin/users/")
    public ResponseEntity <User> getAllUsers(@RequestParam String email){
        User user = restClient.findUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @CrossOrigin
    @PostMapping(value = "/admin/new")
    public void addUser(@RequestBody User user){

        Set<Role> roles = user.getRoles();
        if(user.getIsAdmin()){
            Role role = new Role();
            role.setName("ADMIN");
            roles.add(role);
        }
        if(user.getIsUser()){
            Role role = new Role();
            role.setName("USER");
            roles.add(role);
        }
        user.setRoles(roles);
        restClient.addUser(user);
    }

    @CrossOrigin
    @PutMapping("/admin/updateuser")
    public void updateUser(@RequestBody User user){
        Set<Role> roles = user.getRoles();
        if(user.getIsAdmin()){
            Role role = new Role();
            role.setName("ADMIN");
            roles.add(role);
        }
        if(user.getIsUser()){
            Role role = new Role();
            role.setName("USER");
            roles.add(role);
        }
        user.setRoles(roles);
        restClient.updateUser(user);
    }

    @CrossOrigin
    @DeleteMapping("/admin/deleteuser/{id}")
    public void deleteUser(@PathVariable Long id){
        restClient.deleteUser(id);
    }
}
