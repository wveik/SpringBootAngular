package ru.molcom.service.interfaces;

import ru.molcom.domain.User;

import java.util.List;

public interface IUserService {
    void save(User user);

    User findByUserName(String username);

    User findByEmail(String email);

    boolean checkUserExists(String userName, String email);

    boolean checkUsernameExists(String userName);

    boolean checkEmailExists(String email);

    User saveUser(User user);

    List<User> findUserList();

    void enableUser(String userName);

    void disableUser(String userName);
}
