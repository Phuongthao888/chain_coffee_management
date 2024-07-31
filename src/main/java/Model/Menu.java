package Model;

public class Menu {
	public  int MaMon;
    private String TenMon;
    private String MoTaMon;
    private float GiaTien;
    private String HinhAnh;
    private String NguyenLieuCanThiet;
	public Menu() {
		super();
	}
	public Menu(int maMon, String tenMon, String moTaMon, float giaTien, String hinhAnh, String nguyenLieuCanThiet) {
		super();
		MaMon = maMon;
		TenMon = tenMon;
		MoTaMon = moTaMon;
		GiaTien = giaTien;
		HinhAnh = hinhAnh;
		NguyenLieuCanThiet = nguyenLieuCanThiet;
	}
	public Menu(String tenMon, String moTaMon, float giaTien, String hinhAnh, String nguyenLieuCanThiet) {
		super();
		TenMon = tenMon;
		MoTaMon = moTaMon;
		GiaTien = giaTien;
		HinhAnh = hinhAnh;
		NguyenLieuCanThiet = nguyenLieuCanThiet;
	}
	public int getMaMon() {
		return MaMon;
	}
	public void setMaMon(int maMon) {
		MaMon = maMon;
	}
	public String getTenMon() {
		return TenMon;
	}
	public void setTenMon(String tenMon) {
		TenMon = tenMon;
	}
	public String getMoTaMon() {
		return MoTaMon;
	}
	public void setMoTaMon(String moTaMon) {
		MoTaMon = moTaMon;
	}
	public float getGiaTien() {
		return GiaTien;
	}
	public void setGiaTien(float giaTien) {
		GiaTien = giaTien;
	}
	public String getHinhAnh() {
		return HinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}
	public String getNguyenLieuCanThiet() {
		return NguyenLieuCanThiet;
	}
	public void setNguyenLieuCanThiet(String nguyenLieuCanThiet) {
		NguyenLieuCanThiet = nguyenLieuCanThiet;
	}
}
