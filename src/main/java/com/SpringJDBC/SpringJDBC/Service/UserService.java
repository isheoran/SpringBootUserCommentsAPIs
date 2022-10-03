package com.SpringJDBC.SpringJDBC.Service;

import com.SpringJDBC.SpringJDBC.Entities.User;

public interface UserService {
    public boolean registerUser(User user);
    public String logIn(User user);
    public boolean deleteAccount(User user);
    public boolean updatePassword(User user);
}
