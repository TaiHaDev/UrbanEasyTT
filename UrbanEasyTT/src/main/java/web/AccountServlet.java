package web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.User;

import dao.UserDAO;

/**
 * Servlet implementation class Account
 */
@WebServlet(name = "account", urlPatterns = { "/account" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10, // 10 MB
maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
        this.userDAO = new UserDAO();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			long userId = (long) session.getAttribute("userId");
			User currentUser = userDAO.selectUserById2(userId);
			request.setAttribute("user", currentUser);
			
            RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
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
		try {
			HttpSession session = request.getSession();
			long userId = (long) session.getAttribute("userId");
			
			String userName = request.getParameter("userName");
			if (userName != null) {
				String phoneNum = request.getParameter("phoneNum");
				String email = request.getParameter("email");
				
				
				userDAO.updateInfoUser(userId, userName, phoneNum, email);
				
			}
			else {
				String appPath = request.getServletContext().getRealPath("");
				String savePath = appPath + "user_asset" + File.separator + userId;
				
				Part img = request.getPart("file");
				
				String url = "-";
				
				File folderUpload = new File(savePath);
				if (!folderUpload.exists()) {
					folderUpload.mkdirs();
				}
				
				String fileName = extractFileName(img);
				fileName = new File(fileName).getName();
				img.write(savePath+ File.separator + fileName);
				url = ("user_asset/"+userId+"/"+fileName);
				
				userDAO.updateAvatarUser(userId, url);
				
				
			}
			doGet(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
