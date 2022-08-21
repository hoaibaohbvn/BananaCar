/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.model;

import bananacar.dao.ChiTietTraGopDAO;
import java.util.HashMap;

/**
 *
 * @author USER
 */
public class ChiTietTraGop {
    private int MaCTTG;
    private String MaHDTG;
    private String MaXe;
    private float DonGia;
    private int SoLuong;
    private float ThanhTien;
    ChiTietTraGopDAO daocttg = new ChiTietTraGopDAO();
    private HashMap<String, XeDTO> chiTietTraGop;
    public ChiTietTraGop() {
        chiTietTraGop = new HashMap<>();
    }

    public int getMaCTTG() {
        return MaCTTG;
    }

    public void setMaCTTG(int MaCTTG) {
        this.MaCTTG = MaCTTG;
    }

    public String getMaHDTG() {
        return MaHDTG;
    }

    public void setMaHDTG(String MaHDTG) {
        this.MaHDTG = MaHDTG;
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

    public ChiTietTraGopDAO getDaocttg() {
        return daocttg;
    }

    public void setDaocttg(ChiTietTraGopDAO daocttg) {
        this.daocttg = daocttg;
    }

    public HashMap<String, XeDTO> getChiTietTraGop() {
        return chiTietTraGop;
    }

    public void setChiTietTraGop(HashMap<String, XeDTO> chiTietTraGop) {
        this.chiTietTraGop = chiTietTraGop;
    }
    public void addProduct(XeDTO xe) {
        String MaXe = xe.getXe().getMaXe();
        // nếu tồn tại SP trong giỏ hàng thì cộng thêm số lượng mua mới vào
        if (chiTietTraGop.containsKey(MaXe)) {
            // soLuong = soLuongCu + soLuongMoi
            
            int soLuong = chiTietTraGop.get(MaXe).getSoLuong() + xe.getSoLuong();
            // cập nhật lại số lượng:
            chiTietTraGop.get(MaXe).setSoLuong(soLuong);
            
        } else { // nếu SP chưa có trong giỏ hàng thì put mới vào hashmap
            chiTietTraGop.put(MaXe, xe);
            
        }
    }
    
    public boolean removeProduct(String MaXe) {
        // kiểm tra SP nếu tồn tại thì remove khỏi hashmap
        if (chiTietTraGop.containsKey(MaXe)) {
            chiTietTraGop.remove(MaXe);
            return true;
        } else { 
            return false;
        }
    }
    

    @Override
    public String toString() {
        return MaHDTG;
    }
}
