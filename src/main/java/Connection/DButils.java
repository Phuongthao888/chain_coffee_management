package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

import Model.ChiNhanh;
import Model.HoaDon;
import Model.Menu;
import Model.NguyenLieu;
import Model.khachhang;
import Model.nhanvien;

public class DButils {
//NhanVien:
	public static nhanvien findUser(Connection con, String userName, String password) throws SQLException {
		String sql = "SELECT * FROM nhanvien WHERE User=? AND Password=?";

		try (PreparedStatement pstm = con.prepareStatement(sql)) {
			pstm.setString(1, userName);
			pstm.setString(2, password);

			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					nhanvien user = new nhanvien();
					user.setIDNhanVien(rs.getInt("IDNhanVien"));
					user.setTenNhanVien(rs.getString("TenNhanVien"));
					user.setUser(userName);
					user.setPassword(password);
					user.setChucVu(rs.getString("ChucVu"));
					return user;
				}
			}
		}
		return null;
	}

	public static nhanvien findUser(Connection con, String userName) throws SQLException {
		String sql = "SELECT * FROM nhanvien WHERE User=?";

		try (PreparedStatement pstm = con.prepareStatement(sql)) {
			pstm.setString(1, userName);

			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					nhanvien user = new nhanvien();
					user.setIDNhanVien(rs.getInt("IDNhanVien"));
					user.setTenNhanVien(rs.getString("TenNhanVien"));
					user.setUser(userName);
					user.setPassword(rs.getString("Password"));
					user.setChucVu(rs.getString("ChucVu"));
					return user;
				}
			}
		}
		return null;
	}

	public static void insertAccount(Connection con, nhanvien user) throws SQLException {
		String sql = "INSERT INTO nhanvien(TenNhanVien, NgaySinh, SDT, User, Password, ChucVu) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, user.getTenNhanVien());
			// Thiết lập các giá trị khác của user (NgaySinh, SDT, ChucVu) tùy thuộc vào cấu
			// trúc thực của bảng nhanvien
			pstm.setDate(2, new java.sql.Date(user.getNgaySinh().getTime()));
			pstm.setInt(3, user.getSDT());
			pstm.setString(4, user.getUser());
			pstm.setString(5, user.getPassword());
			pstm.setString(6, user.getChucVu());

			int affectedRows = pstm.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Creating user failed, no rows affected.");
			}

			try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					user.setIDNhanVien(generatedKeys.getInt(1));
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}
		}
	}

	public static List<nhanvien> selectAllNhanVien(Connection conn) throws SQLException {
		String sql = "SELECT * FROM nhanvien";

		try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

			List<nhanvien> nhanVienList = new ArrayList<>();

			while (rs.next()) {
				nhanvien nv = new nhanvien(rs.getInt("IDNhanVien"), rs.getString("TenNhanVien"), rs.getDate("NgaySinh"),
						rs.getInt("SDT"), rs.getString("User"), rs.getString("Password"), rs.getString("ChucVu"));
				nhanVienList.add(nv);
			}

			return nhanVienList;
		}
	}

	public static int insertNhanVien(Connection conn, nhanvien nhanVien) throws SQLException {
		String sql = "INSERT INTO nhanvien (TenNhanVien, NgaySinh, SDT, User, Password, ChucVu) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, nhanVien.getTenNhanVien());
			pstm.setDate(2, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
			pstm.setInt(3, nhanVien.getSDT());
			pstm.setString(4, nhanVien.getUser());
			pstm.setString(5, nhanVien.getPassword());
			pstm.setString(6, nhanVien.getChucVu());

			int rowsAffected = pstm.executeUpdate();

			if (rowsAffected > 0) {
				try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						nhanVien.setIDNhanVien(generatedKeys.getInt(1));
					}
				}
			}

			return rowsAffected;
		}
	}

	public static int deleteNhanVien(Connection conn, int idNhanVien) throws SQLException {
		String sql = "DELETE FROM nhanvien WHERE IDNhanVien = ?";

		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setInt(1, idNhanVien);
			return pstm.executeUpdate();
		}
	}

	public static List<nhanvien> searchNhanVienByName(Connection conn, String searchName) throws SQLException {
		String sql = "SELECT * FROM NhanVien WHERE TenNhanVien LIKE ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + searchName + "%");

			try (ResultSet rs = ps.executeQuery()) {
				List<nhanvien> nhanVienList = new ArrayList<>();

				while (rs.next()) {
					nhanvien nhanVien = new nhanvien(rs.getInt("IDNhanVien"), rs.getString("TenNhanVien"),
							rs.getDate("NgaySinh"), rs.getInt("SDT"), rs.getString("User"), rs.getString("Password"),
							rs.getString("ChucVu"));
					nhanVienList.add(nhanVien);
				}

				return nhanVienList;
			}
		}
	}

