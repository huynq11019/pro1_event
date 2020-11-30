/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.utils;

import com.pro1e.UI.MainF;
import com.pro1e.UI.QLnhiemvuPN;
import com.pro1e.UI.QLsukienPN;
import duan1.model.GiaiDoan;
import duan1.model.NhanVien;
import duan1.model.Phong;
import duan1.model.SuKien;

/**
 *
 * @author huyNQph11019
 */
public class auth {

    //phòng ban hiện tại
    public static Phong curentPhong = new Phong(1, 1, "PHòng QHDH", 0);
    
    public static NhanVien curentNVien = new NhanVien("123", "huy   ", "5", "TC", "2", "1", "1", 0, 0, 1);
    public static SuKien curSUKIEN;
    public static GiaiDoan curGiaiDoan;
    
    public static QLsukienPN curQLsukien;
    public static MainF curmain;
    public static QLnhiemvuPN curqlnhiemvu;

    public static boolean islogin() {
        return auth.curentNVien != null;
    }

    public static void clear() {
        auth.curentNVien = null;
    }

    public static int IDPHONGnv() {
        return auth.curentNVien.getIdphong();
    }

}
