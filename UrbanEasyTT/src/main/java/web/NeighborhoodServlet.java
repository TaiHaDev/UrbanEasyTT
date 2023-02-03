package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NeighborhoodServlet
 */
@WebServlet(name = "neighborhood", urlPatterns = { "/neighborhood" })
public class NeighborhoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NeighborhoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
            String neighborhoodSaved = (String) session.getAttribute("neighborhood");
            request.setAttribute("neighborhoodSaved", neighborhoodSaved);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("neighborhood.jsp");
            dispatcher.forward(request, response);
            
            String neighborhood = request.getParameter("neighborhood");
            
            session.setAttribute("neighborhood", neighborhood);
            
            //PrintWriter writer = response.getWriter();
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
		doGet(request,response);
	}

}
