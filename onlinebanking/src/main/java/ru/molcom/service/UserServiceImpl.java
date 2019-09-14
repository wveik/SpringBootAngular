package ru.molcom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.molcom.dao.IUserDao;
import ru.molcom.domain.User;
import ru.molcom.service.interfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    public IUserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public boolean checkUserExists(String userName, String email) {
        if (checkUsernameExists(userName) || checkEmailExists(userName)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUsernameExists(String userName) {
        if (null != findByUserName(userName)) {
            return true;
        }

        return false;
    }

    public boolean checkEmailExists(String email) {
        if (null != findByEmail(email)) {
            return true;
        }

        return false;
    }

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public List<User> findUserList() {
        return userDao.findAll();
    }

    public void enableUser(String userName) {
        User user = findByUserName(userName);
        user.setEnabled(true);
        userDao.save(user);
    }

    public void disableUser(String userName) {
        User user = findByUserName(userName);
        user.setEnabled(false);
        System.out.println(user.isEnabled());
        userDao.save(user);
        System.out.println(userName + " is disabled.");
    }
}

