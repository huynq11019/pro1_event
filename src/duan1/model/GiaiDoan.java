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
public class GiaiDoan {
    private int idGiaiDoan, idSK;
    private String tenGD, mota  ;
    private String ngayBD,DeadLine ;

    public GiaiDoan() {
    }

    public GiaiDoan(int idGiaiDoan, int idSK, String tenGD, String mota, String ngayBD, String DeadLine) {
        this.idGiaiDoan = idGiaiDoan;
        this.idSK = idSK;
        this.tenGD = tenGD;
        this.mota = mota;
        this.ngayBD = ngayBD;
        this.DeadLine = DeadLine;
    }

    public int getIdGiaiDoan() {
        return idGiaiDoan;
    }

    public void setIdGiaiDoan(int idGiaiDoan) {
        this.idGiaiDoan = idGiaiDoan;
    }

    public int getIdSK() {
        return idSK;
    }

    public void setIdSK(int idSK) {
        this.idSK = idSK;
    }

    public String getTenGD() {
        return tenGD;
    }

    public void setTenGD(String tenGD) {
        this.tenGD = tenGD;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public String getDeadLine() {
        return DeadLine;
    }

    public void setDeadLine(String DeadLine) {
        this.DeadLine = DeadLine;
    }

    @Override
    public String toString() {
        return "GiaiDoan{" + "idGiaiDoan=" + idGiaiDoan + ", idSK=" + idSK + ", tenGD=" + tenGD + ", mota=" + mota + ", ngayBD=" + ngayBD + ", DeadLine=" + DeadLine + '}';
    }
    
   
    
}
