package tablemodels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.BangLuongNhanVien;

public class BangLuongNhanVienTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int MABANGLUONG = 0;
	private static final int MANHANVIEN = 1;
	private static final int HOTEN = 2;
	private static final int VAITRO = 3;
	private static final int HESOLUONG = 4;
	private static final int LUONGCOBAN = 5;
	private static final int PHUCAP = 6;
	private static final int TONGLUONG = 7;
	private String[] headers;
	private List<BangLuongNhanVien> dsBLNV;
	
	public BangLuongNhanVienTableModel(String[] headers, List<BangLuongNhanVien> dsBLNV) {
		super();
		this.headers = headers;
		this.dsBLNV = dsBLNV;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dsBLNV.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return headers.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		BangLuongNhanVien blnv = dsBLNV.get(rowIndex);
		switch (columnIndex) {
		case MABANGLUONG:
			return blnv.getMaBangLuong();
		case MANHANVIEN:
			return blnv.getNhanVien().getMaNhanVien();
		case HOTEN:
			return blnv.getNhanVien().getTenNhanVien();
		case LUONGCOBAN:
			return blnv.getLuongCoBan();
		case PHUCAP:
			return blnv.getPhuCap();
		case TONGLUONG:
			return null;
		case VAITRO:
			return blnv.getNhanVien().getVaiTro();
		case HESOLUONG:
			return blnv.getHeSoLuong();
		default:
			return blnv;
		}
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return headers[column];
	}
	
	
	
}
