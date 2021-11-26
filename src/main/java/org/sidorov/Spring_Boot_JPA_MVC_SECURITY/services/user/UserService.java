package org.sidorov.Spring_Boot_JPA_MVC_SECURITY.services.user;

import org.sidorov.Spring_Boot_JPA_MVC_SECURITY.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User addUser(User user);
    User readUserByUsername(String email);
    List<User> readAll();
    User updateUser(User user);
    void deleteUser(long id);
}
