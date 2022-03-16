package controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * service/doGet/doPost 
	 * @WebServlet/multi-threading/life-cycle
	 */
    public HelloServlet() {
        super();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		Date now = new Date();
		
		System.out.println(request.getContextPath());
		String name = request.getParameter("ho_ten");
		request.setAttribute("name", name);
		
		request.setAttribute("view", "/views/welcome.jsp");
		request.setAttribute("now", now);
		request.getRequestDispatcher("/views/layout.jsp")
		.forward(request, response);
	}
	
	public void init() {
		System.out.println("Init");
	}
	
	public void service(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		System.out.println("Service ...");
		super.service(request, response);
	}
	
	public void destroy() {
		System.out.println("Destroy ... ");
	}
}
