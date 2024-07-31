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

@WebServlet("/UpdateNguyenLieuServlet")
public class UpdateNguyenLieuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");

            // Lấy thông tin từ form
            int idNguyenLieu = Integer.parseInt(request.getParameter("IDNguyenLieu"));
            String tenNguyenLieu = request.getParameter("TenNguyenLieu");
            int soLuongNhap = Integer.parseInt(request.getParameter("SoLuongNhap"));
            float donGiaNhap = Float.parseFloat(request.getParameter("DonGiaNhap"));
            String ngayNhapStr = request.getParameter("NgayNhap");

            // Chuyển đổi ngày từ chuỗi sang đối tượng Date
            Date ngayNhap = null;
            try {
                ngayNhap = new SimpleDateFormat("yyyy-MM-dd").parse(ngayNhapStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            float tongTienNhap = soLuongNhap * donGiaNhap; // Tính tổng tiền nhập

            // Tạo đối tượng NguyenLieu
            NguyenLieu nguyenLieu = new NguyenLieu(idNguyenLieu, tenNguyenLieu, soLuongNhap, donGiaNhap, tongTienNhap, ngayNhap);

            // Thực hiện chức năng cập nhật nguyên liệu
            Connection conn = MySQLConntUtils.getConnection();
            DButils.updateNguyenLieu(conn, nguyenLieu);

            // Cập nhật thành công, chuyển hướng về trang danh sách nguyên liệu
            response.sendRedirect(request.getContextPath() + "/NguyenLieuServlet");
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi và chuyển hướng về trang lỗi
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("IDNguyenLieu");
        int id_new = Integer.parseInt(id);
        Connection connection;
        try {
            connection = MySQLConntUtils.getConnection();
            NguyenLieu nguyenLieu = DButils.selectNguyenLieuById(connection, id_new);
            req.setAttribute("nguyenLieu", nguyenLieu);
            req.getRequestDispatcher("UpdateNguyenLieu.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi và chuyển hướng về trang lỗi
            resp.sendRedirect(req.getContextPath() + "/error.jsp");
        }
    }
}
