package Controller.nguyenlieu;

import Model.NguyenLieu;
import Connection.DButils;
import Connection.MySQLConntUtils;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchNguyenLieuServlet")
public class SearchNguyenLieuServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String errorString = null;
        List<NguyenLieu> nguyenLieuList = new ArrayList<>();

        // Kiểm tra xem có yêu cầu tìm kiếm không
        String searchName = request.getParameter("searchName");
        if (searchName != null && !searchName.isEmpty()) {
            try {
                Connection con = MySQLConntUtils.getConnection();
                nguyenLieuList = DButils.searchNguyenLieuByName(con, searchName);
            } catch (Exception e) {
                e.printStackTrace();
                errorString = "Đã xảy ra lỗi: " + e.getMessage();
            }
        } else {
            // Nếu không có tên tìm kiếm, có thể chuyển hướng hoặc xử lý khác theo yêu cầu của bạn
            // Ở đây, tôi chuyển hướng về trang error.jsp để thông báo lỗi.
            request.setAttribute("errorString", "Vui lòng nhập tên để tìm kiếm.");
            request.getRequestDispatcher("/NguyenLieuServlet").forward(request, response);
            return;
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("nguyenLieuList", nguyenLieuList);
        request.getRequestDispatcher("/nguyenlieu.jsp").forward(request, response);
    }
}
