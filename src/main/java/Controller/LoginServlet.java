package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.nhanvien; // Import nhanvien model
import Connection.DButils;
import Connection.MySQLConntUtils;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/Login.jsp");
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con;
        try {
            con = MySQLConntUtils.getConnection();
            String username = request.getParameter("Username");
            String password = request.getParameter("Password");

            nhanvien usr = new nhanvien(username, password); // Change to nhanvien model
            nhanvien u = DButils.findUser(con, usr.getUser(), usr.getPassword()); // Change to nhanvien model
            System.out.println(u);
            if (u != null) {
                nhanvien user = new nhanvien(u); // Change to nhanvien model
                request.setAttribute("Username", "Chào bạn: " + user.getUser());
                request.getRequestDispatcher("/admin.jsp").forward(request, response);
            } else {
				request.getRequestDispatcher("/error/errorLog.jsp").forward(request, response);
				
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
