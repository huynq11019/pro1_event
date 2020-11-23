/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author huyNQph11019
 */
public class Xfile {

    public static Image getAppicon() {
        URL url = Xfile.class.getResource("com/fileUP");
        return new ImageIcon(url).getImage();
    }

    public static void save(File scr) {
        File dst = new File("iconF", scr.getName());// tạo thư mục 
        if (!dst.getParentFile().exists()) { // kiểm tra thư mực đẫ tồn tại hay chưa
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(scr.getAbsolutePath()); // dẫn đến file muốn coppy
            Path to = Paths.get(dst.getAbsolutePath());// chỗ coppy tới
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static ImageIcon read(String fileName) {
        File path = new File("iconF", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}
