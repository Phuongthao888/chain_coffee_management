package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConntUtils {

    public static Connection getConnection() throws SQLException {
        Connection c = null;
        
        try {
            // Đăng ký MySQL Driver với DriverManager
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Các thông số
            String url = "jdbc:mysql://localhost:3306/quancoffee";
            String username = "root";
            String password = "";
            
            // Tạo kết nối
            c = DriverManager.getConnection(url, username, password);
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new SQLException("Không thể kết nối đến cơ sở dữ liệu.", e);
        }
        
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c) {
        try {
            if (c != null) {
                System.out.println(c.getMetaData().getDatabaseProductName());
                System.out.println(c.getMetaData().getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
