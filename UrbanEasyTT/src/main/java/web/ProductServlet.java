//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package web;

import dao.BookingDAO;
import dao.ProductDAO;
import dao.ReviewDAO;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import util.ReviewerUltilities;
import util.Ultilities;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.Review;
import model.User;

@WebServlet({ "/product-detail" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	private BookingDAO bookingDAO;
	private ReviewDAO reviewDAO;

	public ProductServlet() {

	}

	public void init() {
		this.productDAO = new ProductDAO();
		this.reviewDAO = new ReviewDAO();
		this.bookingDAO = new BookingDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			long id = Long.parseLong(request.getParameter("id"));
			Product product = productDAO.selectProduct(id);
			User owner = reviewDAO.countOwnerReviewById(product.getUserId());
			System.out.println(owner);
			request.setAttribute("product", product);
			request.setAttribute("owner", owner);
			List<Review> reviewsList = reviewDAO.selectReviewsOfPropertyById(id);
			List<Double> averageRatings = ReviewerUltilities.averageRating(reviewsList);
			List<Integer> ratingsPercentage = ReviewerUltilities.aggregateToPercent(averageRatings);
			double averageReview = Math.round(averageRatings.stream().mapToDouble(e -> e).average().orElse(0) * 100)
					/ 100.0;
			request.setAttribute("reviewsList", reviewsList);
			request.setAttribute("averageRatings", averageRatings);
			request.setAttribute("ratingsPercentage", ratingsPercentage);
			request.setAttribute("averageReview", averageReview);
			String[] urlArray = productDAO.selectAssets(id);
			request.setAttribute("assets", urlArray);
			List<Date> bookedDates = bookingDAO.selectBookingDates(id);
			List<String> reformatDates = Ultilities.reformatDates(bookedDates);
			request.setAttribute("bookedDates", reformatDates);
			RequestDispatcher dispatcher = request.getRequestDispatcher("product-detail.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}