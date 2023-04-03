/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;

import dao.CongNhanDAO;
import dao.DiaChiDAO;
import entity.CongNhan;
import tablemodels.CongNhanTableModel;

/**
 *
 * @author Lan Tuong
 */
public class QuanLyCN extends javax.swing.JPanel {

	/**
	 * Creates new form QuanLyNV
	 */
	private CongNhanDAO congNhanDAO;
	private CongNhanTableModel congNhanTableModel;
	private CongNhan congNhan;
	private List<CongNhan> dsCN;
	private boolean trangThaiThem;
	private DiaChiDAO diaChiDAO;
	private QuanLyCN quanLyCN;
	private static final String[] HEADERS = { "Mã công nhân", "Tên công nhân", "Số điện thoai", "Địa chỉ",
			"Ngày vào làm", "Ngày sinh", "Giới tính", "Tổ" };

	public QuanLyCN() {
		tblCongNhan = new JTable();
		congNhanDAO = new CongNhanDAO();
		trangThaiThem = false;
		diaChiDAO = new DiaChiDAO();
		
		initComponents();
		themSuKien();
	}

	private void updateModelTable(List<CongNhan> dsCN, String[] headers) {
		congNhanTableModel = new CongNhanTableModel(headers, dsCN);
		tblCongNhan.setModel(congNhanTableModel);
		tblCongNhan.updateUI();
	}

	private void updateComboboxTinh() {
		List<String> dsCacTinh = diaChiDAO.layDanhSachTinh();

		String[] dsTinh = new String[dsCacTinh.size()];
		dsCacTinh.toArray(dsTinh);
		cmbTinhTP.setModel(new DefaultComboBoxModel<String>(dsTinh));
		cmbTinhTP.updateUI();
		updateComboboxHuyen();
	}

	private void updateComboboxHuyen() {
		String tinh = (String) cmbTinhTP.getSelectedItem();
		List<String> dsCacHuyen = diaChiDAO.layDSHuyenTheoTinh(tinh);
		String[] dsHuyen = new String[dsCacHuyen.size()];
		dsCacHuyen.toArray(dsHuyen);
		cmbQuanHuyen.setModel(new DefaultComboBoxModel<String>(dsHuyen));
		cmbQuanHuyen.updateUI();
		updateComboboxXa();

	}

	private void updateComboboxXa() {
		String tinh = (String) cmbTinhTP.getSelectedItem();
		String huyen = (String) cmbQuanHuyen.getSelectedItem();
		System.out.println(huyen);
		List<String> dsTam = diaChiDAO.layDSXaTheoHuyenTinh(tinh, huyen);
		String[] dsXa = new String[dsTam.size()];
		dsTam.toArray(dsXa);
		cmbPhuongXa.setModel(new DefaultComboBoxModel<String>(dsXa));
		cmbPhuongXa.updateUI();

	}

	private void updateComboboxGioiTinh() {
		
		String gioiTinh = (String) cmbGioiTinh.getSelectedItem();
		
		List<String> dsTam = new ArrayList<>();
		dsTam = List.of("Nam", "Nu");
		
		String[] dsGioiTinh = new String[dsTam.size()];
		
		dsTam.toArray(dsGioiTinh);
		
		cmbGioiTinh.setModel(new DefaultComboBoxModel<String>(dsGioiTinh));
		cmbGioiTinh.updateUI();

	}

	
	private void xoaRong() {
		txtTenCongNhan.setText("");
		txtMaCongNhan.setText("");
		txtSoDienThoai.setText("");
		dtNgaySinh.setDate(null);
		dtNgayVaoLam.setDate(null);
	}

	private void fillDuLieuVaoTextfield() {
		txtMaCongNhan.setEditable(true);
		txtTenCongNhan.setEditable(true);
		txtSoDienThoai.setEditable(true);
		cmbGioiTinh.setEnabled(true);
		cmbTinhTP.setEnabled(true);
		cmbQuanHuyen.setEnabled(true);
		cmbPhuongXa.setEnabled(true);
		cmbTo.setEnabled(true);
//	    	dtNgaySinh.setEdit
		updateComboboxTinh();
		updateComboboxGioiTinh();
	}

