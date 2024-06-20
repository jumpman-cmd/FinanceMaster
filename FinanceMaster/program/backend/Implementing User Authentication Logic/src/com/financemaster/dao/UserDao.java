package com.financemaster.dao;

import com.financemaster.model.User;
import java.sql.*;

public class UserDao
{
    private Connection connection;

    public UserDao()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FinanceMaster", "root", "password");
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void registerUser(User user)
    {
        try
        {
            String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public User getUserByUsername(String username)
    {
        try
        {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}