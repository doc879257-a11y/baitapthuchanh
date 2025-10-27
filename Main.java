import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HỆ THỐNG QUẢN LÝ RẠP CHIẾU PHIM ===");

        Phim phim1 = new Phim("Avengers: Endgame", "Hành động", 180, 13);
        PhongChieu phong1 = new PhongChieu("P01", "IMAX", 20); // Giảm số ghế để test dễ hơn

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 2);
        Date thoiGianChieu = cal.getTime();

        SuatChieu suatChieu1 = new SuatChieu("SC001", phim1, phong1, thoiGianChieu);

        KhachHang khachHang1 = new KhachHang("Nguyễn Văn A", "0912345678", "a@email.com", "012345678901");
        HeThongQuanLyDatVe heThongQL = new HeThongQuanLyDatVe();

        System.out.println("\n=== TRƯỜNG HỢP 1: KHÁCH ĐẶT 4 VÉ CÙNG LÚC ===");
        List<String> danhSachGhe1 = Arrays.asList("A1", "A2", "A3", "A4");
        DatVe datVe1 = khachHang1.datVe(suatChieu1, danhSachGhe1);
        heThongQL.themDatVe(datVe1);
        datVe1.hienThiChiTietVe();

        System.out.println("\n=== TRƯỜNG HỢP 2: THÊM VÉ SAU KHI ĐẶT ===");
        datVe1.themNhieuVe(Arrays.asList("A5", "A6"));
        datVe1.hienThiChiTietVe();

        System.out.println("\n=== TRƯỜNG HỢP 3: HỦY MỘT SỐ VÉ ===");
        khachHang1.huyMotSoVe(datVe1, Arrays.asList("A3", "A4"));
        datVe1.hienThiChiTietVe();

        System.out.println("\n=== TRƯỜNG HỢP 4: THANH TOÁN ===");
        ThanhToan thanhToanThe = new ThanhToanThe("1234-5678-9012-3456", "12/25", "123");
        datVe1.thanhToan(thanhToanThe);

        System.out.println("\n=== TRƯỜNG HỢP 5: KIỂM TRA GHẾ TRỐNG ===");
        System.out.println("Ghế A1: " + (suatChieu1.kiemTraGheTrong("A1") ? "TRỐNG" : "ĐÃ ĐẶT"));
        System.out.println("Ghế A7: " + (suatChieu1.kiemTraGheTrong("A7") ? "TRỐNG" : "ĐÃ ĐẶT"));

        System.out.println("\n=== TRƯỜNG HỢP 6: ĐẶT VÉ CHO SUẤT CHIẾU KHÁC ===");
        Phim phim2 = new Phim("Frozen 2", "Hoạt hình", 104, 6);
        PhongChieu phong2 = new PhongChieu("P02", "3D", 15);
        cal.add(Calendar.HOUR, 3);
        SuatChieu suatChieu2 = new SuatChieu("SC002", phim2, phong2, cal.getTime());

        DatVe datVe2 = khachHang1.datVe(suatChieu2, Arrays.asList("B1", "B2"));
        heThongQL.themDatVe(datVe2);
        datVe2.hienThiChiTietVe();

        System.out.println("\n=== TRƯỜNG HỢP 7: LỊCH SỬ ĐẶT VÉ CỦA KHÁCH HÀNG ===");
        List<DatVe> lichSu = heThongQL.timDatVeTheoKhachHang(khachHang1);
        khachHang1.hienThiLichSuDatVe(lichSu);

        System.out.println("\n=== TỔNG QUAN HỆ THỐNG ===");
        heThongQL.hienThiTatCaDatVe();

        System.out.println("\n=== CHƯƠNG TRÌNH KẾT THÚC ===");
    }
}
