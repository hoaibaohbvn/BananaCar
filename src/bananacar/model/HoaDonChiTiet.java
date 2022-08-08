/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.model;

import bananacar.dao.HoaDonChiTietDAO;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author USER
 */
public class HoaDonChiTiet implements Serializable{
    private int MaHDCT;
    private String MaHD;
    private String MaXe;
    private float DonGia;
    private int SoLuong;
    private float ThanhTien;
    HoaDonChiTietDAO daohdct = new HoaDonChiTietDAO();
    private HashMap<String, XeDTO> chiTietHoaDon;
    public HoaDonChiTiet() {
        chiTietHoaDon = new HashMap<>();
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

    public HashMap<String, XeDTO> getChiTietHoaDon() {
        return chiTietHoaDon;
    }

    public void setChiTietHoaDon(HashMap<String, XeDTO> chiTietHoaDon) {
        this.chiTietHoaDon = chiTietHoaDon;
    }
    public void addProduct(XeDTO xe) {
        String MaXe = xe.getXe().getMaXe();
        // nếu tồn tại SP trong giỏ hàng thì cộng thêm số lượng mua mới vào
        if (chiTietHoaDon.containsKey(MaXe)) {
            // soLuong = soLuongCu + soLuongMoi
            
            int soLuong = chiTietHoaDon.get(MaXe).getSoLuong() + xe.getSoLuong();
            // cập nhật lại số lượng:
            chiTietHoaDon.get(MaXe).setSoLuong(soLuong);
            
        } else { // nếu SP chưa có trong giỏ hàng thì put mới vào hashmap
            chiTietHoaDon.put(MaXe, xe);
            
        }
    }
    
    public boolean removeProduct(String MaXe) {
        // kiểm tra SP nếu tồn tại thì remove khỏi hashmap
        if (chiTietHoaDon.containsKey(MaXe)) {
            chiTietHoaDon.remove(MaXe);
            return true;
        } else { 
            return false;
        }
    }
    public void addCTHD(XeDTO xe){
        int MaHDCT = xe.getMaCTHD().getMaHDCT();
        if(chiTietHoaDon.containsKey(MaHDCT)){
            chiTietHoaDon.get(MaHDCT).getMaCTHD();
        }
    }

    @Override
    public String toString() {
        return MaHD;
    }
}
