/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;

import dao.BangChamCongNhanVienDAO;
import dao.LuuFile;
import dao.NhanVienDAO;
import entity.BangChamCongCongNhan;
import entity.BangChamCongNhanVien;
import entity.CongNhan;
import entity.NhanVien;
import tablemodels.ChiTietLuongCongNhanTableModel;
import tablemodels.ChiTietLuongNhanVienTableModel;

/**
 *
 * @author 1805v
 */
public class ChiTietBangLuongNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form ChiTietBangLuongNhanVien
     */
	
	private static final String[] HEADERS = {
            "STT", "Ngày làm", "Số giờ làm thêm", "Trạng thái đi làm", "Tình trạng chấm công"
        };
	
	private ChiTietLuongNhanVienTableModel chiTietLuongNhanVienTableModel;
	private String maNhanVien;
	private int thangChamCong;
	private int namChamCong;
	private NhanVien nhanVien;
	
	
    public ChiTietBangLuongNhanVien(int thang, int nam, String maNhanVien) {
    	this.thangChamCong = thang;
		this.namChamCong = nam;
		this.maNhanVien = maNhanVien;
		nhanVien = new NhanVien();
        initComponents();
        themSuKien();
    }

    
    private void updateModelTable(List<BangChamCongNhanVien> dsChamCong, String[] headers) {
		chiTietLuongNhanVienTableModel = new ChiTietLuongNhanVienTableModel(headers, dsChamCong);
		tblBangLuongChiTiet.setModel(chiTietLuongNhanVienTableModel);
		tblBangLuongChiTiet.updateUI();
	}
    private void themSuKien() {
		// TODO Auto-generated method stub
    	
    	BangChamCongNhanVienDAO bangChamCongNhanVienDAO = new BangChamCongNhanVienDAO();
    	List<BangChamCongNhanVien> dsbangChamCongNhanVien = bangChamCongNhanVienDAO.layDanhSachCCNVTheoNhanVien(maNhanVien, thangChamCong, namChamCong);
		NhanVienDAO nhanVienDAO = new NhanVienDAO();
		nhanVien = nhanVienDAO.timNhanVienBangMaNhanVien(maNhanVien);
		
		txtMaNhanVien.setText(maNhanVien);
		txtTenNhanVien.setText(nhanVien.getTenNhanVien());
		txtMaNhanVien.setEditable(false);
		txtTenNhanVien.setEditable(false);
		
		if(dsbangChamCongNhanVien != null) {
			 jLabel1.setText("CHI TIẾT LƯƠNG NHÂN VIÊN TRONG THÁNG " + (dsbangChamCongNhanVien.get(0).getNgayChamCong().getMonth() + 1) + "/" + (dsbangChamCongNhanVien.get(0).getNgayChamCong().getYear() + 1900));
		}
		
		updateModelTable(dsbangChamCongNhanVien, HEADERS);

		
		btnInChiTiet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Date ngayIn = new java.sql.Date(new java.util.Date().getTime());
				SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
				String formatDate = dt.format(ngayIn);


				String outputFilePath = null;
				String thang = String.valueOf(thangChamCong);
				String nam = String.valueOf(namChamCong);
				
				try {

					JFileChooser luuFile = new JFileChooser();
					luuFile.setDialogTitle("Chọn thư mục lưu");

					int luaChon = luuFile.showSaveDialog(null);

					if (luaChon == JFileChooser.APPROVE_OPTION) {
						String filePath = luuFile.getSelectedFile().getAbsolutePath();
						
						if (filePath != null) {
							outputFilePath = filePath + ".pdf";
						}


						outputFilePath = filePath + ".pdf";

					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}

				LuuFile luuFile = new LuuFile();
				
				boolean ketQua = luuFile.InBangLuong(outputFilePath, thang, nam, "NV", tblBangLuongChiTiet);
				
				if (ketQua){
					JOptionPane.showMessageDialog(null, "In thành công");
				}
				else {
					JOptionPane.showMessageDialog(null, "In thất bại");

				}

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

        jPanel1 = new javax.swing.JPanel();
        scrChiTietBangLuong = new javax.swing.JScrollPane();
        tblBangLuongChiTiet = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        txtMaNhanVien = new javax.swing.JTextField();
        btnInChiTiet = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrChiTietBangLuong.setBackground(new java.awt.Color(255, 255, 255));
        scrChiTietBangLuong.setBorder(null);

        tblBangLuongChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblBangLuongChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Ngày làm", "Số giờ làm thêm", "Trạng thái đi làm", "Tình trạng chấm công"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBangLuongChiTiet.setSelectionBackground(new java.awt.Color(232, 57, 95));
        scrChiTietBangLuong.setViewportView(tblBangLuongChiTiet);

        jPanel1.add(scrChiTietBangLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1060, 480));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("CHI TIẾT LƯƠNG NHÂN VIÊN TRONG THÁNG");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Tên nhân viên");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Mã nhân viên");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txtTenNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTenNhanVien.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        jPanel1.add(txtTenNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 170, 30));

        txtMaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaNhanVien.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        txtMaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNhanVienActionPerformed(evt);
            }
        });
        jPanel1.add(txtMaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 160, 30));

        btnInChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnInChiTiet.setText("In chi tiết");
        jPanel1.add(btnInChiTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1320, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 125, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 125, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNhanVienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInChiTiet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrChiTietBangLuong;
    private javax.swing.JTable tblBangLuongChiTiet;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtTenNhanVien;
    // End of variables declaration//GEN-END:variables
}
