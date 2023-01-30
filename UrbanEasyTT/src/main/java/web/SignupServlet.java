package web;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dao.AuthenticationDAO;
import util.VerificationEmail;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AuthenticationDAO authenticationDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
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
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		var type = new TypeToken<Map<String,String>>(){}.getType();
		Map<String,String> myMap = gson.fromJson(request.getReader(), type);
		response.setContentType("application/json");	
		String email = myMap.get("email");
		String name = myMap.get("name");
		String password = myMap.get("password");
		boolean isEmailExisted = authenticationDAO.checkExistingEmail(myMap.get("email"));
		response.setStatus(HttpServletResponse.SC_OK);
		if (isEmailExisted) {
			String json = gson.toJson("email false");
			response.getWriter().print(json);
		} else {
			// generate random verqification code and add to a table in the database, then send that code through
			// email to user
			int generatedNumber = VerificationEmail.sendVerificationEmail(myMap.get("email"));
			int id = authenticationDAO.insertTemporaryUserDetail(email, password, name, generatedNumber);
			VerificationEmail.ScheduleVerificationRowDeletion(id);
			// send back id and then making post request from client side with that id and verification code
			String json = gson.toJson(id);
			response.getWriter().print(json);
		}
	}

}
