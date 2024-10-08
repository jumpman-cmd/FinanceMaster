package com.financemaster.servlet;

import com.financemaster.model.User;
import com.financemaster.util.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/user")
public class UserServlet extends HttpServlet
 {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("signup".equals(action)) 
        {
            signup(request, response);
        } 
        
        else if ("signin".equals(action))
        {
            signin(request, response);
        } 
        
        else if ("forgotPassword".equals(action)) 
        {
            forgotPassword(request, response);
        }
}

    private void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection connection = DatabaseConnection.getConnection()) 
        {
            String sql = "INSERT INTO users (name, surname, phoneNumber, email, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, phoneNumber);
            statement.setString(4, email);
            statement.setString(5, password);
            statement.executeUpdate();
            response.sendRedirect("signin.jsp");
        } 
        
        catch (SQLException e) 
        {
            e.printStackTrace();
            response.sendRedirect("signup.jsp?error=Failed to sign up");
        }
    }

    private void signin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection connection = DatabaseConnection.getConnection()) 
        {
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next())
             {
                response.sendRedirect("dashboard.jsp");
            } 
            
            else 
            {
                response.sendRedirect("signin.jsp?error=Invalid credentials");
            }
        } 
        
        catch (SQLException e)
        {
            e.printStackTrace();
            response.sendRedirect("signin.jsp?error=Failed to sign in");
        }
    }

    private void forgotPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String email = request.getParameter("email");

        try (Connection connection = DatabaseConnection.getConnection()) 
        {
            String sql = "SELECT password FROM users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) 
            {
                String password = resultSet.getString("password");
                response.sendRedirect("forgotpassword.jsp?message=Your password is: " + password);
            }
            
            else
            {
                response.sendRedirect("forgotpassword.jsp?error=Email not found");
            }
        } 
        
        catch (SQLException e)
        {
            e.printStackTrace();
            response.sendRedirect("forgotpassword.jsp?error=Failed to retrieve password");
        }
    }
}
