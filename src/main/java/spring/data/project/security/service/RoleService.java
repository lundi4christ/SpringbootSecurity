package spring.data.project.security.service;


import org.springframework.data.jpa.repository.Query;
import spring.data.project.generic.genericService;
import spring.data.project.security.model.Role;

import java.util.Set;


public interface RoleService extends genericService<Role, Integer> {

    @Query(
            value = "SELECT * FROM role WHERE id NOT IN (SELECT role_id from userdata_role where userdata_id = ?1)",
            nativeQuery = true
    )
    Set<Role> getUserNotRoles(Long userId);
}
