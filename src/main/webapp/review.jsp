<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Submit Review</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <h1>FinanceMaster</h1>
        <nav>
            <a href="index.jsp">Home</a>
            <a href="signup.jsp">Sign Up</a>
            <a href="signin.jsp">Sign In</a>
            <a href="forgotpassword.jsp">Forgot Password</a>
            <a href="review.jsp">Submit Review</a>
        </nav>
    </header>

    <div class="container">
        <div class="review">
            <h2>Submit Your Review</h2>
            <form action="ReviewServlet" method="post">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>

                <label for="review">Your Review:</label>
                <textarea id="review" name="review" rows="5" required></textarea>

                <input type="submit" value="Submit Review">
            </form>
        </div>
    </div>

    <footer>
        <p>&copy; 2024 FinanceMaster. Contact us at <a href="mailto:codeks7407@gmail.com">codeks7407@gmail.com</a></p>
        <p>Find more about me on <a href="https://www.linkedin.com/in/yanga-mdede-550034291">LinkedIn</a></p>
    </footer>
</body>
</html>
