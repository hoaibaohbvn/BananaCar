/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bananacar.dao;

import bananacar.helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class ThongKeDAO {
    private List<Object[]> getListOfArray(String sql, String[] cols,Object...args){
        try {
            List<Object[]> list = new ArrayList<Object[]>();
        ResultSet rs = JdbcHelper.executeQuery(sql, args);
        while (rs.next()) {            
            Object[] vals =new Object[cols.length];
            for (int i = 0; i < cols.length; i++) {
                vals[i] = rs.getObject(cols[i]);
            }
            list.add(vals);
        }
        rs.getStatement().getConnection().close();
        return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }  
    }
    
    public List<Object[]> getDSXeBanChay(){
        String sql ="{Call [dbo].[sp_XeBanChay]}";
        String[]cols = {"maxe","Tổng xe bán"};
        return this.getListOfArray(sql, cols);
    }
}
