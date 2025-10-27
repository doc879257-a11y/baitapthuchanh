import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class SuatChieu {
    private String maSuatChieu;
    private Phim phim;
    private PhongChieu phong;
    private Date thoiGian;
    private List<DatVe> danhSachDatVe;

    public SuatChieu(String maSuatChieu, Phim phim, PhongChieu phong, Date thoiGian) {
        this.maSuatChieu = maSuatChieu;
        this.phim = phim;
        this.phong = phong;
        this.thoiGian = thoiGian;
        this.danhSachDatVe = new ArrayList<>();
        if (phim != null) {
            phim.themSuatChieu(this);
        }
    }

    public String getMaSuatChieu() { return maSuatChieu; }
    public void setMaSuatChieu(String maSuatChieu) { this.maSuatChieu = maSuatChieu; }

    public Phim getPhim() { return phim; }
    public void setPhim(Phim phim) { this.phim = phim; }

    public PhongChieu getPhong() { return phong; }
    public void setPhong(PhongChieu phong) { this.phong = phong; }

    public Date getThoiGian() { return thoiGian; }
    public void setThoiGian(Date thoiGian) { this.thoiGian = thoiGian; }

    public List<DatVe> getDanhSachDatVe() { return danhSachDatVe; }

    public void themDatVe(DatVe datVe) {
        if (datVe != null) {
            danhSachDatVe.add(datVe);
        }
    }

    public void xoaDatVe(DatVe datVe) {
        if (datVe != null) {
            danhSachDatVe.remove(datVe);
        }
    }

    public boolean kiemTraGheTrong(String soGhe) {
        for (DatVe datVe : danhSachDatVe) {
            if (datVe.kiemTraGheDaDat(soGhe)) {
                return false;
            }
        }
        return true;
    }

    public String thongTinSuatChieu() {
        return "Suất chiếu: " + maSuatChieu + ", Phim: " +
                (phim != null ? phim.getTenPhim() : "N/A") +
                ", Phòng: " + (phong != null ? phong.getMaPhong() : "N/A") +
                ", Thời gian: " + thoiGian;
    }

    @Override
    public String toString() {
        return thongTinSuatChieu();
    }
}