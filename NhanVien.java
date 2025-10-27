public class NhanVien extends Nguoi {
    private String chucVu;
    private double luong;

    public NhanVien(String hoTen, String soDienThoai, String chucVu, double luong) {
        super(hoTen, soDienThoai);
        this.chucVu = chucVu;
        this.luong = luong;
    }

    public String getChucVu() { return chucVu; }
    public void setChucVu(String chucVu) { this.chucVu = chucVu; }

    public double getLuong() { return luong; }
    public void setLuong(double luong) { this.luong = luong; }

    @Override
    public String thongTin() {
        return "Nhân viên - " + toString() + ", Chức vụ: " + chucVu + ", Lương: " + luong;
    }
}