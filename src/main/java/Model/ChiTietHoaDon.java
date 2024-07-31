package Model;

public class ChiTietHoaDon {
    private int maHoaDon;
    private int maMon;
    private int soLuong;

    // Getter và Setter cho các thuộc tính

    public ChiTietHoaDon(int maHoaDon, int maMon, int soLuong) {
        // Constructor
        this.maHoaDon = maHoaDon;
        this.maMon = maMon;
        this.soLuong = soLuong;
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

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
    
}
