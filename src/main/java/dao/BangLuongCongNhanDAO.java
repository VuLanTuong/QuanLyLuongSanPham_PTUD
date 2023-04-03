package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.BangLuongCongNhan;
import entity.BangLuongNhanVien;

public class BangLuongCongNhanDAO {
	private Connection con;
	private CongNhanDAO congNhanDao;
	
	public BangLuongCongNhanDAO() {
		con = connectdb.ConnectDB.getInstance().getConnection();
		congNhanDao = new CongNhanDAO();
	}
	
	public BangLuongCongNhan timBangLuongCN(String maBangLuong) throws Exception {
		String sql = "select * from BangLuongCongNhan where maBangLuong = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, maBangLuong);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new BangLuongCongNhan(rs.getString("maBangLuong"), congNhanDao.timCongNhanBangMaCongNhan(rs.getString("maCongNhan")), 
						rs.getDate("ngayLapBangLuong"), rs.getDouble("tongLuong"));
			}
		}
		return null;
	}
	
	public List<BangLuongCongNhan> layDanhSachBangLuongCN() {
		List<BangLuongCongNhan> dsBLCN = new ArrayList<>();
		BangLuongCongNhan bangLuongCongNhan;
		String sql = "select * from BangLuongCongNhan";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				bangLuongCongNhan = new BangLuongCongNhan(rs.getString("maBangLuong"), congNhanDao.timCongNhanBangMaCongNhan(rs.getString("maCongNhan")), 
						rs.getDate("ngayLapBangLuong"), rs.getDouble("tongLuong"));
				dsBLCN.add(bangLuongCongNhan);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsBLCN;
	}
}
