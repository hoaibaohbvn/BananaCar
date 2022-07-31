/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.dao;

import bananacar.helper.JdbcHelper;
import bananacar.model.LoaiXe;
import bananacar.model.PhieuNhapHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class PhieuNhapHangDAO extends BananaCarDAO<PhieuNhapHang, String>{

    @Override
    public void insert(PhieuNhapHang pn) {
        String sql ="Insert PhieuNhapHang values"
                + " (?,?,?)";
        JdbcHelper.executeUpdate(sql, 
                pn.getMaPhieuNhap(),
                pn.getMaNV(),
                pn.getNgayNhap(),
                pn.getMaHang(),
                pn.getTongSoLuong(),
                pn.getChietKhau(),
                pn.getGTGT(),
                pn.getThanhTien(),
                pn.getGhiChu()); 
    }

    @Override
    public void update(PhieuNhapHang pn) {
        String sql="UPDATE PhieuNhapHang SET MaNV=?, NgayNhap=?, mahang =?, tongsoluong =?, chietkhau=?, gtgt=?, thanhtien=?,ghichu=? WHERE MaPHieunhap=?";
        JdbcHelper.executeUpdate(sql, 
                pn.getMaNV(),
                pn.getNgayNhap(),
                pn.getMaHang(),
                pn.getTongSoLuong(),
                pn.getChietKhau(),
                pn.getGTGT(),
                pn.getThanhTien(),
                pn.getGhiChu(),
                pn.getMaPhieuNhap()
            );
    }

    @Override
    public void delete(String MaPhieuNhap) {
        String sql ="Delete from PhieuNhapHang where maphieunhap=?";
        JdbcHelper.executeUpdate(sql, MaPhieuNhap);
    }
    
    private PhieuNhapHang readFormResultSet(ResultSet rs) throws SQLException{
        PhieuNhapHang pn = new PhieuNhapHang();
        pn.setMaPhieuNhap(rs.getString("maphieunhap"));
        pn.setMaNV(rs.getString("manv"));
        pn.setNgayNhap(rs.getDate("Ngaynhap"));
        pn.setMaHang(rs.getString("MaHang"));
        pn.setTongSoLuong(rs.getInt("TongSoLuong"));
        pn.setChietKhau(rs.getFloat("chietkhau"));
        pn.setGTGT(rs.getFloat("GTGT"));
        pn.setThanhTien(rs.getFloat("ThanhTien"));
        pn.setGhiChu(rs.getString("GhiChu"));
        return pn;
    }
    @Override
    public List<PhieuNhapHang> selectAll() {
        String sql = "Select* from PhieuNhapHang";
        return selectBySql(sql);
    }

    @Override
    public PhieuNhapHang selectById(String MaPhieuNhap) {
        String sql = "SELECT * FROM PhieuNhapHang WHERE phieunhaphang=?";
        List<PhieuNhapHang> list = selectBySql(sql, MaPhieuNhap);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<PhieuNhapHang> selectBySql(String sql, Object... args) {
        List<PhieuNhapHang> list = new ArrayList<PhieuNhapHang>();
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