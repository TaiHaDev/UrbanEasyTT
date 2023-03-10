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
 * Servlet implementation class NeighborhoodServlet
 */
@WebServlet(name = "neighborhood", urlPatterns = { "/neighborhood" })
public class NeighborhoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NeighborhoodServlet() {
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
			String neighborhoodSaved = (String) session.getAttribute("neighborhood");
			request.setAttribute("neighborhoodSaved", neighborhoodSaved);

			RequestDispatcher dispatcher = request.getRequestDispatcher("neighborhood.jsp");
			dispatcher.forward(request, response);

			// PrintWriter writer = response.getWriter();
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
			String neighborhood = request.getParameter("neighborhood");
			if (neighborhood != "") {
				HttpSession session = request.getSession();
				session.setAttribute("neighborhood", neighborhood);
				response.sendRedirect("step3.jsp");
			} else {
				doGet(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
