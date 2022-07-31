/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.dao;

import bananacar.helper.JdbcHelper;
import bananacar.model.NguoiDung;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class NguoiDungDAO extends BananaCarDAO<NguoiDung, String>{

    @Override
    public void insert(NguoiDung nd) {
       String sql ="Insert NguoiDung values (?,?,?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, 
                nd.getTenDangNhap(),
                nd.getMatKhau(),
                nd.getHoTen(),
                nd.getDienThoai(),
                nd.isGioiTinh(),
                nd.getNgaySinh(),
                nd.getEmail(),
                nd.getDiaChi(),
                nd.isTrangThai(),
                nd.getLuong(),
                nd.isVaiTro()); 
    }

    @Override
    public void update(NguoiDung nd) {
        String sql="UPDATE NguoiDung SET MatKhau=?, HoTen=?, DienThoai=?, GioiTinh=?, NgaySinh=?, Email = ?,DiaChi=?,TrangThai = ?, Luong = ?, VaiTro = ?  WHERE TenDangNhap=?";
        JdbcHelper.executeUpdate(sql, 
                nd.getMatKhau(),
                nd.getHoTen(),
                nd.getDienThoai(),
                nd.isGioiTinh(),
                nd.getNgaySinh(),
                nd.getEmail(),
                nd.getDiaChi(),
                nd.isTrangThai(),
                nd.getLuong(),
                nd.isVaiTro(),
                nd.getTenDangNhap()
            );
    }

    @Override
    public void delete(String TenDangNhap) {
        String sql ="Delete from NguoiDung where TenDangnhap=?";
        JdbcHelper.executeUpdate(sql, TenDangNhap);
    }

    private NguoiDung readFormResultSet(ResultSet rs) throws SQLException{
        NguoiDung nd = new NguoiDung();
        nd.setTenDangNhap(rs.getString("TenDangNhap"));
        nd.setMatKhau(rs.getString("MatKhau"));
        nd.setHoTen(rs.getString("HoTen"));
        nd.setDienThoai(rs.getString("Dienthoai"));
        nd.setGioiTinh(rs.getBoolean("GioiTinh"));
        nd.setNgaySinh(rs.getDate("NgaySinh"));
        nd.setEmail(rs.getString("Email"));
        nd.setDiaChi(rs.getString("DiaChi"));
        nd.setTrangThai(rs.getBoolean("TrangThai"));
        nd.setLuong(rs.getFloat("Luong"));
        nd.setVaiTro(rs.getBoolean("VaiTro"));
        return nd;
    }
    @Override
    public List<NguoiDung> selectAll() {
        String sql = "Select* from NguoiDung";
        return selectBySql(sql);
    }

    @Override
    public NguoiDung selectById(String TenDangNhap) {
        String sql = "SELECT * FROM NguoiDung WHERE tenDangNhap=?";
        List<NguoiDung> list = selectBySql(sql, TenDangNhap);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<NguoiDung> selectBySql(String sql, Object... args) {
        List<NguoiDung> list = new ArrayList<NguoiDung>();
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
