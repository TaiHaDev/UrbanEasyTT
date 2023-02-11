package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class SearchResultServlet
 */
@WebServlet("/result")
public class SearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;
    
    public void init() {
    	this.productDAO = new ProductDAO();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dateStart = request.getParameter("start");
		String dateEnd = request.getParameter("end");
		int guests = Integer.parseInt(request.getParameter("guest"));
		String district = request.getParameter("district");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		List<Product> searchResult = productDAO.searchForProperty(district, city, country, guests, dateStart, dateEnd);
		List<Double> lngList = searchResult.stream().map(prod -> prod.getLng()).toList();
		List<Double> latList = searchResult.stream().map(prod -> prod.getLat()).toList();
		System.out.println(latList);
		request.setAttribute("lat", latList);
		request.setAttribute("lng", lngList);
		request.setAttribute("product", searchResult);
		RequestDispatcher dispatcher = request.getRequestDispatcher("search-result.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
