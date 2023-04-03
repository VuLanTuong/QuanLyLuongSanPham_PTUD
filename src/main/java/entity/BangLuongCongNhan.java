package entity;

import java.util.Date;
import java.util.Objects;

public class BangLuongCongNhan {
	private String maBangLuong;
	private CongNhan congNhan;
	private Date ngayLapBangLuong;
	private double tongLuong;
	

	
	
	public String getMaBangLuong() {
		return maBangLuong;
	}
	public void setMaBangLuong(String maBangLuong) {
		this.maBangLuong = maBangLuong;
	}
	public CongNhan getCongNhan() {
		return congNhan;
	}
	public void setCongNhan(CongNhan congNhan) {
		this.congNhan = congNhan;
	}
	public Date getNgayLapBangLuong() {
		return ngayLapBangLuong;
	}
	public void setNgayLapBangLuong(Date ngayLapBangLuong) {
		this.ngayLapBangLuong = ngayLapBangLuong;
	}
	public double getTongLuong() {
		return tongLuong;
	}
	public void setTongLuong(double tongLuong) {
		this.tongLuong = tongLuong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maBangLuong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BangLuongCongNhan other = (BangLuongCongNhan) obj;
		return Objects.equals(maBangLuong, other.maBangLuong);
	}
	public BangLuongCongNhan(String maBangLuong, CongNhan congNhan, Date ngayLapBangLuong, double tongLuong) {
		super();
		this.maBangLuong = maBangLuong;
		this.congNhan = congNhan;
		this.ngayLapBangLuong = ngayLapBangLuong;
		this.tongLuong = tongLuong;
	}
	public BangLuongCongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BangLuongCongNhan [maBangLuong=" + maBangLuong + ", congNhan=" + congNhan + ", ngayLapBangLuong="
				+ ngayLapBangLuong + ", tongLuong=" + tongLuong + "]";
	}
	
	
	
}