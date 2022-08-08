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
public class XeDTO {
    private HoaDonChiTiet maCTHD;
    private Xe xe;
    private int soLuong;

    

    public XeDTO(Xe xe, int soLuong) {
        this.xe = xe;
        this.soLuong = soLuong;
    }

    public XeDTO() {
    }

    public XeDTO(HoaDonChiTiet maCTHD, Xe xe, int soLuong) {
        this.maCTHD = maCTHD;
        this.xe = xe;
        this.soLuong = soLuong;
    }

    

    public HoaDonChiTiet getMaCTHD() {
        return maCTHD;
    }

    public void setMaCTHD(HoaDonChiTiet maCTHD) {
        this.maCTHD = maCTHD;
    }

    public Xe getXe() {
        return xe;
    }

    public void setXe(Xe xe) {
        this.xe = xe;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    
    
}
