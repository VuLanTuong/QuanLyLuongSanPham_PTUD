package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connectdb.ConnectDB;
import entity.BangPhanCongCongNhan;
import entity.CongDoanSanPham;
import entity.CongNhan;

public class BangPhanCongCongNhanDAO {
	private Connection con;
	private NhanVienDAO nhanVienDAO;
	private CongDoanSanPhamDAO congDoanSanPhamDAO;
	private CongNhanDAO congNhanDAO;
	private DiaChiDAO diaChiDAO;
	private ToNhomDAO toNhomDAO;
	
	public BangPhanCongCongNhanDAO() {
		con = ConnectDB.getInstance().getConnection();
		nhanVienDAO = new NhanVienDAO();
		congDoanSanPhamDAO = new CongDoanSanPhamDAO();
		congNhanDAO = new CongNhanDAO();
		diaChiDAO = new DiaChiDAO();
		toNhomDAO = new ToNhomDAO();
	}
	public BangPhanCongCongNhan timPhanCongCongNhan(String maPCCN) {
		BangPhanCongCongNhan bangPhanCong = null;
		String sql = "select * from PHANCONGCONGNHAN where maPhanCong = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, maPCCN);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				bangPhanCong = new BangPhanCongCongNhan(rs.getString(1), rs.getDate(2), 
						rs.getString(3), rs.getInt(4), congDoanSanPhamDAO.timCongDoan(rs.getString(5)), 
						congNhanDAO.timCongNhanBangMaCongNhan(rs.getString(6)), 
						nhanVienDAO.timNhanVienBangMaNhanVien(rs.getString(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bangPhanCong;
	}
	
	public BangPhanCongCongNhan timPhanCongCongNhanBangMaCongNhan(String maCongNhan) {
		BangPhanCongCongNhan bangPhanCong = null;
		String sql = "select * from PHANCONGCONGNHAN where maCongNhan = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, maCongNhan);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				bangPhanCong = new BangPhanCongCongNhan(rs.getString(1), rs.getDate(2), 
						rs.getString(3), rs.getInt(4), congDoanSanPhamDAO.timCongDoan(rs.getString(5)), 
						congNhanDAO.timCongNhanBangMaCongNhan(rs.getString(6)), 
						nhanVienDAO.timNhanVienBangMaNhanVien(rs.getString(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bangPhanCong;
	}

	
}
