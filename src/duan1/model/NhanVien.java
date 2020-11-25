/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duan1.model;

/**
 *
 * @author nguye
 */
public class NhanVien {
    
    private String  matKhau, tenNV, Hinh, idBan, Email, sdt, cmnd;
   
    private int quyen, manv, idphong ;

    public NhanVien() {
    }

    public NhanVien(String matKhau, String tenNV, String Hinh, String idBan, String Email, String sdt, String cmnd, int quyen, int manv, int idphong) {
        this.matKhau = matKhau;
        this.tenNV = tenNV;
        this.Hinh = Hinh;
        this.idBan = idBan;
        this.Email = Email;
        this.sdt = sdt;
        this.cmnd = cmnd;
        this.quyen = quyen;
        this.manv = manv;
        this.idphong = idphong;
    }

    
    
    
 



    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public String getIdBan() {
        return idBan;
    }

    public void setIdBan(String idBan) {
        this.idBan = idBan;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public int getQuyen() {
        return quyen;
    }

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public int getIdphong() {
        return idphong;
    }

    public void setIdphong(int idphong) {
        this.idphong = idphong;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "matKhau=" + matKhau + ", tenNV=" + tenNV + ", Hinh=" + Hinh + ", idBan=" + idBan + ", Email=" + Email + ", sdt=" + sdt + ", cmnd=" + cmnd + ", quyen=" + quyen + ", manv=" + manv + ", idphong=" + idphong + '}';
    }

    

    

    
      
}
