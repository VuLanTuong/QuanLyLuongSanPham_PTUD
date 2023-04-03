package tablemodels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.BangChamCongCongNhanDAO;
import dao.BangPhanCongCongNhanDAO;
import entity.BangChamCongCongNhan;
import entity.BangLuongCongNhan;
import entity.BangPhanCongCongNhan;
import entity.CongNhan;

public class BangLuongCongNhanTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int MABANGLUONG = 0;
	private static final int MACONGNHAN = 1;
	private static final int HOTEN = 2;
	private static final int TENCONGDOAN = 3;
	private static final int SOLUONGSP = 4;
	private static final int LUONG = 5;
	private String[] headers;
	private List<BangLuongCongNhan> dsBLCN;
	private BangChamCongCongNhan bangChamCongCongNhan;
	private CongNhan congNhan;
	private BangPhanCongCongNhan bangPhanCongCongNhan;
	private BangPhanCongCongNhanDAO bangPhanCongCongNhanDAO;
	private BangChamCongCongNhanDAO bangChamCongCongNhanDAO;
	private String maBangPhanCong;
	private int soLuongSanPham = 0;

	public BangLuongCongNhanTableModel(String[] headers, List<BangLuongCongNhan> dsBLCN) {
		super();
		this.headers = headers;
		this.dsBLCN = dsBLCN;
		bangPhanCongCongNhan = new BangPhanCongCongNhan();
		bangPhanCongCongNhanDAO = new BangPhanCongCongNhanDAO();
		bangChamCongCongNhanDAO = new BangChamCongCongNhanDAO();
		maBangPhanCong = "";
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dsBLCN.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return headers.length;
	}

	// private static final int MABANGLUONG = 0;
//	private static final int MACONGNHAN = 1;
//	private static final int HOTEN = 2;
//	private static final int TENCONGDOAN = 3;
//	private static final int SOLUONGSP = 4;
//	private static final int TIENTHUONG = 5;
//	private static final int PHUCAP = 6;
//	private static final int LUONG = 7;
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		BangLuongCongNhan blcn = dsBLCN.get(rowIndex);
		switch (columnIndex) {
		case MABANGLUONG:
			return blcn.getMaBangLuong();
		case MACONGNHAN:
			return blcn.getCongNhan().getMaCongNhan();
		case HOTEN:
			return blcn.getCongNhan().getTenCongNhan();
		case TENCONGDOAN:
			
			
			bangPhanCongCongNhan = bangPhanCongCongNhanDAO
			.timPhanCongCongNhanBangMaCongNhan(blcn.getCongNhan().getMaCongNhan());
			

			return bangPhanCongCongNhan.getCongDoan().getTenCongDoan();
			
		case SOLUONGSP:

			bangPhanCongCongNhan = bangPhanCongCongNhanDAO
			.timPhanCongCongNhanBangMaCongNhan(blcn.getCongNhan().getMaCongNhan());
			
			
			
			maBangPhanCong = bangPhanCongCongNhan.getMaPhanCong();
			
			
			
			bangChamCongCongNhan = bangChamCongCongNhanDAO.timCongNhanBangMaPhanCong(maBangPhanCong);
			

			return bangChamCongCongNhan.getSoLuongLam();
			
		case LUONG:
		
			return blcn.getTongLuong();

		default:
			return blcn;
		}
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return headers[column];
	}

}
