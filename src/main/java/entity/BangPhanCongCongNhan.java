package entity;

import java.util.Date;

public class BangPhanCongCongNhan {
	private String maPhanCong;
	private Date ngayPhanCong;
	private String caLam;
	private int soLuongPhanCong;
	private CongDoanSanPham congDoan;
	private CongNhan congNhan;
	private NhanVien nguoiPhanCong;
	public String getMaPhanCong() {
		return maPhanCong;
	}
	public void setMaPhanCong(String maPhanCong) {
		this.maPhanCong = maPhanCong;
	}
	public Date getNgayPhanCong() {
		return ngayPhanCong;
	}
	public void setNgayPhanCong(Date ngayPhanCong) {
		this.ngayPhanCong = ngayPhanCong;
	}
	public String getCaLam() {
		return caLam;
	}
	public void setCaLam(String caLam) {
		this.caLam = caLam;
	}
	public int getSoLuongPhanCong() {
		return soLuongPhanCong;
	}
	public void setSoLuongPhanCong(int soLuongPhanCong) {
		this.soLuongPhanCong = soLuongPhanCong;
	}
	public CongDoanSanPham getCongDoan() {
		return congDoan;
	}
	public void setCongDoan(CongDoanSanPham congDoan) {
		this.congDoan = congDoan;
	}
	public CongNhan getCongNhan() {
		return congNhan;
	}
	public void setCongNhan(CongNhan congNhan) {
		this.congNhan = congNhan;
	}
	public NhanVien getNguoiPhanCong() {
		return nguoiPhanCong;
	}
	public void setNguoiPhanCong(NhanVien nguoiPhanCong) {
		this.nguoiPhanCong = nguoiPhanCong;
	}
	public BangPhanCongCongNhan(String maPhanCong, Date ngayPhanCong, String caLam, int soLuongPhanCong,
			CongDoanSanPham congDoan, CongNhan congNhan, NhanVien nguoiPhanCong) {
		super();
		this.maPhanCong = maPhanCong;
		this.ngayPhanCong = ngayPhanCong;
		this.caLam = caLam;
		this.soLuongPhanCong = soLuongPhanCong;
		this.congDoan = congDoan;
		this.congNhan = congNhan;
		this.nguoiPhanCong = nguoiPhanCong;
	}
	public BangPhanCongCongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BangPhanCongCongNhan [maPhanCong=" + maPhanCong + ", ngayPhanCong=" + ngayPhanCong + ", caLam=" + caLam
				+ ", soLuongPhanCong=" + soLuongPhanCong + ", congDoan=" + congDoan + ", congNhan=" + congNhan
				+ ", nguoiPhanCong=" + nguoiPhanCong + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhanCong == null) ? 0 : maPhanCong.hashCode());
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
		BangPhanCongCongNhan other = (BangPhanCongCongNhan) obj;
		if (maPhanCong == null) {
			if (other.maPhanCong != null)
				return false;
		} else if (!maPhanCong.equals(other.maPhanCong))
			return false;
		return true;
	}
	
}
