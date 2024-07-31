package Controller.nguyenlieu;

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

import Model.NguyenLieu;
import Connection.DButils;
import Connection.MySQLConntUtils;

@WebServlet("/AddNguyenLieuServlet")
public class AddNguyenLieuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // Lấy thông tin từ form
        String tenNguyenLieu = request.getParameter("TenNguyenLieu");
        int soLuongNhap = Integer.parseInt(request.getParameter("SoLuongNhap"));
        float donGiaNhap = Float.parseFloat(request.getParameter("DonGiaNhap"));
        String ngayNhapStr = request.getParameter("NgayNhap");

        // Chuyển đổi ngày nhập từ String sang Date
        Date ngayNhap = null;
        try {
            ngayNhap = new SimpleDateFormat("yyyy-MM-dd").parse(ngayNhapStr);
        } catch (ParseException e) {
            e.printStackTrace();
            // Xử lý lỗi và chuyển hướng về trang thất bại hoặc trang lỗi
            response.sendRedirect(request.getContextPath() + "/error.jsp");
            return;
        }

        float tongTienNhap = soLuongNhap * donGiaNhap; // Tính tổng tiền nhập

        // Tạo đối tượng NguyenLieu
        NguyenLieu nguyenLieu = new NguyenLieu(tenNguyenLieu, soLuongNhap, donGiaNhap, tongTienNhap, ngayNhap);

        try {
            // Kết nối đến cơ sở dữ liệu
            Connection conn = MySQLConntUtils.getConnection();

            // Thực hiện chức năng thêm nguyên liệu
            int rowsAffected = DButils.insertNguyenLieu(conn, nguyenLieu);

            if (rowsAffected > 0) {
                // Nếu thêm thành công, chuyển hướng về trang danh sách nguyên liệu
                response.sendRedirect(request.getContextPath() + "/NguyenLieuServlet");
            } else {
                // Nếu thêm không thành công, chuyển hướng về trang thất bại hoặc trang thêm nguyên liệu
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi và chuyển hướng về trang thất bại hoặc trang lỗi
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
