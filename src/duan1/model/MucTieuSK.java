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
public class MucTieuSK {
    private int idMucTieu, idSK;
    private String mucTieu;
    private boolean TrangThai = false;

    @Override
    public String toString() {
        return this.mucTieu;
    }

    public int getIdMucTieu() {
        return idMucTieu;
    }

    public void setIdMucTieu(int idMucTieu) {
        this.idMucTieu = idMucTieu;
    }

    public int getIdSK() {
        return idSK;
    }

    public void setIdSK(int idSK) {
        this.idSK = idSK;
    }

    public String getMucTieu() {
        return mucTieu;
    }

    public void setMucTieu(String mucTieu) {
        this.mucTieu = mucTieu;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
