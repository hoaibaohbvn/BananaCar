/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.model;

/**
 *
 * @author USER
 */
public class HangXe {
    private String MaHang;
    private String TenHang;
    private String DienThoai;
    private String Email;
    private String DiaChi;
    private boolean TrangThai;

    public HangXe() {
    }

    public HangXe(String MaHang, String TenHang, String DienThoai, String Email, String DiaChi, boolean TrangThai) {
        this.MaHang = MaHang;
        this.TenHang = TenHang;
        this.DienThoai = DienThoai;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.TrangThai = TrangThai;
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
}
