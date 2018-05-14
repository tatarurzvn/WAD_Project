<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Emojo - Your Own Emoji Database</title>
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
        <div id="content">
            <%@ include file="WEB-INF/nav.jspf"%>
            <h1>Image View</h1>   
            <form method="post"  action="UploadController" enctype="multipart/form-data"> 
                <div class="form-element">
                    <label for="name">Name</label>
                    <input type="text" name="name" id="name" required>
                </div>
                <div class="form-element">
                    <label for="desc">Description</label>
                    <input type="text" name="desc" id="desc" required>
                </div>
                <div class="form-element">
                    <label for="img">Image</label>
                    <input type="file" name="img" id="img" accept="image/*" required>
                </div>
        </div> 
        <div class="form-element">
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </div>
    </body>
</html>
