/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.DAO;
import com.pro1e.helper.JDBChelper;
import duan1.model.KhachmoiTD;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author nguye
 */
public class KhachMoiTD_DAO implements DAOhelper<KhachmoiTD, Integer>{
    private final String insert_sql = "INSERT INTO KHACMOITD VALUES(?,?)";
    private final String update_sql = "UPDATE KHACMOITD SET IDSK=? where IDKM=?";
    private final String delete_sql ="delete from KHACMOITD where IDKM=?";
    private final String select_all = "select * from KHACMOITD";
    private final String select_byid = "select * from KHACMOITD where IDKM=?";
    @Override
    public int insert(KhachmoiTD e) {
    return JDBChelper.update(insert_sql, e.getIdSK(),e.getIdKM());
      
        
    }

    @Override
    public int update(KhachmoiTD e) {
    return JDBChelper.update(update_sql, e.getIdSK(),e.getIdKM());
    }

    @Override
    public int delete(Integer id) {
    return JDBChelper.update(delete_sql,id);
    }

    @Override
    public List<KhachmoiTD> selectall() {
    return selectbySQL(select_all);
    }

    @Override
    public KhachmoiTD selectbyID(Integer id) {
    List<KhachmoiTD> KM= selectbySQL(select_byid, id);
    return KM.get(0);
    }

    @Override
    public List<KhachmoiTD> selectbySQL(String sql, Object... args) {
    List<KhachmoiTD> listKMTD= new ArrayList<>();
        try {
            ResultSet rs= JDBChelper.query(sql, args);
            while(rs.next()){
                KhachmoiTD KMTD= new KhachmoiTD();
                KMTD.setIdSK(rs.getInt("IDSK"));
                KMTD.setIdKM(rs.getInt("IDKM"));
                listKMTD.add(KMTD);
            }
            rs.getStatement().getConnection().close();
            return listKMTD;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<KhachmoiTD> selectbysomething(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
