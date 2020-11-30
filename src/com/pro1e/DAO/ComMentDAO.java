/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.DAO;
import com.pro1e.helper.JDBChelper;
import duan1.model.Comment;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author nguye
 */
public class ComMentDAO implements DAOhelper<Comment, Integer>{
    private final String insert_sql = "INSERT INTO COMMENT VALUES(?,?,?,?,?)";
    private final String update_sql = "UPDATE COMMENT SET IDNVU=?, TENNV=?, NOIDUNG=?, THOIGIAN=? where IDCMT=?";
    private final String delete_sql ="delete from COMMENT where IDCMT=?";
    private final String select_all = "select * from COMMENT";
    private final String select_byid = "select * from COMMENT where IDCMT=?";
    @Override
    public int insert(Comment e) {
    return JDBChelper.update(insert_sql, e.getIdCMT(),e.getIdNVu(),e.getTenNV(),e.getNoiDung(),e.getThoigian());
    }

    @Override
    public int update(Comment e) {
    return JDBChelper.update(update_sql, e.getIdNVu(),e.getTenNV(),e.getNoiDung(),e.getThoigian(),e.getIdCMT());
     }

    @Override
    public int delete(Integer id) {
     return JDBChelper.update(delete_sql, id);
    }

    @Override
    public List<Comment> selectall() {
     return selectbySQL(select_all);
     }

    @Override
    public Comment selectbyID(Integer id) {
     List<Comment> KM= selectbySQL(select_byid, id);
    return KM.get(0);
   }

    @Override
    public List<Comment> selectbySQL(String sql, Object... args) {
    List<Comment> listKM= new ArrayList<>();
        try {
            ResultSet rs= JDBChelper.query(sql, args);
            while(rs.next()){
                Comment cmt= new Comment();
                cmt.setIdCMT(rs.getInt("IDCMT"));
                cmt.setIdNVu(rs.getInt("IDNVU"));
                cmt.setTenNV(rs.getString("TENNV"));
                cmt.setNoiDung(rs.getString("NOIDUNG"));
                cmt.setThoigian(rs.getString("THOIGIAN"));
                listKM.add(cmt);
            }
            rs.getStatement().getConnection().close();
            return listKM;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Comment> selectbysomething(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
