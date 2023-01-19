//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package web;

import dao.ProductDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet({"/product-detail"})
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public ProductServlet() {
    }

    public void init() {
        this.productDAO = new ProductDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        try {
        	long id = Long.parseLong(request.getParameter("id"));
        	Product product = productDAO.selectProduct(id);
        	
        	request.setAttribute("product", product);
        	String[] urlArray = productDAO.selectAssets(id);
        	request.setAttribute("assets", urlArray);
            RequestDispatcher dispatcher = request.getRequestDispatcher("product-detail.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}