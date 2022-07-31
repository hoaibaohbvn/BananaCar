/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.dao;

import bananacar.helper.JdbcHelper;
import bananacar.model.LoaiXe;
import bananacar.model.PhieuNhapChiTiet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class PhieuNhapChiTietDAO extends BananaCarDAO<PhieuNhapChiTiet, String>{

    @Override
    public void insert(PhieuNhapChiTiet pnct) {
        String sql ="Insert LoaiXe values (?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, 
                pnct.getMaPNCT(),
                pnct.getMaPhieuNhap(),
                pnct.getMaXe(),
                pnct.getSoLuong(),
                pnct.getGiaNhap(),
                pnct.getThanhTien()); 
    }

    @Override
    public void update(PhieuNhapChiTiet pnct) {
        String sql="UPDATE PhieuNhapChiTiet SET Maphieunhap=?, maxe=?, soluong=?,gianhap=?,thanhtien=? WHERE MaPNct=?";
        JdbcHelper.executeUpdate(sql, 
                pnct.getMaPhieuNhap(),
                pnct.getMaXe(),
                pnct.getSoLuong(),
                pnct.getGiaNhap(),
                pnct.getThanhTien(),
                pnct.getMaPNCT()
            );
    }

    @Override
    public void delete(String MaPNCT) {
        String sql ="Delete from PhieuNhapChitiet where maPNCT=?";
        JdbcHelper.executeUpdate(sql, MaPNCT);
    }

    private PhieuNhapChiTiet readFormResultSet(ResultSet rs) throws SQLException{
        PhieuNhapChiTiet pnct = new PhieuNhapChiTiet();
        pnct.setMaPNCT(rs.getInt("Mapnct"));
        pnct.setMaPhieuNhap(rs.getString("MaPhieuNhap"));
        pnct.setMaXe(rs.getString("maxe"));
        pnct.setSoLuong(rs.getInt("soluong"));
        pnct.setGiaNhap(rs.getFloat("GiaNhap"));
        pnct.setThanhTien(rs.getFloat("thanhtien"));
        return pnct;
    }
    @Override
    public List<PhieuNhapChiTiet> selectAll() {
        String sql = "Select* from phieunhapchitiet";
        return selectBySql(sql);
    }

    @Override
    public PhieuNhapChiTiet selectById(String MaPNCT) {
        String sql = "SELECT * FROM phieunhapchitiet WHERE mapnct=?";
        List<PhieuNhapChiTiet> list = selectBySql(sql, MaPNCT);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<PhieuNhapChiTiet> selectBySql(String sql, Object... args) {
        List<PhieuNhapChiTiet> list = new ArrayList<PhieuNhapChiTiet>();
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
    
}
