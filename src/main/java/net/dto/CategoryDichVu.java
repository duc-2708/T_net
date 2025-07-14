
package net.dto;

public class CategoryDichVu {
    private String IDLoaiDV;
    private String TenLoaiDV;
    private String IDDV;
    private String TenDV;
    private Double Gia;

    public CategoryDichVu() {
    }

    public CategoryDichVu(String IDLoaiDV, String TenLoaiDV, String IDDV, String TenDV, Double Gia) {
        this.IDLoaiDV = IDLoaiDV;
        this.TenLoaiDV = TenLoaiDV;
        this.IDDV = IDDV;
        this.TenDV = TenDV;
        this.Gia = Gia;
    }

    public String getIDLoaiDV() {
        return IDLoaiDV;
    }

    public void setIDLoaiDV(String IDLoaiDV) {
        this.IDLoaiDV = IDLoaiDV;
    }

    public String getTenLoaiDV() {
        return TenLoaiDV;
    }

    public void setTenLoaiDV(String TenLoaiDV) {
        this.TenLoaiDV = TenLoaiDV;
    }

    public String getIDDV() {
        return IDDV;
    }

    public void setIDDV(String IDDV) {
        this.IDDV = IDDV;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }

    public Double getGia() {
        return Gia;
    }

    public void setGia(Double Gia) {
        this.Gia = Gia;
    }
    
    
}
