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
/**
 * Servlet implementation class UpdateNhanVienServlet
 */
@WebServlet("/UpdateNhanVienServlet")
public class UpdateNhanVienServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");

            // Lấy thông tin từ form
            int idNhanVien = Integer.parseInt(request.getParameter("IDNhanVien"));
            String tenNhanVien = request.getParameter("TenNhanVien");
            String ngaySinhStr = request.getParameter("NgaySinh");
            int sDT = Integer.parseInt(request.getParameter("SDT"));
            String user = request.getParameter("User");
            String password = request.getParameter("Password");
            String chucVu = request.getParameter("ChucVu");

            // Chuyển chuỗi ngày sinh thành kiểu Date
            Date ngaySinh = null;
            try {
                ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinhStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            // Tạo đối tượng NhanVien
            nhanvien nhanVien = new nhanvien(idNhanVien, tenNhanVien, ngaySinh, sDT, user, password, chucVu);

            // Thực hiện chức năng cập nhật nhân viên
            DButils.updateNhanVien(nhanVien);

            // Chuyển hướng về trang danh sách nhân viên sau khi cập nhật thành công
            response.sendRedirect(request.getContextPath() + "/NhanVienServlet");
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi và chuyển hướng về trang lỗi
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("IDNhanVien");
        int id_new = Integer.parseInt(id);
        Connection connection;
        try {
            connection = MySQLConntUtils.getConnection();
            nhanvien nhanVien = DButils.selectNhanVienById(connection, id_new);
            req.setAttribute("nhanVien", nhanVien);
            req.getRequestDispatcher("updateNhanVien.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}