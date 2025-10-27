public class ThanhToanThe implements ThanhToan {
    private String soThe;
    private String ngayHetHan;
    private String cvv;

    public ThanhToanThe(String soThe, String ngayHetHan, String cvv) {
        this.soThe = soThe;
        this.ngayHetHan = ngayHetHan;
        this.cvv = cvv;
    }

    public String getSoThe() { return soThe; }
    public void setSoThe(String soThe) { this.soThe = soThe; }

    public String getNgayHetHan() { return ngayHetHan; }
    public void setNgayHetHan(String ngayHetHan) { this.ngayHetHan = ngayHetHan; }

    public String getCvv() { return cvv; }
    public void setCvv(String cvv) { this.cvv = cvv; }

    @Override
    public boolean thanhToan(double soTien) {
        System.out.println("Thanh toán bằng thẻ: " + soThe + ", Số tiền: " + soTien + " VNĐ");
        return true;
    }
}