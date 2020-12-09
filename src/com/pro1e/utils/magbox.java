/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.utils;

import com.pro1e.UI.pnKhachmoi;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author huyNQph11019
 */
public class magbox {
    static String noty = "phần mềm quản lý sự kiện";
    static public void mgbox(Component parent,String mesage){
        JOptionPane.showMessageDialog(parent, mesage, noty, JOptionPane.INFORMATION_MESSAGE);
    }
    static public boolean confirm (Component parent, String mesage){
        int result = JOptionPane.showConfirmDialog(parent, mesage, noty, JOptionPane.YES_NO_OPTION);
        return result == JOptionPane.YES_OPTION; 
    }
    public static String prompt(Component parent, String mesage)
    {
        return JOptionPane.showInputDialog(parent, mesage, noty, JOptionPane.INFORMATION_MESSAGE);
    }
  
}
