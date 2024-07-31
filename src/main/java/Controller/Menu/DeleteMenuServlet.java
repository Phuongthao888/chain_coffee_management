package Controller.Menu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Menu;
import Model.nhanvien;
import Connection.DButils;
import Connection.MySQLConntUtils;

import java.util.*;
/**
 * Servlet implementation class DeleteMenuServlet
 */
@WebServlet("/DeleteMenuServlet")
public class DeleteMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String deleteIdParam = request.getParameter("MaMon");
        if (deleteIdParam != null && !deleteIdParam.isEmpty()) {
            try {
                int maMonToDelete = Integer.parseInt(deleteIdParam);
                Connection con = MySQLConntUtils.getConnection();
                
                // Kiểm tra xem MaMon có trong HoaDon hay không
                if (DButils.isMaMonInHoaDon(con, maMonToDelete)) {
                    request.setAttribute("errorString", "Không thể xóa món nước: Món nước đang tồn tại trong hóa đơn.");
                    request.getRequestDispatcher("/errorDelete.jsp").forward(request, response);
                    return;
                }

                int rowsAffected = DButils.deleteProduct(con, maMonToDelete);

                if (rowsAffected > 0) {
                    // Xóa thành công, cập nhật lại danh sách và hiển thị
                    List<Menu> list = DButils.selectAllProduct(con);
                    request.setAttribute("menuList", list);
                } else {
                    // Không có hàng nào bị ảnh hưởng
                    request.setAttribute("errorString", "Không thể xóa món nước: Không có hàng nào bị ảnh hưởng.");

                    // Chuyển hướng tới trang thông báo không xóa được
                    request.getRequestDispatcher("/errorDelete.jsp").forward(request, response);
                    return;
                }
            } catch (NumberFormatException | SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorString", "Không thể xóa món nước: " + e.getMessage());

                // Chuyển hướng tới trang thông báo không xóa được
                request.getRequestDispatcher("/errorDelete.jsp").forward(request, response);
                return;
            }
        } else {
            // ID không hợp lệ
            request.setAttribute("errorString", "ID món nước để xóa không hợp lệ.");

            // Chuyển hướng tới trang thông báo không xóa được
            request.getRequestDispatcher("/errorDelete.jsp").forward(request, response);
            return;
        }

        // Hiển thị lại trang menu.jsp
        request.getRequestDispatcher("/menu.jsp").forward(request, response);
    }
}
