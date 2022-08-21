/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.model;

import bananacar.dao.PhieuNhapChiTietDAO;
import java.util.HashMap;

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
    PhieuNhapChiTietDAO daopnct = new PhieuNhapChiTietDAO();
    private HashMap<String, XeDTO> chiTietPhieuNhap;
    public PhieuNhapChiTiet() {
        chiTietPhieuNhap = new HashMap<>();
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

    public PhieuNhapChiTietDAO getDaopnct() {
        return daopnct;
    }

    public void setDaopnct(PhieuNhapChiTietDAO daopnct) {
        this.daopnct = daopnct;
    }

    public HashMap<String, XeDTO> getChiTietPhieuNhap() {
        return chiTietPhieuNhap;
    }

    public void setChiTietPhieuNhap(HashMap<String, XeDTO> chiTietPhieuNhap) {
        this.chiTietPhieuNhap = chiTietPhieuNhap;
    }

    public void addProduct(XeDTO xe) {
        String MaXe = xe.getXe().getMaXe();
        // nếu tồn tại SP trong giỏ hàng thì cộng thêm số lượng mua mới vào
        if (chiTietPhieuNhap.containsKey(MaXe)) {
            // soLuong = soLuongCu + soLuongMoi
            
            int soLuong = chiTietPhieuNhap.get(MaXe).getSoLuong() + xe.getSoLuong();
            // cập nhật lại số lượng:
            chiTietPhieuNhap.get(MaXe).setSoLuong(soLuong);
            
        } else { // nếu SP chưa có trong giỏ hàng thì put mới vào hashmap
            chiTietPhieuNhap.put(MaXe, xe);
            
        }
    }
    
    public boolean removeProduct(String MaXe) {
        // kiểm tra SP nếu tồn tại thì remove khỏi hashmap
        if (chiTietPhieuNhap.containsKey(MaXe)) {
            chiTietPhieuNhap.remove(MaXe);
            return true;
        } else { 
            return false;
        }
    }
    
    @Override
    public String toString() {
        return MaPhieuNhap;
    }
}
