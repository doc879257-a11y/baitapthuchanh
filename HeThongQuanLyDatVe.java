import java.util.ArrayList;
import java.util.List;

public class HeThongQuanLyDatVe {
    private List<DatVe> danhSachDatVe;

    public HeThongQuanLyDatVe() {
        this.danhSachDatVe = new ArrayList<>();
    }

    public void themDatVe(DatVe datVe) {
        if (datVe != null) {
            danhSachDatVe.add(datVe);
        }
    }

    public List<DatVe> timDatVeTheoKhachHang(KhachHang khachHang) {
        List<DatVe> ketQua = new ArrayList<>();
        for (DatVe datVe : danhSachDatVe) {
            if (datVe.getKhachHang() != null && datVe.getKhachHang().equals(khachHang)) {
                ketQua.add(datVe);
            }
        }
        return ketQua;
    }

    public void hienThiTatCaDatVe() {
        System.out.println("\n=== DANH SÁCH TẤT CẢ ĐẶT VÉ ===");
        if (danhSachDatVe.isEmpty()) {
            System.out.println("Chưa có đặt vé nào.");
            return;
        }

        for (int i = 0; i < danhSachDatVe.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachDatVe.get(i).thongTinDatVe());
        }
    }
}