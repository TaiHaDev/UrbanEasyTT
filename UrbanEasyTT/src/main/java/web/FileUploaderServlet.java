package web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploaderServlet
 */
@WebServlet("/image-upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class FileUploaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "userUploadFiles";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("uploader.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			ArrayList<Part> images = new ArrayList<>(request.getParts());
			
			if(!images.isEmpty()) {
		        HttpSession session = request.getSession();
		        session.setAttribute("images", images);
		        response.sendRedirect("title");
			}
	        else {
	        	doGet(request,response);
	        }
			
			
//			String appPath = request.getServletContext().getRealPath("");
//	        String savePath = appPath + SAVE_DIR; //should replaced by user_id/house_id
//	        
//	        for (Part part : request.getParts()) {
//				String fileName = extractFileName(part);
//				fileName = new File(fileName).getName();
//				part.write(savePath+ File.separator + fileName);
//			}
//			request.setAttribute("message", "Upload File Success!");
//			getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
		} catch (Exception e) {
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
	
//	public File getFolderUpload() {
//	    File folderUpload = new File(System.getProperty("user.home") + "/Uploads");
//	    if (!folderUpload.exists()) {
//	      folderUpload.mkdirs();
//	    }
//	    return folderUpload;
//	  }

}
