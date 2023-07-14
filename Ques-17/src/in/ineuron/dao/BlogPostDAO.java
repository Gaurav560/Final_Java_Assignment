package in.ineuron.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.ineuron.dto.BlogPost;

public class BlogPostDAO {
    // Database connection details
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql:///oct_batch";
    private static final String USER = "root";
    private static final String PASS = "Lumia@540";

    public void createBlogPost(BlogPost post) {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement statement = conn.prepareStatement("INSERT INTO blog_posts (title, description, content) VALUES (?, ?, ?)");
            statement.setString(1, post.getTitle());
            statement.setString(2, post.getDescription());
            statement.setString(3, post.getContent());
            statement.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<BlogPost> getAllBlogPosts() {
        List<BlogPost> blogPosts = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM blog_posts");
            while (resultSet.next()) {
                BlogPost post = new BlogPost();
                post.setId(resultSet.getInt("id"));
                post.setTitle(resultSet.getString("title"));
                post.setDescription(resultSet.getString("description"));
                post.setContent(resultSet.getString("content"));
                blogPosts.add(post);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blogPosts;
    }
}
