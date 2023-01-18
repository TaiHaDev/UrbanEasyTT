//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package web;

import dao.ProductDAO;
import dao.CategoryDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.Category;

@WebServlet({"/home"})
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;
    public HomeServlet() {
    }

    public void init() {
        this.productDAO = new ProductDAO();
        this.categoryDAO = new CategoryDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	List<List<Product>> products = this.productDAO.selectProductByCategory();
        	List<Category> categories = this.categoryDAO.selectAllCategory();
        	
        	
            
//        	request.setAttribute("firstProductList", products.get(0));
//        	products.remove(0);
        	request.setAttribute("firstProduct", products.get(0));
        	products.remove(0);
            request.setAttribute("products", products);
            
            request.setAttribute("firstCategory", categories.get(0));
            categories.remove(0);
            request.setAttribute("categories", categories);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
