package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookingDAO;
import model.Booking;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/bookings")
public class BookingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookingDAO bookingDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingsServlet() {
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
		long userId = (Long) request.getSession().getAttribute("userId");
		List<Booking> bookings = bookingDAO.getBookingInfo(userId);
		System.out.println(userId);
		request.setAttribute("bookings", bookings);
		RequestDispatcher dispatcher = request.getRequestDispatcher("booked-rooms.jsp");
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
