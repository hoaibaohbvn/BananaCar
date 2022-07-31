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
public class HoaDon {
    private String MaHD;
    private String MaKH;
    private String MaNhanVien;
    private Date NgayBan;
    private int TongSoLuong;
    private float GiamGia;
    private float GTGT;
    private float ThanhTien;
    private float HoaHong;

    public HoaDon() {
    }

    public HoaDon(String MaHD, String MaKH, String MaNhanVien, Date NgayBan, int TongSoLuong, float GiamGia, float GTGT, float ThanhTien, float HoaHong) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.MaNhanVien = MaNhanVien;
        this.NgayBan = NgayBan;
        this.TongSoLuong = TongSoLuong;
        this.GiamGia = GiamGia;
        this.GTGT = GTGT;
        this.ThanhTien = ThanhTien;
        this.HoaHong = HoaHong;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public Date getNgayBan() {
        return NgayBan;
    }

    public void setNgayBan(Date NgayBan) {
        this.NgayBan = NgayBan;
    }

    public int getTongSoLuong() {
        return TongSoLuong;
    }

    public void setTongSoLuong(int TongSoLuong) {
        this.TongSoLuong = TongSoLuong;
    }

    public float getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(float GiamGia) {
        this.GiamGia = GiamGia;
    }

    public float getGTGT() {
        return GTGT;
    }

    public void setGTGT(float GTGT) {
        this.GTGT = GTGT;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public float getHoaHong() {
        return HoaHong;
    }

    public void setHoaHong(float HoaHong) {
        this.HoaHong = HoaHong;
    }

    
    
}
