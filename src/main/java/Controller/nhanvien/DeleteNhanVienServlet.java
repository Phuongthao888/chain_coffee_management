package Controller.nhanvien;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.DButils;
import Connection.MySQLConntUtils;

@WebServlet("/DeleteNhanVienServlet")
public class DeleteNhanVienServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String deleteIdParam = request.getParameter("IDNhanVien");
        if (deleteIdParam != null && !deleteIdParam.isEmpty()) {
            try {
                int idNhanVienToDelete = Integer.parseInt(deleteIdParam);
                Connection conn = MySQLConntUtils.getConnection();
                int rowsAffected = DButils.deleteNhanVien(conn, idNhanVienToDelete);

                if (rowsAffected > 0) {
                    // Xóa thành công, cập nhật lại danh sách và hiển thị
                    request.setAttribute("nhanVienList", DButils.selectAllNhanVien(conn));
                } else {
                    // Không có hàng nào bị ảnh hưởng
                    request.setAttribute("errorString", "Không thể xóa nhân viên: Không có hàng nào bị ảnh hưởng.");

                    // Chuyển hướng tới trang thông báo không xóa được
                    request.getRequestDispatcher("/errorDeleteNhanVien.jsp").forward(request, response);
                    return;
                }
            } catch (NumberFormatException | SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorString", "Không thể xóa nhân viên: " + e.getMessage());

                // Chuyển hướng tới trang thông báo không xóa được
                request.getRequestDispatcher("/errorDeleteNhanVien.jsp").forward(request, response);
                return;
            }
        } else {
            // ID không hợp lệ
            request.setAttribute("errorString", "ID nhân viên để xóa không hợp lệ.");

            // Chuyển hướng tới trang thông báo không xóa được
            request.getRequestDispatcher("/errorDeleteNhanVien.jsp").forward(request, response);
            return;
        }

        // Hiển thị lại trang nhanvien.jsp
        request.getRequestDispatcher("/nhanvien.jsp").forward(request, response);
    }
}
