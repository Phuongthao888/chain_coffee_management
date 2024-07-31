// Trong AddKhachHangServlet.java
package Controller.khachhang;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.khachhang;
import Connection.DButils;
import Connection.MySQLConntUtils;

@WebServlet("/AddKhachHangServlet")
public class AddKhachHangServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String tenKhachHang = request.getParameter("TenKhachHang");
        int soLanThanhToan = Integer.parseInt(request.getParameter("SoLanThanhToan"));
        String SDT = request.getParameter("SDT");
        String diaChi = request.getParameter("DiaChi");
        
        

        khachhang khachhang = new khachhang(tenKhachHang, soLanThanhToan, SDT, diaChi);

        try {
            Connection conn = MySQLConntUtils.getConnection();
            int rowsAffected = DButils.insertKhachHang(conn, khachhang);

            if (rowsAffected > 0) {
                response.sendRedirect(request.getContextPath() + "/KhachHangServlet");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/KhachHang.jsp");
    }
}
