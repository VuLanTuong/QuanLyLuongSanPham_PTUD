package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connectdb.ConnectDB;
import entity.BangChamCongNhanVien;

public class BangChamCongNhanVienDAO {
	private Connection con;
	private NhanVienDAO nhanVienDAO;
	public BangChamCongNhanVienDAO() {
		// TODO Auto-generated constructor stub
		con = ConnectDB.getInstance().getConnection();
		nhanVienDAO = new NhanVienDAO();
	}
	public List<BangChamCongNhanVien> layDanhSachCCNV(){
		List<BangChamCongNhanVien> dsCCNV = new ArrayList<>();
		String sql = "select * from CHAMCONGNHANVIEN";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				BangChamCongNhanVien chamCongNV = new BangChamCongNhanVien(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), 
						nhanVienDAO.timNhanVienBangMaNhanVien(rs.getString(5)), nhanVienDAO.timNhanVienBangMaNhanVien(rs.getString(6)));
				dsCCNV.add(chamCongNV);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCCNV;
	}
}
