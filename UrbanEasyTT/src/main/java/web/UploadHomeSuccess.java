package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;

/**
 * Servlet implementation class UploadHomeSuccess
 */
@WebServlet(name = "congratulation", urlPatterns = { "/congratulation" })
public class UploadHomeSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadHomeSuccess() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		this.productDAO = new ProductDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("upload-success.jsp");
			dispatcher.forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			HttpSession session = request.getSession();
			String title = (String) session.getAttribute("houseTitle");
			if (title == null) {
				response.sendRedirect("title");
			}
			String description = (String) session.getAttribute("description");
			if (description == null) {
				response.sendRedirect("description");
			}
			String neighborhood = (String) session.getAttribute("neighborhood");
			if (neighborhood == null) {
				response.sendRedirect("neighborhood");
			}

			String guest = (String) session.getAttribute("guest");
			String bedroom = (String) session.getAttribute("bedroom");
			String bed = (String) session.getAttribute("bed");
			String bathroom = (String) session.getAttribute("bathroom");

			if (guest == null || bedroom == null || bed == null || bathroom == null) {
				response.sendRedirect("floor-plan");
			}

			String district = (String) session.getAttribute("district");
			String city = (String) session.getAttribute("city");
			String country = (String) session.getAttribute("country");
			String streetNumber = (String) session.getAttribute("streetNumber");
			String route = (String) session.getAttribute("route");
			String streetAddress = streetNumber + " " + route;
			String longitude = (String) session.getAttribute("longitude");
			String latitude = (String) session.getAttribute("latitude");

			if (city == null || country == null || streetNumber == null || route == null || longitude == null
					|| latitude == null) {
				response.sendRedirect("location");
			}

			// String userId = (String) session.getAttribute("userId");

			String price = (String) session.getAttribute("price");
			if (price == null) {
				response.sendRedirect("price");
			}

			String category = (String) session.getAttribute("structure");
			if (category == null) {
				response.sendRedirect("category");
			}

			this.productDAO.insertIntoProduct(title, description, neighborhood, guest, bedroom, bed, bathroom, district,
					city, country, streetAddress, longitude, latitude, price, category);

			System.out.println("Insert database done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
