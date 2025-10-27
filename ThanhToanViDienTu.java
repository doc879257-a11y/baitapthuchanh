public class ThanhToanViDienTu implements ThanhToan {
    private String maVi;
    private String nhaCungCap;

    public ThanhToanViDienTu(String maVi, String nhaCungCap) {
        this.maVi = maVi;
        this.nhaCungCap = nhaCungCap;
    }

    public String getMaVi() { return maVi; }
    public void setMaVi(String maVi) { this.maVi = maVi; }

    public String getNhaCungCap() { return nhaCungCap; }
    public void setNhaCungCap(String nhaCungCap) { this.nhaCungCap = nhaCungCap; }

    @Override
    public boolean thanhToan(double soTien) {
        System.out.println("Thanh toán bằng " + nhaCungCap + ": " + maVi + ", Số tiền: " + soTien + " VNĐ");
        return true;
    }
}