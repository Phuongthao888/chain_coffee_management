package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Blog_Coffee;


public class Blog_CoffeeDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Blog_Coffee> getAllBlog() {
		List<Blog_Coffee> list = new ArrayList<>();
		String query = "SELECT * FROM blog";
		try {
			conn = new MySQLConntUtils().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Blog_Coffee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public void insertBlog(String title, String description, String imgurl) {
		String query = "INSERT INTO blog (title, description, imgurl)\r\n" + "VALUES (?,?,?)";

		try {
			conn = new MySQLConntUtils().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, description);
			ps.setString(3, imgurl);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Blog_Coffee getBlogByKey(int id) {
		String query = "SELECT * FROM blog\r\n" + "WHERE id = ?";
		try {
			conn = new MySQLConntUtils().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Blog_Coffee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateBlog(int id, String title, String description, String imgurl) {
		String query = "UPDATE blog\r\n"
				+ "SET title=?, description=?, imgurl=?\r\n"
				+ "WHERE id=?";
		try {
			conn = MySQLConntUtils.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, description);
			ps.setString(3, imgurl);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBlog(int id) {
		String query = "DELETE FROM blog\r\n" + "WHERE id = ?";
		try {
			conn = MySQLConntUtils.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Blog_Coffee> searchBlog(String title){
		List<Blog_Coffee> list = new ArrayList<Blog_Coffee>();
		String query = "SELECT title, description, imgurl FROM blog WHERE title LIKE ?";
		try {
			conn = MySQLConntUtils.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + title + "%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Blog_Coffee(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
