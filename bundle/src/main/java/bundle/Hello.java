package bundle;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Hello extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().print("Hello, World!");
	}
	
}