//Update Nhan Vien
	public static void updateNhanVien(nhanvien nhanVien) throws SQLException {
		String sql = "UPDATE nhanvien SET TenNhanVien=?, NgaySinh=?, SDT=?, User=?, Password=?, ChucVu=? WHERE IDNhanVien=?";

		try (Connection conn = MySQLConntUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, nhanVien.getTenNhanVien());
			ps.setDate(2, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
			ps.setInt(3, nhanVien.getSDT());
			ps.setString(4, nhanVien.getUser());
			ps.setString(5, nhanVien.getPassword());
			ps.setString(6, nhanVien.getChucVu());
			ps.setInt(7, nhanVien.getIDNhanVien());

			ps.executeUpdate();
		}
	}

	public static nhanvien selectNhanVienById(Connection conn, int idNhanVien) throws SQLException {
		String sql = "SELECT * FROM nhanvien WHERE IDNhanVien = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, idNhanVien);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new nhanvien(rs.getInt("IDNhanVien"), rs.getString("TenNhanVien"), rs.getDate("NgaySinh"),
							rs.getInt("SDT"), rs.getString("User"), rs.getString("Password"), rs.getString("ChucVu")
					// Thêm các thông tin khác nếu cần
					);
				}
			}
		}
		return null;
	}

// Hiển thị sản phẩm 
	public static List<khachhang> selectAllKhachHang(Connection conn) throws SQLException {
		String sql = "SELECT * FROM khachhang";

		try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

			List<khachhang> khachHangList = new ArrayList<>();

			while (rs.next()) {
				khachhang kh = new khachhang(rs.getInt("IDKhachHang"), rs.getString("TenKhachHang"),
						rs.getInt("SoLanThanhToan"), rs.getString("DiaChi"), rs.getString("username"),
						rs.getString("SDT"));
				khachHangList.add(kh);
			}

			return khachHangList;
		}
	}

	public static int insertKhachHang(Connection conn, khachhang khachHang) throws SQLException {
		String sql = "INSERT INTO khachhang (TenKhachHang, SoLanThanhToan, SDT, DiaChi) VALUES (?, ?, ?, ?)";
		try (PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, khachHang.getTenKhachHang());
			pstm.setInt(2, khachHang.getSoLanThanhToan());
			pstm.setString(3, khachHang.getSDT());
			pstm.setString(4, khachHang.getDiaChi());

			int rowsAffected = pstm.executeUpdate();
			if (rowsAffected > 0) {
				try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						khachHang.setIDKhachHang(generatedKeys.getInt(1));
					}
				}
			}

			return rowsAffected;
		}
	}

	// Thêm phương thức deleteKhachHang
	public static int deleteKhachHang(Connection conn, int IDKhachHang) throws SQLException {
		String sql = "DELETE FROM khachhang WHERE IDKhachHang = ?";
		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setInt(1, IDKhachHang);
			return pstm.executeUpdate();
		}
	}

	public static boolean isIDKhachHangInHoaDon(Connection conn, int idKhachHang) throws SQLException {
		String sql = "SELECT * FROM HoaDon WHERE IDKhachHang = ?";
		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setInt(1, idKhachHang);
			try (ResultSet rs = pstm.executeQuery()) {
				return rs.next();
			}
		}
	}

	// Update Khach Hang
	public static void updateKhachHang(khachhang khachHang) throws SQLException {
		String sql = "UPDATE khachhang SET TenKhachHang=?, SoLanThanhToan=?, SDT=?, DiaChi=? WHERE IDKhachHang=?";

		try (Connection conn = MySQLConntUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, khachHang.getTenKhachHang());
			ps.setInt(2, khachHang.getSoLanThanhToan());
			ps.setString(3, khachHang.getSDT());
			ps.setString(4, khachHang.getDiaChi());
			ps.setInt(5, khachHang.getIDKhachHang());

			ps.executeUpdate();
		}
	}

	// Select Khach Hang By Id
	public static khachhang selectKhachHangById(Connection conn, int idKhachHang) throws SQLException {
		String sql = "SELECT * FROM khachhang WHERE IDKhachHang = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, idKhachHang);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new khachhang(rs.getInt("IDKhachHang"), rs.getString("TenKhachHang"),
							rs.getInt("SoLanThanhToan"), rs.getString("SDT"), rs.getString("DiaChi"));
				}
			}
		}
		return null;
	}

	public static List<khachhang> searchKhachHangByName(Connection conn, String searchName) throws SQLException {
		String sql = "SELECT * FROM KhachHang WHERE TenKhachHang LIKE ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + searchName + "%");

			try (ResultSet rs = ps.executeQuery()) {
				List<khachhang> khachHangList = new ArrayList<>();

				while (rs.next()) {
					khachhang khachHang = new khachhang(rs.getInt("IDKhachHang"), rs.getString("TenKhachHang"),
							rs.getInt("SoLanThanhToan"), rs.getString("SDT"), rs.getString("DiaChi"));
					khachHangList.add(khachHang);
				}

				return khachHangList;
			}
		}
	}

	public static List<Menu> selectAllProduct(Connection conn) throws SQLException {
		String sql = "SELECT * FROM Menu";

		try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

			List<Menu> productList = new ArrayList<>();

			while (rs.next()) {
				Menu pro = new Menu(rs.getInt("MaMon"), rs.getString("TenMon"), rs.getString("MoTaMon"),
						rs.getFloat("GiaTien"), rs.getString("HinhAnh"), rs.getString("NguyenLieuCanThiet"));
				productList.add(pro);
			}

			return productList;
		}
	}

