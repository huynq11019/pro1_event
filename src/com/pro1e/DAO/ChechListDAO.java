package com.pro1e.DAO;


import com.pro1e.DAO.DAOhelper;
import com.pro1e.helper.JDBChelper;
import duan1.model.CheckListNV;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguye
 */
public class ChechListDAO implements DAOhelper<CheckListNV, Integer>{
    private final String insert_sql = "INSERT INTO CHECHLIST VALUES(?,?,?,?)";
    private final String update_sql = "UPDATE CHECHLIST SET IDNVU=?, NOIDUNGCL=?, TRANGTHAI=? where IDCLIST=?";
    private final String delete_sql ="delete from CHECHLIST where IDCLIST=?";
    private final String select_all = "select * from CHECHLIST";
    private final String select_byid = "select * from CHECHLIST where IDCLIST=?";
    @Override
    public int insert(CheckListNV e) {
    return JDBChelper.update(insert_sql, e.getIdCList(),e.getIdNVu(),e.getNoiDungCList(), e.isTrangThai());
   }

    @Override
    public int update(CheckListNV e) {
     return JDBChelper.update(update_sql, e.getIdNVu(),e.getNoiDungCList(),e.isTrangThai(),e.getIdCList());
    }

    @Override
    public int delete(Integer id) {
     return JDBChelper.update(delete_sql, id);
     }

    @Override
    public List<CheckListNV> selectall() {
     return selectbySQL(select_all);
    }

    @Override
    public CheckListNV selectbyID(Integer id) {
    List<CheckListNV> KM= selectbySQL(select_byid, id);
    return KM.get(0);
    }

    @Override
    public List<CheckListNV> selectbySQL(String sql, Object... args) {
    List<CheckListNV> listKM= new ArrayList<>();
        try {
            ResultSet rs= JDBChelper.query(sql, args);
            while(rs.next()){
                CheckListNV CL= new CheckListNV();
                CL.setIdCList(rs.getInt("IDCMT"));
                CL.setIdNVu(rs.getInt("IDNVU"));
                CL.setNoiDungCList(rs.getString("TENNV"));
                CL.setTrangThai(rs.getBoolean("NOIDUNG"));
                listKM.add(CL);
            }
            rs.getStatement().getConnection().close();
            return listKM;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<CheckListNV> selectbysomething(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
