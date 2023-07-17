package sangttph30270.poly.duan1_nhom6.model;

public class model_Coffe {
    private int CoffeId;
    private String Anh;
    private String tenCoffe;
    private String moTa;
    private String gia;

    public model_Coffe() {
    }

    public model_Coffe(int coffeId, String anh, String tenCoffe, String moTa, String gia) {
        CoffeId = coffeId;
        Anh = anh;
        this.tenCoffe = tenCoffe;
        this.moTa = moTa;
        this.gia = gia;
    }

    public int getCoffeId() {
        return CoffeId;
    }

    public void setCoffeId(int coffeId) {
        CoffeId = coffeId;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }

    public String getTenCoffe() {
        return tenCoffe;
    }

    public void setTenCoffe(String tenCoffe) {
        this.tenCoffe = tenCoffe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
