/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.utils;

import duan1.model.NhanVien;
import duan1.model.Phong;
import duan1.model.SuKien;

/**
 *
 * @author huyNQph11019
 */
public class auth {

    //phòng ban hiện tại
    public static Phong curentPhong;
    public static NhanVien curentNVien;

    public static boolean islogin() {
        return auth.curentNVien!= null;
    }

    public static void clear() {
        auth.curentNVien= null;
    }

    public static int IDPHONGnv() {
        return auth.curentNVien.getIdphong();
    }
    public static SuKien curSUKIEN;
}
