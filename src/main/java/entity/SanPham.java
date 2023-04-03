package entity;

import java.util.Objects;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private double giaTien;
	private String moTa;	
	private int soLuongSanXuat;	
	private String chatLieu;
	private String kichThuoc;	
	private int soLuongCongDoan;
	private String anhSanPham;
	public String getChatLieu() {
		return chatLieu;
	}
	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public double getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public int getSoLuongSanXuat() {
		return soLuongSanXuat;
	}
	public void setSoLuongSanXuat(int soLuongSanXuat) {
		this.soLuongSanXuat = soLuongSanXuat;
	}
	public String getKichThuoc() {
		return kichThuoc;
	}
	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}
	public int getSoLuongCongDoan() {
		return soLuongCongDoan;
	}
	public void setSoLuongCongDoan(int soLuongCongDoan) {
		this.soLuongCongDoan = soLuongCongDoan;
	}
	public String getAnhSanPham() {
		return anhSanPham;
	}
	public void setAnhSanPham(String anhSanPham) {
		this.anhSanPham = anhSanPham;
	}
	public SanPham(String maSanPham, String tenSanPham, double giaTien, String moTa, int soLuongSanXuat,
			String chatLieu, String kichThuoc, int soLuongCongDoan, String anhSanPham) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.giaTien = giaTien;
		this.moTa = moTa;
		this.soLuongSanXuat = soLuongSanXuat;
		this.chatLieu = chatLieu;
		this.kichThuoc = kichThuoc;
		this.soLuongCongDoan = soLuongCongDoan;
		this.anhSanPham = anhSanPham;
	}
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", giaTien=" + giaTien + ", moTa="
				+ moTa + ", soLuongSanXuat=" + soLuongSanXuat + ", chatLieu=" + chatLieu + ", kichThuoc=" + kichThuoc
				+ ", soLuongCongDoan=" + soLuongCongDoan + ", anhSanPham=" + anhSanPham + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSanPham);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSanPham, other.maSanPham);
	}
	
	
}
