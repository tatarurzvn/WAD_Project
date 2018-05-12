<%-- 
    Document   : register
    Created on : May 12, 2018, 3:48:20 PM
    Author     : Radu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Emojo - Your Own Emoji Database</title>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <%@ include file="WEB-INF/nav.jspf"%>
    <body>
        <h1>Registration form</h1>   
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
    </body>
</html>
