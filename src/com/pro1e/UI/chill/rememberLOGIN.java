/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.UI.chill;

import java.io.Serializable;

/**
 *
 * @author huyNQph11019
 */
public class rememberLOGIN implements Serializable{
    private String user, pass;
    private boolean radio;

    public rememberLOGIN() {
    }

    public rememberLOGIN(String user, String pass, boolean radio) {
        this.user = user;
        this.pass = pass;
        this.radio = radio;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isRadio() {
        return radio;
    }

    public void setRadio(boolean radio) {
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "rememberLOGIN{" + "user=" + user + ", pass=" + pass + ", radio=" + radio + '}';
    }
    
}
