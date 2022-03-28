package controllers.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import beans.form_data.RegisterData;
import dao.UserDAO;
import entities.User;
import utils.JpaUtil;

@WebServlet({
	"/users/index",
	"/users/create",
	"/users/store",
	"/users/edit",
	"/users/update",
	"/users/delete",
	"/users/show",
})
public class UserServlet extends HttpServlet {
	private UserDAO userDAO;
	
	public UserServlet() {
		this.userDAO = new UserDAO();
	}

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("create")) {
			this.create(request, response);
		} else if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("show")) {
			this.show(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		} else {
			// 404
		}
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		} else {
			// 404
		}
	}

	protected void index(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		List<User> ds = this.userDAO.all();
		request.setAttribute("ds", ds);
		request.setAttribute("view", 
			"/views/admin/users/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
		.forward(request, response);
	}

	protected void show(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
	}

	protected void create(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.setAttribute("view",
			"/views/admin/users/create.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
		.forward(request, response);
	}

	protected void edit(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException, Exception {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		User entity = this.userDAO.findById(id);
		request.setAttribute("view",
			"/views/admin/users/edit.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
			.forward(request, response);
	}

	protected void delete(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		try {
			String idStr = request.getParameter("id");
			int id = Integer.parseInt(idStr);
			User entity = this.userDAO.findById(id);
			this.userDAO.delete(entity);
			// TODO: Thông báo thành công
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: Thông báo lỗi
		}

		response.sendRedirect("/SP22B2_SOF3011_IT16305"
			+ "/users/index");
	}

	protected void store(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		User entity = new User();
		try {
			BeanUtils.populate(entity,
				request.getParameterMap());
			
			this.userDAO.create(entity);
			
			response.sendRedirect("/SP22B2_SOF3011_IT16305"
				+ "/users/index");
		} catch (Exception e) {
			e.printStackTrace();
			
			// Thông báo lỗi
			response.sendRedirect("/SP22B2_SOF3011_IT16305"
					+ "/users/create");
		}
	}

	protected void update(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
	}
}
