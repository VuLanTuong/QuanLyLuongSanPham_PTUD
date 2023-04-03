package setting;

public interface PathSetting {
	final String PATH_TO_PACKAGE = System.getProperty("user.dir");
//	String PATH_IMAGE_SYSTEM = PATH_TO_PACKAGE + "\\Image\\System";
	final String PATH_ICON = PATH_TO_PACKAGE + "\\icon\\";
	final String PATH_IMAGE_SANPHAM = PATH_TO_PACKAGE+ "\\Image\\";
		final String PATH_IMAGE_NHANVIEN = PATH_ICON + "\\NhanVien\\";
}