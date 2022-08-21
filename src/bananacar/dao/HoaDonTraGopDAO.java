/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.dao;

import bananacar.helper.JdbcHelper;
import bananacar.model.HoaDon;
import bananacar.model.HoaDonTraGop;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class HoaDonTraGopDAO extends BananaCarDAO<HoaDonTraGop, String>{

    @Override
    public void insert(HoaDonTraGop hdtg) {
        String sql ="Insert HoaDonTraGop values(?,?,?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, 
                hdtg.getMaHDTG(),
                hdtg.getMaKH(),
                hdtg.getMaNV(),
                hdtg.getNgayBan(),
                hdtg.getTongSoLuong(),
                hdtg.getGiamGia(),
                hdtg.getGTGT(),
                hdtg.getSoNamTraGop(),
                hdtg.getTraGopMoiThang(),
                hdtg.getTongTienTraGop(),
                hdtg.getTongTienXe()
                
                ); 
    }

    @Override
    public void update(HoaDonTraGop hdtg) {
        String sql="UPDATE HoaDontragop SET makh=?, manv=?, ngayban=?,tongsoluong=?,giamgia=?,gtgt=?,sonamtragop=?,tragopmoithang=?, tongtientragop=?, tongtienxe=? WHERE mahdtg=?";
        JdbcHelper.executeUpdate(sql, 
                hdtg.getMaKH(),
                hdtg.getMaNV(),
                hdtg.getNgayBan(),
                hdtg.getTongSoLuong(),
                hdtg.getGiamGia(),
                hdtg.getGTGT(),
                hdtg.getSoNamTraGop(),
                hdtg.getTraGopMoiThang(),
                hdtg.getTongTienTraGop(),
                hdtg.getTongTienXe(),
                hdtg.getMaHDTG()
            );
    }

    @Override
    public void delete(String maHDTG) {
        String sql ="Delete from HoaDontragop where maHDTG=?";
        JdbcHelper.executeUpdate(sql, maHDTG);
    }

    private HoaDonTraGop readFormResultSet(ResultSet rs) throws SQLException{
        HoaDonTraGop hdtg = new HoaDonTraGop();
        hdtg.setMaHDTG(rs.getString("maHDtg"));
        hdtg.setMaKH(rs.getString("maKh"));
        hdtg.setMaNV(rs.getString("manv"));
        hdtg.setNgayBan(rs.getDate("NgayBan"));
        hdtg.setTongSoLuong(rs.getInt("tongsoluong"));
        hdtg.setGiamGia(rs.getFloat("giamgia"));
        hdtg.setGTGT(rs.getFloat("gtgt"));
        hdtg.setSoNamTraGop(rs.getInt("Sonamtragop"));
        hdtg.setTraGopMoiThang(rs.getFloat("Tragopmoithang"));
        hdtg.setTongTienTraGop(rs.getFloat("TongTienTraGop"));
        hdtg.setTongTienXe(rs.getFloat("tongtienxe"));
        return hdtg;
    }
    @Override
    public List<HoaDonTraGop> selectAll() {
        String sql = "Select* from HoaDontragop";
        return selectBySql(sql);
    }

    @Override
    public HoaDonTraGop selectById(String maHDTG) {
        String sql = "SELECT * FROM Hoadontragop WHERE mahdtg=?";
        List<HoaDonTraGop> list = selectBySql(sql, maHDTG);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<HoaDonTraGop> selectBySql(String sql, Object... args) {
        List<HoaDonTraGop> list = new ArrayList<HoaDonTraGop>();
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
    public int tongHoaDonTraGop() throws SQLException{
        int dem = 0;
        String sql = "SELECT COUNT(*) AS 'COUNT' FROM HoaDontragop";
        ResultSet rs = JdbcHelper.executeQuery(sql);
        while(rs.next()){
            dem = rs.getInt(1);
        }
        return dem;
    }
    public int tongThanhTien() throws SQLException{
        int dem = 0;
        String sql = "SELECT SUM(TongTientragop) AS 'COUNT' FROM HoaDontragop";
        ResultSet rs = JdbcHelper.executeQuery(sql);
        while(rs.next()){
            dem = rs.getInt(1);
        }
        return dem;
    }
    
    public List<HoaDonTraGop> selectByKeyword(String mahdtg, String makhtg) {
        String sql="SELECT * FROM HoaDonTragop WHERE mahdtg LIKE ? or makh like ?";
        return selectBySql(sql, "%"+mahdtg+"%", "%"+makhtg+"%");
    }
}
