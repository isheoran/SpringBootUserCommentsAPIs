package com.SpringJDBC.SpringJDBC.Service;

import com.SpringJDBC.SpringJDBC.Dao.UserDao;
import com.SpringJDBC.SpringJDBC.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {}

    @Override
    public boolean registerUser(User user) {
        userDao.createTable();
        user = new User(user.getName(),user.getEmail(),user.getPassword());
        if(userDao.insertUser(user) > 0) return true;
        return false;
    }

    @Override
    public String logIn(User user) {
        return userDao.findUser(user);
    }

    @Override
    public boolean deleteAccount(User user) {
        return userDao.deleteUser(user);
    }

    @Override
    public boolean updatePassword(User user) {
        return userDao.updatePassword(user);
    }
}
