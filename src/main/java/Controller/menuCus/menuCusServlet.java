package Controller.menuCus;

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
import Model.Menu;

/**
 * Servlet implementation class menuCusServlet
 */
@WebServlet("/menuCusServlet")
public class menuCusServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String errorString = null;
        List<Menu> menuCusList = new ArrayList<>();

        try {
            Connection con = MySQLConntUtils.getConnection();
            menuCusList = DButils.selectAllProduct(con);
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("menuCusList", menuCusList);
        request.getRequestDispatcher("customer/menuCUS.jsp").forward(request, response);
    }
}
