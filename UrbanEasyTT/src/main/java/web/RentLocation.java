package web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * Servlet implementation class RentLocation
 */
@WebServlet(name = "location", urlPatterns = { "/location" })
public class RentLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentLocation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("location.jsp");
            dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		var type = new TypeToken<Map<String, String>>(){}.getType();
		Map<String,String> myMap = gson.fromJson(request.getReader(), type);
		String latitude = myMap.get("latitude");
		String longitude = myMap.get("longitude");
		String streetAddress = myMap.get("streetAddress");
		String district = myMap.get("district");
		String city = myMap.get("city");
		String country = myMap.get("country");
		
		
		HttpSession session = request.getSession();
		
        session.setAttribute("latitude", latitude);
        session.setAttribute("longitude", longitude);
        session.setAttribute("streetAddress", streetAddress);
        session.setAttribute("district", district);
        session.setAttribute("city", city);
        session.setAttribute("country", country);
        
        System.out.println(country);
		System.out.println("after json");
	}

}
