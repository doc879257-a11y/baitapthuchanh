import java.util.List;

public class KhachHang extends Nguoi {
    private String email;
    private String soCCCD;

    public KhachHang(String hoTen, String soDienThoai, String email, String soCCCD) {
        super(hoTen, soDienThoai);
        this.email = email;
        this.soCCCD = soCCCD;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSoCCCD() { return soCCCD; }
    public void setSoCCCD(String soCCCD) { this.soCCCD = soCCCD; }

    @Override
    public String thongTin() {
        return "Khách hàng - " + toString() + ", Email: " + email + ", CCCD: " + soCCCD;
    }

    public DatVe datVe(SuatChieu suatChieu, List<String> danhSachSoGhe) {
        DatVe datVe = new DatVe(this, suatChieu);
        if (danhSachSoGhe != null) {
            datVe.themNhieuVe(danhSachSoGhe);
        }
        return datVe;
    }

    public void huyMotSoVe(DatVe datVe, List<String> danhSachSoGhe) {
        if (datVe != null && danhSachSoGhe != null) {
            datVe.huyMotSoVe(danhSachSoGhe);
        }
    }

    public void hienThiLichSuDatVe(List<DatVe> danhSachDatVe) {
        System.out.println("\n=== LỊCH SỬ ĐẶT VÉ CỦA " + hoTen.toUpperCase() + " ===");
        if (danhSachDatVe == null || danhSachDatVe.isEmpty()) {
            System.out.println("Chưa có đặt vé nào.");
            return;
        }

        for (int i = 0; i < danhSachDatVe.size(); i++) {
            DatVe datVe = danhSachDatVe.get(i);
            System.out.println((i + 1) + ". " + datVe.thongTinDatVe());
        }
    }
}