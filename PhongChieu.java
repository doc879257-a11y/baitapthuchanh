import java.util.ArrayList;
import java.util.List;

public class PhongChieu {
    private String maPhong;
    private String loaiPhong;
    private int soLuongGhe;
    private List<Ghe> danhSachGhe;

    public PhongChieu(String maPhong, String loaiPhong, int soLuongGhe) {
        this.maPhong = maPhong;
        this.loaiPhong = loaiPhong;
        this.soLuongGhe = soLuongGhe;
        this.danhSachGhe = new ArrayList<>();
        khoiTaoGhe();
    }

    private void khoiTaoGhe() {
        for (int i = 1; i <= soLuongGhe; i++) {
            String loaiGhe = (i % 5 == 0) ? "VIP" : "Thường";
            double gia = loaiGhe.equals("VIP") ? 120000 : 80000;
            danhSachGhe.add(new Ghe("A" + i, loaiGhe, gia));
        }
    }

    public String getMaPhong() { return maPhong; }
    public void setMaPhong(String maPhong) { this.maPhong = maPhong; }

    public String getLoaiPhong() { return loaiPhong; }
    public void setLoaiPhong(String loaiPhong) { this.loaiPhong = loaiPhong; }

    public int getSoLuongGhe() { return soLuongGhe; }
    public void setSoLuongGhe(int soLuongGhe) { this.soLuongGhe = soLuongGhe; }

    public List<Ghe> getDanhSachGhe() { return danhSachGhe; }

    public Ghe timGhe(String soGhe) {
        for (Ghe ghe : danhSachGhe) {
            if (ghe.getSoGhe().equals(soGhe)) {
                return ghe;
            }
        }
        return null;
    }

    public String thongTinPhong() {
        return "Phòng " + maPhong + " (" + loaiPhong + ") - Số ghế: " + soLuongGhe;
    }

    @Override
    public String toString() {
        return thongTinPhong();
    }
}