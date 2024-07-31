package Controller.khachhang;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.DButils;
import Connection.MySQLConntUtils;
import Model.khachhang;

@WebServlet("/DeleteKhachHangServlet")
public class DeleteKhachHangServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String deleteIdParam = request.getParameter("IDKhachHang");
        if (deleteIdParam != null && !deleteIdParam.isEmpty()) {
            try {
                int idKhachHangToDelete = Integer.parseInt(deleteIdParam);
                Connection con = MySQLConntUtils.getConnection();

                // Xóa khách hàng không cần kiểm tra xem IDKhachHang có nằm trong bảng HoaDon không
                int rowsAffected = DButils.deleteKhachHang(con, idKhachHangToDelete);

                if (rowsAffected > 0) {
                    // Xóa thành công, cập nhật lại danh sách và hiển thị
                    // Lấy lại danh sách khách hàng sau khi xóa
                    List<khachhang> list = DButils.selectAllKhachHang(con);
                    request.setAttribute("khachHangList", list);

                    // Chuyển hướng tới trang khachhang.jsp
                    request.getRequestDispatcher("/KhachHang.jsp").forward(request, response);
                    return;
                } else {
                    // Không có hàng nào bị ảnh hưởng
                    request.setAttribute("errorString", "Không thể xóa khách hàng: Không có hàng nào bị ảnh hưởng.");

                    // Chuyển hướng tới trang thông báo không xóa được
                    request.getRequestDispatcher("/errorDelete.jsp").forward(request, response);
                    return;
                }
            } catch (NumberFormatException | SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorString", "Không thể xóa khách hàng: " + e.getMessage());

                // Chuyển hướng tới trang thông báo không xóa được
                request.getRequestDispatcher("/errorDelete.jsp").forward(request, response);
                return;
            }
        } else {
            // ID không hợp lệ
            request.setAttribute("errorString", "ID khách hàng để xóa không hợp lệ.");

            // Chuyển hướng tới trang thông báo không xóa được
            request.getRequestDispatcher("/errorDelete.jsp").forward(request, response);
            return;
        }
    }
}
