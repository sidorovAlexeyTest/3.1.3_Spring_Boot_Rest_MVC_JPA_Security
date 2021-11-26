package org.sidorov.Spring_Boot_JPA_MVC_SECURITY.controlles.restController;

import org.sidorov.Spring_Boot_JPA_MVC_SECURITY.model.User;
import org.sidorov.Spring_Boot_JPA_MVC_SECURITY.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private UserService userServiceImpl;

    @Autowired
    public UserRestController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/current_user")
    public @ResponseBody User getCurrentUser(Principal principal) {
        String userName = principal.getName();
        return userServiceImpl.readUserByUsername(userName);
    }


}
