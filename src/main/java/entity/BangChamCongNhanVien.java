package entity;

import java.util.Date;

public class BangChamCongNhanVien {
	private String maChamCong;
	private String caLam;
	private Date ngayChamCong;
	private String trangThai;
	private NhanVien nguoiChamCong;
	private NhanVien nhanVien;
	public String getMaChamCong() {
		return maChamCong;
	}
	public void setMaChamCong(String maChamCong) {
		this.maChamCong = maChamCong;
	}
	public String getCaLam() {
		return caLam;
	}
	public void setCaLam(String caLam) {
		this.caLam = caLam;
	}
	public Date getNgayChamCong() {
		return ngayChamCong;
	}
	public void setNgayChamCong(Date ngayChamCong) {
		this.ngayChamCong = ngayChamCong;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public NhanVien getNguoiChamCong() {
		return nguoiChamCong;
	}
	public void setNguoiChamCong(NhanVien nguoiChamCong) {
		this.nguoiChamCong = nguoiChamCong;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public BangChamCongNhanVien(String maChamCong, String caLam, Date ngayChamCong, String trangThai,
			NhanVien nguoiChamCong, NhanVien nhanVien) {
		super();
		this.maChamCong = maChamCong;
		this.caLam = caLam;
		this.ngayChamCong = ngayChamCong;
		this.trangThai = trangThai;
		this.nguoiChamCong = nguoiChamCong;
		this.nhanVien = nhanVien;
	}
	public BangChamCongNhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BangChamCongNhanVien [maChamCong=" + maChamCong + ", caLam=" + caLam + ", ngayChamCong=" + ngayChamCong
				+ ", trangThai=" + trangThai + ", nguoiChamCong=" + nguoiChamCong + ", nhanVien=" + nhanVien + "]";
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
		BangChamCongNhanVien other = (BangChamCongNhanVien) obj;
		if (maChamCong == null) {
			if (other.maChamCong != null)
				return false;
		} else if (!maChamCong.equals(other.maChamCong))
			return false;
		return true;
	}
	
}
