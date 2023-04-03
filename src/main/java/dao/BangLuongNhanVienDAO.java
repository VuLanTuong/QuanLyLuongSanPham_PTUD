package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.BangLuongNhanVien;

public class BangLuongNhanVienDAO {
	private Connection con;
	private NhanVienDAO nhanVienDao;
	
	public BangLuongNhanVienDAO() {
		con = connectdb.ConnectDB.getInstance().getConnection();
		nhanVienDao = new NhanVienDAO();
	}
	
	public BangLuongNhanVien timBangLuongNV(String maBangLuong) throws Exception {
		String sql = "select * from BangLuongNhanVien where maBangLuong = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, maBangLuong);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new BangLuongNhanVien(rs.getString("maBangLuong"), nhanVienDao.timNhanVienBangMaNhanVien(rs.getString("maNhanVien")), rs.getDate("ngayTinhLuong"),
						rs.getDouble("luongCoBan"), rs.getDouble("phuCap"), rs.getDouble("heSoLuong"));
			}
		}
		
		return null;
	}
	
	public List<BangLuongNhanVien> layDanhSachBangLuongNV() {
		List<BangLuongNhanVien> dsBLNV = new ArrayList<>();
		String sql = "select * from BangLuongNhanVien";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				BangLuongNhanVien blnv = new BangLuongNhanVien(rs.getString("maBangLuong"), nhanVienDao.timNhanVienBangMaNhanVien(rs.getString("maNhanVien")), rs.getDate("ngayTinhLuong"), 
						rs.getDouble("luongCoBan"), rs.getDouble("phuCap"), rs.getDouble("heSoLuong"));
				dsBLNV.add(blnv);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsBLNV;
	}
	
	
	public static void main(String[] args) {
		BangLuongNhanVienDAO bangLuongNhanVienDAO = new BangLuongNhanVienDAO();
		List<BangLuongNhanVien> ds = bangLuongNhanVienDAO.layDanhSachBangLuongNV();
		System.out.println(ds);
	}
}

