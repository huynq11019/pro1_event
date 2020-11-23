/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.DAO;

import com.pro1e.helper.JDBChelper;
import duan1.model.NhanVien;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author huyNQph11019
 */
public class NhanvienDAO implements DAOhelper<NhanVien, Integer> {

    private final String insert_sql = "INSERT INTO NHANVIEN VALUES(?,?,?,?,?,?,?,?)";
    private final String update_sql = "UPDATE NHANVIEN SET TENNV=?, IDBAN=?, EMAIL=?,SDT=?,SDT=? ,CMT=? ,  MATKHAU=?, HINH=?,QUYEN=? WHERE IDNV=?";
    private final String delete_sql ="delete from NHANVIEN where IDNV =?";
    private final String select_all = "select * from NHANVIEN";
    private final String select_byid = "select * from NHANVIEN where IDNV =?";

    @Override
    public int insert(NhanVien e) {
        return JDBChelper.update(insert_sql, e.getTenNV(), e.getIdBan(),
                 e.getEmail(), e.getSdt(), e.getCmnd(), e.getMatKhau(), e.getHinh(), e.getQuyen());

    }

    @Override
    public int update(NhanVien e) {
        return JDBChelper.update(update_sql, e.getTenNV(), e.getIdBan(), e.getEmail(), e.getSdt(), e.getCmnd(), e.getMatKhau(), e.getHinh(), e.getManv());
    }

    @Override
    public int delete(Integer id) {
     return JDBChelper.update(delete_sql, id);
    }

    @Override
    public List<NhanVien> selectall() {
        return selectbySQL(select_all);
    }

    @Override
    public NhanVien selectbyID(Integer id) {
        List<NhanVien> nv = selectbySQL(select_byid, id);
        return nv.get(0);
    }

    @Override
    public List<NhanVien> selectbySQL(String sql, Object... args) {
        List<NhanVien> lsv = new ArrayList<>();
        try {
            ResultSet rs = JDBChelper.query(sql, args);
            while (rs.next()) {
                lsv.add(new NhanVien(rs.getString("MATKHAU"), rs.getString("TENNV"), rs.getString("HINH"), rs.getString("IDBAN"),
                         rs.getString("EMAIL"), rs.getString("SDT"), rs.getString("CMT"), rs.getInt("QUYEN"), rs.getInt("IDNV")));
            }
            rs.getStatement().getConnection().close();
            return lsv;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
