/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.Dialog;
import java.util.Locale;

/**
 *
 * @author Hoang Truong
 */
public class LayDSChamCongCN extends javax.swing.JPanel {

    /**
     * Creates new form LayDSChamCongCN
     */
    public LayDSChamCongCN() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDanhSachPhanCong = new javax.swing.JPanel();
        scrTablePhanCong = new javax.swing.JScrollPane();
        tblPhanCongCongNhan = new javax.swing.JTable();
        lblTinhTrang = new javax.swing.JLabel();
        dtNgayChamCong = new com.toedter.calendar.JDateChooser();
        lblNgayChamCong = new javax.swing.JLabel();
        lblSoLuongLam = new javax.swing.JLabel();
        cmbTinhTrang = new javax.swing.JComboBox<>();
        btnChamCong = new javax.swing.JButton();
        txtSoLuongLam = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlDanhSachPhanCong.setBackground(new java.awt.Color(255, 255, 255));
        pnlDanhSachPhanCong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrTablePhanCong.setBackground(new java.awt.Color(255, 255, 255));
        scrTablePhanCong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phân công", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N

        tblPhanCongCongNhan.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblPhanCongCongNhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phân công", "Mã công nhân", "Tên công nhân", "Mã công đoạn", "Tên công đoạn", "Mã sản phẩm", "Tên sản phẩm", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhanCongCongNhan.setSelectionBackground(new java.awt.Color(232, 57, 95));
        scrTablePhanCong.setViewportView(tblPhanCongCongNhan);

        pnlDanhSachPhanCong.add(scrTablePhanCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 550));

        lblTinhTrang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTinhTrang.setText("Tình trạng:");
        pnlDanhSachPhanCong.add(lblTinhTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, -1, -1));

        dtNgayChamCong.setDateFormatString("yyyy-MM-dd");
        dtNgayChamCong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlDanhSachPhanCong.add(dtNgayChamCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, 240, 30));

        lblNgayChamCong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNgayChamCong.setText("Ngày chấm công:");
        pnlDanhSachPhanCong.add(lblNgayChamCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, -1, -1));

        lblSoLuongLam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSoLuongLam.setText("Số lượng làm:");
        pnlDanhSachPhanCong.add(lblSoLuongLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, -1, -1));

        cmbTinhTrang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đi đúng giờ", "Đi trễ", "Nghỉ có phép", "Nghỉ không phép" }));
        pnlDanhSachPhanCong.add(cmbTinhTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 90, 170, 30));

        btnChamCong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnChamCong.setText("Chấm công");
        pnlDanhSachPhanCong.add(btnChamCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 150, 40));

        txtSoLuongLam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlDanhSachPhanCong.add(txtSoLuongLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 140, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1162, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(pnlDanhSachPhanCong, javax.swing.GroupLayout.PREFERRED_SIZE, 1156, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnlDanhSachPhanCong, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChamCong;
    private javax.swing.JComboBox<String> cmbTinhTrang;
    private com.toedter.calendar.JDateChooser dtNgayChamCong;
    private javax.swing.JLabel lblNgayChamCong;
    private javax.swing.JLabel lblSoLuongLam;
    private javax.swing.JLabel lblTinhTrang;
    private javax.swing.JPanel pnlDanhSachPhanCong;
    private javax.swing.JScrollPane scrTablePhanCong;
    private javax.swing.JTable tblPhanCongCongNhan;
    private javax.swing.JTextField txtSoLuongLam;
    // End of variables declaration//GEN-END:variables
}
