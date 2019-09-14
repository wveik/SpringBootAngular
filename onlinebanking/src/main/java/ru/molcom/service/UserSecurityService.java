package ru.molcom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.molcom.dao.IUserDao;
import ru.molcom.domain.User;


@Service
public class UserSecurityService implements UserDetailsService {

    /** The application logger */

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUserName(username);

        if (null == user) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }

        return user;
    }
}
