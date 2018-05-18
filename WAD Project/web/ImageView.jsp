<%@page import="DAO.ImageDAO"%>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.List"%>
<%@ page import="java.io.InputStream"%>
<%@ page import="java.io.OutputStream"%>
<%@ page trimDirectiveWhitespaces="true" %>
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
            <h1>${requestScope.name}</h1> 
            <div class="image">
                <img src="${request.contextPath}${requestScope.imageRequest}">
            </div>
            <div class="comment">
                <form method="post"  action="CommentController?id=${requestScope.id}&name=${requestScope.name}&imageRequest=${requestScope.imageRequest}"> 
                    <div class="form-element">
                        <label for="comment">Post a comment!</label>
                        <input type="text" name="comment" id="comment" required>
                    </div>
                    <div class="form-element">
                        <input type="submit" value="Submit">
                        <input type="reset" value="Reset">
                    </div>
            </div>
            <div class="commentList">
                <c:forEach items="${requestScope.comments}" var="comment">
                    <p> - ${comment.getUser()}: ${comment.getContent()}</p>
                    <p></p>
                </c:forEach>
            </div>
        </div> 

    </body>
</html>
