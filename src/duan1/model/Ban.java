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
public class Ban {
    private int  idPhong;
    private String tenBan, idban;

    public Ban(int idPhong, String tenBan, String idban) {
        this.idPhong = idPhong;
        this.tenBan = tenBan;
        this.idban = idban;
    }

    public Ban() {
    }


    public String toString1() {
        return "Ban{" + "idPhong=" + idPhong + ", tenBan=" + tenBan + ", idban=" + idban + '}';
    }

    @Override
    public String toString() {
        return this.tenBan; 
    }
   
     
    public String getIdban() {
        return idban;
    }

    public void setIdban(String idban) {
        this.idban = idban;
    }

  

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }
    
}
