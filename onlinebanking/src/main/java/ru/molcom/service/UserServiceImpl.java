package ru.molcom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.molcom.dao.IUserDao;
import ru.molcom.dao.IRoleDao;
import ru.molcom.domain.User;
import ru.molcom.domain.security.UserRole;
import ru.molcom.service.interfaces.IAccountService;
import ru.molcom.service.interfaces.IUserService;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    public IUserDao userDao;

    @Autowired
    private IRoleDao roleDao;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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

    public User createUser(User user, Set<UserRole> userRoles) //throws IllegalArgumentException
        {
        User localUser = userDao.findByUserName(user.getUsername());

        if (localUser != null) {
            //throw new IllegalArgumentException("\"User with username {} already exist. Nothing will be done. \", " + user.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            for (UserRole ur : userRoles) {
                roleDao.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);

            user.setPrimaryAccount(accountService.createPrimaryAccount());
            user.setSavingsAccount(accountService.createSavingsAccount());

            localUser = userDao.save(user);
        }

        return localUser;
    }
}

