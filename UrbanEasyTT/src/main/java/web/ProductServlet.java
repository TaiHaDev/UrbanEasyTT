//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package web;

import dao.ProductDAO;
import dao.ReviewDAO;
import dao.UserDAO;

import java.io.IOException;
import java.util.List;
import util.ReviewerUltilities;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.Review;
import model.User;


@WebServlet({"/product-detail"})
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;
    private UserDAO userDAO;
    private ReviewDAO reviewDAO;

    public ProductServlet() {
    	
    }

    public void init() {
        this.productDAO = new ProductDAO();
        this.userDAO = new UserDAO();
        this.reviewDAO = new ReviewDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
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
        	double averageReview = Math.round(averageRatings.stream().mapToDouble(e -> e).average().orElse(0) * 100) / 100.0;
        	request.setAttribute("reviewsList", reviewsList);
        	request.setAttribute("averageRatings", averageRatings);
        	request.setAttribute("ratingsPercentage", ratingsPercentage);
        	request.setAttribute("averageReview", averageReview);
        	System.out.println(reviewsList.size());
        	String[] urlArray = productDAO.selectAssets(id);
        	request.setAttribute("assets", urlArray);
            RequestDispatcher dispatcher = request.getRequestDispatcher("product-detail.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}