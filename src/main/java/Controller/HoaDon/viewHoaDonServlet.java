package Controller.HoaDon;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.DButils;
import Connection.MySQLConntUtils;
import java.util.*;
import Model.HoaDon;
/**
 * Servlet implementation class viewHoaDonServlet
 */
@WebServlet("/viewHoaDonServlet")
public class viewHoaDonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String errorString = null;
        int maHoaDon = Integer.parseInt(request.getParameter("MaHoaDon"));
        List<HoaDon> hoaDonList = new ArrayList<>();

        try {
            Connection con = MySQLConntUtils.getConnection();
            hoaDonList = DButils.selectHoaDonByMaHoaDon(con, maHoaDon);
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        request.setAttribute("errorString", errorString);
        request.setAttribute("hoaDonList", hoaDonList);
        request.getRequestDispatcher("/ViewHoaDon.jsp").forward(request, response);
    }
}

