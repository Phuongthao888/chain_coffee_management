package Controller.nhanvien;

import Model.nhanvien;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.DButils;
import Connection.MySQLConntUtils;

import java.util.*;
/**
 * Servlet implementation class SearchNhanVienServlet
 */
@WebServlet("/SearchNhanVienServlet")
public class SearchNhanVienServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String errorString = null;
        List<nhanvien> nhanVienList = new ArrayList<>();

        // Kiểm tra xem có yêu cầu tìm kiếm không
        String searchName = request.getParameter("searchName");
        if (searchName != null && !searchName.isEmpty()) {
            try {
                Connection con = MySQLConntUtils.getConnection();
                nhanVienList = DButils.searchNhanVienByName(con, searchName);
            } catch (Exception e) {
                e.printStackTrace();
                errorString = "Đã xảy ra lỗi: " + e.getMessage();
            }
        } else {
            // Nếu không có tên tìm kiếm, có thể chuyển hướng hoặc xử lý khác theo yêu cầu của bạn
            // Ở đây, tôi chuyển hướng về trang error.jsp để thông báo lỗi.
            request.setAttribute("errorString", "Vui lòng nhập tên để tìm kiếm.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("nhanVienList", nhanVienList);
        request.getRequestDispatcher("/nhanvien.jsp").forward(request, response);
    }
}

