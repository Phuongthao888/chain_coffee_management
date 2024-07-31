package Controller.Menu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Menu;
import Connection.DButils;
import Connection.MySQLConntUtils;

import java.util.*;


/**
 * Servlet implementation class AddMenuServlet
 */
@WebServlet("/AddMenuServlet")
public class AddMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String TenMon = request.getParameter("TenMon");
        String MoTaMon = request.getParameter("MoTaMon");
        float GiaTien = Float.parseFloat(request.getParameter("GiaTien"));
        String HinhAnh = request.getParameter("HinhAnh");
        String NguyenLieuCanThiet = request.getParameter("NguyenLieuCanThiet");

        Menu menu = new Menu(TenMon, MoTaMon, GiaTien, HinhAnh, NguyenLieuCanThiet);

        try {
            Connection conn = MySQLConntUtils.getConnection();
            int rowsAffected = DButils.insertProduct(conn, menu);

            if (rowsAffected > 0) {
                response.sendRedirect(request.getContextPath() + "/MenuServlet");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/MenuServlet");
    }
}

