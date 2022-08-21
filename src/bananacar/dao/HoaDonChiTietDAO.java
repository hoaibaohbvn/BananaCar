/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.dao;

import bananacar.helper.JdbcHelper;
import bananacar.model.HoaDonChiTiet;
import bananacar.model.LoaiXe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class HoaDonChiTietDAO extends BananaCarDAO<HoaDonChiTiet, String>{

    @Override
    public void insert(HoaDonChiTiet hdct) {
        String sql ="Insert hoadonchitiet values (?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, 
                hdct.getMaHD(),
                hdct.getMaXe(),
                hdct.getDonGia(),
                hdct.getSoLuong(),
                hdct.getThanhTien()); 
    }

    @Override
    public void update(HoaDonChiTiet hdct) {
        String sql="UPDATE hoadonchitiet SET mahd=?, maxe=?,dongia=?,soluong=?,thanhtien=? WHERE MaHDCT=?";
        JdbcHelper.executeUpdate(sql, 
                hdct.getMaHD(),
                hdct.getMaXe(),
                hdct.getDonGia(),
                hdct.getSoLuong(),
                hdct.getThanhTien(),
                hdct.getMaHDCT()
            );
    }

    @Override
    public void delete(String MaHDCT) {
        String sql ="Delete from hoadonchitiet where mahdct=?";
        JdbcHelper.executeUpdate(sql, MaHDCT);
    }

    
    private HoaDonChiTiet readFormResultSet(ResultSet rs) throws SQLException{
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setMaHDCT(rs.getInt("mahdct"));
        hdct.setMaHD(rs.getString("mahd"));
        hdct.setMaXe(rs.getString("Maxe"));
        hdct.setDonGia(rs.getFloat("Dongia"));
        hdct.setSoLuong(rs.getInt("soluong"));
        hdct.setThanhTien(rs.getFloat("thanhtien"));
        return hdct;
    }
    @Override
    public List<HoaDonChiTiet> selectAll() {
        String sql = "Select* from hoadonchitiet";
        return selectBySql(sql);
    }

    @Override
    public HoaDonChiTiet selectById(String MaHDCT) {
        String sql = "SELECT * FROM hoadonchitiet WHERE mahdct=?";
        List<HoaDonChiTiet> list = selectBySql(sql, MaHDCT);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<HoaDonChiTiet>();
        ResultSet rs = null;
        try {
            rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                list.add(readFormResultSet(rs));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }
    public List<HoaDonChiTiet> timDanhSachHDCT(String MaHoaDon){
        String sql = "SELECT * FROM HoaDonChiTiet WHERE MaHD = ?";
        return selectBySql(sql, MaHoaDon);
    }
    public List<HoaDonChiTiet> selectAllXeBanChay() {
        String sql = "select DISTINCT maxe, sum(soluong) as tong from HoaDonChiTiet \n" +
"group by maxe  having sum(soluong) > 5";
        return selectBySql(sql);
    }
   
    
}
