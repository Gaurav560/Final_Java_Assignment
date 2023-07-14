package in.ineuron.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reader")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		
		String name = request.getParameter("name");

		// Set the name attribute in the request
		request.setAttribute("name", name);

		// Forward the request to the welcome.jsp page
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
		
	}
}
