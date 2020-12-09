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
    private final String update_sql = "UPDATE NHANVIEN SET TENNV=?, IDBAN=?, EMAIL=?,SDT=? ,CMT=? ,  MATKHAU=?, HINH=?,QUYEN=? WHERE IDNV=?";
    private final String delete_sql = "delete from NHANVIEN where IDNV =?";
    private final String select_all = "select * from NHANVIEN";
    private final String select_byid = "select * from NHANVIEN where IDNV =?";

    @Override
    public int insert(NhanVien e) {
        return JDBChelper.update(insert_sql, e.getTenNV(), e.getIdBan(), 
                e.getEmail(), e.getSdt(), e.getCmnd(), e.getMatKhau(), e.getHinh(), e.getQuyen());

    }

    @Override
    public int update(NhanVien e) {
        return JDBChelper.update(update_sql, e.getTenNV(), e.getIdBan(),  e.getEmail(), e.getSdt(), e.getCmnd(), e.getMatKhau(), e.getHinh(), e.getQuyen(), e.getManv());
    }

    @Override
    public int delete(Integer id) {
        return JDBChelper.update(delete_sql, id);
    }

    public List<NhanVien> timKiemNV(String key) {
        String sql = "select * from NHANVIEN where TENNV like N'%" + key + "%' or IDBAN = ?";
        return selectbySQL(sql, key);
    }

    @Override
    public List<NhanVien> selectall() {
        return selectbySQL(select_all);
    }

    @Override
    public NhanVien selectbyID(Integer id) {
        List<NhanVien> nv = selectbySQL(select_byid, id);
        if (nv.isEmpty()) {// kiểm tra có dữ liệu không
            return null;
        }
        return nv.get(0);
    }

    public List<NhanVien> selectByBan(String ban) {
        String sql = "select * from NHANVIEN where iDBAN =?";
        return selectbySQL(sql, ban);
    }

    public NhanVien selectByeDT(String email) {
        String sqla = "select * from NHANVIEN where  SDT like ? or  EMAIL like ?";
//        List<NhanVien> lit =  selectbySQL(sqla, email , email);
//        System.out.println(lit.get(0));
//        return lit.get(0);
        List<NhanVien> nv = new ArrayList<>();
        nv = this.selectbySQL(sqla, email, email);
        if (nv.isEmpty()) {// kiểm tra có dữ liệu không
            return null;
        }
        return nv.get(0);
    }

    @Override
    public List<NhanVien> selectbySQL(String sql, Object... args) {
        List<NhanVien> lsv = new ArrayList<>();
        try {
            ResultSet rs = JDBChelper.query(sql, args);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setManv(rs.getInt("IDNV"));
                nv.setTenNV(rs.getString("TENNV"));
                nv.setIdBan(rs.getString("IDBAN"));
                nv.setEmail(rs.getString("EMAIL"));
                nv.setSdt(rs.getString("SDT"));
                nv.setCmnd(rs.getString("CMT"));
                nv.setMatKhau(rs.getString("MATKHAU"));
                nv.setHinh(rs.getString("HINH"));
                nv.setQuyen(rs.getInt("QUYEN"));
//                nv.setIdphong(rs.getInt("IDPHONG"));
                lsv.add(nv);
            }
            rs.getStatement().getConnection().close();
            return lsv;
        } catch (SQLException e) {
            
            throw new RuntimeException();
        }
    }

    @Override
    public List<NhanVien> selectbysomething(Integer id) {
        String sql = "select * from NHANVIEN inner join PHANCONG on NHANVIEN.IDNV = PHANCONG.IDNVIEN\n"
                + "where PHANCONG.IDNVU = ?";
        return selectbySQL(sql, id);
    }
    public static void main(String[] args) {
        NhanvienDAO nvdao = new NhanvienDAO();
        List<NhanVien> lsnv = nvdao.selectbysomething(2);
        for (NhanVien nhanVien : lsnv) {
            System.out.println(nhanVien.toString());
            
        }
    }
}
