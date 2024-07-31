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
 * Servlet implementation class UpdateAdminServlet
 */
@WebServlet("/updatebl")
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
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
		request.getRequestDispatcher("/blog/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String idString = request.getParameter("id");
	    int id = 0;
	    if(idString != null && !idString.isEmpty()) {
	        id = Integer.parseInt(idString);
	    }
	    
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String imgurl = request.getParameter("imgurl");
		
		Blog_CoffeeDAO dao = new Blog_CoffeeDAO();
		dao.updateBlog(id, title, description, imgurl);
		response.sendRedirect("showadminblog");
	}

}
