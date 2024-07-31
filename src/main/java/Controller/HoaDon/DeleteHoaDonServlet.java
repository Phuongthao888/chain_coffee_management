package Controller.HoaDon;

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

import java.util.*;
/**
 * Servlet implementation class DeleteHaoDonServlet
 */
@WebServlet("/DeleteHoaDonServlet")
public class DeleteHoaDonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String deleteIdParam = request.getParameter("MaHoaDon");
        if (deleteIdParam != null && !deleteIdParam.isEmpty()) {
            try {
                int maHoaDonToDelete = Integer.parseInt(deleteIdParam);
                Connection con = MySQLConntUtils.getConnection();

                int rowsAffected = DButils.deleteHoaDon(con, maHoaDonToDelete);

                if (rowsAffected > 0) {
                    // Xóa thành công, cập nhật lại danh sách và hiển thị
                    // (Nếu cần)
                } else {
                    // Không có hàng nào bị ảnh hưởng
                    request.setAttribute("errorString", "Không thể xóa hóa đơn: Không có hàng nào bị ảnh hưởng.");

                    // Chuyển hướng tới trang thông báo không xóa được
                    request.getRequestDispatcher("/errorDelete.jsp").forward(request, response);
                    return;
                }
            } catch (NumberFormatException | SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorString", "Không thể xóa hóa đơn: " + e.getMessage());

                // Chuyển hướng tới trang thông báo không xóa được
                request.getRequestDispatcher("/errorDelete.jsp").forward(request, response);
                return;
            }
        } else {
            // ID không hợp lệ
            request.setAttribute("errorString", "ID hóa đơn để xóa không hợp lệ.");

            // Chuyển hướng tới trang thông báo không xóa được
            request.getRequestDispatcher("/errorDelete.jsp").forward(request, response);
            return;
        }

        // Chuyển hướng tới trang danh sách hóa đơn (nếu cần)
        response.sendRedirect(request.getContextPath() + "/HoaDonServlet");
    }
}
