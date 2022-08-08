/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.dao;

import bananacar.helper.JdbcHelper;
import bananacar.model.LoaiXe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class LoaiXeDAO extends BananaCarDAO<LoaiXe, String>{

    @Override
    public void insert(LoaiXe lx) {
        String sql ="Insert LoaiXe values (?,?,?)";
        JdbcHelper.executeUpdate(sql, 
                lx.getMaLoai(),
                lx.getTenLoai(),
                lx.getGhiChu()); 
    }

    @Override
    public void update(LoaiXe lx) {
        String sql="UPDATE LoaiXe SET TenLoai=?, GhiChu=? WHERE MaLoai=?";
        JdbcHelper.executeUpdate(sql, 
                lx.getTenLoai(),
                lx.getGhiChu(),
                lx.getMaLoai()
            );
    }

    @Override
    public void delete(String MaLoai) {
        String sql ="Delete from LoaiXe where maLoai=?";
        JdbcHelper.executeUpdate(sql, MaLoai);
    }

    private LoaiXe readFormResultSet(ResultSet rs) throws SQLException{
        LoaiXe lx = new LoaiXe();
        lx.setMaLoai(rs.getString("MaLoai"));
        lx.setTenLoai(rs.getString("TenLoai"));
        lx.setGhiChu(rs.getString("GhiChu"));
        return lx;
    }
    @Override
    public List<LoaiXe> selectAll() {
        String sql = "Select* from LoaiXe";
        return selectBySql(sql);
    }

    @Override
    public LoaiXe selectById(String MaLoai) {
        String sql = "SELECT * FROM LoaiXe WHERE maloai=?";
        List<LoaiXe> list = selectBySql(sql, MaLoai);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<LoaiXe> selectBySql(String sql, Object... args) {
        List<LoaiXe> list = new ArrayList<LoaiXe>();
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
    public List<LoaiXe> selectByKeyword(String maloai, String tenloai) {
        String sql="SELECT * FROM LoaiXe WHERE maloai LIKE ? or tenloai like ?";
        return selectBySql(sql, "%"+maloai+"%", "%"+tenloai+"%");
    }
}
