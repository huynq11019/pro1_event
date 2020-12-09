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
public class Chitieu {
    private int idChiTieu, idNvu;
    private Float soTien;
    private String mota, ngayCT,Tennv ,tennvu;
    private int idNvien;

    public Chitieu() {
    }

    public Chitieu(int idChiTieu, int idNvu, Float soTien, String mota, String ngayCT, int idNvien) {
        this.idChiTieu = idChiTieu;
        this.idNvu = idNvu;
        this.soTien = soTien;
        this.mota = mota;
        this.ngayCT = ngayCT;
        this.idNvien = idNvien;
    }

    public int getIdChiTieu() {
        return idChiTieu;
    }

    public void setIdChiTieu(int idChiTieu) {
        this.idChiTieu = idChiTieu;
    }

    public int getIdNvu() {
        return idNvu;
    }

    public void setIdNvu(int idNvu) {
        this.idNvu = idNvu;
    }

    public Float getSoTien() {
        return soTien;
    }

    public void setSoTien(Float soTien) {
        this.soTien = soTien;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNgayCT() {
        return ngayCT;
    }

    public void setNgayCT(String ngayCT) {
        this.ngayCT = ngayCT;
    }

    public int getIdNvien() {
        return idNvien;
    }

    public void setIdNvien(int idNvien) {
        this.idNvien = idNvien;
    }

    public String getTennv() {
        return Tennv;
    }

    public void setTennv(String Tennv) {
        this.Tennv = Tennv;
    }

    public String getTennvu() {
        return tennvu;
    }

    public void setTennvu(String tennvu) {
        this.tennvu = tennvu;
    }

    @Override
    public String toString() {
        return "Chitieu{" + "idChiTieu=" + idChiTieu + ", idNvu=" + idNvu + ", soTien=" + soTien + ", mota=" + mota + ", ngayCT=" + ngayCT + ", Tennv=" + Tennv + ", tennvu=" + tennvu + ", idNvien=" + idNvien + '}';
    }

  
    
}
