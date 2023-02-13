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
 * Servlet implementation class LocationConfirmServlet
 */
@WebServlet(name = "location-confirm", urlPatterns = { "/location-confirm" })
public class LocationConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LocationConfirmServlet() {
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
			String streetNumber = (String) session.getAttribute("streetNumber");
			String route = (String) session.getAttribute("route");
			String district = (String) session.getAttribute("district");
			String city = (String) session.getAttribute("city");
			String country = (String) session.getAttribute("country");

			request.setAttribute("streetNumber", streetNumber);
			request.setAttribute("route", route);
			request.setAttribute("district", district);
			request.setAttribute("city", city);
			request.setAttribute("country", country);

			if (country != null && city != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("location-confirm.jsp");
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("location-confirm");
			}

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
			String streetNumberReal = request.getParameter("streetNumber");
			String routeReal = request.getParameter("route");
			String districtReal = request.getParameter("district");

			HttpSession session = request.getSession();
			session.setAttribute("streetNumber", streetNumberReal);
			session.setAttribute("route", routeReal);
			session.setAttribute("district", districtReal);

			System.out.println(streetNumberReal + ", " + routeReal + ", " + districtReal);

			response.sendRedirect("floor-plan");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
