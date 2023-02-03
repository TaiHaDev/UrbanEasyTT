package web;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploaderServlet
 */
@WebServlet("/image-upload")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class FileUploaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    /* Receive file uploaded to the Servlet from the HTML5 form */
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("uploader.jsp");
            dispatcher.forward(request, response);
            
			Part filePart = request.getPart("file");
		    String fileName = filePart.getSubmittedFileName();
		    for (Part part : request.getParts()) {
		    	part.write(fileName);
		    }
		    
//		    System.out.println(fileName);
//		    Path path = Paths.get(fileName);
//		    String absolutePath = path.toRealPath().toString();
//		    System.out.println(absolutePath);
//			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    
	  }

	}
