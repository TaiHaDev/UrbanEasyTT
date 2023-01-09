//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package web;

import model.Product;
import dao.ProductDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet({"/"})
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public ProductServlet() {
    	this.productDAO = new ProductDAO();
    }

    public void init() {
        this.productDAO = new ProductDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getServletPath();
        try {
            switch (action) {
                case "/product-detail":
                    this.showProductDetail(request, response);
                    break;
                case "/list":
                    this.listProduct(request, response);
                    break;
                default:
                    this.listProduct(request, response);
            }

        } catch (SQLException var5) {
            throw new ServletException(var5);
        }
    }
    
    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        ArrayList<Product> products = this.productDAO.selectAllProducts();
        request.setAttribute("productList", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showProductDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-detail.jsp");
        dispatcher.forward(request, response);
    }
}
