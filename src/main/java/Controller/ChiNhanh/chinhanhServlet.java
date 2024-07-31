package Controller.ChiNhanh;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.DButils;
import Connection.MySQLConntUtils;
import Model.ChiNhanh;
import Model.Menu;

/**
 * Servlet implementation class chinhanhServlet
 */
@WebServlet("/chinhanhServlet")
public class chinhanhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chinhanhServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String errorString = null;
        List<ChiNhanh> chinhanhList = new ArrayList<>();

        try {
            Connection con = MySQLConntUtils.getConnection();
            chinhanhList = DButils.selectAllChiNhanh(con);
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("chinhanhList", chinhanhList);
        request.getRequestDispatcher("/chinhanh.jsp").forward(request, response);
    }

}
