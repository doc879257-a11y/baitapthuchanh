public class Ghe {
    private String soGhe;
    private String loaiGhe; // "Thường", "VIP"
    private double gia;

    public Ghe(String soGhe, String loaiGhe, double gia) {
        this.soGhe = soGhe;
        this.loaiGhe = loaiGhe;
        this.gia = gia;
    }

    public String getSoGhe() { return soGhe; }
    public void setSoGhe(String soGhe) { this.soGhe = soGhe; }

    public String getLoaiGhe() { return loaiGhe; }
    public void setLoaiGhe(String loaiGhe) { this.loaiGhe = loaiGhe; }

    public double getGia() { return gia; }
    public void setGia(double gia) { this.gia = gia; }

    public String thongTinGhe() {
        return "Ghế " + soGhe + " (" + loaiGhe + ") - Giá: " + gia + " VNĐ";
    }

    public double tinhGia() {
        return gia;
    }

    @Override
    public String toString() {
        return thongTinGhe();
    }
}

