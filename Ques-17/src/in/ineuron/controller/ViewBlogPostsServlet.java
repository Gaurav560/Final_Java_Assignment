package in.ineuron.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dao.BlogPostDAO;
import in.ineuron.dto.BlogPost;

@WebServlet("/view")
public class ViewBlogPostsServlet extends HttpServlet {
	
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		BlogPostDAO blogPostDAO = new BlogPostDAO();
        List<BlogPost> blogPosts = blogPostDAO.getAllBlogPosts();
        System.out.println("in view servlet");
        request.setAttribute("blogPosts", blogPosts);

        request.getRequestDispatcher("view.jsp").forward(request, response);
        System.out.println("in view servlet");
    }
}

