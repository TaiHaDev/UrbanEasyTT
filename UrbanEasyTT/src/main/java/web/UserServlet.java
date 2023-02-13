package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDAO;
import dao.UserDAO;
import model.Product;
import model.Review;
import model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private ReviewDAO reviewDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		this.userDAO = UserDAO.getInstance();
		this.reviewDAO = ReviewDAO.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			long userId = Long.parseLong(request.getParameter("id"));
			User chosenUser = userDAO.selectUserById(userId);
			request.setAttribute("userInfo", chosenUser);
			List<Product> userOwnedProperty = userDAO.selectPropertyOwnedByUser(userId);
			request.setAttribute("propertyList", userOwnedProperty);
			List<Review> reviewsFromUser = reviewDAO.selectReviewsFromUserToOwner(userId);
			request.setAttribute("reviewList", reviewsFromUser);
			request.setAttribute("totalReviews", reviewsFromUser.size());
			RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
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
		doGet(request, response);
	}

}