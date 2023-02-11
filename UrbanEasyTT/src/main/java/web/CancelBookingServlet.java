package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookingDAO;

/**
 * Servlet implementation class CancelBookingServlet
 */
@WebServlet("/CancelBooking")
public class CancelBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingDAO bookingDAO;
    
	public void init() {
		this.bookingDAO = new BookingDAO();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long bookingId = Long.parseLong(request.getParameter("id"));
		if (request.getSession().getAttribute("userId") != null) {
			bookingDAO.cancelBooking(bookingId);
			// then refund...?
		}
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentLength(0);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}