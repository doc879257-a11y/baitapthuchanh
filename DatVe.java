import java.util.ArrayList;
import java.util.List;

public class DatVe {
    private String maDatVe;
    private KhachHang khachHang;
    private SuatChieu suatChieu;
    private List<Ve> danhSachVe;
    private double tongTien;
    private String trangThai;

    public DatVe(KhachHang khachHang, SuatChieu suatChieu) {
        this.maDatVe = "DV" + System.currentTimeMillis();
        this.khachHang = khachHang;
        this.suatChieu = suatChieu;
        this.danhSachVe = new ArrayList<>();
        this.tongTien = 0;
        this.trangThai = "Chờ thanh toán";
        if (suatChieu != null) {
            suatChieu.themDatVe(this);
        }
    }

    public String getMaDatVe() { return maDatVe; }
    public KhachHang getKhachHang() { return khachHang; }
    public SuatChieu getSuatChieu() { return suatChieu; }
    public List<Ve> getDanhSachVe() { return danhSachVe; }
    public double getTongTien() { return tongTien; }
    public String getTrangThai() { return trangThai; }

    public void themNhieuVe(List<String> danhSachSoGhe) {
        if (danhSachSoGhe == null || suatChieu == null) return;

        for (String soGhe : danhSachSoGhe) {
            Ghe ghe = suatChieu.getPhong().timGhe(soGhe);
            if (ghe != null) {
                if (suatChieu.kiemTraGheTrong(soGhe)) {
                    Ve ve = new Ve("V" + System.currentTimeMillis() + "_" + danhSachVe.size(), ghe);
                    themVe(ve);
                } else {
                    System.out.println("Ghế " + soGhe + " đã được đặt! Không thể thêm vào đặt vé.");
                }
            } else {
                System.out.println("Không tìm thấy ghế " + soGhe);
            }
        }
    }

    public void themVe(Ve ve) {
        if (ve != null && ve.getGhe() != null) {
            if (suatChieu.kiemTraGheTrong(ve.getGhe().getSoGhe())) {
                danhSachVe.add(ve);
                tongTien += ve.getGia();
            } else {
                System.out.println("Ghế " + ve.getGhe().getSoGhe() + " đã được đặt!");
            }
        }
    }

    public void xoaVeTheoSoGhe(String soGhe) {
        Ve veCanXoa = null;
        for (Ve ve : danhSachVe) {
            if (ve.getGhe() != null && ve.getGhe().getSoGhe().equals(soGhe)) {
                veCanXoa = ve;
                break;
            }
        }

        if (veCanXoa != null) {
            xoaVe(veCanXoa);
        } else {
            System.out.println("Không tìm thấy ghế " + soGhe + " trong đặt vé");
        }
    }

    public void xoaVe(Ve ve) {
        if (danhSachVe.remove(ve)) {
            tongTien -= ve.getGia();
            ve.huyVe();
        }
    }

    public boolean kiemTraGheDaDat(String soGhe) {
        for (Ve ve : danhSachVe) {
            if (ve.getGhe() != null && ve.getGhe().getSoGhe().equals(soGhe)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getDanhSachSoGheDaDat() {
        List<String> danhSachSoGhe = new ArrayList<>();
        for (Ve ve : danhSachVe) {
            if (ve.getGhe() != null) {
                danhSachSoGhe.add(ve.getGhe().getSoGhe());
            }
        }
        return danhSachSoGhe;
    }

    public boolean thanhToan(ThanhToan phuongThucThanhToan) {
        if (danhSachVe.isEmpty()) {
            System.out.println("Không có vé nào để thanh toán!");
            return false;
        }

        if (phuongThucThanhToan.thanhToan(tongTien)) {
            this.trangThai = "Đã thanh toán";
            System.out.println("Thanh toán thành công! Tổng tiền: " + tongTien + " VNĐ");
            return true;
        } else {
            System.out.println("Thanh toán thất bại!");
            return false;
        }
    }

    public void huyMotSoVe(List<String> danhSachSoGhe) {
        if (danhSachSoGhe != null) {
            for (String soGhe : danhSachSoGhe) {
                xoaVeTheoSoGhe(soGhe);
            }
        }
    }

    public void hienThiChiTietVe() {
        System.out.println("\n=== CHI TIẾT ĐẶT VÉ ===");
        System.out.println("Mã đặt vé: " + maDatVe);
        System.out.println("Khách hàng: " + (khachHang != null ? khachHang.getHoTen() : "N/A"));
        System.out.println("Phim: " + (suatChieu != null && suatChieu.getPhim() != null ? suatChieu.getPhim().getTenPhim() : "N/A"));
        System.out.println("Suất chiếu: " + (suatChieu != null ? suatChieu.getMaSuatChieu() : "N/A"));
        System.out.println("Phòng: " + (suatChieu != null && suatChieu.getPhong() != null ? suatChieu.getPhong().getMaPhong() : "N/A"));
        System.out.println("Danh sách ghế đã đặt: " + getDanhSachSoGheDaDat());
        System.out.println("Tổng số vé: " + danhSachVe.size());
        System.out.println("Tổng tiền: " + tongTien + " VNĐ");
        System.out.println("Trạng thái: " + trangThai);

        if (!danhSachVe.isEmpty()) {
            System.out.println("\nChi tiết từng vé:");
            for (int i = 0; i < danhSachVe.size(); i++) {
                System.out.println((i + 1) + ". " + danhSachVe.get(i).thongTinVe());
            }
        }
    }

    public String thongTinDatVe() {
        return "Mã đặt vé: " + maDatVe +
                ", Khách hàng: " + (khachHang != null ? khachHang.getHoTen() : "N/A") +
                ", Số vé: " + danhSachVe.size() +
                ", Tổng tiền: " + tongTien + " VNĐ" +
                ", Trạng thái: " + trangThai;
    }

    @Override
    public String toString() {
        return thongTinDatVe();
    }
}