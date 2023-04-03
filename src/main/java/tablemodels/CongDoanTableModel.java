package tablemodels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.CongDoanSanPham;

public class CongDoanTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int STT = 0;
	private static final int MACD = 1;
	private static final int TENCD = 2;
	private static final int TIENCD = 3;
	private static final int SOLUONG = 4;
	private static final int SOLUONGDALAM = 5;
	private static final int TONGTIEN = 6;
	private static final int THOIHAN = 7;
	private static final int MUCDOHOANTHANH = 8;
	private List<CongDoanSanPham> dsCD = new ArrayList<>();
	private String[] headers;
	
	public CongDoanTableModel(List<CongDoanSanPham> dsCD, String[] headers) {
		super();
		this.dsCD = dsCD;
		this.headers = headers;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dsCD.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return headers.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CongDoanSanPham congDoan = dsCD.get(rowIndex);
		switch (columnIndex) {
		case STT:
			return dsCD.indexOf(congDoan)+1;
		case MACD: {
			
			return congDoan.getMaCongDoan();
		}
		case TENCD:
			return congDoan.getTenCongDoan();
		case TIENCD:
			return congDoan.getTienCongDoan();
		case SOLUONG:
			return congDoan.getSoLuong();
		case SOLUONGDALAM:
			return 0;
		case TONGTIEN:
			return congDoan.getSoLuong()*congDoan.getTienCongDoan();
		case THOIHAN:
			return 0;
		case MUCDOHOANTHANH:
			return 0 + "%";
		default:
			return congDoan;
		}
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return headers[column];
	}

}
