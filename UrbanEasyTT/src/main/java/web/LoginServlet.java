package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import dao.ProductDAO;
import dao.ReviewDAO;
import dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDAO loginDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
        this.loginDAO = new LoginDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = request.getParameter("email");
		String password = request.getParameter("password");
		Integer userId = loginDAO.authenticateUser(userName, password);
		String referrer = request.getHeader("referer");
		if (userId == -1) {
			if (referrer.contains("?")) {
				referrer += "&re=true";
			} else {
				referrer += "?re=true";
			}
			response.sendRedirect(referrer);
		} else {
			HttpSession session =  request.getSession();
			session.setAttribute("userId", userId);
			session.setMaxInactiveInterval(60 * 60); // user sẽ bị log out ra nếu không hoạt động trong một tiếng
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
			referrer = referrer.replace("&re=true", "");
			response.sendRedirect(referrer);
		}

		
		
	}

}