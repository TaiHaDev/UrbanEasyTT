package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Category;
import model.Product;

/**
 * Servlet implementation class HostingServlet
 */
@WebServlet(name = "hosting", urlPatterns = { "/hosting" })
public class HostingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HostingServlet() {
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
		try {
			
			HttpSession session = request.getSession();
			long userId = (long) session.getAttribute("userId");
        	List<Product> products = this.productDAO.selectHousesOwnByUser(userId);
        	
        	request.setAttribute("houseAmount", products.size());
            request.setAttribute("products", products);
            
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("hosting.jsp");
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
		try {
			String idToDelete = request.getParameter("delete");
			if(idToDelete!=null) {
				productDAO.deleteProductById(idToDelete);
				doGet(request,response);
			}
	        else {
	        	doGet(request,response);
	        }
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
