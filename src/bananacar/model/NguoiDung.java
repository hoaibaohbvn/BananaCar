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
public class NguoiDung {
    private String TenDangNhap;
    private String MatKhau;
    private String HoTen;
    private String DienThoai;
    private boolean GioiTinh;
    private Date NgaySinh;
    private String Email;
    private String DiaChi; 
    private boolean TrangThai;
    private float Luong;
    private boolean VaiTro;

    public NguoiDung() {
    }

    public NguoiDung(String TenDangNhap, String MatKhau, String HoTen, String DienThoai, boolean GioiTinh, Date NgaySinh, String Email, String DiaChi, boolean TrangThai, float Luong, boolean VaiTro) {
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.HoTen = HoTen;
        this.DienThoai = DienThoai;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.TrangThai = TrangThai;
        this.Luong = Luong;
        this.VaiTro = VaiTro;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
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

    public float getLuong() {
        return Luong;
    }

    public void setLuong(float Luong) {
        this.Luong = Luong;
    }

    public boolean isVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(boolean VaiTro) {
        this.VaiTro = VaiTro;
    }
    
    
}
