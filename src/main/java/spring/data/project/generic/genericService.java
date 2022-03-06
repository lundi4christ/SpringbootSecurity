package spring.data.project.generic;

import org.springframework.data.repository.Repository;
import spring.data.project.entities.userData;

import java.util.Optional;

public interface genericService<T, ID extends Object> {
    <S extends T> S save(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<ID> ids);

    long count();

    void deleteById(ID id);

    void delete(T entity);

    void deleteAllById(Iterable<? extends ID> ids);

    void deleteAll(Iterable<? extends T> entities);

    void deleteAll();

   // void updateUser(long id, userData userdata);
}
