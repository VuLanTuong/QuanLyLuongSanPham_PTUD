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
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import dao.CongNhanDAO;
import dao.DiaChiDAO;
import dao.ToNhomDAO;
import entity.CongNhan;
import entity.DiaChi;
import entity.NhanVien;
import entity.TaiKhoan;
import entity.ToNhom;
import setting.PathSetting;
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
	private ToNhomDAO toNhomDAO;
	private static final String[] HEADERS = { "Mã công nhân", "Tên công nhân", "Số điện thoai", "Địa chỉ",
			"Ngày vào làm", "Ngày sinh", "Giới tính", "Tổ" };

	public QuanLyCN() {
		tblCongNhan = new JTable();
		congNhanDAO = new CongNhanDAO();
		trangThaiThem = false;
		diaChiDAO = new DiaChiDAO();
		toNhomDAO = new ToNhomDAO();
		
		initComponents();
		themSuKien();
		updateComboboxTinh();
		updateComboboxGioiTinh();
		updateComboboxTo();
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
private void updateComboboxTo() {
		
		String to = (String) cmbGioiTinh.getSelectedItem();
		
		List<String> dsTam = new ArrayList<>();
		
		dsTam = List.of("Tổ áo khoác", "Tổ áo thun", 
				"Tổ áo sơ mi", "Tổ quần tây", "Tổ đồ bộ" );
		
		String[] dsTo = new String[dsTam.size()];
		
		dsTam.toArray(dsTo);
		
		cmbTo.setModel(new DefaultComboBoxModel<String>(dsTo));
		cmbTo.updateUI();

	}
	
	private void xoaRong() {
		txtTenCongNhan.setText("");
		txtMaCongNhan.setText("");
		txtSoDienThoai.setText("");
		dtNgaySinh.setDate(null);
		dtNgayVaoLam.setDate(null);
	}

	private void batDuLieuVaoTextfield() {
		txtMaCongNhan.setEditable(true);
		txtTenCongNhan.setEditable(true);
		txtSoDienThoai.setEditable(true);
		cmbGioiTinh.setEnabled(true);
		cmbTinhTP.setEnabled(true);
		cmbQuanHuyen.setEnabled(true);
		cmbPhuongXa.setEnabled(true);
		cmbTo.setEnabled(true);
//	    	dtNgaySinh.setEdit
//		updateComboboxTinh();
//		updateComboboxGioiTinh();
	}
	private void tatDuLieuVaoTextfield() {
		txtMaCongNhan.setEditable(false);
		txtTenCongNhan.setEditable(false);
		txtSoDienThoai.setEditable(false);
		cmbGioiTinh.setEnabled(false);
		cmbTinhTP.setEnabled(false);
		cmbQuanHuyen.setEnabled(false);
		cmbPhuongXa.setEnabled(false);
		cmbTo.setEnabled(false);
//	    	dtNgaySinh.setEdit
//		updateComboboxTinh();
//		updateComboboxGioiTinh();
	}
	 private CongNhan getDuLieuTuTextField() throws Exception {
			String maNV = txtMaCongNhan.getText().trim();
//			sau se check regex
			String tenNV = txtTenCongNhan.getText().trim();
			//sau se check regex
			String soDienThoai = txtSoDienThoai.getText().trim();
			//sau se check regex
//			String email = txtEmail.getText().trim();
			Date ngaySinh = null;
			try {
				ngaySinh = dtNgaySinh.getDate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			Date ngayVaoLam = null;
			try {
				ngayVaoLam = dtNgayVaoLam.getDate();
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(ngayVaoLam.getYear() - ngaySinh.getYear() < 18)
			{
				JOptionPane.showMessageDialog(null, "Nhân viên phải từ 18 tuổi trở lên");
				return null;
			}
			String tenTo = cmbTo.getSelectedItem().toString();
			
			ToNhom toNhom = new ToNhom();
			toNhom = toNhomDAO.timToNhomBangTenTo(tenTo);
			
			
			String gioiTinh = cmbGioiTinh.getSelectedItem().toString();
//			String vaiTro = cmbVaiTro.getSelectedItem().toString();
			DiaChi diaChi = diaChiDAO.getDiaChiTheoTinhHuyenXa(cmbTinhTP.getSelectedItem().toString()
					, cmbQuanHuyen.getSelectedItem().toString()
					, cmbPhuongXa.getSelectedItem().toString());
//			String hinhAnh  = lblAnhDaiDien.getIcon().toString();
//			//xoa duong dan tuyet doi cua link anh va thay bang duong dan tuong doi trong project
//			hinhAnh = hinhAnh.replace(PathSetting.PATH_IMAGE_NHANVIEN,"" );
//			CongNhan congNhan1 = new (maNV, tenNV, ngaySinh, email, soDienThoai, diaChi,
//					ngayVaoLam, gioiTinh, vaiTro, hinhAnh);
			
			
			CongNhan congNhan = new CongNhan(maNV, tenNV, soDienThoai, diaChi, ngayVaoLam, ngaySinh, gioiTinh, toNhom);
			return congNhan;
			
			
			
			
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
							fillThongTinCongNhan(congNhan);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			}

			private void fillThongTinCongNhan(CongNhan congNhan) throws Exception {
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
//				lblAnhDaiDien.setIcon(new ImageIcon(PathSetting.PATH_IMAGE_NHANVIEN + congNhan.getAnhDaiDien()));
				//					lbAnh.setIcon(new javax.swing.ImageIcon(PathSetting.PATH_IMAGE_NHANVIEN + nv.getLinkAnhNV())); // NOI18N
//					lbAnh.updateUI()

			}
		});

	
			cmbTinhTP.addPopupMenuListener(new PopupMenuListener() {

			
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				// TODO Auto-generated method stub
				updateComboboxHuyen();
				
			}

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
			 cmbQuanHuyen.addPopupMenuListener(new PopupMenuListener() {
					
					@Override
					public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
						// TODO Auto-generated method stub
						
						
					}
					
					@Override
					public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
						// TODO Auto-generated method stub
						updateComboboxXa();
						
						
					}
					
					@Override
					public void popupMenuCanceled(PopupMenuEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
			 
			 cmbPhuongXa.addPopupMenuListener(new PopupMenuListener() {
				
				@Override
				public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void popupMenuCanceled(PopupMenuEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			//bắt sự kiện btn thêm
		        btnThem.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							btnThemActionPerformed(e);
//							tblNhanVien.setEnabled(true);
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
						
					}
					private void btnThemActionPerformed(ActionEvent evt){
				    	updateComboboxTinh();
						xoaRong();
						batDuLieuVaoTextfield();
						trangThaiThem = true;
				        pnlChucNangTo.removeAll();
				        pnlChucNangTo.setLayout(new BorderLayout());
				        PanelXacNhan pnlXacNhan = new PanelXacNhan();
				        pnlChucNangTo.add(pnlXacNhan);	
				
				        ActionListener listenerHuy = new java.awt.event.ActionListener() {
				            public void actionPerformed(java.awt.event.ActionEvent evt) {
				                System.out.println("ok");
				            	trangThaiThem = false;
				                pnlChucNangTo.removeAll();
				                pnlChucNangTo.setLayout(new BorderLayout());
				                pnlChucNangTo.add(pnlChucNang);
				                pnlChucNangTo.updateUI();
//				                tatTextfield();
				            }
				        };
				        ActionListener listenerThem = new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
//								NhanVien nhanVien = null;
								try {
									CongNhan congNhan = getDuLieuTuTextField();
									if(congNhan != null) {
										if(congNhanDAO.themCongNhan(congNhan))
										congNhanDAO.themCongNhan(congNhan);
										
										dsCN = congNhanDAO.layDanhSachCongNhan();
										updateModelTable(dsCN, HEADERS);
										xoaRong();
										JOptionPane.showMessageDialog(null, "Thêm thành công");
										
									}
								} catch (Exception e2) {
									e2.printStackTrace();
									// TODO: handle exception
								}
								
							}
						};
						
				        pnlXacNhan.huyAddActionListener(listenerHuy);
				        pnlXacNhan.xacNhanAddActionListener(listenerThem);
				        pnlChucNangTo.repaint();
				        pnlChucNangTo.revalidate();
						
						
					
					}
					
					

				}); 
		        
		        btnXoa.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							btnXoaActionPerformed(e);
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
						
					}
				    private void btnXoaActionPerformed(ActionEvent evt) {
				        // TODO add your handling code here:
				    	try {
							String maCN = (String) tblCongNhan.getModel().getValueAt(tblCongNhan.getSelectedRow(), 0);
							int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không", "Xóa",
									JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
							if(luaChon == JOptionPane.YES_OPTION ) {
								boolean ketQua = congNhanDAO.xoaCongNhan(maCN);
								if(ketQua) {
									
									//cap nhat lai bang nhan vien
									dsCN = congNhanDAO.layDanhSachCongNhan();
									updateModelTable(dsCN, HEADERS);
									xoaRong();
									JOptionPane.showMessageDialog(null, "Xóa thành công");

									
								}
								else {
									
									JOptionPane.showMessageDialog(null, "Xóa thất bại");
									xoaRong();
								}

							}
							
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
				    	
				    }
				});
		    	btnSua.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSuaActionPerformed(evt);
					}
				    private void btnSuaActionPerformed(ActionEvent evt) {
				        // TODO add your handling code here:
				    	
				    	batDuLieuVaoTextfield();;
				    	String huyenDangChon = cmbQuanHuyen.getSelectedItem().toString();
				    	String xaDangChon = cmbPhuongXa.getSelectedItem().toString();
//				    	lamMoiHuyen(tinhDangChon);
				    	
//				    	lamMoiXa(huyenDangChon);
				    	updateComboboxHuyen();
				    	
				    	cmbQuanHuyen.setSelectedItem(huyenDangChon);
				    	updateComboboxXa();
				    	cmbPhuongXa.setSelectedItem(xaDangChon);
//						trangThaiThem = true;
				        pnlChucNangTo.removeAll();
				        pnlChucNangTo.setLayout(new BorderLayout());
				        PanelXacNhan pnlXacNhan = new PanelXacNhan();
				        pnlChucNangTo.add(pnlXacNhan);
				
				        ActionListener listenerHuy = new ActionListener() {
				            public void actionPerformed(ActionEvent evt) {
				                System.out.println("ok");
				            	trangThaiThem = false;
				                pnlChucNangTo.removeAll();
				                pnlChucNangTo.setLayout(new BorderLayout());
				                pnlChucNangTo.add(pnlChucNang);
				                pnlChucNangTo.updateUI();
				                tatDuLieuVaoTextfield();;
				            }
				        };
				        
				        ActionListener listenerSua = new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								try {
									CongNhan congNhan = getDuLieuTuTextField();
								
									if(congNhan != null) {
										congNhanDAO.capNhatCongNhan(congNhan);
										dsCN = congNhanDAO.layDanhSachCongNhan();
										updateModelTable(dsCN, HEADERS);
										JOptionPane.showMessageDialog(null, "Cập nhật thành công");
									}
									
								} catch (Exception e2) {
									// TODO: handle exception
									e2.printStackTrace();
								}
								
							}
							
						};
				        pnlXacNhan.huyAddActionListener(listenerHuy);
				        pnlXacNhan.xacNhanAddActionListener(listenerSua);
				        pnlChucNangTo.repaint();
				        pnlChucNangTo.revalidate();

				    	
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
        cmbTo.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Tổ áo khoác", "Tổ áo thun", "Tổ áo sơ mi", "Tổ quần tây", "Tổ đồ bộ" }));
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