// phương thức thêm và xóa dữ liệu của Menu: 
	public static int insertProduct(Connection conn, Menu menu) throws SQLException {
		String sql = "INSERT INTO Menu (MaMon, TenMon, MoTaMon, GiaTien, HinhAnh, NguyenLieuCanThiet) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setInt(1, menu.getMaMon());
			pstm.setString(2, menu.getTenMon());
			pstm.setString(3, menu.getMoTaMon());
			pstm.setFloat(4, menu.getGiaTien());
			pstm.setString(5, menu.getHinhAnh());
			pstm.setString(6, menu.getNguyenLieuCanThiet());
			return pstm.executeUpdate();
		}
	}

//xóa sản phẩm 
	public static int deleteProduct(Connection conn, int MaMon) throws SQLException {
		// Kiểm tra xem MaMon có trong HoaDon hay không
		if (isMaMonInHoaDon(conn, MaMon)) {
			throw new SQLException("Không thể xóa món nước: Món nước đang tồn tại trong hóa đơn.");
		}

		// Nếu không có trong HoaDon, thực hiện xóa từ bảng menu
		String sql = "DELETE FROM menu WHERE MaMon = ?";
		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setInt(1, MaMon);
			return pstm.executeUpdate();
		}
	}

	public static boolean isMaMonInHoaDon(Connection conn, int maMon) throws SQLException {
		String sql = "SELECT * FROM HoaDon WHERE MaMon = ?";
		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setInt(1, maMon);
			try (ResultSet rs = pstm.executeQuery()) {
				return rs.next();
			}
		}
	}
//tìm sản phẩm theo tên
	public static List<Menu> searchProductByName(Connection conn, String searchName) throws SQLException {
		String sql = "SELECT * FROM Menu WHERE TenMon LIKE ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + searchName + "%");

			try (ResultSet rs = ps.executeQuery()) {
				List<Menu> productList = new ArrayList<>();

				while (rs.next()) {
					Menu pro = new Menu(rs.getInt("MaMon"), rs.getString("TenMon"), rs.getString("MoTaMon"),
							rs.getFloat("GiaTien"), rs.getString("HinhAnh"), rs.getString("NguyenLieuCanThiet"));
					productList.add(pro);
				}

				return productList;
			}
		}
	}

