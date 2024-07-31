package Controller.nguyenlieu;

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

@WebServlet("/DeleteNguyenLieuServlet")
public class DeleteNguyenLieuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String deleteIdParam = request.getParameter("IDNguyenLieu");
        if (deleteIdParam != null && !deleteIdParam.isEmpty()) {
            try {
                int idNguyenLieuToDelete = Integer.parseInt(deleteIdParam);
                Connection con = MySQLConntUtils.getConnection();
                
                // Kiểm tra xem IDNguyenLieu có trong KiemKho hay không
                if (DButils.isIdNguyenLieuInKiemKho(con, idNguyenLieuToDelete)) {
                    request.setAttribute("errorString", "Không thể xóa nguyên liệu: Nguyên liệu đang tồn tại trong bảng KiemKho.");
                    request.getRequestDispatcher("/errorDelete.jsp").forward(request, response);
                    return;
                }

                int rowsAffected = DButils.deleteNguyenLieu(con, idNguyenLieuToDelete);

                if (rowsAffected > 0) {
                    // Xóa thành công, cập nhật lại danh sách và hiển thị
                    request.setAttribute("nguyenLieuList", DButils.selectAllNguyenLieu(con));
                } else {
                    // Không có hàng nào bị ảnh hưởng
                    request.setAttribute("errorString", "Không thể xóa nguyên liệu: Không có hàng nào bị ảnh hưởng.");

                    // Chuyển hướng tới trang thông báo không xóa được
                    request.getRequestDispatcher("/errorDelete.jsp").forward(request, response);
                    return;
                }
            } catch (NumberFormatException | SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorString", "Không thể xóa nguyên liệu: " + e.getMessage());

                // Chuyển hướng tới trang thông báo không xóa được
                request.getRequestDispatcher("/errorDelete.jsp").forward(request, response);
                return;
            }
        } else {
            // ID không hợp lệ
            request.setAttribute("errorString", "ID nguyên liệu để xóa không hợp lệ.");

            // Chuyển hướng tới trang thông báo không xóa được
            request.getRequestDispatcher("/errorDeleteNguyenLieu.jsp").forward(request, response);
            return;
        }

        // Hiển thị lại trang nguyenlieu.jsp
        request.getRequestDispatcher("/nguyenlieu.jsp").forward(request, response);
    }
}
