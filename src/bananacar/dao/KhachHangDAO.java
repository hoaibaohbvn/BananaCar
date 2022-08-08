/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.dao;

import bananacar.helper.JdbcHelper;
import bananacar.model.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class KhachHangDAO extends BananaCarDAO<KhachHang, String>{

    @Override
    public void insert(KhachHang kh) {
        String sql ="Insert khachHang values (?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, 
                kh.getMaKH(),
                kh.getHoTen(),
                kh.getDienThoai(),
                kh.isGioiTinh(),
                kh.getNgaySinh(),
                kh.getNVQuanLy(),
                kh.getEmail(),
                kh.getDiaChi(),
                kh.getGhiChu());
    }

    @Override
    public void update(KhachHang kh) {
        String sql = "Update KhachHang set HoTen = ?, DIenThoai=?,gioiTinh=?,Ngaysinh=?,NVQuanLy=?,email= ?, diachi=?, ghichu=?, where makh = ?";
        JdbcHelper.executeUpdate(sql,
                kh.getHoTen(),
                kh.getDienThoai(),
                kh.isGioiTinh(),
                kh.getNgaySinh(),
                kh.getNVQuanLy(),
                kh.getEmail(),
                kh.getDiaChi(),
                kh.getGhiChu(),                
                kh.getMaKH()
                );
    }

    @Override
    public void delete(String MaKH) {
        String sql ="Delete from KhachHang where MaKH=?";
        JdbcHelper.executeUpdate(sql, MaKH);
    }

    private KhachHang readFormResultSet(ResultSet rs) throws SQLException{
        KhachHang kh = new KhachHang();
        kh.setMaKH(rs.getString("MaKH"));
        kh.setHoTen(rs.getString("HoTen"));
        kh.setDienThoai(rs.getString("DienThoai"));
        kh.setGioiTinh(rs.getBoolean("GioiTinh"));
        kh.setNgaySinh(rs.getDate("NgaySinh"));
        kh.setNVQuanLy(rs.getString("NVQuanly"));
        kh.setEmail(rs.getString("Email"));
        kh.setDiaChi(rs.getString("DiaChi"));
        kh.setGhiChu(rs.getString("GhiChu"));
        return kh;
    }
    @Override
    public List<KhachHang> selectAll() {
        String sql = "Select* from KhachHang";
        return selectBySql(sql);
    }

    @Override
    public KhachHang selectById(String MaKH) {
        String sql = "SELECT * FROM KhachHang WHERE makh=?";
        List<KhachHang> list = selectBySql(sql, MaKH);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<KhachHang>();
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
    public int tongKhachHang() throws SQLException{
        int dem = 0;
        String sql = "SELECT COUNT(*) AS 'COUNT' FROM KhachHang";
        ResultSet rs = JdbcHelper.executeQuery(sql);
        while(rs.next()){
            dem = rs.getInt(1);
        }
        return dem;
    }
    public List<KhachHang> selectByKeyword(String makh, String hoten) {
        String sql="SELECT * FROM Khachhang WHERE maKH LIKE ? or hoten like ?";
        return selectBySql(sql, "%"+makh+"%", "%"+hoten+"%");
    }
}
