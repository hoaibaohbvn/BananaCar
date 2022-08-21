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
public class HoaDonTraGop {
    private String MaHDTG;
    private String MaKH;
    private String MaNV;
    private Date NgayBan;
    private int TongSoLuong;
    private float GiamGia;
    private float GTGT;
    private int SoNamTraGop;
    private float TraGopMoiThang;
    private float TongTienTraGop;
    private float TongTienXe;

    public HoaDonTraGop() {
    }

    public HoaDonTraGop(String MaHDTG, String MaKH, String MaNV, Date NgayBan, int TongSoLuong, float GiamGia, float GTGT, int SoNamTraGop, float TraGopMoiThang, float TongTienTraGop, float TongTienXe) {
        this.MaHDTG = MaHDTG;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
        this.NgayBan = NgayBan;
        this.TongSoLuong = TongSoLuong;
        this.GiamGia = GiamGia;
        this.GTGT = GTGT;
        this.SoNamTraGop = SoNamTraGop;
        this.TraGopMoiThang = TraGopMoiThang;
        this.TongTienTraGop = TongTienTraGop;
        this.TongTienXe = TongTienXe;
    }

    public String getMaHDTG() {
        return MaHDTG;
    }

    public void setMaHDTG(String MaHDTG) {
        this.MaHDTG = MaHDTG;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
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

    public int getSoNamTraGop() {
        return SoNamTraGop;
    }

    public void setSoNamTraGop(int SoNamTraGop) {
        this.SoNamTraGop = SoNamTraGop;
    }

    public float getTraGopMoiThang() {
        return TraGopMoiThang;
    }

    public void setTraGopMoiThang(float TraGopMoiThang) {
        this.TraGopMoiThang = TraGopMoiThang;
    }

    public float getTongTienTraGop() {
        return TongTienTraGop;
    }

    public void setTongTienTraGop(float TongTienTraGop) {
        this.TongTienTraGop = TongTienTraGop;
    }

    public float getTongTienXe() {
        return TongTienXe;
    }

    public void setTongTienXe(float TongTienXe) {
        this.TongTienXe = TongTienXe;
    }
    public Integer toInt(){
        return SoNamTraGop;
    }
}
