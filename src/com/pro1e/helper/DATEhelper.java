/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author huyNQph11019
 */
public class DATEhelper {

    static final SimpleDateFormat date_formater = new SimpleDateFormat("MM/dd/yyyy");

    /**
     * Chuyển đổi String sang Date
     *
     * @param date là String cần chuyển
     * @param pattern là định dạng thời gian
     * @return Date kết quả
 *
     */
    public static Date toDate(String date, String... pattern) {
        try {
            if (pattern.length > 0) {
                date_formater.applyPattern(pattern[0]);
            }
            if (date == null) {
                // trả vè ngày giờ hiện tại
                return DATEhelper.nowDate();
            }
            // format String to Date
            return date_formater.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Chuyển đổi từ Date sang String
     *
     * @param date là Date cần chuyển đổi
     * @param pattern là định dạng thời gian
     * @return String kết quả
     */
    public static String toString(Date date, String... pattern) {
        try {
            if (pattern.length > 0) {
                date_formater.applyPattern(pattern[0]);

            }
            if (date == null) {
                return date_formater.format(nowDate());
            }
            return date_formater.format(date);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Lấy thời gian hiện tại
     *
     * @return Date kết quả
     */
    public static Date nowDate() {
        return new Date();
    }
     /**
 * Bổ sung số ngày vào thời gian
 * @param date thời gian hiện có
 * @param days số ngày cần bổ sung váo date
     * @return date đã + số ngày
 * */
    public static Date addDay (Date date,int day){
        date.setTime(date.getTime()+day*24*60*60*1000);
        return date;
    }
     
 /**
 * Bổ sung số ngày vào thời gian hiện hành
     * @param day
 * @param days số ngày cần bổ sung vào thời gian hiện tại
 * @return Date kết quả
 */
    public static Date add(int day){
        Date now = DATEhelper.nowDate();
        now.setTime(now.getTime()+day*2*60*60*1000);
        return now;
    }
 
}
