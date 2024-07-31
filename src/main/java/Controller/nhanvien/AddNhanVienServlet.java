package Controller.nhanvien;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.nhanvien;
import Connection.DButils;
import Connection.MySQLConntUtils;

@WebServlet("/AddNhanVienServlet")
public class AddNhanVienServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // Lấy thông tin từ form
        String tenNhanVien = request.getParameter("TenNhanVien");
        String ngaySinhStr = request.getParameter("NgaySinh");
        int sdt = Integer.parseInt(request.getParameter("SDT"));
        String user = request.getParameter("User");
        String password = request.getParameter("Password");
        String chucVu = request.getParameter("ChucVu");

        // Chuyển đổi ngày sinh từ String sang Date
        Date ngaySinh = null;
        try {
            ngaySinh = new SimpleDateFormat("dd-MM-yyyy").parse(ngaySinhStr);
        } catch (ParseException e) {
            e.printStackTrace();
            // Xử lý lỗi và chuyển hướng về trang thất bại hoặc trang lỗi
            response.sendRedirect(request.getContextPath() + "/error.jsp");
            return;
        }

        // Tạo đối tượng NhanVien
        nhanvien nhanVien = new nhanvien(tenNhanVien, ngaySinh, sdt, user, password, chucVu);

        try {
            // Kết nối đến cơ sở dữ liệu
            Connection conn = MySQLConntUtils.getConnection();

            // Thực hiện chức năng thêm nhân viên
            int rowsAffected = DButils.insertNhanVien(conn, nhanVien);

            if (rowsAffected > 0) {
                // Nếu thêm thành công, chuyển hướng về trang thành công hoặc trang danh sách nhân viên
                response.sendRedirect(request.getContextPath() + "/NhanVienServlet");
            } else {
                // Nếu thêm không thành công, chuyển hướng về trang thất bại hoặc trang thêm nhân viên
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi và chuyển hướng về trang thất bại hoặc trang lỗi
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