	private void themSuKien() {
		dsCN = congNhanDAO.layDanhSachCongNhan();
		updateModelTable(dsCN, HEADERS);
		if (tblCongNhan.getColumnModel().getColumnCount() > 0) {
			tblCongNhan.getColumnModel().getColumn(3).setMinWidth(320);
		}
		tblCongNhan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String item = (String) tblCongNhan.getModel().getValueAt(tblCongNhan.getSelectedRow(), 0);
				if (item != null) {
					CongNhan congNhan = null;
					try {
						if (!trangThaiThem) {

							congNhan = congNhanDAO.timCongNhanBangMaCongNhan(item);
							fillThongTinNhanVien(congNhan);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			}

			private void fillThongTinNhanVien(CongNhan congNhan) throws Exception {
				txtMaCongNhan.setText(congNhan.getMaCongNhan());
				txtTenCongNhan.setText(congNhan.getTenCongNhan());
				txtSoDienThoai.setText(congNhan.getSoDienThoai());
				cmbTinhTP.addItem(congNhan.getDiaChi().getTinhTP());
				cmbTinhTP.setSelectedItem(congNhan.getDiaChi().getTinhTP());
				cmbQuanHuyen.addItem(congNhan.getDiaChi().getQuanHuyen());
				cmbQuanHuyen.setSelectedItem(congNhan.getDiaChi().getQuanHuyen());
				cmbPhuongXa.addItem(congNhan.getDiaChi().getPhuongXa());
				cmbPhuongXa.setSelectedItem(congNhan.getDiaChi().getPhuongXa());
//					cmbVaiTro.addItem(nv.getVaiTro());
				cmbTo.setSelectedItem(congNhan.getToNhom().getTenToNhom());
				cmbGioiTinh.setSelectedItem(congNhan.getGioiTinh().compareTo("Nu") == 0 ? "Nu" : "Nam");
				dtNgaySinh.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(congNhan.getNgaySinh().toString()));
				dtNgayVaoLam.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(congNhan.getNgayVaoLam().toString()));
//					lbAnh.setIcon(new javax.swing.ImageIcon(PathSetting.PATH_IMAGE_NHANVIEN + nv.getLinkAnhNV())); // NOI18N
//					lbAnh.updateUI()

			}
		});

		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					btnThemActionPerformed(e);
					// tblNhanVien.setEnabled(true);
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}

			private void btnThemActionPerformed(ActionEvent evt) {
				xoaRong();
				fillDuLieuVaoTextfield();
				trangThaiThem = true;

			}
		});
	}

	

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlQLCN = new javax.swing.JPanel();
        lblMaCongNhan = new javax.swing.JLabel();
        lblTenCongNhan = new javax.swing.JLabel();
        lblSoDienThoai = new javax.swing.JLabel();
        txtMaCongNhan = new javax.swing.JTextField();
        txtTenCongNhan = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        lblNgaySinh = new javax.swing.JLabel();
        lblNgayVaoLam = new javax.swing.JLabel();
        lblTo = new javax.swing.JLabel();
        cmbTinhTP = new javax.swing.JComboBox<>();
        cmbQuanHuyen = new javax.swing.JComboBox<>();
        cmbPhuongXa = new javax.swing.JComboBox<>();
        cmbGioiTinh = new javax.swing.JComboBox<>();
        lblTieuDe = new javax.swing.JLabel();
        lblAnhDaiDien = new javax.swing.JLabel();
        cmbTo = new javax.swing.JComboBox<>();
        scrTableCongNhan = new javax.swing.JScrollPane();
        tblCongNhan = new javax.swing.JTable();
        btnChonAnh = new javax.swing.JButton();
        pnlChucNangTo = new javax.swing.JPanel();
        pnlChucNang = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        dtNgaySinh = new com.toedter.calendar.JDateChooser();
        dtNgayVaoLam = new com.toedter.calendar.JDateChooser();
        setBackground(new java.awt.Color(255, 255, 255));

        pnlQLCN.setBackground(new java.awt.Color(255, 255, 255));
        pnlQLCN.setPreferredSize(new java.awt.Dimension(1250, 475));

        lblMaCongNhan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMaCongNhan.setText("Mã công nhân:");

        lblTenCongNhan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTenCongNhan.setText("Tên công nhân:");

        lblSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSoDienThoai.setText("Số điện thoại:");

        txtMaCongNhan.setEditable(false);
        txtMaCongNhan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaCongNhan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMaCongNhan.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

        txtTenCongNhan.setEditable(false);
        txtTenCongNhan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTenCongNhan.setBorder(null);
        txtTenCongNhan.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

        txtSoDienThoai.setEditable(false);
        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSoDienThoai.setBorder(null);
        txtSoDienThoai.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDiaChi.setText("Địa chỉ:");

        lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGioiTinh.setText("Giới tính:");

        lblNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNgaySinh.setText("Ngày sinh:");

        lblNgayVaoLam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNgayVaoLam.setText("Ngày vào làm:");

        lblTo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTo.setText("Tổ:");

        cmbTinhTP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbTinhTP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tỉnh/Thành phố" }));
        cmbTinhTP.setEnabled(false);

        cmbQuanHuyen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbQuanHuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quận/Huyện" }));
        cmbQuanHuyen.setEnabled(false);

        cmbPhuongXa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbPhuongXa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phường/Xã" }));
        cmbPhuongXa.setEnabled(false);

        cmbGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cmbGioiTinh.setEnabled(false);

        lblTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("QUẢN LÝ CÔNG NHÂN");

        lblAnhDaiDien.setBackground(new java.awt.Color(0, 204, 153));
        lblAnhDaiDien.setForeground(new java.awt.Color(0, 255, 204));

        cmbTo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tổ" }));
        cmbTo.setEnabled(false);

        scrTableCongNhan.setBackground(new java.awt.Color(255, 255, 255));
        scrTableCongNhan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách công nhân", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

        tblCongNhan.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblCongNhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã công nhân", "Tên công nhân", "Số điện thoại", "Email", "Địa chỉ", "Giới tính", "Ngày sinh", "Ngày vào làm", "Tổ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCongNhan.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblCongNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCongNhanMouseClicked(evt);
            }
        });
        scrTableCongNhan.setViewportView(tblCongNhan);

        btnChonAnh.setText("Hình ảnh");
        btnChonAnh.setEnabled(false);

        pnlChucNangTo.setBackground(new java.awt.Color(255, 255, 255));
        pnlChucNangTo.setLayout(new java.awt.BorderLayout());

        pnlChucNang.setBackground(new java.awt.Color(255, 255, 255));
        pnlChucNang.setPreferredSize(new java.awt.Dimension(698, 57));

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-20.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlChucNangLayout = new javax.swing.GroupLayout(pnlChucNang);
        pnlChucNang.setLayout(pnlChucNangLayout);
        pnlChucNangLayout.setHorizontalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnTimKiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlChucNangLayout.setVerticalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnTimKiem))
                .addContainerGap())
        );

        pnlChucNangTo.add(pnlChucNang, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlQLCNLayout = new javax.swing.GroupLayout(pnlQLCN);
        pnlQLCN.setLayout(pnlQLCNLayout);
        pnlQLCNLayout.setHorizontalGroup(
            pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlQLCNLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlQLCNLayout.createSequentialGroup()
                        .addGroup(pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSoDienThoai)
                            .addComponent(lblMaCongNhan)
                            .addComponent(lblTenCongNhan)
                            .addComponent(lblDiaChi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlQLCNLayout.createSequentialGroup()
                                .addComponent(cmbTinhTP, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbQuanHuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbPhuongXa, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTenCongNhan)
                            .addComponent(txtMaCongNhan)
                            .addComponent(txtSoDienThoai))
                        .addGap(18, 18, 18)
                        .addGroup(pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNgaySinh)
                            .addComponent(lblGioiTinh)
                            .addComponent(lblNgayVaoLam)
                            .addComponent(lblTo))
                        .addGap(31, 31, 31)
                        .addGroup(pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(162, 162, 162))
                    .addGroup(pnlQLCNLayout.createSequentialGroup()
                        .addComponent(pnlChucNangTo, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAnhDaiDien, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQLCNLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnChonAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)))
                .addGap(224, 224, 224))
            .addComponent(scrTableCongNhan, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlQLCNLayout.setVerticalGroup(
            pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLCNLayout.createSequentialGroup()
                .addComponent(lblTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlQLCNLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlQLCNLayout.createSequentialGroup()
                                .addGroup(pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMaCongNhan)
                                    .addComponent(txtMaCongNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTenCongNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTenCongNhan))
                                .addGap(20, 20, 20)
                                .addGroup(pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSoDienThoai))
                                .addGap(15, 15, 15)
                                .addGroup(pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDiaChi)
                                    .addGroup(pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmbTinhTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbQuanHuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbPhuongXa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlQLCNLayout.createSequentialGroup()
                                .addGroup(pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblGioiTinh)
                                    .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addComponent(lblNgaySinh)
                                .addGap(22, 22, 22)
                                .addComponent(lblNgayVaoLam)
                                .addGap(10, 10, 10)
                                .addGroup(pnlQLCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbTo)
                                    .addComponent(lblTo))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlChucNangTo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlQLCNLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAnhDaiDien, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChonAnh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrTableCongNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addContainerGap())
        );
        scrTableCongNhan.setBackground(new java.awt.Color(255, 255, 255));
        scrTableCongNhan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

        tblCongNhan.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        dsCN = congNhanDAO.layDanhSachCongNhan();
        System.out.println(dsCN);
        updateModelTable(dsCN, HEADERS);
        tblCongNhan.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblCongNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCongNhanMouseClicked(evt);
            }
        });
        scrTableCongNhan.setViewportView(tblCongNhan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlQLCN, javax.swing.GroupLayout.DEFAULT_SIZE, 1637, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlQLCN, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

	private void tblCongNhanMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblCongNhanMouseClicked

	}// GEN-LAST:event_tblCongNhanMouseClicked

	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemActionPerformed
		pnlChucNangTo.removeAll();
		pnlChucNangTo.setLayout(new BorderLayout());
		PanelXacNhan pnlXacNhan = new PanelXacNhan();
		pnlChucNangTo.add(pnlXacNhan);

		ActionListener listenerHuy = new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("ok");
				pnlChucNangTo.removeAll();
				pnlChucNangTo.setLayout(new BorderLayout());
				pnlChucNangTo.add(pnlChucNang);
				pnlChucNangTo.updateUI();
			}
		};
		pnlXacNhan.huyAddActionListener(listenerHuy);
		pnlChucNangTo.repaint();
		pnlChucNangTo.revalidate();
	}// GEN-LAST:event_btnThemActionPerformed

	private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSuaActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnSuaActionPerformed

	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnXoaActionPerformed

	private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTimKiemActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnTimKiemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cmbGioiTinh;
    private javax.swing.JComboBox<String> cmbPhuongXa;
    private javax.swing.JComboBox<String> cmbQuanHuyen;
    private javax.swing.JComboBox<String> cmbTinhTP;
    private javax.swing.JComboBox<String> cmbTo;
    private javax.swing.JLabel lblAnhDaiDien;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblMaCongNhan;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblNgayVaoLam;
    private com.toedter.calendar.JDateChooser dtNgaySinh;
    private com.toedter.calendar.JDateChooser dtNgayVaoLam;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JLabel lblTenCongNhan;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JLabel lblTo;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JPanel pnlChucNangTo;
    private javax.swing.JPanel pnlQLCN;
    private javax.swing.JScrollPane scrTableCongNhan;
    private javax.swing.JTable tblCongNhan;
    private javax.swing.JTextField txtMaCongNhan;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenCongNhan;
    // End of variables declaration//GEN-END:variables
}
