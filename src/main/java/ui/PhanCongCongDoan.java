/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.border.MatteBorder;


/**
 *
 * @author ADMIN
 */
public class PhanCongCongDoan extends javax.swing.JPanel {

    /**
     * Creates new form PhanCongCongDoan
     */
    public PhanCongCongDoan() {
        initComponents();
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
        jPanel5 = new javax.swing.JPanel();
        scrTableSanPham = new javax.swing.JScrollPane();
        tblDanhSachSanPham = new javax.swing.JTable();
        lblMaCongDoan = new javax.swing.JLabel();
        lblMaPhanCOng = new javax.swing.JLabel();
        lblMaCongNhan = new javax.swing.JLabel();
        lblTenCongNhan = new javax.swing.JLabel();
        lblTenCongDoan = new javax.swing.JLabel();
        lblTenSanPham = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        lblMaSanPham = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbCaLam = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtMaPhanCong = new javax.swing.JTextField();
        txtMaCongNhan = new javax.swing.JTextField();
        txtTenCongNhan = new javax.swing.JTextField();
        txtMaCongDoan = new javax.swing.JTextField();
        txtTenCongDoan = new javax.swing.JTextField();
        txtSoLuongCD = new javax.swing.JTextField();
        txtMaSanPham = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        pnlChucNangTo = new javax.swing.JPanel();
        pnlChucNang = new javax.swing.JPanel();
        btnPhanCong = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        scrTableCongNhan = new javax.swing.JScrollPane();
        tblCongNhan = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1250, 475));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrTableSanPham.setBackground(new java.awt.Color(255, 255, 255));
        scrTableSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách công nhân", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N

        tblDanhSachSanPham.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblDanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã công nhân", "Tên công nhân"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachSanPham.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblDanhSachSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachSanPhamMouseClicked(evt);
            }
        });
        scrTableSanPham.setViewportView(tblDanhSachSanPham);

        jPanel5.add(scrTableSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 380, 420));

        lblMaCongDoan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMaCongDoan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMaCongDoan.setText("Mã công đoạn:");
        jPanel5.add(lblMaCongDoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, 170, 30));

        lblMaPhanCOng.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMaPhanCOng.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMaPhanCOng.setText("Mã phân công:");
        jPanel5.add(lblMaPhanCOng, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 190, 30));

        lblMaCongNhan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMaCongNhan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMaCongNhan.setText("Mã công nhân:");
        jPanel5.add(lblMaCongNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, 190, 30));

        lblTenCongNhan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTenCongNhan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTenCongNhan.setText("Tên công nhân:");
        jPanel5.add(lblTenCongNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, 190, 30));

        lblTenCongDoan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTenCongDoan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTenCongDoan.setText("Tên công đoạn:");
        jPanel5.add(lblTenCongDoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 220, 170, 30));

        lblTenSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTenSanPham.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTenSanPham.setText("Tên sản phẩm:");
        jPanel5.add(lblTenSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 340, 170, 30));

        lblSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSoLuong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSoLuong.setText("Số lượng:");
        jPanel5.add(lblSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, 170, 30));

        lblMaSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMaSanPham.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMaSanPham.setText("Mã sản phẩm:");
        jPanel5.add(lblMaSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 300, 170, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("PHÂN CÔNG");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Số lượng:");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Ca làm:");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 60, 30));

        cmbCaLam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbCaLam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sáng", "Chiều", "Tối" }));
        jPanel5.add(cmbCaLam, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 100, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("THÔNG TIN CHI TIẾT PHÂN CÔNG");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, -1, -1));

        txtSoLuong.setBackground(new java.awt.Color(255, 255, 255));
        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSoLuong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSoLuong.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        jPanel5.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 100, 25));

        txtMaPhanCong.setEditable(false);
        txtMaPhanCong.setBackground(new java.awt.Color(255, 255, 255));
        txtMaPhanCong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaPhanCong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMaPhanCong.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        jPanel5.add(txtMaPhanCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 60, 187, 25));

        txtMaCongNhan.setEditable(false);
        txtMaCongNhan.setBackground(new java.awt.Color(255, 255, 255));
        txtMaCongNhan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaCongNhan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMaCongNhan.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        jPanel5.add(txtMaCongNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 100, 187, 25));

        txtTenCongNhan.setEditable(false);
        txtTenCongNhan.setBackground(new java.awt.Color(255, 255, 255));
        txtTenCongNhan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTenCongNhan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTenCongNhan.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        jPanel5.add(txtTenCongNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 140, 187, 25));

        txtMaCongDoan.setEditable(false);
        txtMaCongDoan.setBackground(new java.awt.Color(255, 255, 255));
        txtMaCongDoan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaCongDoan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMaCongDoan.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        jPanel5.add(txtMaCongDoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 180, 187, 25));

        txtTenCongDoan.setEditable(false);
        txtTenCongDoan.setBackground(new java.awt.Color(255, 255, 255));
        txtTenCongDoan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTenCongDoan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTenCongDoan.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        jPanel5.add(txtTenCongDoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, 187, 25));

        txtSoLuongCD.setEditable(false);
        txtSoLuongCD.setBackground(new java.awt.Color(255, 255, 255));
        txtSoLuongCD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSoLuongCD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSoLuongCD.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        jPanel5.add(txtSoLuongCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 260, 187, 25));

        txtMaSanPham.setEditable(false);
        txtMaSanPham.setBackground(new java.awt.Color(255, 255, 255));
        txtMaSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaSanPham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMaSanPham.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        jPanel5.add(txtMaSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 300, 187, 25));

        txtTenSanPham.setEditable(false);
        txtTenSanPham.setBackground(new java.awt.Color(255, 255, 255));
        txtTenSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTenSanPham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTenSanPham.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        jPanel5.add(txtTenSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 340, 187, 25));

        pnlChucNangTo.setBackground(new java.awt.Color(255, 255, 255));
        pnlChucNangTo.setLayout(new java.awt.BorderLayout());

        pnlChucNang.setBackground(new java.awt.Color(255, 255, 255));
        pnlChucNang.setPreferredSize(new java.awt.Dimension(698, 57));

        btnPhanCong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPhanCong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-20.png"))); // NOI18N
        btnPhanCong.setText("Phân công");
        btnPhanCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanCongActionPerformed(evt);
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
                .addComponent(btnPhanCong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnTimKiem)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        pnlChucNangLayout.setVerticalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPhanCong)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnTimKiem))
                .addContainerGap())
        );

        pnlChucNangTo.add(pnlChucNang, java.awt.BorderLayout.CENTER);

        jPanel5.add(pnlChucNangTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 590, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1223, 489));

        scrTableCongNhan.setBackground(new java.awt.Color(255, 255, 255));
        scrTableCongNhan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phân công", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N

        tblCongNhan.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblCongNhan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCongNhan.setSelectionBackground(new java.awt.Color(232, 57, 95));
        scrTableCongNhan.setViewportView(tblCongNhan);

        jPanel1.add(scrTableCongNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 495, 1223, 329));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1223, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDanhSachSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachSanPhamMouseClicked

    }//GEN-LAST:event_tblDanhSachSanPhamMouseClicked

    private void btnPhanCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanCongActionPerformed
        
    }//GEN-LAST:event_btnPhanCongActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
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
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPhanCong;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cmbCaLam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblMaCongDoan;
    private javax.swing.JLabel lblMaCongNhan;
    private javax.swing.JLabel lblMaPhanCOng;
    private javax.swing.JLabel lblMaSanPham;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenCongDoan;
    private javax.swing.JLabel lblTenCongNhan;
    private javax.swing.JLabel lblTenSanPham;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JPanel pnlChucNangTo;
    private javax.swing.JScrollPane scrTableCongNhan;
    private javax.swing.JScrollPane scrTableSanPham;
    private javax.swing.JTable tblCongNhan;
    private javax.swing.JTable tblDanhSachSanPham;
    private javax.swing.JTextField txtMaCongDoan;
    private javax.swing.JTextField txtMaCongNhan;
    private javax.swing.JTextField txtMaPhanCong;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuongCD;
    private javax.swing.JTextField txtTenCongDoan;
    private javax.swing.JTextField txtTenCongNhan;
    private javax.swing.JTextField txtTenSanPham;
    // End of variables declaration//GEN-END:variables
}
