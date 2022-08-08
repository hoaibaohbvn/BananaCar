/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.dao;

import bananacar.helper.JdbcHelper;
import bananacar.model.HangXe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class HangXeDAO extends BananaCarDAO<HangXe, String>{

    @Override
    public void insert(HangXe hx) {
        String sql ="Insert HangXe values (?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, 
                hx.getMaHang(),
                hx.getTenHang(),
                hx.getDienThoai(),
                hx.getEmail(),
                hx.getDiaChi(),
                hx.isTrangThai()); 
    }

    @Override
    public void update(HangXe hx) {
        String sql = "Update Hangxe set tenhang=?, dienthoai=?,email=?,diachi=?,trangthai=? where mahang= ?";
        JdbcHelper.executeUpdate(sql, 
                hx.getTenHang(),
                hx.getDienThoai(),
                hx.getEmail(),
                hx.getDiaChi(),
                hx.isTrangThai(),
                hx.getMaHang());
    }

    @Override
    public void delete(String MaHang) {
        String sql ="Delete from HangXe where MaHang=?";
        JdbcHelper.executeUpdate(sql, MaHang);
    }

    private HangXe readFormResultSet(ResultSet rs) throws SQLException{
        HangXe hx = new HangXe();
        hx.setMaHang(rs.getString("MaHang"));
        hx.setTenHang(rs.getString("TenHang"));
        hx.setDienThoai(rs.getString("DienThoai"));
        hx.setEmail(rs.getString("Email"));
        hx.setDiaChi(rs.getString("DiaChi"));
        hx.setTrangThai(rs.getBoolean("TrangThai"));
        return hx;
    }
    @Override
    public List<HangXe> selectAll() {
        String sql = "Select* from HangXe";
        return selectBySql(sql);
    }

    @Override
    public HangXe selectById(String MaHang) {
        String sql = "SELECT * FROM HangXe WHERE MaHang=?";
        List<HangXe> list = selectBySql(sql, MaHang);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<HangXe> selectBySql(String sql, Object... args) {
        List<HangXe> list = new ArrayList<HangXe>();
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
    public List<HangXe> selectByKeyword(String mahang, String tenhang) {
        String sql="SELECT * FROM HangXe WHERE maHang LIKE ? or tenhang like ?";
        return selectBySql(sql, "%"+mahang+"%", "%"+tenhang+"%");
    }
    
}
