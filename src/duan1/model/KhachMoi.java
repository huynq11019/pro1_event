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
public class KhachMoi {
    private int idKhachMoi, idphong;
    private String tenKM,email,sdt,ghiChu;

    public KhachMoi() {
    }

    public KhachMoi(int idKhachMoi, int idphong, String tenKM, String email, String sdt, String ghiChu) {
        this.idKhachMoi = idKhachMoi;
        this.idphong = idphong;
        this.tenKM = tenKM;
        this.email = email;
        this.sdt = sdt;
        this.ghiChu = ghiChu;
    }

    public int getIdKhachMoi() {
        return idKhachMoi;
    }

    public void setIdKhachMoi(int idKhachMoi) {
        this.idKhachMoi = idKhachMoi;
    }

    public int getIdphong() {
        return idphong;
    }

    public void setIdphong(int idphong) {
        this.idphong = idphong;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

     
    
}
