package Model;

import java.util.Date;

public class NguyenLieu {
    private int IDNguyenLieu;
    private String TenNguyenLieu;
    private int SoLuongNhap;
    private float DonGiaNhap;
    private float TongTienNhap;
    private Date NgayNhap;

    // Constructors
    public NguyenLieu() {
    }

    public NguyenLieu(String tenNguyenLieu, int soLuongNhap, float donGiaNhap, float tongTienNhap, Date ngayNhap) {
		super();
		TenNguyenLieu = tenNguyenLieu;
		SoLuongNhap = soLuongNhap;
		DonGiaNhap = donGiaNhap;
		TongTienNhap = tongTienNhap;
		NgayNhap = ngayNhap;
	}

	public NguyenLieu(int IDNguyenLieu, String TenNguyenLieu, int SoLuongNhap, float DonGiaNhap, float TongTienNhap, Date NgayNhap) {
        this.IDNguyenLieu = IDNguyenLieu;
        this.TenNguyenLieu = TenNguyenLieu;
        this.SoLuongNhap = SoLuongNhap;
        this.DonGiaNhap = DonGiaNhap;
        this.TongTienNhap = TongTienNhap;
        this.NgayNhap = NgayNhap;
    }

    // Getters and Setters
    public int getIDNguyenLieu() {
        return IDNguyenLieu;
    }

    public void setIDNguyenLieu(int IDNguyenLieu) {
        this.IDNguyenLieu = IDNguyenLieu;
    }

    public String getTenNguyenLieu() {
        return TenNguyenLieu;
    }

    public void setTenNguyenLieu(String TenNguyenLieu) {
        this.TenNguyenLieu = TenNguyenLieu;
    }

    public int getSoLuongNhap() {
        return SoLuongNhap;
    }

    public void setSoLuongNhap(int SoLuongNhap) {
        this.SoLuongNhap = SoLuongNhap;
    }

    public float getDonGiaNhap() {
        return DonGiaNhap;
    }

    public void setDonGiaNhap(float DonGiaNhap) {
        this.DonGiaNhap = DonGiaNhap;
    }

    public float getTongTienNhap() {
        return TongTienNhap;
    }

    public void setTongTienNhap(float TongTienNhap) {
        this.TongTienNhap = TongTienNhap;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }
    
}
