/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

/**
 *
 * @author Hoang Truong
 */
public class ThongKeLuongCN extends javax.swing.JPanel {

    /**
     * Creates new form ThongKeLuongNV
     */
    public ThongKeLuongCN() {
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

        jComboBox5 = new javax.swing.JComboBox<>();
        jPanel26 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cmbTo = new javax.swing.JComboBox<>();
        btnInBangThongKe = new javax.swing.JButton();
        jLabel112 = new javax.swing.JLabel();
        btnThongKe = new javax.swing.JButton();
        cmbTuNam = new javax.swing.JComboBox<>();
        cmbDenNam = new javax.swing.JComboBox<>();
        jLabel119 = new javax.swing.JLabel();
        cmbTuThang = new javax.swing.JComboBox<>();
        cmbDenThang = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbLoaiThongKe = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel117.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel117.setText("Tổ");
        jPanel26.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 30, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, 780, 470));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 710, 460));

        cmbTo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tổ áo khoác", "Tổ áo thun", "Tổ áo sơ mi", "Tổ quần tây", "Tổ đồ bộ" }));
        jPanel26.add(cmbTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 30, -1, -1));

        btnInBangThongKe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnInBangThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_printbangluong.png"))); // NOI18N
        btnInBangThongKe.setText("In bảng thống kê");
        btnInBangThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInBangThongKeActionPerformed(evt);
            }
        });
        jPanel26.add(btnInBangThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 200, 40));

        jLabel112.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel112.setText("Đến:");
        jPanel26.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 39, -1));

        btnThongKe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/growth.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });
        jPanel26.add(btnThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 200, -1));

        cmbTuNam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbTuNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2022", "2023" }));
        jPanel26.add(cmbTuNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, 30));

        cmbDenNam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbDenNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2022", "2023" }));
        jPanel26.add(cmbDenNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        jLabel119.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel119.setText("Từ:");
        jPanel26.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 39, -1));

        cmbTuThang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbTuThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jPanel26.add(cmbTuThang, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        cmbDenThang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbDenThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jPanel26.add(cmbDenThang, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Tháng");
        jPanel26.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Năm");
        jPanel26.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Tháng");
        jPanel26.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Năm");
        jPanel26.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        cmbLoaiThongKe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbLoaiThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống kê lương công nhân theo tháng", "Thống kê công nhân có số lượng sản phẩm cao nhất", "Thống kê công nhân có số lượng sản phẩm thấp nhất", "Thống kê tổ có số lượng sản phẩm cao nhất" }));
        cmbLoaiThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLoaiThongKeActionPerformed(evt);
            }
        });
        jPanel26.add(cmbLoaiThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 360, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Chọn loại thống kê:");
        jPanel26.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THỐNG KÊ LƯƠNG CÔNG NHÂN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1713, Short.MAX_VALUE)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInBangThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInBangThongKeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInBangThongKeActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void cmbLoaiThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLoaiThongKeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbLoaiThongKeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInBangThongKe;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JComboBox<String> cmbDenNam;
    private javax.swing.JComboBox<String> cmbDenThang;
    private javax.swing.JComboBox<String> cmbLoaiThongKe;
    private javax.swing.JComboBox<String> cmbTo;
    private javax.swing.JComboBox<String> cmbTuNam;
    private javax.swing.JComboBox<String> cmbTuThang;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel26;
    // End of variables declaration//GEN-END:variables
}