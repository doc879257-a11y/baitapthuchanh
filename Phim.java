import java.util.ArrayList;
import java.util.List;

public class Phim {
    private String tenPhim;
    private String theLoai;
    private int thoiLuong; // phút
    private int tuoiGioiHan;
    private List<SuatChieu> danhSachSuatChieu;

    public Phim(String tenPhim, String theLoai, int thoiLuong, int tuoiGioiHan) {
        this.tenPhim = tenPhim;
        this.theLoai = theLoai;
        this.thoiLuong = thoiLuong;
        this.tuoiGioiHan = tuoiGioiHan;
        this.danhSachSuatChieu = new ArrayList<>();
    }

    // Getter và Setter
    public String getTenPhim() { return tenPhim; }
    public void setTenPhim(String tenPhim) { this.tenPhim = tenPhim; }

    public String getTheLoai() { return theLoai; }
    public void setTheLoai(String theLoai) { this.theLoai = theLoai; }

    public int getThoiLuong() { return thoiLuong; }
    public void setThoiLuong(int thoiLuong) { this.thoiLuong = thoiLuong; }

    public int getTuoiGioiHan() { return tuoiGioiHan; }
    public void setTuoiGioiHan(int tuoiGioiHan) { this.tuoiGioiHan = tuoiGioiHan; }

    public List<SuatChieu> getDanhSachSuatChieu() { return danhSachSuatChieu; }

    public void themSuatChieu(SuatChieu suatChieu) {
        danhSachSuatChieu.add(suatChieu);
    }

    public void xoaSuatChieu(SuatChieu suatChieu) {
        danhSachSuatChieu.remove(suatChieu);
    }

    public String thongTinPhim() {
        return "Phim: " + tenPhim + ", Thể loại: " + theLoai +
                ", Thời lượng: " + thoiLuong + " phút, Giới hạn tuổi: " + tuoiGioiHan + "+";
    }

    @Override
    public String toString() {
        return thongTinPhim();
    }
}