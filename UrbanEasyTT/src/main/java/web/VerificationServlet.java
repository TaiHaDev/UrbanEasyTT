package web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dao.AuthenticationDAO;

/**
 * Servlet implementation class VerificationServlet
 */
@WebServlet("/VerificationServlet")
public class VerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AuthenticationDAO authenticationDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
        this.authenticationDAO = new AuthenticationDAO();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		response.setContentType("application/json");	
		response.setStatus(HttpServletResponse.SC_OK);
		// TODO Auto-generated method stub
		int verificationId = Integer.parseInt(request.getParameter("id"));
		String codes = request.getParameter("codes");
		boolean isVerified = authenticationDAO.verifyCodes(verificationId, codes);
		if (!isVerified) {
			String json = gson.toJson("error");
			response.getWriter().print(json);
		} else {
			String json = gson.toJson("ok");
			response.getWriter().print(json);
			authenticationDAO.finalisingUser(verificationId);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	
	}

}