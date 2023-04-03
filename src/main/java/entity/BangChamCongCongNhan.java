package entity;

import java.util.Date;

public class BangChamCongCongNhan {
	private String maChamCong;
	private Date ngayChamCong;
	private int soLuongLam;
	private String trangThai;
	private BangPhanCongCongNhan phanCong;
	private NhanVien nguoiChamCong;
	
	public String getMaChamCong() {
		return maChamCong;
	}
	public void setMaChamCong(String maChamCong) {
		this.maChamCong = maChamCong;
	}
	public Date getNgayChamCong() {
		return ngayChamCong;
	}
	public void setNgayChamCong(Date ngayChamCong) {
		this.ngayChamCong = ngayChamCong;
	}
	public int getSoLuongLam() {
		return soLuongLam;
	}
	public void setSoLuongLam(int soLuongLam) {
		this.soLuongLam = soLuongLam;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public BangPhanCongCongNhan getPhanCong() {
		return phanCong;
	}
	public void setPhanCong(BangPhanCongCongNhan phanCong) {
		this.phanCong = phanCong;
	}
	public NhanVien getNguoiChamCong() {
		return nguoiChamCong;
	}
	public void setNguoiChamCong(NhanVien nguoiChamCong) {
		this.nguoiChamCong = nguoiChamCong;
	}
	public BangChamCongCongNhan(String maChamCong, Date ngayChamCong, int soLuongLam, String trangThai,
			BangPhanCongCongNhan phanCong, NhanVien nguoiChamCong) {
		super();
		this.maChamCong = maChamCong;
		this.ngayChamCong = ngayChamCong;
		this.soLuongLam = soLuongLam;
		this.trangThai = trangThai;
		this.phanCong = phanCong;
		this.nguoiChamCong = nguoiChamCong;
	}
	public BangChamCongCongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BangChamCongCongNhan [maChamCong=" + maChamCong + ", ngayChamCong=" + ngayChamCong + ", soLuongLam="
				+ soLuongLam + ", trangThai=" + trangThai + ", phanCong=" + phanCong + ", nguoiChamCong="
				+ nguoiChamCong + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maChamCong == null) ? 0 : maChamCong.hashCode());
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
		BangChamCongCongNhan other = (BangChamCongCongNhan) obj;
		if (maChamCong == null) {
			if (other.maChamCong != null)
				return false;
		} else if (!maChamCong.equals(other.maChamCong))
			return false;
		return true;
	}
	
}
