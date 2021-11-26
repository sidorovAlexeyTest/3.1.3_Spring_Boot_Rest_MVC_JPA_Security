package org.sidorov.Spring_Boot_JPA_MVC_SECURITY.services.role;

import org.sidorov.Spring_Boot_JPA_MVC_SECURITY.model.Role;

import java.util.List;

public interface RoleService {
    Role readRoleByRole(String role);
    void addRole(Role role);
    List<Role> readRoles();
}
