/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.DAO;
import com.pro1e.helper.JDBChelper;
import duan1.model.Phong;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author huyNQph11019
 */
public class PhongDAO implements DAOhelper<Phong, Integer>{
        private final String insert_sql = "INSERT INTO PHONG VALUES(?,?,?,?)";
        private final String update_sql = "UPDATE PHONG SET TENPHONG=?, IDTRP=?, NGANSACH=? where IDPHONG=?";
        private final String delete_sql ="delete from PHONG where IDPHONG=?";
        private final String select_all = "select * from PHONG";
        private final String select_byid = "select * from PHONG where IDPHONG=?";
    @Override
    public int insert(Phong e) {
    return JDBChelper.update(insert_sql, e.getIDPhong(),e.getTenPhong(),e.getIdTrP(),e.getNgansach());
    }

    @Override
    public int update(Phong e) {
    return JDBChelper.update(update_sql,e.getTenPhong(),e.getIdTrP(),e.getNgansach(), e.getIDPhong());
    }

    @Override
    public int delete(Integer id) {
    return JDBChelper.update(delete_sql, id);
    }

    @Override
    public List<Phong> selectall() {
       return selectbySQL(select_all);
    }

    @Override
    public Phong selectbyID(Integer id) {
        List<Phong> KM= selectbySQL(select_byid, id);
    return KM.get(0);
    }

    @Override
    public List<Phong> selectbySQL(String sql, Object... args) {
    List<Phong> listPH= new ArrayList<>();
        try {
            ResultSet rs= JDBChelper.query(sql, args);
            while(rs.next()){
                Phong PH= new Phong();
                PH.setIDPhong(rs.getInt("IDPHONG"));
                PH.setTenPhong(rs.getString("TENPHONG"));
                PH.setIdTrP(rs.getInt("IDTRP"));
                PH.setNgansach(rs.getFloat("NGANSACH"));
                listPH.add(PH);
            }
            rs.getStatement().getConnection().close();
            return listPH;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Phong> selectbysomething(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
