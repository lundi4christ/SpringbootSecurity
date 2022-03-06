package spring.data.project.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import spring.data.project.dao.userDao;
import spring.data.project.entities.userData;
import spring.data.project.security.model.Role;
import spring.data.project.security.repository.RoleRepository;

import java.util.Optional;
import java.util.Set;

public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private userDao userdao;


    @Override
    public <S extends Role> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Role> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Role> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Role> findAll() {
        return null;
    }

    @Override
    public Iterable<Role> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Role entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Role> entities) {

    }

    @Override
    public void deleteAll() {

    }

    ////////// Assign Role to User
    public void assignUserRole(Long userId, Integer roleId){

        userData user = userdao.findById(userId).orElse(null);
        Role role = roleRepository.findById(roleId).orElse(null);

        Set<Role> userRoles = user.getRoles();
        userRoles.add(role);
        user.setRoles(userRoles);

        userdao.save(user);
    }

    //////// Unassign Role from User
    public void unassignUserRole(Long userId, Integer roleId){

        userData user = userdao.findById(userId).orElse(null);
        Set<Role> userRoles = user.getRoles();

        userRoles.removeIf(x -> x.getId() == roleId);

        userdao.save(user);
    }

    public Set<Role> getUserRoles(userData user){
        return user.getRoles();
    }

    public Set<Role> getUserNotRoles(Long userId) {
        return roleRepository.getUserNotRoles(userId);
    }

}
