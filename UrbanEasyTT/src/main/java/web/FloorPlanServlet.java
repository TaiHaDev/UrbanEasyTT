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
 * Servlet implementation class FloorPlanServlet
 */
@WebServlet("/floor-plan")
public class FloorPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FloorPlanServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("floor-plan.jsp");
            dispatcher.forward(request, response);
		} catch (Exception e) {
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
		String guest = myMap.get("guest");
		String bedroom = myMap.get("bedroom");
		String bed = myMap.get("bed");
		String bathroom = myMap.get("bathroom");
		
		HttpSession session = request.getSession();
		
        session.setAttribute("guest", guest);
        session.setAttribute("bedroom", bedroom);
        session.setAttribute("bed", bed);
        session.setAttribute("bathroom", bathroom);
        
		System.out.println("after json bed: "+bed);
	}

}
