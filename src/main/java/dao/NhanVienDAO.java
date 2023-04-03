package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

import connectdb.ConnectDB;
import entity.CongNhan;
import entity.DiaChi;
import entity.NhanVien;
import entity.ToNhom;

public class NhanVienDAO {
	private Connection con;
	private DiaChiDAO diaChiDAO;
	private ToNhomDAO toNhomDAO;

	public NhanVienDAO() {
		con = ConnectDB.getInstance().getConnection();
		diaChiDAO = new DiaChiDAO();
		toNhomDAO = new ToNhomDAO();

	}

	public List<NhanVien> layDanhSachNhanVien() {
		List<NhanVien> dsNhanVien = new ArrayList<>();
		String sql = "select * from NHANVIEN";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				NhanVien nhanvien = new NhanVien(rs.getString(1), rs.getString(2),rs.getDate(3),rs.getString(4) , rs.getString(5),diaChiDAO.layMaDiaChi(rs.getString(6)),
						rs.getDate(7),rs.getString(8), rs.getString(9),
						rs.getString(10));
				dsNhanVien.add(nhanvien);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}

	public boolean themNhanVien(NhanVien nhanVien) {
		if (timNhanVienBangMaNhanVien(nhanVien.getMaNhanVien())!= null)
			return false;
		
		String sql = "INSERT INTO [dbo].[NHANVIEN]"
				+ "           ([maNhanVien]"
				+ "           ,[tenNhanVien]"
				+ "           ,[ngaySinh]"
				+ "           ,[email]"
				+ "           ,[sdt]"
				+ "           ,[maDC]"
				+ "           ,[ngayVaoLam]"
				+ "           ,[gioiTinh]"
				+ "           ,[vaiTro]"
				+ "           ,[anhDaiDien])"
				+ "     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, nhanVien.getMaNhanVien());
			stmt.setString(2, nhanVien.getTenNhanVien());
			stmt.setDate(3, new Date(nhanVien.getNgaySinh().getTime()));
			stmt.setString(4, nhanVien.getEmail());
			stmt.setString(5, nhanVien.getSoDienThoai());
			stmt.setString(6, nhanVien.getDiaChi().getMaDC());
			stmt.setDate(7, new Date(nhanVien.getNgayVaoLam().getTime()));
			stmt.setString(8, nhanVien.getGioiTinh());
			stmt.setString(9, nhanVien.getVaiTro());
			stmt.setString(10, nhanVien.getAnhDaiDien());
			stmt.executeUpdate();
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public NhanVien timNhanVienBangMaNhanVien(String maNhanVien) {
		String sql = "select * from nhanvien where manhanvien = ?";
		NhanVien nhanVien = null;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, maNhanVien);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				nhanVien = new NhanVien(rs.getString(1), rs.getString(2),rs.getDate(3),rs.getString(4) , rs.getString(5),diaChiDAO.layMaDiaChi(rs.getString(6)),
						rs.getDate(7),rs.getString(8), rs.getString(9),
						rs.getString(10));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nhanVien;
	}

	public boolean xoaNhanVien(String maNhanVien) {
		int dem = 0;

		String sql = "delete from NhanVien where maNhanVien = ?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, maNhanVien);

			dem = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dem > 0;
	}

	public boolean capNhatNhanVien(NhanVien nhanVien) {
		if (timNhanVienBangMaNhanVien(nhanVien.getMaNhanVien()) == null)
			return false;
		
		int dem = 0;
		
		
		String sql = "UPDATE [dbo].[NHANVIEN]\r\n"
				+ " SET  [tenNhanVien] = ?"
				+ "      ,[ngaySinh] = ?"
				+ "      ,[email] = ?"
				+ "      ,[sdt] = ?"
				+ "      ,[maDC] = ?"
				+ "      ,[ngayVaoLam] = ?"
				+ "      ,[gioiTinh] =?"
				+ "      ,[vaiTro] = ?"
				+ "      ,[anhDaiDien] = ?"
				+ " WHERE maNhanVien = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, nhanVien.getTenNhanVien());
			stmt.setDate(2, new Date(nhanVien.getNgaySinh().getTime()));
			stmt.setString(3, nhanVien.getEmail());
			stmt.setString(4, nhanVien.getSoDienThoai());
			stmt.setString(5, nhanVien.getDiaChi().getMaDC());
			stmt.setDate(6, new Date(nhanVien.getNgayVaoLam().getTime()));
			stmt.setString(7, nhanVien.getGioiTinh());
			stmt.setString(8, nhanVien.getVaiTro());
			stmt.setString(9, nhanVien.getAnhDaiDien());
			stmt.setString(10, nhanVien.getMaNhanVien());
			stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dem > 0;
	}


}
