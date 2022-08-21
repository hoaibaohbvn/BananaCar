/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.dao;

import bananacar.helper.JdbcHelper;
import bananacar.model.ChiTietTraGop;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author USER
 */
public class ChiTietTraGopDAO extends BananaCarDAO<ChiTietTraGop, String>{

    @Override
    public void insert(ChiTietTraGop cttg) {
        String sql ="Insert chitiettragop values (?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, 
                cttg.getMaHDTG(),
                cttg.getMaXe(),
                cttg.getDonGia(),
                cttg.getSoLuong(),
                cttg.getThanhTien()); 
    }

    @Override
    public void update(ChiTietTraGop cttg) {
        String sql="UPDATE chitiettragop SET mahdtg=?, maxe=?,dongia=?,soluong=?,thanhtien=? WHERE MaHDCT=?";
        JdbcHelper.executeUpdate(sql, 
                cttg.getMaHDTG(),
                cttg.getMaXe(),
                cttg.getDonGia(),
                cttg.getSoLuong(),
                cttg.getThanhTien(),
                cttg.getMaCTTG()
            );
    }

    @Override
    public void delete(String MaCTTG) {
        String sql ="Delete from hoadonchitiet where macttg=?";
        JdbcHelper.executeUpdate(sql, MaCTTG);
    }

    private ChiTietTraGop readFormResultSet(ResultSet rs) throws SQLException{
        ChiTietTraGop cttg = new ChiTietTraGop();
        cttg.setMaCTTG(rs.getInt("macttg"));
        cttg.setMaHDTG(rs.getString("mahdtg"));
        cttg.setMaXe(rs.getString("Maxe"));
        cttg.setDonGia(rs.getFloat("Dongia"));
        cttg.setSoLuong(rs.getInt("soluong"));
        cttg.setThanhTien(rs.getFloat("thanhtien"));
        return cttg;
    }
    @Override
    public List<ChiTietTraGop> selectAll() {
        String sql = "Select* from chitiettragop";
        return selectBySql(sql);
    }

    @Override
    public ChiTietTraGop selectById(String MaCTTG) {
        String sql = "SELECT * FROM chitiettragop WHERE macttg=?";
        List<ChiTietTraGop> list = selectBySql(sql, MaCTTG);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<ChiTietTraGop> selectBySql(String sql, Object... args) {
        List<ChiTietTraGop> list = new ArrayList<ChiTietTraGop>();
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
    
    public List<ChiTietTraGop> timDanhSachCTTG(String MaHDTG){
        String sql = "SELECT * FROM ChiTiettragop WHERE MaHDTG = ?";
        return selectBySql(sql, MaHDTG);
    }
    
}
