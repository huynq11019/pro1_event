    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duan1.model;


import java.util.Date;

/**
 *
 * @author nguye
 */
public class Comment {
    private int idCMT, idNVu; //id comment
    private String tenNV,noiDung;
    private String thoigian; 

    public Comment() {
    }

    public Comment(int idCMT, int idNVu, String tenNV, String noiDung, String thoigian) {
        this.idCMT = idCMT;
        this.idNVu = idNVu;
        this.tenNV = tenNV;
        this.noiDung = noiDung;
        this.thoigian = thoigian;
    }

    public int getIdCMT() {
        return idCMT;
    }

    public void setIdCMT(int idCMT) {
        this.idCMT = idCMT;
    }

    public int getIdNVu() {
        return idNVu;
    }

    public void setIdNVu(int idNVu) {
        this.idNVu = idNVu;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }
    

    
    
}
