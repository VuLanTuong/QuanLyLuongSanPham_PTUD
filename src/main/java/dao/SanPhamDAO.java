package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connectdb.ConnectDB;
import entity.SanPham;

public class SanPhamDAO {
	private Connection con;
	public SanPhamDAO() {
		// TODO Auto-generated constructor stub
		con = ConnectDB.getInstance().getConnection();
		
	}
	public boolean themSanPham(SanPham sanPham) {
		if(timSanPham(sanPham.getMaSanPham()) != null)
			return false;
		String sql = "INSERT INTO [dbo].[SANPHAM]\r\n"
				+ "           ([maSanPham]\r\n"
				+ "           ,[tenSanPham]\r\n"
				+ "           ,[giaTien]\r\n"
				+ "           ,[moTaSanPham]\r\n"
				+ "           ,[soLuongSanXuat]\r\n"
				+ "           ,[chatLieu]\r\n"
				+ "           ,[kichThuoc]\r\n"
				+ "           ,[anhSanPham]\r\n"
				+ "           ,[soLuongCongDoan])\r\n"
				+ "     VALUES\r\n"
				+ "           (?,?,?,?,?,?,?,?,?)";
		int dem = 0;
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, sanPham.getMaSanPham());
			stmt.setString(2, sanPham.getTenSanPham());
			stmt.setDouble(3, sanPham.getGiaTien());
			stmt.setString(4, sanPham.getMoTa());
			stmt.setInt(5, sanPham.getSoLuongSanXuat());
			stmt.setString(6, sanPham.getChatLieu());
			stmt.setString(7, sanPham.getKichThuoc());
			stmt.setString(8, sanPham.getAnhSanPham());
			stmt.setInt(9, sanPham.getSoLuongCongDoan());
			dem = stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dem >0;
		
	}
	public SanPham timSanPham(String maSanPham) {
		String sql = "select * from SanPham where maSanPham = ?";
		SanPham sp = null;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, maSanPham);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				sp = new SanPham(rs.getString(1), rs.getNString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5),rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sp;
	}
	public List<SanPham> layDanhSachSanPham(){
		List<SanPham> dsSanPham  = new ArrayList<>();
		String sql = "select * from SanPham";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			ResultSet rs =  stmt.executeQuery();
			while(rs.next()) {
				SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				dsSanPham.add(sp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSanPham;
	}
	public boolean xoaSanPham(String maSanPham) {
		String sql = "delete from SanPham where maSanPham = ?";
		int dem = 0;
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, maSanPham);
			dem = stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dem >0;
	}
	public boolean canNhatSanPham(SanPham sanPham) {
		if(timSanPham(sanPham.getMaSanPham())== null)
			return false;
		int dem = 0;
		String sql  = "UPDATE [dbo].[SANPHAM]\r\n"
				+ "   SET [tenSanPham] = ? "
				+ "      ,[giaTien] = ? "
				+ "      ,[moTaSanPham] = ? "
				+ "      ,[soLuongSanXuat] = ? "
				+ "      ,[chatLieu] = ? "
				+ "      ,[kichThuoc] = ? "
				+ "      ,[anhSanPham] = ? "
				+ "      ,[soLuongCongDoan] = ? "
				+ " WHERE maSanPham = ? ";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, sanPham.getTenSanPham());
			stmt.setDouble(2, sanPham.getGiaTien());
			stmt.setString(3, sanPham.getMoTa());
			stmt.setInt(4, sanPham.getSoLuongSanXuat());
			stmt.setString(5, sanPham.getChatLieu());
			stmt.setString(6, sanPham.getKichThuoc());
			stmt.setString(7, sanPham.getAnhSanPham());
			stmt.setInt(8, sanPham.getSoLuongCongDoan());
			dem = stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dem >0;
	}
	
	
}
