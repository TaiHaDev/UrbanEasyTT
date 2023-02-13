package web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dao.ReviewDAO;

/**
 * Servlet implementation class SubmitReviewServlet
 */
@WebServlet("/submitReview")
public class SubmitReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewDAO reviewDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitReviewServlet() {
		super();
	}

	public void init() {
		reviewDAO = new ReviewDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson gson = new Gson();
		var type = new TypeToken<Map<String, String>>() {
		}.getType();
		Map<String, String> myMap = gson.fromJson(request.getReader(), type);
		response.setContentType("application/json");
		long bookingId = Long.parseLong(myMap.get("bookingId"));
		long propertyId = Long.parseLong(myMap.get("propertyId"));
		long userId = Long.parseLong(myMap.get("userId"));
		double checkInRating = Double.parseDouble(myMap.get("checkInRating"));
		double cleanlinessRating = Double.parseDouble(myMap.get("cleanlinessRating"));
		double communicationRating = Double.parseDouble(myMap.get("communicationRating"));
		double accuracyRating = Double.parseDouble(myMap.get("accuracyRating"));
		double locationRating = Double.parseDouble(myMap.get("locationRating"));
		double valueRating = Double.parseDouble(myMap.get("valueRating"));
		String comment = myMap.get("commentContent");
		reviewDAO.insertNewReviewFromUser(bookingId, propertyId, userId, checkInRating, cleanlinessRating,
				communicationRating, accuracyRating, locationRating, valueRating, comment);
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentLength(0);

	}

}