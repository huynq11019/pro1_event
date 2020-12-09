/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.UI;

import com.pro1e.DAO.BanDAO;
import com.pro1e.DAO.PhongDAO;
import com.pro1e.utils.auth;
import duan1.model.Ban;
import duan1.model.Phong;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author huyNQph11019
 */
public class pnPHONG extends javax.swing.JPanel {

    /**
     * Creates new form pnPHONG
     */
    PhongDAO phongDAO = new PhongDAO();
    BanDAO banDAO = new BanDAO();
    DefaultTableModel dfphong;
    DefaultTableModel dfban;
    List<Phong> lsPhoNG;
    List<Ban> lsBan;

    public pnPHONG() {
        initComponents();
        loadBan();

    }

//    void loadPhong() {
//        lsPhoNG = phongDAO.selectall();
//        dfphong = (DefaultTableModel) tbphong.getModel();
//        dfphong.setRowCount(0);
//        for (Phong phong : lsPhoNG) {
//            dfphong.addRow(new Object[]{
//                phong.getIDPhong(), phong.getTenPhong(), phong.getIDPhong()
//            });
//        }
//        auth.curentPhong = lsPhoNG.get(0);
//        tbphong.setRowSelectionInterval(0, 0);
//        loadBan();
//    }
    void loadBan() {
        lsBan = banDAO.selectbyPhong(auth.curentPhong.getIDPhong());
        dfban = (DefaultTableModel) tbban.getModel();
        dfban.setRowCount(0);
        for (Ban ban : lsBan) {
            dfban.addRow(new Object[]{
                ban.getIdban(), ban.getTenBan()
            });

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbban = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1110, 640));

        tbban.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "mã BAN", "Trưởng ban"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbban.setRowHeight(30);
        tbban.setSelectionBackground(new java.awt.Color(51, 153, 255));
        tbban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbban);
        if (tbban.getColumnModel().getColumnCount() > 0) {
            tbban.getColumnModel().getColumn(0).setResizable(false);
            tbban.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton2.setBackground(new java.awt.Color(0, 153, 204));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pro1e/icon/icons8_add_new_50px.png"))); // NOI18N
        jButton2.setText("TẠO BAN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      // tạo pan
      new pntaoban(this, null).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbbanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbanMouseClicked
        int index=0;
        if (evt.getClickCount() == 2 ) {
            index = tbban.getSelectedRow();
            new pntaoban(this, lsBan.get(index)).setVisible(true);
        }
    }//GEN-LAST:event_tbbanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbban;
    // End of variables declaration//GEN-END:variables
}