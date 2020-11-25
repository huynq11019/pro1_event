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

public class SuKien {
    private int IDSK, idPhong;
    private String tenSK,moTa;
    private String ngayTao;
    private String ngayKetThuc ;

    public SuKien() {
    }

    public SuKien(int IDSK, int idPhong, String tenSK, String moTa, String ngayTao, String ngayKetThuc) {
        this.IDSK = IDSK;
        this.idPhong = idPhong;
        this.tenSK = tenSK;
        this.moTa = moTa;
        this.ngayTao = ngayTao;
        this.ngayKetThuc = ngayKetThuc;
    }

        
    public int getIDSK() {
        return IDSK;
    }

    public void setIDSK(int IDSK) {
        this.IDSK = IDSK;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public String getTenSK() {
        return tenSK;
    }

    public void setTenSK(String tenSK) {
        this.tenSK = tenSK;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Override
    public String toString() {
        return "SuKien{" + "IDSK=" + IDSK + ", idPhong=" + idPhong + ", tenSK=" + tenSK + ", moTa=" + moTa + ", ngayTao=" + ngayTao + ", ngayKetThuc=" + ngayKetThuc + '}';
    }

    
    
}
