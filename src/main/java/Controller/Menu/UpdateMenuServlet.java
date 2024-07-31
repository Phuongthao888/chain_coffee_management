package Controller.Menu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Menu;
import Connection.DButils;
import Connection.MySQLConntUtils;

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 10,
    maxFileSize = 1024 * 1024 * 50,
    maxRequestSize = 1024 * 1024 * 100
)

@WebServlet("/UpdateMenuServlet")
public class UpdateMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");

            // Lấy thông tin từ form
            int maMon = Integer.parseInt(request.getParameter("maMon"));
            String tenMon = request.getParameter("TenMon");
            String moTaMon = request.getParameter("MoTaMon");
            float giaTien = Float.parseFloat(request.getParameter("GiaTien"));
            String hinhAnh = request.getParameter("HinhAnh");
            String nguyenLieuCanThiet = request.getParameter("NguyenLieuCanThiet");

            // Tạo đối tượng Menu
            Menu menu = new Menu(maMon, tenMon, moTaMon, giaTien, hinhAnh, nguyenLieuCanThiet);

            // Thực hiện chức năng cập nhật menu
            DButils.updateMenu(menu);

            // Chuyển hướng về trang danh sách menu sau khi cập nhật thành công
            response.sendRedirect(request.getContextPath() + "/MenuServlet");
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi và chuyển hướng về trang lỗi
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("maMon");
        int id_new = Integer.parseInt(id);
        Connection connection;
        try {
            connection = MySQLConntUtils.getConnection();
            Menu menu = DButils.selectProductById(connection, id_new);
            req.setAttribute("menu", menu);
            req.getRequestDispatcher("updateMenu.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi và chuyển hướng về trang lỗi
            resp.sendRedirect(req.getContextPath() + "/error.jsp");
        }
    }
}
