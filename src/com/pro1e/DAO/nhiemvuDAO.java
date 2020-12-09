/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.DAO;

import com.pro1e.helper.JDBChelper;
import duan1.model.NhiemVu;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author huyNQph11019
 */
public class nhiemvuDAO implements DAOhelper<NhiemVu, Integer> {

    private final String insert_sql = "insert into NHIEMVU(TENNVU,IDGIAIDOAN,MOTA,TRANGTHAI,FILEIN, NGAYBATDAU,DEADLINE,TGHT )\n"
            + "VALUES (?,?,?,?,?,?,?,?)";
    private final String update_sql = "update NHIEMVU  set TENNVU=?,IDGIAIDOAN=?,MOTA=?,TRANGTHAI=?,FILEIN=?, NGAYBATDAU=?,DEADLINE=?,TGHT=? where IDNVU =?";
    private final String delete_sql = "delete from NHIEMVU  IDNVU=?";
    private final String select_all = "select * from NHIEMVU order by IDNVU desc";
    private final String select_byid = "select * from NHIEMVU where IDGIAIDOAN= ?";

    @Override
    public int insert(NhiemVu e) {
        return JDBChelper.update(insert_sql, e.getTenNVu(), e.getIdGiaiDoan(), e.getMoTa(), e.isTrangThai(),e.getFileIn(), e.getNgatBD(), e.getDeaLine(), e.getTGHT());
    }

    @Override
    public int update(NhiemVu e) {
        return JDBChelper.update(update_sql, e.getTenNVu(), e.getIdGiaiDoan(), e.getMoTa(),e.isTrangThai(), e.getFileIn(), e.getNgatBD(), e.getDeaLine(), e.getTGHT(), e.getiDNVu());
    }

    @Override
    public int delete(Integer id) {
        return JDBChelper.update(delete_sql, id);
    }

    @Override
    public List<NhiemVu> selectall() {
       return  selectbySQL(select_all);
    }

    @Override
    public NhiemVu selectbyID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NhiemVu> selectbySQL(String sql, Object... args) {
        try {
            List<NhiemVu> lsnhiemvu = new ArrayList<>();
            ResultSet rs = JDBChelper.query(sql, args);
            while (rs.next()) {
                NhiemVu nvu = new NhiemVu();
                nvu.setiDNVu(rs.getInt("IDNVU"));
                nvu.setIdGiaiDoan(rs.getInt("IDGIAIDOAN"));
                nvu.setTenNVu(rs.getString("TENNVU"));
                nvu.setMoTa(rs.getString("MOTA"));
                nvu.setFileIn(rs.getString("FILEIN"));
                nvu.setNgatBD(rs.getString("NGAYBATDAU"));
                nvu.setDeaLine(rs.getString("DEADLINE"));
                nvu.setTGHT(rs.getInt("TGHT"));
                nvu.setTrangThai(rs.getBoolean("TRANGTHAI"));
                lsnhiemvu.add(nvu);
            }
            rs.getStatement().getConnection().close();
            return lsnhiemvu;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        nhiemvuDAO nvdao = new nhiemvuDAO();
        List<NhiemVu> listNV = nvdao.selectbysomething(1);

        for (NhiemVu nhiemVu : listNV) {
            System.out.println(nhiemVu);
        }
    }

    @Override
    public List<NhiemVu> selectbysomething(Integer id) {
      return selectbySQL(select_byid,id );
    }
}
