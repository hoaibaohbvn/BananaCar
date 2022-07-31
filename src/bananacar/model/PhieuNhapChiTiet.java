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
public class PhieuNhapChiTiet {
    private int MaPNCT;
    private String MaPhieuNhap;
    private String MaXe;
    private int SoLuong;
    private float GiaNhap;
    private float ThanhTien;

    public PhieuNhapChiTiet() {
    }

    public PhieuNhapChiTiet(int MaPNCT, String MaPhieuNhap, String MaXe, int SoLuong, float GiaNhap, float ThanhTien) {
        this.MaPNCT = MaPNCT;
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaXe = MaXe;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
        this.ThanhTien = ThanhTien;
    }

    public int getMaPNCT() {
        return MaPNCT;
    }

    public void setMaPNCT(int MaPNCT) {
        this.MaPNCT = MaPNCT;
    }

    public String getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(String MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
    }

    public String getMaXe() {
        return MaXe;
    }

    public void setMaXe(String MaXe) {
        this.MaXe = MaXe;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
}
