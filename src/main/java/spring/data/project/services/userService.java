package spring.data.project.services;

import spring.data.project.entities.userData;
import spring.data.project.generic.genericService;

public interface userService extends genericService<userData, Long> {

    userData findByFirstname(String firstname);

    userData findById(long id);

    userData createUser(userData userdata);

}
