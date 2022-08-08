/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.dao;

import bananacar.helper.JdbcHelper;
import bananacar.model.Xe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class XeDAO extends BananaCarDAO<Xe, String>{

    @Override
    public void insert(Xe xe) {
        String sql = "Insert Xe values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, 
                xe.getMaXe(),
                xe.getTenXe(),
                xe.getMaHang(),
                xe.getMaLoai(),
                xe.getTonKho(),
                xe.getDinhMucNhoNhat(),
                xe.getDinhMucLonNhat(),
                xe.getGiaBan(),
                xe.getHinh(),
                xe.isTrangThai(),
                xe.getChoNgoi(),
                xe.getDongCo(),
                xe.getSucManh(),
                xe.isTayLaiTroLuc(),
                xe.isTuiKhi(),
                xe.isHTChongBoCungPhanh(),
                xe.getBaoHanh());
    }

    @Override
    public void update(Xe xe) {
        String sql = "Update Xe set TenXe=?,MaHang=?,maloai=?,Tonkho=?,DinhMucLonNhat=?,dinhmucnhonhat=?,"
                + "giaban=?,hinh=?,trangthai=?,chongoi=?,dongco=?,sucmanh=?,taylaitroluc=?,tuikhi=?,HTchongbocungphanh=?,"
                + "baohanh=? where maxe=?";
        JdbcHelper.executeUpdate(sql,
                xe.getTenXe(),
                xe.getMaHang(),
                xe.getMaLoai(),
                xe.getTonKho(),
                xe.getDinhMucNhoNhat(),
                xe.getDinhMucLonNhat(),
                xe.getGiaBan(),
                xe.getHinh(),
                xe.isTrangThai(),
                xe.getChoNgoi(),
                xe.getDongCo(),
                xe.getSucManh(),
                xe.isTayLaiTroLuc(),
                xe.isTuiKhi(),
                xe.isHTChongBoCungPhanh(),
                xe.getBaoHanh(),
                xe.getMaXe());
    }

    @Override
    public void delete(String MaXe) {
        String sql ="Delete from Xe where maxe=?";
        JdbcHelper.executeUpdate(sql, MaXe);
    }
    
    private Xe readFormResultSet(ResultSet rs) throws SQLException{
        Xe xe = new Xe();
        xe.setMaXe(rs.getString("MaXe"));
        xe.setTenXe(rs.getString("TenXe"));
        xe.setMaHang(rs.getString("MaHang"));
        xe.setMaLoai(rs.getString("MaLoai"));
        xe.setTonKho(rs.getInt("TonKho"));
        xe.setDinhMucNhoNhat(rs.getInt("DinhMucNhoNhat"));
        xe.setDinhMucLonNhat(rs.getInt("DinhMucLonNhat"));
        xe.setGiaBan(rs.getFloat("GiaBan"));
        xe.setHinh(rs.getString("Hinh"));
        xe.setTrangThai(rs.getBoolean("TrangThai"));
        xe.setChoNgoi(rs.getInt("ChoNgoi"));
        xe.setDongCo(rs.getInt("Dongco"));
        xe.setSucManh(rs.getInt("Sucmanh"));
        xe.setTayLaiTroLuc(rs.getBoolean("Taylaitroluc"));
        xe.setTuiKhi(rs.getBoolean("TuiKhi"));
        xe.setHTChongBoCungPhanh(rs.getBoolean("HTchongbocungphanh"));
        xe.setBaoHanh(rs.getInt("BaoHanh"));
        return xe;
    }
    @Override
    public List<Xe> selectAll() {
        String sql = "Select* from Xe";
        return selectBySql(sql);
    }

    @Override
    public Xe selectById(String MaXe) {
        String sql = "SELECT * FROM Xe WHERE Maxe=?";
        List<Xe> list = selectBySql(sql, MaXe);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<Xe> selectBySql(String sql, Object... args) {
        List<Xe> list = new ArrayList<Xe>();
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
    
    public List<Xe> selectByKeyword(String maxe, String tenxe) {
        String sql="SELECT * FROM Xe WHERE maxe LIKE ? or tenxe like ?";
        return selectBySql(sql, "%"+maxe+"%", "%"+tenxe+"%");
    }
}
