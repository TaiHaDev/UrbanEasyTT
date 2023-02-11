package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookingDAO;

/**
 * Servlet implementation class SuccessfulPaymentServlet
 */
@WebServlet("/SuccessfulPayment")
public class SuccessfulPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingDAO bookingDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessfulPaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	this.bookingDAO = new BookingDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long propertyId =  Long.parseLong(request.getParameter("propId"));
		long userId = Long.parseLong(request.getParameter("userId"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		bookingDAO.insertCustomerBooking(propertyId, userId, startDate, endDate);
		response.sendRedirect(request.getContextPath() + "/successful-payment.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}