package Controller.nhanvien;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.nhanvien;
import Connection.DButils;
import Connection.MySQLConntUtils;

@WebServlet("/NhanVienServlet")
public class NhanVienServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String errorString = null;
        List<nhanvien> list = new ArrayList<>();

        try {
            Connection con = MySQLConntUtils.getConnection();
            list = DButils.selectAllNhanVien(con);
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("nhanVienList", list);
        request.getRequestDispatcher("/nhanvien.jsp").forward(request, response);
    }
}
