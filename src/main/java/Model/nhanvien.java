package Model;

import java.util.Date;

public class nhanvien {
	private int IDNhanVien;
	private String TenNhanVien;
	private Date NgaySinh;
	private int SDT;
	private String User;
	private String Password;
	private String ChucVu;

	// Constructors
	public nhanvien() {
	}

	public nhanvien(int IDNhanVien, String TenNhanVien, Date NgaySinh, int SDT, String User, String Password,
			String ChucVu) {
		this.IDNhanVien = IDNhanVien;
		this.TenNhanVien = TenNhanVien;
		this.NgaySinh = NgaySinh;
		this.SDT = SDT;
		this.User = User;
		this.Password = Password;
		this.ChucVu = ChucVu;
	}

	

	public nhanvien(String user, String password) {
		super();
		User = user;
		Password = password;
	}
	public nhanvien(nhanvien u) {
		super();
		this.User = u.User;
		this.Password = u.Password;
	}
	// Getter and Setter methods
	public int getIDNhanVien() {
		return IDNhanVien;
	}

	public void setIDNhanVien(int IDNhanVien) {
		this.IDNhanVien = IDNhanVien;
	}

	public String getTenNhanVien() {
		return TenNhanVien;
	}

	public void setTenNhanVien(String TenNhanVien) {
		this.TenNhanVien = TenNhanVien;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date NgaySinh) {
		this.NgaySinh = NgaySinh;
	}

	public int getSDT() {
		return SDT;
	}

	public void setSDT(int SDT) {
		this.SDT = SDT;
	}

	public nhanvien(String tenNhanVien, Date ngaySinh, int sDT, String user, String password, String chucVu) {
		super();
		TenNhanVien = tenNhanVien;
		NgaySinh = ngaySinh;
		SDT = sDT;
		User = user;
		Password = password;
		ChucVu = chucVu;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String User) {
		this.User = User;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getChucVu() {
		return ChucVu;
	}

	public void setChucVu(String ChucVu) {
		this.ChucVu = ChucVu;
	}
}
