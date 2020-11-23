/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author huyNQph11019
 * @param xdate phương thức dùng để convverse ngày tháng 
 */
public class Xdate {
    static SimpleDateFormat smd  = new SimpleDateFormat();
    public static Date todate(String date, String panttern){
        try {
            smd.applyPattern(panttern);
            return smd.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException();
        }
    }
    public static String toString (Date date, String panttern){
        smd.applyPattern(panttern);
        return smd.format(date);
        
    }
    public static Date addDay(Date date , long day){
        date.setTime(date.getTime()+day*24*60*60*1000);
        return date;
    }
}
