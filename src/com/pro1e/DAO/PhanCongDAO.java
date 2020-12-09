package com.pro1e.DAO;

import com.pro1e.DAO.DAOhelper;
import com.pro1e.helper.JDBChelper;
import duan1.model.PhanCong;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class PhanCongDAO implements DAOhelper<PhanCong, Integer> {

    private final String insert_sql = "insert into PHANCONG (IDNVIEN,IDNVU)\n"
            + "values(?,?)";
    private final String update_sql = "UPDATE PHANCONG SET IDNVU=? where IDNVIEN=?";
    private final String delete_sql = "delete from PHANCONG where IDNVIEN=? and IDNVU=?";
    private final String select_all = "select * from PHANCONG";
    private final String select_byid = "select * from PHANCONG where IDNVIEN=?";
    private final String select_byNvu = "{call selectPC (?,?)}";

    @Override
    public int insert(PhanCong e) {
        return JDBChelper.update(insert_sql, e.getIdNVien(), e.getIdNVu());
    }

    @Override
    public int update(PhanCong e) {
        return JDBChelper.update(update_sql, e.getIdNVu(), e.getIdNVien());
    }

    @Override
    public int delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int delete2(int idnvien, int idnvu) {
        return JDBChelper.update(delete_sql, idnvien, idnvu);
    }

    @Override
    public List<PhanCong> selectall() {
        return selectbySQL(select_all);
    }

    @Override
    public PhanCong selectbyID(Integer id) {
        List<PhanCong> KM = selectbySQL(select_byid, id);
        return KM.get(0);
    }

    @Override
    public List<PhanCong> selectbySQL(String sql, Object... args) {
        List<PhanCong> listPC = new ArrayList<>();
        try {
            ResultSet rs = JDBChelper.query(sql, args);
            while (rs.next()) {
                PhanCong PC = new PhanCong();
                PC.setIdNVien(rs.getInt("IDNV"));
                PC.setIdNVu(rs.getInt("IDNVU"));
                PC.setTenNV(rs.getString("TENNV"));
                listPC.add(PC);
            }
            rs.getStatement().getConnection().close();
            return listPC;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public List<PhanCong> selectONexists(String idBAN, Integer idnvu) {
        return selectbySQL(select_byNvu, idBAN, idnvu);
    }

    @Override
    public List<PhanCong> selectbysomething(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        PhanCongDAO p = new PhanCongDAO();
        List<PhanCong> lspc;
        lspc = p.selectONexists("TT", 3);
        for (PhanCong phanCong : lspc) {
            System.out.println(phanCong.toString());
        }

    }
}
