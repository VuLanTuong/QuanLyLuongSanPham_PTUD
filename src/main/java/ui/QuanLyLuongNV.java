/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;

import dao.BangLuongNhanVienDAO;
import entity.BangLuongNhanVien;
import entity.CongNhan;
import entity.NhanVien;
import tablemodels.BangLuongNhanVienTableModel;
import tablemodels.CongNhanTableModel;

/**
 *

 */
public class QuanLyLuongNV extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyLuongNV
     */
	private static final String[] HEADERS = {"Mã bảng lương","Mã nhân viên","Họ tên","Vai trò","Hệ số lương",
			"Lương cơ bản", "Phụ cấp", "Tổng lương"};
	private NhanVien nhanVien;
	private BangLuongNhanVienDAO bangLuongNhanVienDAO;
    private BangLuongNhanVienTableModel blNVTableModel;
    private List<BangLuongNhanVien> dsBLNV;
    private boolean trangThaiThem;
    
    public QuanLyLuongNV() {
    	nhanVien = new NhanVien();
    	tblQuanLiLuongNV = new JTable();
    	bangLuongNhanVienDAO = new BangLuongNhanVienDAO();
    	dsBLNV = new ArrayList<>();
    	trangThaiThem = false;
    	tblQuanLiLuongNV.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
        initComponents();
        themSuKien();
        
    }
    private void updateModelTable(List<BangLuongNhanVien> dsCN, String[] headers) {
		blNVTableModel = new BangLuongNhanVienTableModel(headers, dsCN);
		tblQuanLiLuongNV.setModel(blNVTableModel);
		tblQuanLiLuongNV.updateUI();
	}
    
    
    private void xoaRong() {
		txtHoTen.setText("");
		txtHeSoLuong.setText("");
		txtLuong.setText("");
		txtMaLuong.setText("");
		txtPhuCap.setText("");
		txtTienThuong.setText("");
		txtVaiTro.setText("");
		txtTongLuong.setText("");
		txtMaNV.setText("");
		
	}
    
    private void fillDuLieuVaoTextfield() {
		txtMaNV.setEditable(true);
		txtMaLuong.setEditable(true);
		txtHoTen.setEditable(true);
		txtLuong.setEditable(true);
		txtHeSoLuong.setEditable(true);
		txtPhuCap.setEditable(true);
		txtVaiTro.setEditable(true);
		txtTongLuong.setEditable(true);
		}
    
    private void themSuKien() {
		dsBLNV = bangLuongNhanVienDAO.layDanhSachBangLuongNV();
		updateModelTable(dsBLNV, HEADERS);
		if (tblQuanLiLuongNV.getColumnModel().getColumnCount() > 0) {
			tblQuanLiLuongNV.getColumnModel().getColumn(3).setMinWidth(320);
		}
		tblQuanLiLuongNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String item = (String) tblQuanLiLuongNV.getModel().getValueAt(tblQuanLiLuongNV.getSelectedRow(), 0);
				if (item != null) {
					BangLuongNhanVien bangLuongNhanVien = null;
					try {
						if (!trangThaiThem) {

							bangLuongNhanVien = bangLuongNhanVienDAO.timBangLuongNV(item);
							fillThongTinBangLuong(bangLuongNhanVien);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			}

			private void fillThongTinBangLuong(BangLuongNhanVien bangLuongNhanVien) throws Exception {
				String heSoLuong = Double.toString(bangLuongNhanVien.getHeSoLuong());
				String phuCap = Double.toString(bangLuongNhanVien.getPhuCap());
				String luongCoBan = Double.toString(bangLuongNhanVien.getLuongCoBan());
				txtHoTen.setText(bangLuongNhanVien.getNhanVien().getTenNhanVien());
				txtHeSoLuong.setText(heSoLuong);
				txtLuong.setText(luongCoBan);
				txtMaLuong.setText(bangLuongNhanVien.getMaBangLuong());
				txtPhuCap.setText(phuCap);
				txtTienThuong.setText("");
				txtVaiTro.setText(bangLuongNhanVien.getNhanVien().getVaiTro());
				txtTongLuong.setText("");
				txtMaNV.setText(bangLuongNhanVien.getNhanVien().getMaNhanVien());
				

			}
		});
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane7 = new javax.swing.JScrollPane();
        tblQuanLiLuongNV = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnInBangLuong = new javax.swing.JButton();
        lblHoTen = new javax.swing.JLabel();
        txtMaLuong = new javax.swing.JTextField();
        lblHeSoLuong = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtHeSoLuong = new javax.swing.JTextField();
        lblTienThuong = new javax.swing.JLabel();
        lblLuong = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        cmbThang = new javax.swing.JComboBox<>();
        btnTinhLuong = new javax.swing.JButton();
        lblMaLuong = new javax.swing.JLabel();
        txtPhuCap = new javax.swing.JTextField();
        txtTongLuong = new javax.swing.JTextField();
        lblTongLuong = new javax.swing.JLabel();
        lblPhuCap = new javax.swing.JLabel();
        txtTienThuong = new javax.swing.JTextField();
        btnXoaRong = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        lblMaNV = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtVaiTro = new javax.swing.JTextField();
        lblVaiTro = new javax.swing.JLabel();
        cmbNam = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));

        tblQuanLiLuongNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã lương", "Mã nhân viên", "Họ và tên", "Vai trò", "Lương", "Hệ số lương", "Tiền thưởng", "Phụ cấp", "Tổng lương"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQuanLiLuongNV.setFillsViewportHeight(true);
        tblQuanLiLuongNV.setRowHeight(30);
        tblQuanLiLuongNV.setSurrendersFocusOnKeystroke(true);
        jScrollPane7.setViewportView(tblQuanLiLuongNV);

        tblQuanLiLuongNV.setSelectionBackground(new java.awt.Color(232, 57, 95));
        dsBLNV = bangLuongNhanVienDAO.layDanhSachBangLuongNV();
        updateModelTable(dsBLNV, HEADERS);
        
        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("QUẢN LÝ LƯƠNG NHÂN VIÊN");

        btnInBangLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnInBangLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_printbangluong.png"))); // NOI18N
        btnInBangLuong.setText("In bảng lương");
        btnInBangLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInBangLuongMouseClicked(evt);
            }
        });

        lblHoTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblHoTen.setText("Họ tên:");

        txtMaLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaLuong.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

        lblHeSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblHeSoLuong.setText("Hệ số lương:");

        txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtHoTen.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

        txtHeSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtHeSoLuong.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

        lblTienThuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTienThuong.setText("Tiền thưởng:");

        lblLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblLuong.setText("Lương:");

        txtLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtLuong.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

        cmbThang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cmbThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbThangActionPerformed(evt);
            }
        });

        btnTinhLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTinhLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_tinhluong.png"))); // NOI18N
        btnTinhLuong.setText("Tính lương");
        btnTinhLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhLuongActionPerformed(evt);
            }
        });

        lblMaLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMaLuong.setText("Mã lương:");

        txtPhuCap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPhuCap.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

        txtTongLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTongLuong.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

        lblTongLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTongLuong.setText("Tổng lương:");

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

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");

        lblMaNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMaNV.setText("Mã nhân viên:");

        txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaNV.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

        txtVaiTro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtVaiTro.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

        lblVaiTro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblVaiTro.setText("Vai trò:");

        cmbNam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Năm", "2021", "2022", "2023" }));
        cmbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNamActionPerformed(evt);
            }
        });
       
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaLuong)
                            .addComponent(lblHoTen)
                            .addComponent(lblVaiTro)
                            .addComponent(lblTongLuong))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMaNV)
                        .addGap(27, 27, 27)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblTienThuong)
                                .addComponent(lblLuong))
                            .addGap(46, 46, 46)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTienThuong, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnXoaRong)
                                .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblHeSoLuong)
                                .addComponent(lblPhuCap))
                            .addGap(44, 44, 44)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPhuCap, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtHeSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTimKiem)
                        .addGap(197, 197, 197)))
                .addGap(0, 208, Short.MAX_VALUE)
                .addComponent(cmbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(cmbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btnTinhLuong)
                .addGap(65, 65, 65)
                .addComponent(btnInBangLuong)
                .addGap(98, 98, 98))
            .addComponent(jScrollPane7)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHeSoLuong)
                    .addComponent(txtHeSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaNV)
                    .addComponent(cmbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTinhLuong)
                    .addComponent(btnInBangLuong))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaLuong)
                    .addComponent(txtMaLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhuCap)
                    .addComponent(txtPhuCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHoTen)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTienThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTienThuong))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVaiTro)
                            .addComponent(txtVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblLuong)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongLuong)
                    .addComponent(txtTongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem)
                    .addComponent(btnXoaRong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbThangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbThangActionPerformed

    private void btnTinhLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTinhLuongActionPerformed

    private void btnXoaRongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaRongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaRongActionPerformed

    private void cmbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbNamActionPerformed

    private void btnInBangLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInBangLuongMouseClicked
        JDialog inBangLuong = new JDialog();
        inBangLuong.add(new InBangLuong());
        inBangLuong.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        inBangLuong.setSize(900, 700);
        inBangLuong.setLocationRelativeTo(null);
        inBangLuong
                .setVisible(true);
    }//GEN-LAST:event_btnInBangLuongMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInBangLuong;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTinhLuong;
    private javax.swing.JButton btnXoaRong;
    private javax.swing.JComboBox<String> cmbNam;
    private javax.swing.JComboBox<String> cmbThang;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblHeSoLuong;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblLuong;
    private javax.swing.JLabel lblMaLuong;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblPhuCap;
    private javax.swing.JLabel lblTienThuong;
    private javax.swing.JLabel lblTongLuong;
    private javax.swing.JLabel lblVaiTro;
    private javax.swing.JTable tblQuanLiLuongNV;
    private javax.swing.JTextField txtHeSoLuong;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMaLuong;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtPhuCap;
    private javax.swing.JTextField txtTienThuong;
    private javax.swing.JTextField txtTongLuong;
    private javax.swing.JTextField txtVaiTro;
    // End of variables declaration//GEN-END:variables
}
