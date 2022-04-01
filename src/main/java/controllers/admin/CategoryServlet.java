package controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entities.Category;
import entities.User;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
       
    public CategoryServlet() {
        super();
        this.userDAO = new UserDAO();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		List<User> ds = this.userDAO.all();
		request.setAttribute("dsUser", ds);
		request.getRequestDispatcher(
			"/views/admin/categories/create.jsp"
		).forward(request, response);
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		// TODO: check form
		try {
			String ten = request.getParameter("ten");
			Category cate = new Category();
			cate.setTen(ten);
			
			int id = Integer.parseInt(
				request.getParameter("user_id")
			);
			User user = this.userDAO.findById(id);
			cate.setUser(user);
			
			// TODO: this.categoryDAO.create(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