// Trong class DButils
	public static Menu selectProductById(Connection conn, int maMon) throws SQLException {
		String sql = "SELECT * FROM Menu WHERE MaMon = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, maMon);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Menu(rs.getInt("MaMon"), rs.getString("TenMon"), rs.getString("MoTaMon"),
							rs.getFloat("GiaTien"), rs.getString("HinhAnh"), rs.getString("NguyenLieuCanThiet"));
				}
			}
		}
		return null;
	}

// Update sản phẩm
	public static void updateMenu(Menu menu) throws SQLException {
		String sql = "UPDATE Menu SET TenMon=?, MoTaMon=?, GiaTien=?, HinhAnh=?, NguyenLieuCanThiet=? WHERE MaMon=?";

		try (Connection conn = MySQLConntUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, menu.getTenMon());
			ps.setString(2, menu.getMoTaMon());
			ps.setFloat(3, menu.getGiaTien());
			ps.setString(4, menu.getHinhAnh());
			ps.setString(5, menu.getNguyenLieuCanThiet());
			ps.setInt(6, menu.getMaMon());

			ps.executeUpdate();
		}
	}

	// Hoa Don:
	public static List<HoaDon> selectAllHoaDon(Connection conn) throws SQLException {
		String sql = "SELECT * FROM HoaDon";

		try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			List<HoaDon> hoaDonList = new ArrayList<>();

			while (rs.next()) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.setStt(rs.getInt("stt"));
				hoaDon.setMaHoaDon(rs.getInt("MaHoaDon"));
				hoaDon.setMaMon(rs.getInt("MaMon"));
				hoaDon.setNgayTaoHoaDon(rs.getDate("NgayTaoHoaDon"));
				hoaDon.setSoLuong(rs.getInt("SoLuong"));
				hoaDon.setDongia(rs.getFloat("Dongia"));
				hoaDon.setTongBill(rs.getFloat("TongBill"));
				

				// Sử dụng phương thức getTenMonByMaMon để lấy tên món từ Menu
				String tenMon = getTenMonByMaMon(conn, hoaDon.getMaMon());
				hoaDon.setTenMon(tenMon);
				
				hoaDon.setIdKhachHang(rs.getInt("IDKhachHang"));
				String tenKhachHang= getTenKHbyidKH(conn, hoaDon.getIdKhachHang());
				hoaDon.setTenKhachHang(tenKhachHang);
				
				hoaDon.setIdChiNhanh(rs.getInt("chinhanhID"));
				String tenChiNhanh= getTenCNbyidCN(conn, hoaDon.getIdChiNhanh());
				hoaDon.setTenChiNhanh(tenChiNhanh);;
				
				hoaDonList.add(hoaDon);
			}

			return hoaDonList;
		}
	}

	public static int insertHoaDon(Connection conn, HoaDon hoaDon) throws SQLException {
		String sql = "INSERT INTO HoaDon (MaHoaDon, MaMon, NgayTaoHoaDon, SoLuong, DonGia, TongBill) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setInt(1, hoaDon.getMaHoaDon());
			pstm.setInt(2, hoaDon.getMaMon());
			pstm.setDate(3, java.sql.Date.valueOf(hoaDon.getNgayTaoHoaDon().atStartOfDay().toLocalDate()));
			pstm.setInt(4, hoaDon.getSoLuong());
			pstm.setFloat(5, hoaDon.getDongia());
			pstm.setFloat(6, hoaDon.getTongBill());
			return pstm.executeUpdate();
		}
	}

	public static int insertHoaDonList(Connection conn, List<HoaDon> hoaDonList) throws SQLException {
		String sql = "INSERT INTO HoaDon (MaHoaDon, MaMon, NgayTaoHoaDon, SoLuong, DonGia, TongBill, IDKhachHang, chinhanhID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			for (HoaDon hoaDon : hoaDonList) {
				pstm.setInt(1, hoaDon.getMaHoaDon());
				pstm.setInt(2, hoaDon.getMaMon());
				pstm.setDate(3, java.sql.Date.valueOf(hoaDon.getNgayTaoHoaDon().atStartOfDay().toLocalDate()));
				pstm.setInt(4, hoaDon.getSoLuong());
				pstm.setFloat(5, hoaDon.getDongia());
				pstm.setFloat(6, hoaDon.getTongBill());
				pstm.setInt(7, hoaDon.getIdKhachHang());
				pstm.setInt(8, hoaDon.getIdChiNhanh());
				pstm.addBatch();
			}
			return pstm.executeBatch().length;
		}
	}

	public static float getGiaTienByMaMon(Connection conn, int maMon) throws SQLException {
		String sql = "SELECT GiaTien FROM Menu WHERE MaMon = ?";
		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setInt(1, maMon);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					return rs.getFloat("GiaTien");
				}
			}
		}
		return 0.0f; // Trả về giá trị mặc định nếu không tìm thấy giá tiền
	}

	public static String getTenMonByMaMon(Connection conn, int maMon) throws SQLException {
		String sql = "SELECT TenMon FROM Menu WHERE MaMon = ?";
		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setInt(1, maMon);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					return rs.getString("TenMon");
				}
			}
		}
		return ""; // Trả về giá trị mặc định nếu không tìm thấy tên món
	}
	
	public static String getTenKHbyidKH(Connection conn, int idKhachHang) throws SQLException {
		String sql = "SELECT TenKhachHang FROM KhachHang WHERE IDKhachHang = ?";
		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setInt(1, idKhachHang);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					return rs.getString("TenKhachHang");
				}
			}
		}
		return ""; // Trả về giá trị mặc định nếu không tìm thấy tên món
	}
	
	public static String getTenCNbyidCN(Connection conn, int idChiNhanh) throws SQLException {
		String sql = "SELECT tenchinhanh FROM chinhanh WHERE chinhanhID = ?";
		try (PreparedStatement pstm = conn.prepareStatement(sql)) {
			pstm.setInt(1, idChiNhanh);
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					return rs.getString("tenchinhanh");
				}
			}
		}
		return ""; // Trả về giá trị mặc định nếu không tìm thấy tên món
	}
	
	 public static boolean kiemTraMaMonTonTai(Connection conn, int maMon) throws SQLException {
	        String sql = "SELECT COUNT(*) FROM Menu WHERE MaMon = ?";
	        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
	            pstm.setInt(1, maMon);
	            try (ResultSet rs = pstm.executeQuery()) {
	                if (rs.next()) {
	                    int count = rs.getInt(1);
	                    return count > 0;
	                }
	            }
	        }
	        return false;
	    }
	 public static int deleteHoaDon(Connection conn, int maHoaDon) throws SQLException {
	        String sql = "DELETE FROM HoaDon WHERE MaHoaDon = ?";
	        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
	            pstm.setInt(1, maHoaDon);
	            return pstm.executeUpdate();
	        }
	    }
	 public static List<HoaDon> selectHoaDonByMaHoaDon(Connection conn, int maHoaDon) throws SQLException {
		    List<HoaDon> hoaDonList = new ArrayList<>();
		    String sql = "SELECT * FROM HoaDon WHERE MaHoaDon = ?";

		    try (PreparedStatement pstm = conn.prepareStatement(sql)) {
		        pstm.setInt(1, maHoaDon);

		        try (ResultSet rs = pstm.executeQuery()) {
		            while (rs.next()) {
		            	HoaDon hoaDon = new HoaDon();
						hoaDon.setStt(rs.getInt("stt"));
						hoaDon.setMaHoaDon(rs.getInt("MaHoaDon"));
						hoaDon.setMaMon(rs.getInt("MaMon"));
						hoaDon.setNgayTaoHoaDon(rs.getDate("NgayTaoHoaDon"));
						hoaDon.setSoLuong(rs.getInt("SoLuong"));
						hoaDon.setDongia(rs.getFloat("Dongia"));
						hoaDon.setTongBill(rs.getFloat("TongBill"));
						

						// Sử dụng phương thức getTenMonByMaMon để lấy tên món từ Menu
						String tenMon = getTenMonByMaMon(conn, hoaDon.getMaMon());
						hoaDon.setTenMon(tenMon);
						
						hoaDon.setIdKhachHang(rs.getInt("IDKhachHang"));
						String tenKhachHang= getTenKHbyidKH(conn, hoaDon.getIdKhachHang());
						hoaDon.setTenKhachHang(tenKhachHang);
						
						hoaDon.setIdChiNhanh(rs.getInt("chinhanhID"));
						String tenChiNhanh= getTenCNbyidCN(conn, hoaDon.getIdChiNhanh());
						hoaDon.setTenChiNhanh(tenChiNhanh);;
						
						hoaDonList.add(hoaDon);
		            }
		        }
		    }
		    return hoaDonList;
		}
	 
	 //NGUYÊN LIỆU:
	 public static List<NguyenLieu> selectAllNguyenLieu(Connection conn) throws SQLException {
	        String sql = "SELECT * FROM nguyenlieu";

	        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

	            List<NguyenLieu> nguyenLieuList = new ArrayList<>();

	            while (rs.next()) {
	                NguyenLieu nl = new NguyenLieu(
	                        rs.getInt("IDNguyenLieu"),
	                        rs.getString("TenNguyenLieu"),
	                        rs.getInt("SoLuongNhap"),
	                        rs.getFloat("DonGiaNhap"),
	                        rs.getFloat("TongTienNhap"),
	                        rs.getDate("NgayNhap")
	                );
	                nguyenLieuList.add(nl);
	            }

	            return nguyenLieuList;
	        }
	    }
	 public static int insertNguyenLieu(Connection conn, NguyenLieu nguyenLieu) throws SQLException {
		    String sql = "INSERT INTO nguyenlieu (TenNguyenLieu, SoLuongNhap, DonGiaNhap, TongTienNhap, NgayNhap) VALUES (?, ?, ?, ?, ?)";

		    try (PreparedStatement ps = conn.prepareStatement(sql)) {
		        ps.setString(1, nguyenLieu.getTenNguyenLieu());
		        ps.setInt(2, nguyenLieu.getSoLuongNhap());
		        ps.setFloat(3, nguyenLieu.getDonGiaNhap());
		        ps.setFloat(4, nguyenLieu.getTongTienNhap());

		        // Chuyển đổi từ java.util.Date sang java.sql.Date
		        java.sql.Date ngayNhapSql = new java.sql.Date(nguyenLieu.getNgayNhap().getTime());
		        ps.setDate(5, ngayNhapSql);

		        return ps.executeUpdate();
		    }
		}
	 public static boolean isIdNguyenLieuInKiemKho(Connection conn, int idNguyenLieu) throws SQLException {
	        String sql = "SELECT * FROM KiemKho WHERE IDNguyenLieu = ?";
	        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
	            pstm.setInt(1, idNguyenLieu);
	            try (ResultSet rs = pstm.executeQuery()) {
	                return rs.next();
	            }
	        }
	    }

	    // Xóa một nguyên liệu dựa trên ID
	    public static int deleteNguyenLieu(Connection conn, int idNguyenLieu) throws SQLException {
	        // Kiểm tra xem IDNguyenLieu có trong bảng KiemKho hay không
	        if (isIdNguyenLieuInKiemKho(conn, idNguyenLieu)) {
	            throw new SQLException("Không thể xóa nguyên liệu: Nguyên liệu đang tồn tại trong kiểm kho.");
	        }

	        // Nếu không có trong KiemKho, thực hiện xóa từ bảng NguyenLieu
	        String sql = "DELETE FROM NguyenLieu WHERE IDNguyenLieu = ?";
	        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
	            pstm.setInt(1, idNguyenLieu);
	            return pstm.executeUpdate();
	        }
	    }
	 
	    public static NguyenLieu selectNguyenLieuById(Connection conn, int idNguyenLieu) throws SQLException {
	        String sql = "SELECT * FROM nguyenlieu WHERE IDNguyenLieu = ?";

	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, idNguyenLieu);

	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    String tenNguyenLieu = rs.getString("TenNguyenLieu");
	                    int soLuongNhap = rs.getInt("SoLuongNhap");
	                    float donGiaNhap = rs.getFloat("DonGiaNhap");
	                    float tongTienNhap = rs.getFloat("TongTienNhap");
	                    java.util.Date ngayNhap = rs.getDate("NgayNhap");

	                    return new NguyenLieu(idNguyenLieu, tenNguyenLieu, soLuongNhap, donGiaNhap, tongTienNhap, ngayNhap);
	                }
	            }
	        }
	        return null;
	    }

	    // Hàm cập nhật nguyên liệu
	    public static void updateNguyenLieu(Connection conn, NguyenLieu nguyenLieu) throws SQLException {
	        String sql = "UPDATE nguyenlieu SET TenNguyenLieu=?, SoLuongNhap=?, DonGiaNhap=?, TongTienNhap=?, NgayNhap=? WHERE IDNguyenLieu=?";

	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, nguyenLieu.getTenNguyenLieu());
	            ps.setInt(2, nguyenLieu.getSoLuongNhap());
	            ps.setFloat(3, nguyenLieu.getDonGiaNhap());
	            ps.setFloat(4, nguyenLieu.getTongTienNhap());

	            // Chuyển đổi từ java.util.Date sang java.sql.Date
	            java.sql.Date ngayNhapSql = new java.sql.Date(nguyenLieu.getNgayNhap().getTime());
	            ps.setDate(5, ngayNhapSql);

	            ps.setInt(6, nguyenLieu.getIDNguyenLieu());

	            ps.executeUpdate();
	        }
	    }
