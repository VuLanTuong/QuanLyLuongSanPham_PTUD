package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connectdb.ConnectDB;
import entity.BangChamCongCongNhan;
import entity.CongNhan;
import entity.NhanVien;

public class BangChamCongCongNhanDAO {
	private Connection con;
	private BangPhanCongCongNhanDAO bangPhanCongCongNhanDAO;
	private NhanVienDAO nhanVienDAO;
	private DiaChiDAO diaChiDAO;
	private ToNhomDAO toNhomDAO;
	
	
	
	public BangChamCongCongNhanDAO() {
		// TODO Auto-generated constructor stub
		con = ConnectDB.getInstance().getConnection();
		bangPhanCongCongNhanDAO = new BangPhanCongCongNhanDAO();
		nhanVienDAO = new NhanVienDAO();
		diaChiDAO = new DiaChiDAO();
		toNhomDAO = new ToNhomDAO();
	}
	public List<BangChamCongCongNhan> layDanhSachChamCongCN(){
		String sql = "select * from BANGCHAMCONGCONGNHAN";
		List<BangChamCongCongNhan> dsCCCN = new ArrayList<>();
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				BangChamCongCongNhan bangChamCong = new BangChamCongCongNhan(rs.getString(1), rs.getDate(2), 
						rs.getInt(3), rs.getString(4),
						bangPhanCongCongNhanDAO.timPhanCongCongNhan(rs.getString(5)),
						nhanVienDAO.timNhanVienBangMaNhanVien(rs.getString(6)));
				dsCCCN.add(bangChamCong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCCCN;
	}
	
	public BangChamCongCongNhan timCongNhanBangMaCongNhan(String maCongNhan) {
		String sql = "select * from BANGCHAMCONGCONGNHAN where macongnhan = ?";
		BangChamCongCongNhan bangChamCongCongNhan = null;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, maCongNhan);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				bangChamCongCongNhan = new BangChamCongCongNhan(rs.getString(1), rs.getDate(2), 
						rs.getInt(3), rs.getString(4),
						bangPhanCongCongNhanDAO.timPhanCongCongNhan(rs.getString(5)),
						nhanVienDAO.timNhanVienBangMaNhanVien(rs.getString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bangChamCongCongNhan;
		
	}
	
	public BangChamCongCongNhan timCongNhanBangMaPhanCong(String maPhanCong) {
		String sql = "select * from BANGCHAMCONGCONGNHAN where maphancong = ?";
		BangChamCongCongNhan bangChamCongCongNhan = null;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, maPhanCong);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				bangChamCongCongNhan = new BangChamCongCongNhan(rs.getString(1), rs.getDate(2), 
						rs.getInt(3), rs.getString(4),
						bangPhanCongCongNhanDAO.timPhanCongCongNhan(rs.getString(5)),
						nhanVienDAO.timNhanVienBangMaNhanVien(rs.getString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bangChamCongCongNhan;
		
	}
	
	
}
