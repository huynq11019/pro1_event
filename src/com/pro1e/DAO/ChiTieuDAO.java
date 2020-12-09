/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.DAO;
import com.pro1e.helper.JDBChelper;
import duan1.model.Chitieu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author nguye
 */
public class ChiTieuDAO implements DAOhelper<Chitieu, Integer>{
    private final String insert_sql = "INSERT INTO CHITIEU VALUES(?,?,?,?,?)";
    private final String update_sql = "UPDATE CHITIEU SET IDNVU=?, SOTIEN=?, MOTA=?, IDNVIEN=?, NGAYCT=? where IDCTIEU=?";
    private final String delete_sql ="delete from CHITIEU where IDCTIEU=?";
    private final String select_all = "select * from CHITIEU";
    private final String select_byid = "select * from CHITIEU where IDCTIEU=?";
    private final String select_nv ="select IDCTIEU,NHIEMVU.IDNVU,NHIEMVU.TENNVU,CHITIEU.IDNVIEN, NHANVIEN.TENNV,CHITIEU.MOTA,CHITIEU.NGAYCT,CHITIEU.SOTIEN from CHITIEU inner join NHIEMVU on CHITIEU.IDNVU = NHIEMVU.IDNVU inner join NHANVIEN on CHITIEU.IDNVIEN = NHANVIEN.IDNV\n" +
"order by IDCTIEU desc" ;
    @Override
    public int insert(Chitieu e) {
        return JDBChelper.update(insert_sql, e.getIdNvu(),e.getSoTien(),e.getMota(),e.getIdNvien(),e.getNgayCT());
    }

    @Override
    public int update(Chitieu e) {
    return JDBChelper.update(update_sql,e.getIdNvu(),e.getSoTien(),e.getMota(),e.getIdNvien(),e.getNgayCT(), e.getIdChiTieu());
   }

    @Override
    public int delete(Integer id) {
    return JDBChelper.update(delete_sql, id);
    }

    @Override
    public List<Chitieu> selectall() {
    return selectbySQL(select_nv);
    }

    @Override
    public Chitieu selectbyID(Integer id) {
    List<Chitieu> KM= selectbySQL(select_byid, id);
    return KM.get(0);
    }

    @Override
    public List<Chitieu> selectbySQL(String sql, Object... args) {
     List<Chitieu> listCT= new ArrayList<>();
        try {
            ResultSet rs= JDBChelper.query(sql, args);
            while(rs.next()){
                Chitieu CT= new Chitieu();
                CT.setIdChiTieu(rs.getInt("IDCTIEU"));
                CT.setIdNvu(rs.getInt("IDNVU"));
                CT.setSoTien(rs.getFloat("SOTIEN"));
                CT.setMota(rs.getString("MOTA"));
                CT.setIdNvien(rs.getInt("IDNVIEN"));
                CT.setNgayCT(rs.getString("NGAYCT"));
                
                CT.setTennv(rs.getString("TENNV"));
                CT.setTennvu(rs.getString("TENNVU"));
                listCT.add(CT);
            }
            rs.getStatement().getConnection().close();
            return listCT;
        } catch (Exception e) {
            throw new RuntimeException();
        } 
    }

    @Override
    public List<Chitieu> selectbysomething(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        ChiTieuDAO ctdao = new ChiTieuDAO();
        for (Chitieu chitieu : ctdao.selectall()) {
            System.out.println(chitieu.toString());
        }
    }
}
