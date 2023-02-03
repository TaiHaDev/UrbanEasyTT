package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;

/**
 * Servlet implementation class UploadHomeSuccess
 */
@WebServlet(name = "congratulation", urlPatterns = { "/congratulation" })
public class UploadHomeSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadHomeSuccess() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
        this.productDAO = new ProductDAO();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("upload-success.jsp");
            dispatcher.forward(request, response);
            
            String success = request.getParameter("success");
            
            //System.out.println("this printed after the get parameter");
            
            HttpSession session = request.getSession();
            String title = (String) session.getAttribute("houseTitle");
    		String description = (String) session.getAttribute("description");
    		String neighborhood = (String) session.getAttribute("neighborhood");
    		
    		String guest = (String) session.getAttribute("guest");
    		String bedroom = (String) session.getAttribute("bedroom");
    		String bed = (String) session.getAttribute("bed");
    		String bathroom = (String) session.getAttribute("bathroom");
    		
    		
    		String district = (String) session.getAttribute("district");
    		String city = (String) session.getAttribute("city");
    		String country = (String) session.getAttribute("country");
    		String streetAddress = (String) session.getAttribute("streetAddress");
    		String longitude = (String) session.getAttribute("longitude");	
    		String latitude = (String) session.getAttribute("latitude");
    		
    		String price = (String) session.getAttribute("price");
    		
    		String category = (String) session.getAttribute("structure");
    		
    		this.productDAO.insertIntoProduct(title, description, neighborhood, guest, bedroom, bed, bathroom, district, city, country, streetAddress, longitude, latitude, price, category);
            
    		System.out.println("Insert database done");
            //PrintWriter writer = response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
