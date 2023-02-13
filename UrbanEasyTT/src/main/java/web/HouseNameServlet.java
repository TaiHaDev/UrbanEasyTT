package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HouseNameServlet
 */
@WebServlet(name = "title", urlPatterns = { "/title" })
public class HouseNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HouseNameServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String title = (String) session.getAttribute("houseTitle");
			request.setAttribute("title", title);

			RequestDispatcher dispatcher = request.getRequestDispatcher("name-your-house.jsp");
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
		try {
			String houseTitle = request.getParameter("name");
			System.out.println("title: " + houseTitle);
			if (houseTitle != "") {
				HttpSession session = request.getSession();
				session.setAttribute("houseTitle", houseTitle);
				response.sendRedirect("description");
			} else {
				doGet(request, response);
			}
		} catch (Exception e) {
		}

	}

}
