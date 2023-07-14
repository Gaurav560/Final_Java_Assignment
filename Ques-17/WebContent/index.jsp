<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Blog Posts</title>
</head>
<body>
    <h1>myBlog.com</h1>
    <ul>
        <c:forEach var="post" items="${blogPosts}">
            <li>
                <h2>${post.title}</h2>
                <p>${post.description}</p>
                <p>${post.content}</p>
            </li>
        </c:forEach>
    </ul>

    <hr>

    <h2>Create a New Blog Post</h2>
    <form action="create" method="post">
        <label for="title">Title:</label><br>
        <input type="text" id="title" name="title" required><br><br>
        <label for="description">Description:</label><br>
        <input type="text" id="description" name="description" required><br><br>
        <label for="content">Content:</label><br>
        <textarea id="content" name="content" rows="5" required></textarea><br><br>
        <input type="submit" value="Create">
    </form>
    
    <hr>
     <form action="view">
        <input type="submit" value="View All Blog Posts">
    </form>
</body>
</html>
