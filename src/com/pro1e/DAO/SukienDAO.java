/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.DAO;

import com.pro1e.helper.JDBChelper;
import duan1.model.SuKien;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huyNQph11019
 */
public class SukienDAO implements DAOhelper<SuKien, Integer> {

    private final String insert_sql = "insert into SUKIEN(TENSK,IDPHONG,NOIDUNG,NGAYBATDAU,NGAYKETTHUC) values(?,?,?,?,?)";
    private final String update_sql = "update SUKIEN set TENSK =? , IDPHONG=?, NOIDUNG=?, NGAYBATDAU=? ,NGAYKETTHUC=? where IDSK=?";
    private final String delete_sql = "delete from SUKIEN where IDSK=?";
    private final String select_all = "select * from SUKIEN order by IDSK asc";
    private final String select_byid = "select * from SUKIEN where =?";

    @Override
    public int insert(SuKien e) {
     return JDBChelper.update(insert_sql, e.getTenSK(), e.getIdPhong(), e.getMoTa(), e.getNgayTao(), e.getNgayKetThuc());
//        PreparedStatement prm = JDBChelper.getStm(insert_sql, e.getTenSK(), e.getIdPhong(), e.getMoTa(), e.getNgayTao(), e.getNgayKetThuc());
//        try {
//            //excute
//            prm.execute();
//            ResultSet rs = prm.getGeneratedKeys();
//            int IDSukien= 0;
//            if (rs.next()) {
//                IDSukien = rs.getInt("IDSK");
//               }
//            return IDSukien;
//        } catch (SQLException ex) {
//            throw new RuntimeException();
//        }

    }

    @Override
    public int update(SuKien e) {
        return JDBChelper.update(update_sql, e.getTenSK(), e.getIDSK(), e.getMoTa(), e.getNgayTao(), e.getNgayKetThuc(), e.getIDSK());
    }

    @Override
    public int delete(Integer id) {
        return JDBChelper.update(delete_sql, id);
    }

    @Override
    public List<SuKien> selectall() {
        return selectbySQL(select_all);
    }

    @Override
    public SuKien selectbyID(Integer id) {
        List<SuKien> lst = selectbySQL(select_byid, id);
        return lst.get(0);
    }

    @Override
    public List<SuKien> selectbySQL(String sql, Object... args) {
        List<SuKien> lst = new ArrayList<>();
        try {
            ResultSet rs = JDBChelper.query(sql, args);
            while (rs.next()) {
                SuKien sk = new SuKien();
                sk.setIDSK(rs.getInt("IDSK"));
                sk.setTenSK(rs.getString("TENSK"));
                sk.setIdPhong(rs.getInt("IDPHONG"));
                sk.setMoTa(rs.getString("NOIDUNG"));
                sk.setNgayTao(rs.getString("NGAYBATDAU"));
                sk.setNgayKetThuc(rs.getString("NGAYKETTHUC"));
                lst.add(sk);
              //  System.out.println(sk.toString());
            }
            rs.getStatement().getConnection().close();

            return lst;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<SuKien> selectbysomething(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
