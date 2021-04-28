package com.kcsajan;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Cookie ck[] = request.getCookies();
		if (ck != null) {
			String name = ck[0].getValue();
			if (name.equals("sajan") || name != null) {
				request.getRequestDispatcher("link.html").include(request, response);
				out.println("<br>Welcome to Profile<br>");
				out.println("Welcome " + ck[0].getValue());
			}

		} else {
			out.println("Please Login to access Profile");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}
}
