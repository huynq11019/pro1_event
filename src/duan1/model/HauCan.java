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
public class HauCan {
    private int IDHauCan;
    private String TenBP,TenNguoiLH,email,dienThoai;

    public HauCan() {
    }

    public HauCan(int IDHauCan, String TenBP, String TenNguoiLH, String email, String dienThoai) {
        this.IDHauCan = IDHauCan;
        this.TenBP = TenBP;
        this.TenNguoiLH = TenNguoiLH;
        this.email = email;
        this.dienThoai = dienThoai;
    }

    public int getIDHauCan() {
        return IDHauCan;
    }

    public void setIDHauCan(int IDHauCan) {
        this.IDHauCan = IDHauCan;
    }

    public String getTenBP() {
        return TenBP;
    }

    public void setTenBP(String TenBP) {
        this.TenBP = TenBP;
    }

    public String getTenNguoiLH() {
        return TenNguoiLH;
    }

    public void setTenNguoiLH(String TenNguoiLH) {
        this.TenNguoiLH = TenNguoiLH;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    @Override
    public String toString() {
        return "HauCan{" + "IDHauCan=" + IDHauCan + ", TenBP=" + TenBP + ", TenNguoiLH=" + TenNguoiLH + ", email=" + email + ", dienThoai=" + dienThoai + '}';
    }

   
    
}
