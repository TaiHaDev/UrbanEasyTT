package web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.FacilityDAO;
import dao.ProductDAO;

/**
 * Servlet implementation class UploadHomeSuccess
 */
@WebServlet(name = "congratulation", urlPatterns = { "/congratulation" })
public class UploadHomeSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	private FacilityDAO facilityDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadHomeSuccess() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		this.productDAO = new ProductDAO();
		this.facilityDAO = new FacilityDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();

			String category = (String) session.getAttribute("structure");
			if (category == null) {
				response.sendRedirect("structure");
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

			String guest = (String) session.getAttribute("guest");
			String bedroom = (String) session.getAttribute("bedroom");
			String bed = (String) session.getAttribute("bed");
			String bathroom = (String) session.getAttribute("bathroom");

			if (guest == null || bedroom == null || bed == null || bathroom == null) {
				response.sendRedirect("floor-plan");
			}

			ArrayList<String> amenities = (ArrayList<String>) session.getAttribute("amenities");
			if (amenities.isEmpty()) {
				response.sendRedirect("amenities");
			}

			ArrayList<Part> images = (ArrayList<Part>) session.getAttribute("images");
			if (images.isEmpty()) {
				response.sendRedirect("image-upload");
			}

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

			// String userId = (String) session.getAttribute("userId");

			String price = (String) session.getAttribute("price");
			if (price == null) {
				response.sendRedirect("price");
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("upload-success.jsp");
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
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();

			String category = (String) session.getAttribute("structure");

			String district = (String) session.getAttribute("district");
			String city = (String) session.getAttribute("city");
			String country = (String) session.getAttribute("country");
			String streetNumber = (String) session.getAttribute("streetNumber");
			String route = (String) session.getAttribute("route");
			String streetAddress = streetNumber + " " + route;
			String longitude = (String) session.getAttribute("longitude");
			String latitude = (String) session.getAttribute("latitude");

			String guest = (String) session.getAttribute("guest");
			String bedroom = (String) session.getAttribute("bedroom");
			String bed = (String) session.getAttribute("bed");
			String bathroom = (String) session.getAttribute("bathroom");

			ArrayList<String> amenities = (ArrayList<String>) session.getAttribute("amenities");

			String title = (String) session.getAttribute("houseTitle");
			String description = (String) session.getAttribute("description");
			String neighborhood = (String) session.getAttribute("neighborhood");

			// String userId = (String) session.getAttribute("userId");

			String price = (String) session.getAttribute("price");

			String idInserted = this.productDAO.insertIntoProduct(title, description, neighborhood, guest, bedroom, bed,
					bathroom, district, city, country, streetAddress, longitude, latitude, price, category);

			this.facilityDAO.insertIntoFacilityDetail(amenities, idInserted);

			// upload images to web server
			String appPath = request.getServletContext().getRealPath("");
			String savePath = appPath + "image_asset" + File.separator + idInserted; // path location of house
			ArrayList<Part> images = (ArrayList<Part>) session.getAttribute("images");
			ArrayList<String> urls = new ArrayList<>();
			String url = "-";

			File folderUpload = new File(savePath);
			if (!folderUpload.exists()) {
				folderUpload.mkdirs();
			}
			System.out.println("Path: " + savePath + File.separator + extractFileName(images.get(0)));

			for (Part part : images) {
				String fileName = extractFileName(part);
				fileName = new File(fileName).getName();
				System.out.println("fileName: " + fileName);
				url = savePath + File.separator + fileName;
				part.write(url);
				urls.add(url);

			}

			response.sendRedirect("home");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
