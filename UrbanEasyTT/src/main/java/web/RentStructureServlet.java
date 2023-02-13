package web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dao.CategoryDAO;
import model.Category;

/**
 * Servlet implementation class RentStructureServlet
 */
@WebServlet("/structure")
public class RentStructureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {
		this.categoryDAO = new CategoryDAO();
	}

	public RentStructureServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Category> categories = this.categoryDAO.selectAllCategory();
			request.setAttribute("categories", categories);

			RequestDispatcher dispatcher = request.getRequestDispatcher("structure.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson gson = new Gson();
		System.out.println("i'm here help me");
		var type = new TypeToken<Map<String, String>>() {
		}.getType();
		Map<String, String> myMap = gson.fromJson(request.getReader(), type);

		String category = myMap.get("selectedCategory");

		HttpSession session = request.getSession();
		session.setAttribute("structure", category);
		System.out.println("after json " + category);
	}

}
