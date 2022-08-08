/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.model;

import java.util.Date;

/**
 *
 * @author USER
 */
public class KhachHang {
    private String MaKH;
    private String HoTen;
    private String DienThoai;
    private boolean GioiTinh;
    private Date NgaySinh;
    private String NVQuanLy;
    private String Email;
    private String DiaChi;
    private String GhiChu;

    public KhachHang() {
    }

    public KhachHang(String MaKH, String HoTen, String DienThoai, boolean GioiTinh, Date NgaySinh, String NVQuanLy, String Email, String DiaChi, String GhiChu) {
        this.MaKH = MaKH;
        this.HoTen = HoTen;
        this.DienThoai = DienThoai;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.NVQuanLy = NVQuanLy;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.GhiChu = GhiChu;

    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getNVQuanLy() {
        return NVQuanLy;
    }

    public void setNVQuanLy(String NVQuanLy) {
        this.NVQuanLy = NVQuanLy;
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

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    
    @Override
    public String toString() {
        return  MaKH;
    }
    
    
}
