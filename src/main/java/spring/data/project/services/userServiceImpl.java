package spring.data.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.data.project.dao.userDao;
import spring.data.project.entities.userData;

import java.util.Optional;

@Service
public class userServiceImpl implements userService {

    @Autowired
    public userDao userdao;


    public <S extends userData> S save(S entity) {

        return userdao.save(entity);
    }

    public <S extends userData> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    public Optional<userData> findById(Long aLong) {

        return userdao.findById(aLong);
    }


    public boolean existsById(Long aLong) {
        return false;
    }

    public Iterable<userData> findAll() {
        return userdao.findAll();
    }

    public Iterable<userData> findAllById(Iterable<Long> longs) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void deleteById(Long aLong) {
        userdao.deleteById(aLong);
    }

    public void delete(userData entity) {
        userdao.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    public void deleteAll(Iterable<? extends userData> entities) {

    }

    public void deleteAll() {

    }

    public void updateUser(long userid, userData userdata) {
         userdao.save(userdata);
    }

    @Override
    public userData findByFirstname(String firstname) {
        return userdao.findByFirstname(firstname);
    }

    @Override
    public userData findById(long id) {
        return userdao.findById(id);
    }

    @Override
    public userData createUser(userData userdata) {
        return null;
    }
}
