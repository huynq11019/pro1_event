/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.DAO;

import com.pro1e.helper.JDBChelper;
import duan1.model.GiaiDoan;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huyNQph11019
 */
public class GiaidoanDAO implements DAOhelper<GiaiDoan, Integer> {

    private final String insert_sql = "insert into GIADOAN (IDSK, TENGD , NGAYBATDAU, DEADLINE,MOTA,lockAt) values (?,?,?,?,?,?)";
    private final String update_sql = "update GIADOAN set IDSK = ? , TENGD = ? , NGAYBATDAU = ? , DEADLINE = ?, MOTA=?,lockAt=? where IDGIAODOAN = ?";
    private final String delete_sql = "delete from  GIADOAN where IDGIAODOAN = ?";
    private final String select_all = "select * from GIADOAN";
    private final String select_byid = "select * from GIADOAN where IDGIAODOAN = ?";

    @Override
    public int insert(GiaiDoan e) {
        return JDBChelper.update(insert_sql, e.getIdSK(), e.getTenGD(), e.getNgayBD(), e.getDeadLine(), e.getMota(),e.getLockAT());
    }

    @Override
    public int update(GiaiDoan e) {
        return JDBChelper.update(update_sql, e.getIdSK(), e.getTenGD(), e.getNgayBD(), e.getDeadLine(), e.getMota(),e.getLockAT(), e.getIdGiaiDoan());
    }

    @Override
    public int delete(Integer id) {
        return JDBChelper.update(delete_sql, id);
    }

    @Override
    public List<GiaiDoan> selectall() {
       return selectbySQL(select_all);
    }
//    public List<GiaiDoan> selectBYsk(Integer idsk){
//        String sql = "select * from GIADOAN where IDSK = ?";
//        return selectbySQL(sql, idsk);
//    }
    @Override
    public GiaiDoan selectbyID(Integer id) {
       List<GiaiDoan> lst = selectbySQL(select_byid, id);
        if (lst.isEmpty()) {
            return null;
        }
        return lst.get(0);
    }

    @Override
    public List<GiaiDoan> selectbySQL(String sql, Object... args) {
        List<GiaiDoan> lst = new ArrayList<>();
        ResultSet rs = JDBChelper.query(sql, args);
        try {
            while (rs.next()) {
                GiaiDoan gd = new GiaiDoan();
                gd.setIdGiaiDoan(rs.getInt("IDGIAODOAN"));
                gd.setIdSK(rs.getInt("IDSK"));
                gd.setTenGD(rs.getString("TENGD"));
                gd.setMota(rs.getString("MOTA"));
                gd.setNgayBD(rs.getString("NGAYBATDAU"));
                gd.setDeadLine(rs.getString("DEADLINE"));
                gd.setLockAT(rs.getString("lockAt"));
                lst.add(gd);
            }
            rs.getStatement().getConnection().close();
            return lst;
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<GiaiDoan> selectbysomething(Integer id) {
        String sql = "select * from GIADOAN where IDSK = ?";
        return selectbySQL(sql, id);
    }

   

}
