package Controller.HoaDon;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.MySQLConntUtils;
import Connection.DButils;
import Model.HoaDon;

@WebServlet("/SearchHoaDonServlet")
public class SearchHoaDonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String errorString = null;
        List<HoaDon> hoaDonList = new ArrayList<>();

        // Kiểm tra xem có yêu cầu tìm kiếm không
        String searchIDBill = request.getParameter("searchIDBill");

        if (searchIDBill != null && !searchIDBill.isEmpty()) {
            try {
                int maHoaDon = Integer.parseInt(searchIDBill);
                Connection con = MySQLConntUtils.getConnection();

                // Gọi hàm tìm kiếm theo mã hóa đơn từ DButils
                hoaDonList = DButils.selectHoaDonByMaHoaDon(con, maHoaDon);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                errorString = "Mã hóa đơn không hợp lệ";
            } catch (Exception e) {
                e.printStackTrace();
                errorString = "Đã xảy ra lỗi: " + e.getMessage();
            }
        } else {
            // Nếu không có mã hóa đơn để tìm kiếm, có thể chuyển hướng hoặc xử lý khác theo yêu cầu của bạn
            // Ở đây, tôi chuyển hướng về trang error.jsp để thông báo lỗi.
            request.setAttribute("errorString", "Vui lòng nhập mã hóa đơn để tìm kiếm.");
            request.getRequestDispatcher("/HoaDonServlet").forward(request, response);
            return;
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("hoaDonList", hoaDonList);
        request.getRequestDispatcher("/HoaDon.jsp").forward(request, response);
    }
}
