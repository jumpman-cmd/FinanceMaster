package com.financemaster;

import com.financemaster.model.User;
import com.financemaster.service.UserService;

public class Main
{
    public static void main(String[] args)
    {
        UserService userService = new UserService();

        // Example: Register a new user
        userService.registerUser("john_doe", "john@example.com", "securepassword");

        // Example: Authenticate user
        boolean isAuthenticated = userService.authenticateUser("john_doe", "securepassword");
        System.out.println("Authentication successful: " + isAuthenticated);
    }
}