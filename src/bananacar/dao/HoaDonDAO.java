/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.dao;

import bananacar.helper.JdbcHelper;
import bananacar.model.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class HoaDonDAO extends BananaCarDAO<HoaDon, String>{

    @Override
    public void insert(HoaDon hd) {
        String sql ="Insert HoaDon values(?,?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, 
                hd.getMaHD(),
                hd.getMaKH(),
                hd.getMaNhanVien(),
                hd.getNgayBan(),
                hd.getTongSoLuong(),
                hd.getGiamGia(),
                hd.getGTGT(),
                hd.getThanhTien(),
                hd.getHoaHong(),
                hd.getTongTienHang()); 
    }

    @Override
    public void update(HoaDon hd) {
        String sql="UPDATE HoaDon SET makh=?, manhanvien=?, ngayban=?,tongsoluong=?,giamgia=?,gtgt=?,thanhtien=?,hoahong=?,tongtienhang=? WHERE Mahd=?";
        JdbcHelper.executeUpdate(sql, 
                hd.getMaKH(),
                hd.getMaNhanVien(),
                hd.getNgayBan(),
                hd.getTongSoLuong(),
                hd.getGiamGia(),
                hd.getGTGT(),
                hd.getThanhTien(),
                hd.getHoaHong(),
                hd.getTongTienHang(),
                hd.getMaHD()
            );
    }

    @Override
    public void delete(String maHD) {
        String sql ="Delete from HoaDon where maHD=?";
        JdbcHelper.executeUpdate(sql, maHD);
    }

    private HoaDon readFormResultSet(ResultSet rs) throws SQLException{
        HoaDon hd = new HoaDon();
        hd.setMaHD(rs.getString("maHD"));
        hd.setMaKH(rs.getString("maKh"));
        hd.setMaNhanVien(rs.getString("manhanvien"));
        hd.setNgayBan(rs.getDate("NgayBan"));
        hd.setTongSoLuong(rs.getInt("tongsoluong"));
        hd.setGiamGia(rs.getFloat("giamgia"));
        hd.setGTGT(rs.getFloat("gtgt"));
        hd.setThanhTien(rs.getFloat("thanhtien"));
        hd.setHoaHong(rs.getFloat("Hoahong"));
        hd.setTongTienHang(rs.getFloat("tongtienhang"));
        return hd;
    }
    
    
    @Override
    public List<HoaDon> selectAll() {
        String sql = "Select* from HoaDon";
        return selectBySql(sql);
    }

    @Override
    public HoaDon selectById(String MaHD) {
        String sql = "SELECT * FROM Hoadon WHERE mahd=?";
        List<HoaDon> list = selectBySql(sql, MaHD);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<HoaDon>();
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
    public int tongHoaDon() throws SQLException{
        int dem = 0;
        String sql = "SELECT COUNT(*) AS 'COUNT' FROM HoaDon";
        ResultSet rs = JdbcHelper.executeQuery(sql);
        while(rs.next()){
            dem = rs.getInt(1);
        }
        return dem;
    }
    public List<HoaDon> selectByKeyword(String mahd, String makh) {
        String sql="SELECT * FROM HoaDon WHERE mahd LIKE ? or makh like ?";
        return selectBySql(sql, "%"+mahd+"%", "%"+makh+"%");
    }
    
    public int tongThanhTien() throws SQLException{
        int dem = 0;
        String sql = "SELECT SUM(ThanhTien) AS 'COUNT' FROM HoaDon";
        ResultSet rs = JdbcHelper.executeQuery(sql);
        while(rs.next()){
            dem = rs.getInt(1);
        }
        return dem;
    }
}
