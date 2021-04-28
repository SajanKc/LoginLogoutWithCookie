package com.kcsajan;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.equals("sajan") && password.equals("1234")) {
			request.getRequestDispatcher("link.html").include(request, response);
			out.println("<br>Login successful !!!");
			out.println("<br /> Welcome " + username);
			Cookie ck = new Cookie("username", username);
			response.addCookie(ck);
		} else {
			request.getRequestDispatcher("link.html").include(request, response);
			out.println("<br>Sorry, Username and Password Does Not Matched !!!<br>");
//			response.sendRedirect("index.html");
		}
		out.close();
	}
}
