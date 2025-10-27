public abstract class Nguoi {
    protected String hoTen;
    protected String soDienThoai;

    public Nguoi(String hoTen, String soDienThoai) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
    }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public abstract String thongTin();

    @Override
    public String toString() {
        return "Họ tên: " + hoTen + ", SĐT: " + soDienThoai;
    }
}