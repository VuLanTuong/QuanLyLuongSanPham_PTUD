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
import entity.SanPham;
import entity.ToNhom;

public class CongNhanDAO {
	private Connection con;
	private DiaChiDAO diaChiDAO;
	private ToNhomDAO toNhomDAO;

	public CongNhanDAO() {
		con = ConnectDB.getInstance().getConnection();
		diaChiDAO = new DiaChiDAO();
		toNhomDAO = new ToNhomDAO();

	}

	public List<CongNhan> layDanhSachCongNhan() {
		//sau nhớ ràng buộc 1 công nhân nếu được phân công rồi thì sẽ không xuất hiện trong
		//danh sách công nhân ở mục phân công nữa, mà phải sửa từ danh sách phân công công đoạn
		List<CongNhan> dsCN = new ArrayList<>();
		String sql = "select * from CongNhan";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
			
				CongNhan congNhan1 = new CongNhan(rs.getString(1), rs.getString(2), rs.getString(3),
						diaChiDAO.layMaDiaChi(rs.getString(4)), rs.getDate(5), rs.getDate(6), rs.getString(7), toNhomDAO.layToNhomTheoMa(rs.getString(9)));
				dsCN.add(congNhan1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCN;
	}

	public boolean themCongNhan(CongNhan congNhan) {
		if (timCongNhanBangMaCongNhan(congNhan.getMaCongNhan()) != null)
			return false;
		String sql = "INSERT INTO [dbo].[CONGNHAN]" 
				+ "           ([maCongNhan]"
				+ "           ,[tenCongNhan]" 
				+ "           ,[sdt]" 
				+ "           ,[maDC]"
				+ "           ,[ngayVaoLam]" 
				+ "           ,[ngaySinh]" 
				+ "           ,[gioiTinh]"
				+ "           ,[anhDaiDien]" 
				+ "           ,[maTo])" 
				+ "     VALUES" + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, congNhan.getMaCongNhan());
			stmt.setString(2, congNhan.getTenCongNhan());
			stmt.setString(3, congNhan.getSoDienThoai());
			stmt.setString(4, congNhan.getDiaChi().getMaDC());
			stmt.setDate(5, new Date(congNhan.getNgayVaoLam().getTime()));
			stmt.setDate(6, new Date(congNhan.getNgaySinh().getTime()));
			stmt.setString(7, congNhan.getGioiTinh());
			stmt.setString(8, null);
			stmt.setString(9, congNhan.getToNhom().getMaToNhom());
			stmt.executeUpdate();
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public CongNhan timCongNhanBangMaCongNhan(String maCongNhan) {
		String sql = "select * from CongNhan where maCongNhan = ?";
		CongNhan congNhan = null;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, maCongNhan);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				congNhan = new CongNhan(rs.getString(1), rs.getString(2), rs.getString(3),
						diaChiDAO.layMaDiaChi(rs.getString(4)), rs.getDate(5), rs.getDate(6), rs.getString(7),
						toNhomDAO.layToNhomTheoMa(rs.getString(9)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return congNhan;
	}

	public boolean xoaCongNhan(String maCongNhan) {
		int dem = 0;

		String sql = "delete from CongNhan where maCongNhan = ?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, maCongNhan);

			dem = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dem > 0;
	}

	public boolean capNhatCongNhan(CongNhan congNhan) {
		if (timCongNhanBangMaCongNhan(congNhan.getMaCongNhan()) == null)
			return false;
		int dem = 0;

		String sql = "UPDATE [dbo].[CONGNHAN]\r\n" 
				+ "   SET [tenCongNhan] = ?"
				+ "      ,[sdt] = ?" 
				+ "      ,[maDC] = ?" 
				+ "      ,[ngayVaoLam] = ?" 
				+ "      ,[ngaySinh] = ?"
				+ "      ,[gioiTinh] = ?" 
				+ "      ,[anhDaiDien] = ?" 
				+ "      ,[maTo] = ?" 
				+ " WHERE maCongNhan = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, congNhan.getTenCongNhan());
			stmt.setString(2, congNhan.getSoDienThoai());
			stmt.setString(3, congNhan.getDiaChi().getMaDC());
			stmt.setDate(4, new Date(congNhan.getNgayVaoLam().getTime()));
			stmt.setDate(5, new Date(congNhan.getNgaySinh().getTime()));
			stmt.setString(6, congNhan.getGioiTinh());
			stmt.setString(7, null);
			stmt.setString(8, congNhan.getToNhom().getMaToNhom());
			stmt.setString(9, congNhan.getMaCongNhan());

			dem = stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dem > 0;
	}
	
	
	
	public static void main(String[] args) {
//		ToNhom toNhom = new ToNhom("TN000001", "Tổ áo thun", 20);
//		DiaChi diaChi = new DiaChi("DC-0000499", "Thành phố Cần Thơ", "Huyện Cờ Đỏ", "Xã Đông Hiệp");
//		CongNhan congNhan = new CongNhan("CN000011", "Mai Văn Ok", "0123456789", diaChi, new Date(12 / 11 / 2015),
//				new Date(12 / 11 / 1990), "nam", toNhom);
//		CongNhanDAO congNhanDao = new CongNhanDAO();
//		
//		System.out.println(congNhanDao.layDanhSachCongNhan());
		CongNhanDAO congNhanDao = new CongNhanDAO();
		List<CongNhan> dscn = congNhanDao.layDanhSachCongNhan();

		System.out.println(dscn);
//		System.out.println(congNhanDao.timCongNhanBangMaCongNhan("CN000011"));
//		System.out.println(congNhanDao.xoaCongNhan("CN000011"));
//		System.out.println(congNhanDao.themCongNhan(congNhan));
	}

}
