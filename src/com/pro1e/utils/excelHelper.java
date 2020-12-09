/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.utils;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author huyNQph11019
 */
public class excelHelper {

    public static void wireE() {
        try {
            File f = new File("ex.xlsx");
            FileOutputStream file = new FileOutputStream(f);
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet wsheet = wb.createSheet("name");
            
        } catch (Exception e) {
        }

    }
}
