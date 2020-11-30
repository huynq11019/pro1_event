/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.DAO;
import com.pro1e.helper.JDBChelper;
import duan1.model.Ban;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author nguye
 */
public class BanDAO implements DAOhelper<Ban, String>{
    private final String insertSql= "insert into BAN(IDBAN,IDPHONG,TENBAN)\n" +
                                    "values(?,?,?)";
    private final String updateSql="update BAN set IDPHONG=?, TENBAN=? where IDBAN=?";
    private final String selectAll= "Select * from BAN";
    private final String selectByID= "select * from BAN where IDBAN=?";
    private final String deleteSql= "Delete from BAN where IDBAN=?";
    
    @Override
    public int insert(Ban e) {
        return JDBChelper.update(insertSql, e.getIdban(),e.getIdPhong(),e.getTenBan());
    }

    @Override
    public int update(Ban e) {
        return JDBChelper.update(updateSql, e.getIdPhong(),e.getTenBan(),e.getIdban());
       
    }

    @Override
    public int delete(String id) {
        return JDBChelper.update(deleteSql, id);
    }

    @Override
    public List<Ban> selectall() {
    return selectbySQL(selectAll);
    }

    @Override
    public Ban selectbyID(String id) {
    List<Ban> ban= selectbySQL(selectByID, id);
    return ban.get(0);
    }

    @Override
    public List<Ban> selectbySQL(String sql, Object... args) {
        List<Ban> listBan= new ArrayList<>();
        try {
            ResultSet rs= JDBChelper.query(sql, args);
            while(rs.next()){
                Ban ban= new Ban();
                ban.setIdban(rs.getString("IDBAN"));
                ban.setIdPhong(rs.getInt("IDPHONG"));
                ban.setTenBan(rs.getString("TENBAN"));
                listBan.add(ban);
            }
            rs.getStatement().getConnection().close();
            return listBan;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) {
        BanDAO d = new BanDAO();
        List<Ban> lsban = d.selectall();
        for (Ban ban : lsban) {
            System.out.println(ban.toString());
        }
        
    }

    @Override
    public List<Ban> selectbysomething(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
