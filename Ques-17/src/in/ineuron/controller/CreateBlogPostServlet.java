package in.ineuron.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dao.BlogPostDAO;
import in.ineuron.dto.BlogPost;


@WebServlet("/create")
public class CreateBlogPostServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String content = request.getParameter("content");

        BlogPost post = new BlogPost();
        post.setTitle(title);
        post.setDescription(description);
        post.setContent(content);

        BlogPostDAO blogPostDAO = new BlogPostDAO();
        blogPostDAO.createBlogPost(post);

        response.sendRedirect("view");
    }
}

