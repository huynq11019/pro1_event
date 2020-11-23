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
public class CheckListNV {
    private int idCList,  idNVu;
    private String noiDungCList;
    private boolean trangThai = false;

    public CheckListNV() {
    }

    public CheckListNV(int idCList, int idNVu, String noiDungCList) {
        this.idCList = idCList;
        this.idNVu = idNVu;
        this.noiDungCList = noiDungCList;
    }

    @Override
    public String toString() {
        return "CheckList{" + "idCList=" + idCList + ", idNVu=" + idNVu + ", noiDungCList=" + noiDungCList + ", trangThai=" + trangThai + '}';
    }

    public int getIdCList() {
        return idCList;
    }

    public void setIdCList(int idCList) {
        this.idCList = idCList;
    }

    public int getIdNVu() {
        return idNVu;
    }

    public void setIdNVu(int idNVu) {
        this.idNVu = idNVu;
    }

    public String getNoiDungCList() {
        return noiDungCList;
    }

    public void setNoiDungCList(String noiDungCList) {
        this.noiDungCList = noiDungCList;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
