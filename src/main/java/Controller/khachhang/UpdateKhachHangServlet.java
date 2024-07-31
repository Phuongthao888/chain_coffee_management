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

@WebServlet("/UpdateKhachHangServlet")
public class UpdateKhachHangServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");

            // Lấy thông tin từ form
            int idKhachHang = Integer.parseInt(request.getParameter("IDKhachHang"));
            String tenKhachHang = request.getParameter("TenKhachHang");
            
            // Kiểm tra giá trị SoLanThanhToan trước khi chuyển đổi
            String soLanThanhToanStr = request.getParameter("SoLanThanhToan");
            int soLanThanhToan = (soLanThanhToanStr != null && !soLanThanhToanStr.isEmpty()) ? Integer.parseInt(soLanThanhToanStr) : 0;
            
            String sdt = request.getParameter("SDT");
            String diaChi = request.getParameter("DiaChi");

            // Tạo đối tượng KhachHang
            khachhang khachHang = new khachhang(idKhachHang, tenKhachHang, soLanThanhToan, sdt, diaChi);

            // Thực hiện chức năng cập nhật khách hàng
            DButils.updateKhachHang(khachHang);

            // Chuyển hướng về trang danh sách khách hàng sau khi cập nhật thành công
            response.sendRedirect(request.getContextPath() + "/KhachHangServlet");
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi và chuyển hướng về trang lỗi
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("IDKhachHang");
        int id_new = Integer.parseInt(id);
        Connection connection;
        try {
            connection = MySQLConntUtils.getConnection();
            khachhang khachHang = DButils.selectKhachHangById(connection, id_new);
            req.setAttribute("khachHang", khachHang);
            req.getRequestDispatcher("UpdateKhachHang.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
