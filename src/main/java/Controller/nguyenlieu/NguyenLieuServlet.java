package Controller.nguyenlieu;

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

import Model.NguyenLieu;
import Connection.DButils;
import Connection.MySQLConntUtils;

@WebServlet("/NguyenLieuServlet")
public class NguyenLieuServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String errorString = null;
        List<NguyenLieu> list = new ArrayList<>();

        try {
            Connection con = MySQLConntUtils.getConnection();
            list = DButils.selectAllNguyenLieu(con);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("nguyenLieuList", list);
        request.getRequestDispatcher("/nguyenlieu.jsp").forward(request, response);
    }
}
