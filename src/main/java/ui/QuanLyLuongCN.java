/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import dao.BangChamCongCongNhanDAO;
import dao.BangLuongCongNhanDAO;
import dao.BangLuongNhanVienDAO;
import dao.BangPhanCongCongNhanDAO;
import entity.BangChamCongCongNhan;
import entity.BangLuongCongNhan;
import entity.BangLuongNhanVien;
import entity.BangPhanCongCongNhan;
import entity.CongNhan;
import entity.NhanVien;
import tablemodels.BangLuongCongNhanTableModel;
import tablemodels.BangLuongNhanVienTableModel;

/**
 *

 */
public class QuanLyLuongCN extends javax.swing.JPanel {

	// private static final int MABANGLUONG = 0;
//	private static final int MACONGNHAN = 1;
//	private static final int HOTEN = 2;
//	private static final int TENCONGDOAN = 3;
//	private static final int SOLUONGSP = 4;
//	private static final int LUONG = 5;

	private static final String[] HEADERS = { "Mã bảng lương", "Mã công nhân", "Họ tên", "Tên công đoạn",
			"Số lượng sản phẩm", "Lương" };
	private CongNhan congNhan;
	private BangLuongCongNhanDAO bangLuongCongNhanDAO;
	private BangLuongCongNhanTableModel bangLuongCongNhanTableModel;
	private BangLuongCongNhan bangLuongCongNhan;
	private BangPhanCongCongNhan bangPhanCongCongNhan;
	private BangPhanCongCongNhanDAO bangPhanCongCongNhanDAO;
	private BangChamCongCongNhanDAO bangChamCongCongNhanDAO;
	private BangChamCongCongNhan bangChamCongCongNhan;
	private List<BangLuongCongNhan> dsbangLuongCongNhan;
	private boolean trangThaiThem;
	private String maPhanCong = "";

	public QuanLyLuongCN() {
		congNhan = new CongNhan();
		tblQuanLiLuongCN = new JTable();
		bangLuongCongNhanDAO = new BangLuongCongNhanDAO();
		dsbangLuongCongNhan = new ArrayList<>();
		trangThaiThem = false;
		bangPhanCongCongNhan = new BangPhanCongCongNhan();
		bangPhanCongCongNhanDAO = new BangPhanCongCongNhanDAO();
		bangChamCongCongNhanDAO = new BangChamCongCongNhanDAO();
		bangChamCongCongNhan = new BangChamCongCongNhan();
		tblQuanLiLuongCN.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		initComponents();
		themSuKien();

	}

	private void updateModelTable(List<BangLuongCongNhan> dsCN, String[] headers) {
		bangLuongCongNhanTableModel = new BangLuongCongNhanTableModel(headers, dsCN);
		tblQuanLiLuongCN.setModel(bangLuongCongNhanTableModel);
		tblQuanLiLuongCN.updateUI();
	}

	private void xoaRong() {
		txtHoTen.setText("");
		txtLuong.setText("");
		txtMaLuong.setText("");
		txtPhuCap.setText("");
		txtTienThuong.setText("");
		txtLuong.setText("");
		txtMaCN.setText("");
		txtSoLuongSP.setText("");
		txtTenCongDoan.setText("");

	}

	private void fillDuLieuVaoTextField() {
		txtHoTen.setEditable(true);
		txtLuong.setEditable(true);
		txtMaLuong.setEditable(true);
		txtPhuCap.setEditable(true);
		txtTienThuong.setEditable(true);
		txtLuong.setEditable(true);
		txtMaCN.setEditable(true);
		txtSoLuongSP.setEditable(true);
		txtTenCongDoan.setEditable(true);

	}

