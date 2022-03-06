package spring.data.project.security.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.data.project.security.model.Role;

import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    @Query(
            value = "SELECT * FROM role WHERE id NOT IN (SELECT role_id from userdata_role where userdata_id = ?1)",
            nativeQuery = true
    )
    Set<Role> getUserNotRoles(Long userId);
}
