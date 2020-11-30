/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.DAO;
import duan1.model.HauCan;
import com.pro1e.helper.JDBChelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class HauCanDAO implements DAOhelper<HauCan, Integer>{

        private final String insert_sql = "INSERT INTO HAUCAN VALUES(?,?,?,?)";
        private final String update_sql = "UPDATE HAUCAN SET TENBP=?, TENNGUOILH=?, EMAIL=?, DTHOAI=? where IDHAUCAN=?";
        private final String delete_sql ="delete from HAUCAN where IDHAUCAN=?";
        private final String select_all = "select * from HAUCAN";
        private final String select_byid = "select * from HAUCAN where IDHAUCAN=?";

    @Override
    public int insert(HauCan e) {
        return JDBChelper.update(insert_sql, e.getTenBP(),e.getTenNguoiLH(),e.getEmail(),e.getDienThoai());
     }

    @Override
    public int update(HauCan e) {
         return JDBChelper.update(update_sql, e.getTenBP(),e.getTenNguoiLH(),e.getEmail(),e.getDienThoai(),e.getIDHauCan());
         
    }

    @Override
    public int delete(Integer id) {
    return JDBChelper.update(delete_sql, id);
    }

    @Override
    public List<HauCan> selectall() {
    return selectbySQL(select_all);
    }

    @Override
    public HauCan selectbyID(Integer id) {
        List<HauCan> HC= selectbySQL(select_byid, id);
        return HC.get(0);
    }

    @Override
    public List<HauCan> selectbySQL(String sql, Object... args) {
     List<HauCan> listHC= new ArrayList<>();
        try {
            ResultSet rs= JDBChelper.query(sql, args);
            while(rs.next()){
                HauCan HC= new HauCan();
                HC.setIDHauCan(rs.getInt("IDHAUCAN"));
                HC.setTenBP(rs.getString("TENBP"));
                HC.setTenNguoiLH(rs.getString("TENNGUOILH"));
                HC.setEmail(rs.getString("EMAIL"));
                HC.setDienThoai(rs.getString("DTHOAI"));
                listHC.add(HC);
            }
            rs.getStatement().getConnection().close();
            return listHC;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<HauCan> selectbysomething(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        HauCanDAO hcdao = new HauCanDAO();
        List<HauCan> hc = hcdao.selectall();
        for (HauCan hauCan : hc) {
            System.out.println(hauCan.toString());
        }
                
        
    }
    
    
    
}
