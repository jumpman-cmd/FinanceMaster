package com.financemaster.service;

import com.financemaster.dao.UserDao;
import com.financemaster.model.User;

public class UserService
{
    private UserDao userDao;

    public UserService()
    {
        this.userDao = new UserDao();
    }

    public void registerUser(String username, String email, String password)
    {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);  // Encrypt the password before saving (recommended)
        userDao.registerUser(user);
    }

    public boolean authenticateUser(String username, String password)
    {
        User user = userDao.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password))
        {  // Here weCompare encrypted passwords (I think its recommended)
            return true;
        }
        return false;
    }
}