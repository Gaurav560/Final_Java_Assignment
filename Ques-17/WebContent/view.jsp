<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Blog Posts</title>
</head>
<body>
    <h1>All Blog Posts:-</h1>
    <ul>
        <c:forEach var="post" items="${blogPosts}">
            <li>
                <h2>${post.title}</h2>
                <p>${post.description}</p>
                <p>${post.content}</p>
            </li>
        </c:forEach>
    </ul>
</body>
</html>


