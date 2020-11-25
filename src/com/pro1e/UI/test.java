/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.UI;

import com.pro1e.DAO.MuctieuskDAO;
import com.pro1e.DAO.NhanvienDAO;
import java.util.List;
import duan1.model.*;

/**
 *
 * @author huyNQph11019
 */
public class test {

    public static void main(String[] args) {
        MuctieuskDAO mtdao = new MuctieuskDAO();
        //   System.out.println(nvdao.selectByeDT("0925573154"));
        List<MucTieuSK> lst = mtdao.selectall();
        for (MucTieuSK mucTieuSK : lst) {
            System.out.println(mucTieuSK.toString());
        }
    }
}
