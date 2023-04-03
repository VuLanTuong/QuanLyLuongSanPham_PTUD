package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connectdb.ConnectDB;
import entity.CongDoanSanPham;

public class CongDoanSanPhamDAO {
	private Connection con;
	private SanPhamDAO sanPhamDAO;
	public CongDoanSanPhamDAO() {
		// TODO Auto-generated constructor stub
		con = ConnectDB.getInstance().getConnection();
		sanPhamDAO = new SanPhamDAO();
	}
	public boolean themCongDoan(CongDoanSanPham congDoan) {
		if(timCongDoan(congDoan.getMaCongDoan())!= null)
			return false;
		int dem = 0;
		String sql = "INSERT INTO [dbo].[CONGDOANSANPHAM]\r\n"
				+ "           ([maCongDoan]\r\n"
				+ "           ,[tenCongDoan]\r\n"
				+ "           ,[tienCongDoan]\r\n"
				+ "           ,[soLuong]\r\n"
				+ "           ,[tinhTrang]\r\n"
				+ "           ,[noiDung]\r\n"
				+ "           ,[maSanPham])\r\n"
				+ "     VALUES\r\n"
				+ "           (?,?,?,?,?,?,?)";
		try (PreparedStatement stmt  = con.prepareStatement(sql)){
			stmt.setString(1, congDoan.getMaCongDoan());
			stmt.setString(2, congDoan.getTenCongDoan());
			stmt.setDouble(3, congDoan.getTienCongDoan());
			stmt.setInt(4, congDoan.getSoLuong());
			stmt.setString(5, congDoan.getTinhTrang());
			stmt.setString(6, congDoan.getMoTa());
			stmt.setString(7, congDoan.getSanPham().getMaSanPham());
			dem = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dem >0;
	}
	public CongDoanSanPham timCongDoan(String maCongDoan) {
		String sql = "select * from CongDoanSanPham";
		CongDoanSanPham congDoan = null;
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				congDoan = new CongDoanSanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6), sanPhamDAO.timSanPham(rs.getString(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return congDoan;
	}
	public boolean xoaCongDoan(String maCongDoan) {
		if(timCongDoan(maCongDoan)== null)
			return false;
		String sql = "delete from CongDoanSanPham where maCongDoan = ?";
		int dem = 0;
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, maCongDoan);
			dem = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dem >0;
		
	}
	public boolean capNhatCongDoan(CongDoanSanPham congDoan) {
		if(timCongDoan(congDoan.getMaCongDoan())== null)
			return false;
		String sql = "UPDATE [dbo].[CONGDOANSANPHAM]\r\n"
				+ "   SET [tenCongDoan] = ? "
				+ "      ,[tienCongDoan] = ? "
				+ "      ,[soLuong] = ? "
				+ "      ,[tinhTrang] = ? "
				+ "      ,[noiDung] = ? "
				+ "      ,[maSanPham] = ? "
				+ " WHERE maCongDoan = ? ";
		int dem = 0;
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, congDoan.getTenCongDoan());
			stmt.setDouble(2, congDoan.getTienCongDoan());
			stmt.setInt(3, congDoan.getSoLuong());
			stmt.setString(4, congDoan.getTinhTrang());
			stmt.setString(5, congDoan.getMoTa());
			stmt.setString(6, congDoan.getSanPham().getMaSanPham());
			dem = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dem >0;
	}
	public List<CongDoanSanPham> layDanhSachCongDoan(){
		List<CongDoanSanPham> dsCongDoan = new ArrayList<>();
		String sql = "select * from CongDoanSanPham";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				CongDoanSanPham congDoan = new CongDoanSanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6), sanPhamDAO.timSanPham(rs.getString(7)));
				dsCongDoan.add(congDoan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCongDoan;
	}
	public List<CongDoanSanPham> layDanhSachTheoMaSP(String maSP){
		List<CongDoanSanPham> dsCongDoan = new ArrayList<>();
		String sql = "select * from CongDoanSanPham where maSanPham = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, maSP);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				CongDoanSanPham congDoan = new CongDoanSanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6), sanPhamDAO.timSanPham(rs.getString(7)));
				dsCongDoan.add(congDoan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCongDoan;
		
	}
	
}
