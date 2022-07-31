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
public class PhieuNhapHang {
    private String MaPhieuNhap;
    private String MaNV;
    private Date NgayNhap;
    private String MaHang;
    private int TongSoLuong;
    private float ChietKhau;
    private float GTGT;
    private double ThanhTien;
    private String GhiChu;

    public PhieuNhapHang() {
    }

    public PhieuNhapHang(String MaPhieuNhap, String MaNV, Date NgayNhap, String MaHang, int TongSoLuong, float ChietKhau, float GTGT, double ThanhTien, String GhiChu) {
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaNV = MaNV;
        this.NgayNhap = NgayNhap;
        this.MaHang = MaHang;
        this.TongSoLuong = TongSoLuong;
        this.ChietKhau = ChietKhau;
        this.GTGT = GTGT;
        this.ThanhTien = ThanhTien;
        this.GhiChu = GhiChu;
    }

    public String getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(String MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public int getTongSoLuong() {
        return TongSoLuong;
    }

    public void setTongSoLuong(int TongSoLuong) {
        this.TongSoLuong = TongSoLuong;
    }

    public float getChietKhau() {
        return ChietKhau;
    }

    public void setChietKhau(float ChietKhau) {
        this.ChietKhau = ChietKhau;
    }

    public float getGTGT() {
        return GTGT;
    }

    public void setGTGT(float GTGT) {
        this.GTGT = GTGT;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
}
