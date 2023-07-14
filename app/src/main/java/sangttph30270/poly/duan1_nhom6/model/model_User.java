package sangttph30270.poly.duan1_nhom6.model;

public class model_User {
    private int userId;
    private String hoTen;
    private String matKhau;
    private String chucNang;

    public model_User() {
    }

    public model_User(int userId, String hoTen, String matKhau, String chucNang) {
        this.userId = userId;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.chucNang = chucNang;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getChucNang() {
        return chucNang;
    }

    public void setChucNang(String chucNang) {
        this.chucNang = chucNang;
    }
}
