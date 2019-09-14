package ru.molcom.dao;

import org.springframework.data.repository.CrudRepository;
import ru.molcom.domain.User;

import java.util.List;

public interface IUserDao extends CrudRepository<User, Long> {
    User findByUserName(String userName);

    User findByEmail(String email);

    List<User> findAll();
}
