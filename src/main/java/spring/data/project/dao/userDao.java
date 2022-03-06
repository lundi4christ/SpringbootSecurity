package spring.data.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.data.project.entities.userData;
import spring.data.project.generic.genericService;

@Repository
public interface userDao extends CrudRepository<userData, Long> {

   userData findByFirstname(String firstname);

   userData findById(long id);

   // void updateUser(long userid, userData userdata);
}
