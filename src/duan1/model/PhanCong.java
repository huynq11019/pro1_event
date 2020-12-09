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
public class PhanCong {

    private int idNVien, idNVu;
   private String tenNV;

    public PhanCong() {
    }

    public PhanCong(int idNVien, int idNVu, String tenNV) {
        this.idNVien = idNVien;
        this.idNVu = idNVu;
        this.tenNV = tenNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    @Override
    public String toString() {
        return "PhanCong{" + "idNVien=" + idNVien + ", idNVu=" + idNVu + ", tenNV=" + tenNV + '}';
    }

 

    public int getIdNVien() {
        return idNVien;
    }

    public void setIdNVien(int idNVien) {
        this.idNVien = idNVien;
    }

    public int getIdNVu() {
        return idNVu;
    }

    public void setIdNVu(int idNVu) {
        this.idNVu = idNVu;
    }

}
