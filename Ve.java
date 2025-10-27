public class Ve {
    private String maVe;
    private Ghe ghe;
    private double gia;
    private String trangThai;

    public Ve(String maVe, Ghe ghe) {
        this.maVe = maVe;
        this.ghe = ghe;
        this.gia = ghe != null ? ghe.getGia() : 0;
        this.trangThai = "Đã đặt";
    }

    public String getMaVe() { return maVe; }
    public void setMaVe(String maVe) { this.maVe = maVe; }

    public Ghe getGhe() { return ghe; }
    public void setGhe(Ghe ghe) { this.ghe = ghe; }

    public double getGia() { return gia; }
    public void setGia(double gia) { this.gia = gia; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

    public String thongTinVe() {
        return "Vé: " + maVe + ", " +
                (ghe != null ? ghe.thongTinGhe() : "Không có ghế") +
                ", Trạng thái: " + trangThai;
    }

    public void huyVe() {
        this.trangThai = "Đã hủy";
    }

    @Override
    public String toString() {
        return thongTinVe();
    }
}