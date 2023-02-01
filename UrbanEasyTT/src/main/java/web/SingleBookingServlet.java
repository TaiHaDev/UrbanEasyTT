package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookingDAO;
import model.Booking;

/**
 * Servlet implementation class SingeBookingServlet
 */
@WebServlet("/booking")
public class SingleBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookingDAO bookingDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	bookingDAO = new BookingDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long bookingId = Long.parseLong(request.getParameter("id"));
		Booking bookingDetail  = bookingDAO.getBookingDetails(bookingId);
		request.setAttribute("booking", bookingDetail);
		request.setAttribute("id", bookingId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("booking-detail.jsp");
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
