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
public class NhiemVu {
    private int iDNVu, idGiaiDoan, TGHT;
    private String tenNVu,moTa,fileIn;
    private boolean trangThai ;
    private String ngatBD, DeaLine; // ngày bắt đầu, ngày kết thúc, ngày hoàn thành

    public NhiemVu() {
    }

    public NhiemVu(int iDNVu, int idGiaiDoan, int TGHT, String tenNVu, String moTa, String fileIn, boolean trangThai, String ngatBD, String DeaLine) {
        this.iDNVu = iDNVu;
        this.idGiaiDoan = idGiaiDoan;
        this.TGHT = TGHT;
        this.tenNVu = tenNVu;
        this.moTa = moTa;
        this.fileIn = fileIn;
        this.trangThai = trangThai;
        this.ngatBD = ngatBD;
        this.DeaLine = DeaLine;
    }

 

    public int getiDNVu() {
        return iDNVu;
    }

    public void setiDNVu(int iDNVu) {
        this.iDNVu = iDNVu;
    }

    public int getIdGiaiDoan() {
        return idGiaiDoan;
    }

    public void setIdGiaiDoan(int idGiaiDoan) {
        this.idGiaiDoan = idGiaiDoan;
    }

    public String getTenNVu() {
        return tenNVu;
    }

    public void setTenNVu(String tenNVu) {
        this.tenNVu = tenNVu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getFileIn() {
        return fileIn;
    }

    public void setFileIn(String fileIn) {
        this.fileIn = fileIn;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgatBD() {
        return ngatBD;
    }

    public void setNgatBD(String ngatBD) {
        this.ngatBD = ngatBD;
    }

    public String getDeaLine() {
        return DeaLine;
    }

    public void setDeaLine(String DeaLine) {
        this.DeaLine = DeaLine;
    }

    public int getTGHT() {
        return TGHT;
    }

    public void setTGHT(int TGHT) {
        this.TGHT = TGHT;
    }

  

    @Override
    public String toString() {
        return "NhiemVu{" + "iDNVu=" + iDNVu + ", idGiaiDoan=" + idGiaiDoan + ", tenNVu=" + tenNVu + ", moTa=" + moTa + ", fileIn=" + fileIn + ", trangThai=" + trangThai + ", ngatBD=" + ngatBD + ", DeaLine=" + DeaLine + ", TGHT=" + TGHT + '}';
    }
    
    
  
}
