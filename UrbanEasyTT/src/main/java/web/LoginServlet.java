package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AuthenticationDAO;
import dao.ProductDAO;
import dao.ReviewDAO;
import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AuthenticationDAO loginDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
        this.loginDAO = new AuthenticationDAO();
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
		String userName = request.getParameter("email");
		String password = request.getParameter("password");
		User user = loginDAO.authenticateUser(userName, password);
		String referrer = request.getHeader("referer");
		referrer = referrer.replaceFirst("[?, &]re=true", "");
		if (user == null) {
			if (referrer.contains("?")) {
				referrer += "&re=true";
			} else {
				referrer += "?re=true";
			}
			response.sendRedirect(referrer);
		} else {
			HttpSession session =  request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("avatar", user.getAvatarURL());
			session.setMaxInactiveInterval(60 * 60); // user sẽ bị log out ra nếu không hoạt động trong một tiếng
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
			Object intendedPageUrl = session.getAttribute("intendedPage");
			if (intendedPageUrl != null) {
				response.sendRedirect((String) intendedPageUrl);

			} else {
				response.sendRedirect(referrer);
			}
		}

		
		
	}

}