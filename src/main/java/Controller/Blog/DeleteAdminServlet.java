package Controller.Blog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.Blog_CoffeeDAO;
import Model.Blog_Coffee;



/**
 * Servlet implementation class DeleteAdminServlet
 */
@WebServlet("/deletebl")
public class DeleteAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
	    int id = 0; 
	    
	    if(idString != null && !idString.isEmpty()) {
	        try {
	            id = Integer.parseInt(idString);
	        } catch (NumberFormatException e) {
	            e.printStackTrace(); 
	        }
	    }
		Blog_CoffeeDAO dao = new Blog_CoffeeDAO();
		Blog_Coffee bl = dao.getBlogByKey(id);
		request.setAttribute("blL", bl);
		request.getRequestDispatcher("/blog/delete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
	    int id = 0; 
	    
	    if(idString != null && !idString.isEmpty()) {
	        try {
	            id = Integer.parseInt(idString);
	        } catch (NumberFormatException e) {
	            e.printStackTrace(); 
	        }
	    }
		Blog_CoffeeDAO dao = new Blog_CoffeeDAO();
		dao.deleteBlog(id);
		response.sendRedirect("showadminblog");
	}

}
