/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.DAO;

import com.pro1e.helper.JDBChelper;
import duan1.model.KhachMoi;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class KhachMoiDAO implements DAOhelper<KhachMoi, Integer>{
     private final String insert_sql = "insert into KHACMOI(TENKM,EMAIL,SDT,GHICHU) values(?,?,?,?)";
    private final String update_sql = "UPDATE KHACMOI SET  TENKM=?, EMAIL=?, SDT=?, GHICHU=? WHERE IDKM=?";
    private final String delete_sql ="delete from KHACMOI where IDKM=?";
    private final String select_all = "select * from KHACMOI";
    private final String select_byid = "select * from KHACMOI where IDKM=?";

    @Override
    public int insert(KhachMoi e) {
    return JDBChelper.update(insert_sql, e.getTenKM(),
            e.getEmail(), e.getSdt(), e.getGhiChu());
    }

    @Override
    public int update(KhachMoi e) {
    return JDBChelper.update(update_sql,   e.getTenKM(),e.getEmail(),e.getSdt(),e.getGhiChu(),e.getIdKhachMoi());
    }

    @Override
    public int delete(Integer id) {
    return JDBChelper.update(delete_sql, id);
    }

    @Override
    public List<KhachMoi> selectall() {
    return selectbySQL(select_all);
    }
  
    @Override
    public KhachMoi selectbyID(Integer id) {
    List<KhachMoi> KM= selectbySQL(select_byid, id);
    return KM.get(0);
    }


    @Override
    public List<KhachMoi> selectbySQL(String sql, Object... args) {
        List<KhachMoi> listKM= new ArrayList<>();
        try {
            ResultSet rs= JDBChelper.query(sql, args);
            while(rs.next()){
                KhachMoi km= new KhachMoi();
                km.setIdKhachMoi(rs.getInt("IDKM"));
                km.setTenKM(rs.getString("TENKM"));
                km.setEmail(rs.getString("EMAIL"));
                km.setSdt(rs.getString("SDT"));
                km.setGhiChu(rs.getString("GHICHU"));
                listKM.add(km);
            }
            rs.getStatement().getConnection().close();
            return listKM;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<KhachMoi> selectbysomething(Integer id) {
        String sql = "select * from KHACMOI inner join KHACMOITD on KHACMOI.IDKM = KHACMOITD.IDKM where IDSK = ?";
        return selectbySQL(sql,id);
    }
public List<KhachMoi> timKiemKM (String keyW){
    String sql = "select * from KHACMOI where TENKM like N'%"+keyW+"%' or SDT like '%"+keyW+"%' or EMAIL like '%"+keyW+"%'";
    return selectbySQL(sql);
}
    public static void main(String[] args) {
        KhachMoiDAO kmdao = new KhachMoiDAO();
        for (KhachMoi khachMoi : kmdao.selectall()) {
            System.out.println(khachMoi.toString());    
        }
    }
    
}
