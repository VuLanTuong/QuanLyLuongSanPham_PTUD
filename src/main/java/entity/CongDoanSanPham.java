package entity;

public class CongDoanSanPham {
	private String maCongDoan;
	private String tenCongDoan;
	private double tienCongDoan;
	private int soLuong;
	private String tinhTrang;
	private String moTa;
	private SanPham sanPham;
	public String getMaCongDoan() {
		return maCongDoan;
	}
	public void setMaCongDoan(String maCongDoan) {
		this.maCongDoan = maCongDoan;
	}
	public String getTenCongDoan() {
		return tenCongDoan;
	}
	public void setTenCongDoan(String tenCongDoan) {
		this.tenCongDoan = tenCongDoan;
	}
	public double getTienCongDoan() {
		return tienCongDoan;
	}
	public void setTienCongDoan(double tienCongDoan) {
		this.tienCongDoan = tienCongDoan;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public CongDoanSanPham(String maCongDoan, String tenCongDoan, double tienCongDoan, int soLuong, String tinhTrang,
			String moTa, SanPham sanPham) {
		super();
		this.maCongDoan = maCongDoan;
		this.tenCongDoan = tenCongDoan;
		this.tienCongDoan = tienCongDoan;
		this.soLuong = soLuong;
		this.tinhTrang = tinhTrang;
		this.moTa = moTa;
		this.sanPham = sanPham;
	}
	public CongDoanSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CongDoanSanPham [maCongDoan=" + maCongDoan + ", tenCongDoan=" + tenCongDoan + ", tienCongDoan="
				+ tienCongDoan + ", soLuong=" + soLuong + ", tinhTrang=" + tinhTrang + ", moTa=" + moTa + ", sanPham="
				+ sanPham + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maCongDoan == null) ? 0 : maCongDoan.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CongDoanSanPham other = (CongDoanSanPham) obj;
		if (maCongDoan == null) {
			if (other.maCongDoan != null)
				return false;
		} else if (!maCongDoan.equals(other.maCongDoan))
			return false;
		return true;
	}
	
}
