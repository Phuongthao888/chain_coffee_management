package Model;

public class khachhang {
	private int IDKhachHang;
	private String TenKhachHang;
	private int SoLanThanhToan;
	private String SDT;
	private String DiaChi;
	private String username;
	public int getIDKhachHang() {
		return IDKhachHang;
	}
	public void setIDKhachHang(int iDKhachHang) {
		IDKhachHang = iDKhachHang;
	}
	public String getTenKhachHang() {
		return TenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}
	public int getSoLanThanhToan() {
		return SoLanThanhToan;
	}
	public void setSoLanThanhToan(int soLanThanhToan) {
		SoLanThanhToan = soLanThanhToan;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String SDT) {
		this.SDT= SDT;
	}
	public khachhang(int iDKhachHang, String tenKhachHang, int soLanThanhToan, String diaChi, String username,
			String SDT) {
		super();
		IDKhachHang = iDKhachHang;
		TenKhachHang = tenKhachHang;
		SoLanThanhToan = soLanThanhToan;
		DiaChi = diaChi;
		this.username = username;
		this.SDT = SDT;
	}
	
	public khachhang(String tenKhachHang, int soLanThanhToan, String sDT, String diaChi) {
		super();
		TenKhachHang = tenKhachHang;
		SoLanThanhToan = soLanThanhToan;
		DiaChi = diaChi;
		SDT = sDT;
	}
	public khachhang(int iDKhachHang, String tenKhachHang, int soLanThanhToan, String sDT, String diaChi) {
		super();
		IDKhachHang = iDKhachHang;
		TenKhachHang = tenKhachHang;
		SoLanThanhToan = soLanThanhToan;
		SDT = sDT;
		DiaChi = diaChi;
	}
	public khachhang(String userName, String SDT) {
		super();
		this.username = userName;
		this.SDT = SDT;
	}
	public khachhang(khachhang us) {
		super();
		this.username = us.username;
		this.SDT = us.SDT;
	}
	public khachhang() {
		super();
	}
}
