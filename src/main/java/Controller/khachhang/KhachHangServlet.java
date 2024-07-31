package Controller.khachhang;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.khachhang;
import Connection.DButils;
import Connection.MySQLConntUtils;


/**
 * Servlet implementation class KhachHangServlet
 */
@WebServlet("/KhachHangServlet")
public class KhachHangServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String errorString = null;
        List<khachhang> list = new ArrayList<>();

        try {
            Connection con = MySQLConntUtils.getConnection();
            list = DButils.selectAllKhachHang(con);
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("khachHangList", list);
        request.getRequestDispatcher("/KhachHang.jsp").forward(request, response);
    }
}
