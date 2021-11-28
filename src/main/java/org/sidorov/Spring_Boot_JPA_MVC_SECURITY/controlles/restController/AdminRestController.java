package org.sidorov.Spring_Boot_JPA_MVC_SECURITY.controlles.restController;

import org.sidorov.Spring_Boot_JPA_MVC_SECURITY.model.Role;
import org.sidorov.Spring_Boot_JPA_MVC_SECURITY.model.User;
import org.sidorov.Spring_Boot_JPA_MVC_SECURITY.services.role.RoleService;
import org.sidorov.Spring_Boot_JPA_MVC_SECURITY.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping(path = "admin")
public class AdminRestController {

    private UserService userServiceImpl;

    @Autowired
    public AdminRestController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userServiceImpl.readAll();
        return (userList != null)
                ? new ResponseEntity<>(userList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @PostMapping("/user")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        User newUser = userServiceImpl.addUser(user);
        return (newUser != null)
                ? new ResponseEntity<>(newUser, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        System.out.println(user);
        User newUser = userServiceImpl.updateUser(user);
        return (newUser != null)
                ? new ResponseEntity<>(newUser, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/user")
    public ResponseEntity<Long> deleteUser(@RequestBody long id) {
        try {
            System.out.println(id);
            userServiceImpl.deleteUser(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
