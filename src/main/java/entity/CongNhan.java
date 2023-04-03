package entity;

import java.util.Date;

public class CongNhan {
	private String maCongNhan;
	private String tenCongNhan;
	private String soDienThoai;
	private DiaChi diaChi;
	private Date ngayVaoLam;
	private Date ngaySinh;
	private String gioiTinh;
	private ToNhom toNhom;
	public String getMaCongNhan() {
		return maCongNhan;
	}
	public void setMaCongNhan(String maCongNhan) {
		this.maCongNhan = maCongNhan;
	}
	public String getTenCongNhan() {
		return tenCongNhan;
	}
	public void setTenCongNhan(String tenCongNhan) {
		this.tenCongNhan = tenCongNhan;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public DiaChi getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}
	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public ToNhom getToNhom() {
		return toNhom;
	}
	public void setToNhom(ToNhom toNhom) {
		this.toNhom = toNhom;
	}
	public CongNhan(String maCongNhan, String tenCongNhan, String soDienThoai, DiaChi diaChi, Date ngayVaoLam,
			Date ngaySinh, String gioiTinh, ToNhom toNhom) {
		super();
		this.maCongNhan = maCongNhan;
		this.tenCongNhan = tenCongNhan;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.ngayVaoLam = ngayVaoLam;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.toNhom = toNhom;
	}
	public CongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maCongNhan == null) ? 0 : maCongNhan.hashCode());
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
		CongNhan other = (CongNhan) obj;
		if (maCongNhan == null) {
			if (other.maCongNhan != null)
				return false;
		} else if (!maCongNhan.equals(other.maCongNhan))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CongNhan [maCongNhan=" + maCongNhan + ", tenCongNhan=" + tenCongNhan + ", soDienThoai=" + soDienThoai
				+ ", diaChi=" + diaChi + ", ngayVaoLam=" + ngayVaoLam + ", ngaySinh=" + ngaySinh + ", gioiTinh="
				+ gioiTinh + ", toNhom=" + toNhom + "]";
	}
	
}
