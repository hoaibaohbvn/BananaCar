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
public class HoaDonChiTiet {
    private int MaHDCT;
    private String MaHD;
    private String MaXe;
    private float DonGia;
    private int SoLuong;
    private float ThanhTien;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int MaHDCT, String MaHD, String MaXe, float DonGia, int SoLuong, float ThanhTien) {
        this.MaHDCT = MaHDCT;
        this.MaHD = MaHD;
        this.MaXe = MaXe;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
    }

    public int getMaHDCT() {
        return MaHDCT;
    }

    public void setMaHDCT(int MaHDCT) {
        this.MaHDCT = MaHDCT;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaXe() {
        return MaXe;
    }

    public void setMaXe(String MaXe) {
        this.MaXe = MaXe;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
}
