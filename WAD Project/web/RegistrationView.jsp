<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Emojo - Deceptively Unfunny</title>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>
        <%!
            public void jspInit() {
                System.out.print("Started");
            }

        %>
        <%@ include file="WEB-INF/nav.jspf"%>
        <div class="register">
        <h1>Register</h1>   
            <form method="post"  action="RegistrationController"> 
                <div class="form-element">
                    <label for="fname">First Name</label>
                    <input type="text" name="fname" id="fname" required>
                </div>
                <div class="form-element">
                    <label for="lname">Last Name</label>
                    <input type="text" name="lname" id="lname" required>
                </div>
                <div class="form-element">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-element">
                    <label for="username">Username</label>
                    <input type="text" name="uname" id="uname" required>
                </div>
                <div class="form-element">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" required>
                </div>
                <div class="form-element">
                    <label for="rPassword">Repeat password</label>
                    <input type="password" id="rPassword" required>
                </div>
                
                <div class="form-element">
                    <input type="submit" value="Submit">
                    <input type="reset" value="Reset">
                </div>  
            </form>
        <c:forEach items="${requestScope.RegistrationErrors}" var="error">
            <p>${error}</p>
        </c:forEach>
        </div>
    </body>
</html>
