package Controller.Blog;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.Blog_CoffeeDAO;
import Model.Blog_Coffee;


@WebServlet("/showadminblog")
public class BlogAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BlogAdminServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Blog_CoffeeDAO dao = new Blog_CoffeeDAO();
		List<Blog_Coffee> bl = dao.getAllBlog(); 
		
		request.setAttribute("listadblog", bl);
		request.getRequestDispatcher("/blog/show.jsp").forward(request, response);
	}

}
