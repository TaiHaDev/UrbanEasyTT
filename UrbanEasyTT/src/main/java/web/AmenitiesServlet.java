package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dao.FacilityDAO;
import model.Facility;
/**
 * Servlet implementation class AmenitiesServlet
 */
@WebServlet("/amenities")
public class AmenitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FacilityDAO facilityDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
        this.facilityDAO = new FacilityDAO();
    }
    public AmenitiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Facility> facilities = this.facilityDAO.selectAllFacility();
			request.setAttribute("facilities", facilities);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("amenities.jsp");
            dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		System.out.println("i'm here help me");
		var type = new TypeToken<ArrayList<String>>(){}.getType();
		ArrayList<String> myMap = gson.fromJson(request.getReader(), type);
		
		
		HttpSession session = request.getSession();
        session.setAttribute("amenities", myMap);
		for(String amen: myMap) {
			System.out.println(amen);
		}
	}

}
