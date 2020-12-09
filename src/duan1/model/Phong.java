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
public class Phong {
    private int IDPhong, idTrP;
    private String tenPhong ;
    private float ngansach ;

    public Phong() {
    }

    public Phong(int IDPhong, int idTrP, String tenPhong, float ngansach) {
        this.IDPhong = IDPhong;
        this.idTrP = idTrP;
        this.tenPhong = tenPhong;
        this.ngansach = ngansach;
    }

    public int getIDPhong() {
        return IDPhong;
    }

    public void setIDPhong(int IDPhong) {
        this.IDPhong = IDPhong;
    }

    public int getIdTrP() {
        return idTrP;
    }

    public void setIdTrP(int idTrP) {
        this.idTrP = idTrP;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public float getNgansach() {
        return ngansach;
    }

    public void setNgansach(float ngansach) {
        this.ngansach = ngansach;
    }

    @Override
    public String toString() {
        return "Phong{" + "IDPhong=" + IDPhong + ", idTrP=" + idTrP + ", tenPhong=" + tenPhong + ", ngansach=" + ngansach + '}';
    }

    
            
    
}
