/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duan1.model;

/**
 *
 * @author huyNQph11019
 */
public class KhachmoiTD {
    private  int idSK, idKM;

    public KhachmoiTD() {
    }

    public KhachmoiTD(int idSK, int idKM) {
        this.idSK = idSK;
        this.idKM = idKM;
    }

    public int getIdSK() {
        return idSK;
    }

    public void setIdSK(int idSK) {
        this.idSK = idSK;
    }

    public int getIdKM() {
        return idKM;
    }

    public void setIdKM(int idKM) {
        this.idKM = idKM;
    }
    
}
