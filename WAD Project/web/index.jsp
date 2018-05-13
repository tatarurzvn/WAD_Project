<%@ page pageEncoding="UTF-8" %>
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
        <%@ include file="WEB-INF/nav.jspf"%>
        <div>
            <h1>Emojo</h1>
            <h2>Hello, ${sessionScope.user_session}!</h2>
            <table>
                <tr>
                    <c:forEach var="image" items="${applicationScope.images}" varStatus="i"> <%--${i.index}--%>
                        <c:if test="${i.count%3==0}">
                        </tr><tr>
                        </c:if>
                        <td>${image.key}, ${image.value}</td>

                    </c:forEach>
                </tr>
            </table>
        </div>
    </body>
</html>
