package Model;

public class ChiNhanh {
	private int chinhanhID;
	private String tenchinhanh;
	private String diachi;
	private int sdt;
	
	public ChiNhanh() {
		super();
	}

	public ChiNhanh(int chinhanhID, String tenchinhanh, String diachi, int sdt) {
		super();
		this.chinhanhID = chinhanhID;
		this.tenchinhanh = tenchinhanh;
		this.diachi = diachi;
		this.sdt = sdt;
	}

	public int getChinhanhID() {
		return chinhanhID;
	}

	public void setChinhanhID(int chinhanhID) {
		this.chinhanhID = chinhanhID;
	}

	public String getTenchinhanh() {
		return tenchinhanh;
	}

	public void setTenchinhanh(String tenchinhanh) {
		this.tenchinhanh = tenchinhanh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	
}
