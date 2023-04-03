package test;

import java.util.List;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import connectdb.ConnectDB;
import dao.BangLuongCongNhanDAO;
import entity.BangLuongCongNhan;
import ui.MainUI;

public class TestConnection {
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(new FlatMacLightLaf());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		MainUI appUI = new MainUI();
//		appUI.setLocationRelativeTo(null);
		appUI.setVisible(true);
//		BangLuongCongNhanDAO bangLuongCongNhanDAO = new BangLuongCongNhanDAO();
//		List<BangLuongCongNhan> dsCN = bangLuongCongNhanDAO.layDanhSachBangLuongCN();
//		System.out.println(dsCN);
	}
}
