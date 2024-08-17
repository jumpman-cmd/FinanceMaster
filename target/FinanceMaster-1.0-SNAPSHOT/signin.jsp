<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <img src="images/intro-1704559079.jpg" alt="Intro Image">
        <h1>Sign In</h1>
        <form action="user" method="post">
            <input type="hidden" name="action" value="signin">
            <input type="email" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Sign In</button>
        </form>
        <a href="forgotpassword.jsp">Forgot Password?</a>
        <a href="signup.jsp">Don't have an account? Sign Up</a>
    </div>
</body>
</html>