// Tạo list 
	    public static List<NguyenLieu> searchNguyenLieuByName(Connection conn, String tenNguyenLieu) throws SQLException {
	        String sql = "SELECT * FROM nguyenlieu WHERE TenNguyenLieu LIKE ?";
	        tenNguyenLieu = "%" + tenNguyenLieu + "%"; // Tìm kiếm mọi tên có chứa chuỗi nhập vào

	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, tenNguyenLieu);

	            List<NguyenLieu> nguyenLieuList = new ArrayList<>();

	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                    int idNguyenLieu = rs.getInt("IDNguyenLieu");
	                    String tenNguyenLieuDB = rs.getString("TenNguyenLieu");
	                    int soLuongNhap = rs.getInt("SoLuongNhap");
	                    float donGiaNhap = rs.getFloat("DonGiaNhap");
	                    float tongTienNhap = rs.getFloat("TongTienNhap");
	                    java.util.Date ngayNhap = rs.getDate("NgayNhap");

	                    NguyenLieu nguyenLieu = new NguyenLieu(idNguyenLieu, tenNguyenLieuDB, soLuongNhap, donGiaNhap, tongTienNhap, ngayNhap);
	                    nguyenLieuList.add(nguyenLieu);
	                }
	            }

	            return nguyenLieuList;
	        }
	    }
	    
	    public static List<ChiNhanh> selectAllChiNhanh(Connection conn) throws SQLException {
			String sql = "SELECT * FROM chinhanh";

			try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

				List<ChiNhanh> chinhanhList = new ArrayList<>();

				while (rs.next()) {
					ChiNhanh cn = new ChiNhanh(rs.getInt("chinhanhID"), rs.getString("tenchinhanh"), rs.getString("diachi"), rs.getInt("sdt"));
					chinhanhList.add(cn);
				}

				return chinhanhList;
			}
		}
//	    public static int insertChiNhanh(Connection conn, ChiNhanh cn) throws SQLException {
//			String sql = "INSERT INTO chinhanh (chinhanhID, tenchinhanh, diachi, sdt) VALUES (?, ?, ?, ?)";
//			try (PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//				pstm.setInt(1, cn.getChinhanhID());
//				pstm.setString(2, cn.getTenchinhanh());
//				pstm.setString(3, cn.getDiachi());
//				pstm.setInt(4, cn.getSdt());
//
//				int rowsAffected = pstm.executeUpdate();
//
//				if (rowsAffected > 0) {
//					try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
//						if (generatedKeys.next()) {
//							cn.setChinhanhID(generatedKeys.getInt(1));;
//						}
//					}
//				}
//
//				return rowsAffected;
//			}
//		}
}
