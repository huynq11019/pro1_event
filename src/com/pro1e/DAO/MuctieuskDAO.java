/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.DAO;

import com.pro1e.helper.JDBChelper;
import duan1.model.MucTieuSK;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author huyNQph11019
 */
public class MuctieuskDAO implements DAOhelper<MucTieuSK, Integer> {
//    private final String insert_sql = "";
//    private final String update_sql = "";
//    private final String delete_sql ="";
//    private final String select_all = "";
//    private final String select_byid = "";

    private final String insert_sql = "insert into MUCTIEUSK(IDSK,MUCTIEU,TRANGTHAI) values (?,?,?)";
    private final String update_sql = "update MUCTIEUSK set IDSK,MUCTIEU,TRANGTHAI where IDMT = ?";
    private final String delete_sql = "delete from MUCTIEUSK where IDMT = ?";
    private final String select_all = "select * from MUCTIEUSK";
    private final String select_byid = "select * from MUCTIEUSK where IDMT=?";

    @Override
    public int insert(MucTieuSK e) {
       return JDBChelper.update(insert_sql, e.getIdSK(),e.getMucTieu(),e.isTrangThai());
    }

    @Override
    public int update(MucTieuSK e) {
      return JDBChelper.update(update_sql,e.getIdSK(),e.getMucTieu(),e.isTrangThai(),e.getIdMucTieu() );
    }

    @Override
    public int delete(Integer id) {
       return JDBChelper.update(delete_sql, id);
    }

    @Override
    public List<MucTieuSK> selectall() {
      return selectbySQL(select_all);
    }

    @Override
    public MucTieuSK selectbyID(Integer id) {
       return selectbySQL(select_byid, id).get(0);
    }

    @Override
    public List<MucTieuSK> selectbySQL(String sql, Object... args) {
        try {
            List<MucTieuSK> lst = new ArrayList<>();
            ResultSet rs = JDBChelper.query(sql, args);
            while (rs.next()) {                
                MucTieuSK mtsk = new MucTieuSK();
                mtsk.setIdMucTieu(rs.getInt("IDMT"));
                mtsk.setIdSK(rs.getInt("IDSK"));
                mtsk.setTrangThai(rs.getBoolean("TRANGTHAI"));
                mtsk.setMucTieu(rs.getString("MUCTIEU"));
                lst.add(mtsk);
            }
            rs.getStatement().getConnection().close();
            return lst;
        } catch (SQLException e) {
            throw new RuntimeException();
                    
        }
    }

}
