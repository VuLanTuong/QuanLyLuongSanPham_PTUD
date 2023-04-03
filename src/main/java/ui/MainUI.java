/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ui.ChamCongNhanVien;
import ui.QuanLyCN;
import ui.QuanLyCongDoan;
import ui.QuanLyLuongCN;
import ui.QuanLyLuongNV;
import ui.QuanLyNV;
import ui.QuanLySP;
import ui.ThongKeDoanhThu;
import ui.ThongKeLuongCN;
import ui.ThongKeLuongNV;
import ui.TrangChu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import ui.MenuItem;
import java.awt.Window.Type;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;

/**
 *
 * @author Hoang TRuong
 */
public class MainUI extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public MainUI() {
    	setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
    	setExtendedState(Frame.MAXIMIZED_BOTH);
        initComponents();
        this.setDefaultCloseOperation(MainUI.EXIT_ON_CLOSE);
        execute();
    }

    private void execute() {
        ImageIcon iconTrangChu = new ImageIcon(setting.PathSetting.PATH_ICON+"iconshome.png");
        ImageIcon iconNhanVien = new ImageIcon(setting.PathSetting.PATH_ICON+"team.png");
        ImageIcon iconCongNhan = new ImageIcon(setting.PathSetting.PATH_ICON+"tutorial.png");
        ImageIcon iconSanPham = new ImageIcon(setting.PathSetting.PATH_ICON+"list.png");
        ImageIcon iconThongKe = new ImageIcon(setting.PathSetting.PATH_ICON+"growth.png");
        ImageIcon iconSubMenu = new ImageIcon(setting.PathSetting.PATH_ICON+"o.png");
        
        panelBody.add(new TrangChu());
        //  create submenu nhanvien 
        MenuItem menuCapNhatNV = new MenuItem(iconSubMenu, "Cập nhật", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new QuanLyNV());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuChamCongNV = new MenuItem(iconSubMenu, "Chấm công", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new ChamCongNhanVien());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuXemLuongNV = new MenuItem(iconSubMenu, "Lương", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new QuanLyLuongNV());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        //  create submenu congnhan 
        MenuItem menuCapNhatCN = new MenuItem(iconSubMenu, "Cập nhật", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new QuanLyCN());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuChamCongCN = new MenuItem(iconSubMenu, "Chấm công", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new ui.ChamCongCongNhan());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuXemLuongCN = new MenuItem(iconSubMenu, "Lương", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new QuanLyLuongCN());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        //  create submenu sanpham 
        MenuItem menuCapNhatSP = new MenuItem(iconSubMenu, "Cập nhật", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new QuanLySP());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuPhanCongDoan = new MenuItem(iconSubMenu, "Phân công đoạn", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new QuanLyCongDoan());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });

    
        //  create submenu thongke
        MenuItem menuTKLuongNV = new MenuItem(iconSubMenu, "Lương nhân viên", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new ThongKeLuongNV());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuTKLuongCN = new MenuItem(iconSubMenu, "Lương công nhân", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new ThongKeLuongCN());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuTKDoanhThu = new MenuItem(iconSubMenu, "Doanh thu", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new ThongKeDoanhThu());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        
        MenuItem menuTrangChu = new MenuItem(iconTrangChu, "Trang chủ", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBody.removeAll();
                panelBody.add(new TrangChu());
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuNhanVien = new MenuItem(iconNhanVien, "Nhân viên", null, menuCapNhatNV, menuChamCongNV, menuXemLuongNV);
        MenuItem menuCongNhan = new MenuItem(iconCongNhan, "Công nhân", null, menuCapNhatCN, menuChamCongCN, menuXemLuongCN);
        MenuItem menuSanPham = new MenuItem(iconSanPham, "Sản phẩm", null, menuCapNhatSP, menuPhanCongDoan);
        MenuItem menuThongKe = new MenuItem(iconThongKe, "Thống kê", null, menuTKLuongNV, menuTKLuongCN, menuTKDoanhThu);
        addMenu(menuTrangChu, menuNhanVien, menuCongNhan, menuSanPham,menuThongKe);
    }

    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        panelAccount = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        panelBody = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenu.setPreferredSize(new java.awt.Dimension(250, 384));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(4, 4));

        menus.setBackground(new java.awt.Color(255, 255, 255));
        menus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        panelAccount.setBackground(new java.awt.Color(255, 255, 255));
        panelAccount.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setIcon(new javax.swing.ImageIcon(setting.PathSetting.PATH_ICON+"role-model.png")); // NOI18N

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Nguyễn Văn Nam");
        jTextField1.setBorder(null);

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(setting.PathSetting.PATH_ICON+"key-person.png")); // NOI18N
        jButton9.setText("Đổi mật khẩu");

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(setting.PathSetting.PATH_ICON+"logout.png")); // NOI18N
        jButton10.setText("Đăng xuất");

        javax.swing.GroupLayout panelAccountLayout = new javax.swing.GroupLayout(panelAccount);
        panelAccount.setLayout(panelAccountLayout);
        panelAccountLayout.setHorizontalGroup(
            panelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1)
            .addGroup(panelAccountLayout.createSequentialGroup()
                .addGroup(panelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelAccountLayout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(jLabel2))
                        .addGroup(panelAccountLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panelAccountLayout.setVerticalGroup(
            panelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccountLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10))
        );

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setBackground(new java.awt.Color(255, 255, 255));
        panelBody.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        setSize(new Dimension(1920, 1080));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelAccount;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