	private void themSuKien() {
		dsbangLuongCongNhan = bangLuongCongNhanDAO.layDanhSachBangLuongCN();
		updateModelTable(dsbangLuongCongNhan, HEADERS);
//		if (tblQuanLiLuongCN.getColumnModel().getColumnCount() > 0) {
//			tblQuanLiLuongCN.getColumnModel().getColumn(3).setMinWidth(320);
//		}
		tblQuanLiLuongCN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String item = (String) tblQuanLiLuongCN.getModel().getValueAt(tblQuanLiLuongCN.getSelectedRow(), 0);
				if (item != null) {
					BangLuongCongNhan bangLuongCongNhan = null;
					try {
						if (!trangThaiThem) {

							bangLuongCongNhan = bangLuongCongNhanDAO.timBangLuongCN(item);
							fillThongTinBangLuong(bangLuongCongNhan);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			}

			private void fillThongTinBangLuong(BangLuongCongNhan bangLuongCongNhan) throws Exception {
				bangPhanCongCongNhan = bangPhanCongCongNhanDAO
						.timPhanCongCongNhanBangMaCongNhan(bangLuongCongNhan.getCongNhan().getMaCongNhan());
						
						
						
						maPhanCong = bangPhanCongCongNhan.getMaPhanCong();
						bangChamCongCongNhan = bangChamCongCongNhanDAO
								.timCongNhanBangMaPhanCong(maPhanCong);
						
				bangPhanCongCongNhan = bangPhanCongCongNhanDAO
						.timPhanCongCongNhanBangMaCongNhan(bangLuongCongNhan.getCongNhan().getMaCongNhan());
				
				String luong = Double.toString(bangLuongCongNhan.getTongLuong());
				String soLuongSP = Integer.toString(bangChamCongCongNhan.getSoLuongLam());
				
				txtHoTen.setText(bangLuongCongNhan.getCongNhan().getTenCongNhan());
				txtMaLuong.setText(bangLuongCongNhan.getMaBangLuong());
				txtSoLuongSP.setText(soLuongSP);
				txtTienThuong.setText("");
				txtLuong.setText(luong);
				txtPhuCap.setText("");
				txtTenCongDoan.setText(bangPhanCongCongNhan.getCongDoan().getTenCongDoan());
				txtMaCN.setText(bangLuongCongNhan.getCongNhan().getMaCongNhan());
				

			}
		});
		
		
		
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane8 = new javax.swing.JScrollPane();
		tblQuanLiLuongCN = new javax.swing.JTable();
		btnTimKiem = new javax.swing.JButton();
		lblMaCN = new javax.swing.JLabel();
		txtMaCN = new javax.swing.JTextField();
		jLabel96 = new javax.swing.JLabel();
		txtMaLuong = new javax.swing.JTextField();
		lblSoLuongSP = new javax.swing.JLabel();
		txtHoTen = new javax.swing.JTextField();
		txtPhuCap = new javax.swing.JTextField();
		lblTienThuong = new javax.swing.JLabel();
		lblLuong = new javax.swing.JLabel();
		txtLuong = new javax.swing.JTextField();
		cmbThang = new javax.swing.JComboBox<>();
		jComboBox8 = new javax.swing.JComboBox<>();
		btnTinhLuong = new javax.swing.JButton();
		jLabel6 = new javax.swing.JLabel();
		lblMaLuong = new javax.swing.JLabel();
		txtSoLuongSP = new javax.swing.JTextField();
		txtTenCongDoan = new javax.swing.JTextField();
		lblTenCongDoan = new javax.swing.JLabel();
		lblPhuCap = new javax.swing.JLabel();
		txtTienThuong = new javax.swing.JTextField();
		btnXoaRong = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		cmbTo = new javax.swing.JComboBox<>();
		btnInBangLuong = new javax.swing.JButton();

		setBackground(new java.awt.Color(255, 255, 255));

		jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));

		tblQuanLiLuongCN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		tblQuanLiLuongCN.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null } },
				new String[] { "Mã lương", "Mã công nhân", "Họ và tên", "Tên công đoạn", "Số lượng sản phẩm",
						"Tiền thưởng", "Phụ cấp", "Lương" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tblQuanLiLuongCN.setFillsViewportHeight(true);
		tblQuanLiLuongCN.setRowHeight(30);
		tblQuanLiLuongCN.setSurrendersFocusOnKeystroke(true);
		jScrollPane8.setViewportView(tblQuanLiLuongCN);
		
		dsbangLuongCongNhan = bangLuongCongNhanDAO.layDanhSachBangLuongCN();
        updateModelTable(dsbangLuongCongNhan, HEADERS);

		btnTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
		btnTimKiem.setText("Tìm kiếm");

		lblMaCN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblMaCN.setText("Mã công nhân:");

		txtMaCN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		txtMaCN.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

		jLabel96.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		jLabel96.setText("Họ tên:");

		txtMaLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		txtMaLuong.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

		lblSoLuongSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblSoLuongSP.setText("Số lượng sản phẩm:");

		txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		txtHoTen.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

		txtPhuCap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		txtPhuCap.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

		lblTienThuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblTienThuong.setText("Tiền thưởng:");

		lblLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblLuong.setText("Lương:");

		txtLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		txtLuong.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

		cmbThang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		cmbThang.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Tháng ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		cmbThang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbThangActionPerformed(evt);
			}
		});

		jComboBox8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023" }));

		btnTinhLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnTinhLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_tinhluong.png"))); // NOI18N
		btnTinhLuong.setText("Tính lương");
		btnTinhLuong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTinhLuongActionPerformed(evt);
			}
		});

		jLabel6.setBackground(new java.awt.Color(255, 255, 255));
		jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
		jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel6.setText("QUẢN LÝ LƯƠNG CÔNG NHÂN");

		lblMaLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblMaLuong.setText("Mã lương:");

		txtSoLuongSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		txtSoLuongSP.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

		txtTenCongDoan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		txtTenCongDoan.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

		lblTenCongDoan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblTenCongDoan.setText("Tên công đoạn:");

		lblPhuCap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		lblPhuCap.setText("Phụ cấp:");

		txtTienThuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		txtTienThuong.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

		btnXoaRong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnXoaRong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eraser.png"))); // NOI18N
		btnXoaRong.setText("Xóa rỗng");
		btnXoaRong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaRongActionPerformed(evt);
			}
		});

		cmbTo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		cmbTo.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Tổ áo khoác", "Tổ áo thun", "Tổ áo sơ mi", "Tổ quần tây", "Tổ đồ bộ" }));
		cmbTo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbToActionPerformed(evt);
			}
		});

		btnInBangLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnInBangLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_printbangluong.png"))); // NOI18N
		btnInBangLuong.setText("In bảng lương");
		btnInBangLuong.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnInBangLuongMouseClicked(evt);
			}
		});
		btnInBangLuong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnInBangLuongActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jScrollPane8)
						.addGroup(layout.createSequentialGroup().addGap(32, 32, 32).addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblMaLuong)
								.addComponent(lblMaCN).addComponent(jLabel96).addComponent(lblTenCongDoan))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
										.addComponent(txtTenCongDoan).addComponent(txtMaLuong).addComponent(txtMaCN))
								.addGap(32, 32, 32)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup().addComponent(lblTienThuong)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(txtTienThuong, javax.swing.GroupLayout.PREFERRED_SIZE,
														181, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
												.createSequentialGroup().addComponent(lblPhuCap)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(txtPhuCap, javax.swing.GroupLayout.PREFERRED_SIZE, 181,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup().addComponent(lblSoLuongSP)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txtSoLuongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 181,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lblLuong).addComponent(btnTimKiem))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(btnXoaRong).addComponent(txtLuong,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 181,
																		javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107,
										Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(cmbTo, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnTinhLuong))
								.addGap(48, 48, 48)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(btnInBangLuong)
										.addGroup(layout.createSequentialGroup()
												.addComponent(cmbThang, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(63, 63, 63).addComponent(jComboBox8,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel1))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(37, 37, 37).addComponent(jLabel1))
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(86, 86, 86)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel96)))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(txtMaCN, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lblSoLuongSP)
												.addComponent(txtSoLuongSP, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(cmbTo, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(cmbThang, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lblMaCN))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(txtMaLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lblMaLuong).addComponent(lblPhuCap))
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(lblTienThuong))
												.addGroup(layout.createSequentialGroup().addGap(7, 7, 7).addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(btnTinhLuong).addComponent(btnInBangLuong))))
										.addGap(11, 11, 11))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup()
												.addComponent(txtPhuCap, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(txtTienThuong, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lblTenCongDoan)
												.addComponent(txtTenCongDoan, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lblLuong)))
										.addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(
												txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(32, 32, 32)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnXoaRong).addComponent(btnTimKiem))))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)));
	}// </editor-fold>//GEN-END:initComponents

	private void cmbThangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cmbThangActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_cmbThangActionPerformed

	private void btnXoaRongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaRongActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnXoaRongActionPerformed

	private void cmbToActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cmbToActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_cmbToActionPerformed

	private void btnTinhLuongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTinhLuongActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnTinhLuongActionPerformed

	private void btnInBangLuongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInBangLuongActionPerformed

	}// GEN-LAST:event_btnInBangLuongActionPerformed

	private void btnInBangLuongMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnInBangLuongMouseClicked
		JDialog inBangLuong = new JDialog();
		inBangLuong.add(new InBangLuong());
		inBangLuong.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		inBangLuong.setSize(900, 700);
		inBangLuong.setLocationRelativeTo(null);
		inBangLuong.setVisible(true);
	}// GEN-LAST:event_btnInBangLuongMouseClicked

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnInBangLuong;
	private javax.swing.JButton btnTimKiem;
	private javax.swing.JButton btnTinhLuong;
	private javax.swing.JButton btnXoaRong;
	private javax.swing.JComboBox<String> cmbThang;
	private javax.swing.JComboBox<String> cmbTo;
	private javax.swing.JComboBox<String> jComboBox8;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel96;
	private javax.swing.JScrollPane jScrollPane8;
	private javax.swing.JLabel lblLuong;
	private javax.swing.JLabel lblMaCN;
	private javax.swing.JLabel lblMaLuong;
	private javax.swing.JLabel lblPhuCap;
	private javax.swing.JLabel lblSoLuongSP;
	private javax.swing.JLabel lblTenCongDoan;
	private javax.swing.JLabel lblTienThuong;
	private javax.swing.JTable tblQuanLiLuongCN;
	private javax.swing.JTextField txtHoTen;
	private javax.swing.JTextField txtLuong;
	private javax.swing.JTextField txtMaCN;
	private javax.swing.JTextField txtMaLuong;
	private javax.swing.JTextField txtPhuCap;
	private javax.swing.JTextField txtSoLuongSP;
	private javax.swing.JTextField txtTenCongDoan;
	private javax.swing.JTextField txtTienThuong;
	// End of variables declaration//GEN-END:variables
}
