package Model;

import java.time.LocalDate;
import java.util.Date;

public class HoaDon {
    private int stt;
    private int maHoaDon;
    private int maMon;
    private String tenMon;
    private LocalDate ngayTaoHoaDon;
    private int soLuong;
    private float dongia;
    private float tongBill;
    private int idKhachHang;
    private String tenKhachHang;
    private int idChiNhanh;
    private String tenChiNhanh;
    
    public HoaDon() {
        // Constructor mặc định
    }

    public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public HoaDon(int maHoaDon, int maMon, String tenMon, LocalDate ngayTaoHoaDon2, int soLuong, float dongia,
			float tongBill) {
		super();
		this.maHoaDon = maHoaDon;
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.ngayTaoHoaDon = ngayTaoHoaDon2;
		this.soLuong = soLuong;
		this.dongia = dongia;
		this.tongBill = tongBill;
	}

	public HoaDon(int stt, int maHoaDon, int maMon, LocalDate ngayTaoHoaDon, int soLuong, float dongia, float tongBill,
                  int trangThaiHoaDon, int idKhachHang) {
        this.stt = stt;
        this.maHoaDon = maHoaDon;
        this.maMon = maMon;
        this.ngayTaoHoaDon = ngayTaoHoaDon;
        this.soLuong = soLuong;
        this.dongia = dongia;
        this.tongBill = tongBill;

    }

	public HoaDon(int stt, int maHoaDon, int maMon, String tenMon, LocalDate ngayTaoHoaDon, int soLuong, float dongia,
			float tongBill, int idKhachHang, String tenKhachHang) {
		super();
		this.stt = stt;
		this.maHoaDon = maHoaDon;
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.ngayTaoHoaDon = ngayTaoHoaDon;
		this.soLuong = soLuong;
		this.dongia = dongia;
		this.tongBill = tongBill;
		this.idKhachHang = idKhachHang;
		this.tenKhachHang = tenKhachHang;
	}

	public HoaDon(int stt, int maHoaDon, int maMon, String tenMon, LocalDate ngayTaoHoaDon, int soLuong, float dongia,
			float tongBill, int idKhachHang, String tenKhachHang, int idChiNhanh, String tenChiNhanh) {
		super();
		this.stt = stt;
		this.maHoaDon = maHoaDon;
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.ngayTaoHoaDon = ngayTaoHoaDon;
		this.soLuong = soLuong;
		this.dongia = dongia;
		this.tongBill = tongBill;
		this.idKhachHang = idKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.idChiNhanh = idChiNhanh;
		this.tenChiNhanh = tenChiNhanh;
	}

	// Getter và setter cho các thuộc tính

    public int getStt() {
        return stt;
    }

    

	public HoaDon(int maHoaDon, int maMon, LocalDate ngayTaoHoaDon, int soLuong, float dongia, float tongBill,
			int trangThaiHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
		this.maMon = maMon;
		this.ngayTaoHoaDon = ngayTaoHoaDon;
		this.soLuong = soLuong;
		this.dongia = dongia;
		this.tongBill = tongBill;
	
	}

	public void setStt(int stt) {
        this.stt = stt;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public LocalDate getNgayTaoHoaDon() {
        return ngayTaoHoaDon;
    }

    public void setNgayTaoHoaDon(LocalDate ngayTaoHoaDon) {
        this.ngayTaoHoaDon = ngayTaoHoaDon;
      }

      public void setNgayTaoHoaDon(java.sql.Date sqlDate) {
        this.ngayTaoHoaDon = sqlDate.toLocalDate(); // Convert to LocalDate before storing
      }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public float getTongBill() {
        return tongBill;
    }

    public void setTongBill(float tongBill) {
        this.tongBill = tongBill;
    }

	public int getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public int getIdChiNhanh() {
		return idChiNhanh;
	}

	public void setIdChiNhanh(int idChiNhanh) {
		this.idChiNhanh = idChiNhanh;
	}

	public String getTenChiNhanh() {
		return tenChiNhanh;
	}

	public void setTenChiNhanh(String tenChiNhanh) {
		this.tenChiNhanh = tenChiNhanh;
	}


}
