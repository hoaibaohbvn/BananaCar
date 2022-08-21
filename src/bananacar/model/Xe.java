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
public class Xe{
    private String MaXe;
    private String TenXe;
    private String MaHang;
    private String MaLoai;
    private int TonKho;
    private int DinhMucNhoNhat;
    private int DinhMucLonNhat;
    private float GiaBan;
    private String Hinh;
    private boolean TrangThai;
    private int ChoNgoi;
    private int DongCo;
    private int SucManh;
    private boolean TayLaiTroLuc;
    private boolean TuiKhi;
    private boolean HTChongBoCungPhanh;
    private int BaoHanh;
    private float giaNhap;

    public Xe() {
    }

    public Xe(String MaXe, String TenXe, String MaHang, String MaLoai, int TonKho, int DinhMucNhoNhat, int DinhMucLonNhat, float GiaBan, String Hinh, boolean TrangThai, int ChoNgoi, int DongCo, int SucManh, boolean TayLaiTroLuc, boolean TuiKhi, boolean HTChongBoCungPhanh, int BaoHanh, float giaNhap) {
        this.MaXe = MaXe;
        this.TenXe = TenXe;
        this.MaHang = MaHang;
        this.MaLoai = MaLoai;
        this.TonKho = TonKho;
        this.DinhMucNhoNhat = DinhMucNhoNhat;
        this.DinhMucLonNhat = DinhMucLonNhat;
        this.GiaBan = GiaBan;
        this.Hinh = Hinh;
        this.TrangThai = TrangThai;
        this.ChoNgoi = ChoNgoi;
        this.DongCo = DongCo;
        this.SucManh = SucManh;
        this.TayLaiTroLuc = TayLaiTroLuc;
        this.TuiKhi = TuiKhi;
        this.HTChongBoCungPhanh = HTChongBoCungPhanh;
        this.BaoHanh = BaoHanh;
        this.giaNhap = giaNhap;
    }

    public String getMaXe() {
        return MaXe;
    }

    public void setMaXe(String MaXe) {
        this.MaXe = MaXe;
    }

    public String getTenXe() {
        return TenXe;
    }

    public void setTenXe(String TenXe) {
        this.TenXe = TenXe;
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public int getTonKho() {
        return TonKho;
    }

    public void setTonKho(int TonKho) {
        this.TonKho = TonKho;
    }

    public int getDinhMucNhoNhat() {
        return DinhMucNhoNhat;
    }

    public void setDinhMucNhoNhat(int DinhMucNhoNhat) {
        this.DinhMucNhoNhat = DinhMucNhoNhat;
    }

    public int getDinhMucLonNhat() {
        return DinhMucLonNhat;
    }

    public void setDinhMucLonNhat(int DinhMucLonNhat) {
        this.DinhMucLonNhat = DinhMucLonNhat;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getChoNgoi() {
        return ChoNgoi;
    }

    public void setChoNgoi(int ChoNgoi) {
        this.ChoNgoi = ChoNgoi;
    }

    public int getDongCo() {
        return DongCo;
    }

    public void setDongCo(int DongCo) {
        this.DongCo = DongCo;
    }

    public int getSucManh() {
        return SucManh;
    }

    public void setSucManh(int SucManh) {
        this.SucManh = SucManh;
    }

    public boolean isTayLaiTroLuc() {
        return TayLaiTroLuc;
    }

    public void setTayLaiTroLuc(boolean TayLaiTroLuc) {
        this.TayLaiTroLuc = TayLaiTroLuc;
    }

    public boolean isTuiKhi() {
        return TuiKhi;
    }

    public void setTuiKhi(boolean TuiKhi) {
        this.TuiKhi = TuiKhi;
    }

    public boolean isHTChongBoCungPhanh() {
        return HTChongBoCungPhanh;
    }

    public void setHTChongBoCungPhanh(boolean HTChongBoCungPhanh) {
        this.HTChongBoCungPhanh = HTChongBoCungPhanh;
    }

    public int getBaoHanh() {
        return BaoHanh;
    }

    public void setBaoHanh(int BaoHanh) {
        this.BaoHanh = BaoHanh;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    
}
