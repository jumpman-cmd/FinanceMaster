package com.financemaster.servlet;

import com.financemaster.model.Review;
import com.financemaster.util.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/review")
public class ReviewServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        try (Connection connection = DatabaseConnection.getConnection()) 
        {
            String sql = "INSERT INTO reviews (email, message) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, message);
            statement.executeUpdate();
            response.sendRedirect("dashboard.jsp?message=Thank you for your review!");
        } 
        
        catch (SQLException e)
        {
            e.printStackTrace();
            response.sendRedirect("review.jsp?error=Failed to submit review");
        }
    }
}
