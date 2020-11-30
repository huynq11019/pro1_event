/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.UI;

import com.pro1e.DAO.nhiemvuDAO;
import com.pro1e.utils.Xdate;
import com.pro1e.utils.magbox;
import duan1.model.GiaiDoan;
import duan1.model.NhiemVu;

/**
 *
 * 
 */
public class TAOnhiemvu extends javax.swing.JDialog {

    /**
     * Creates new form TaoNhiemvu
     */
//    private GiaiDoan curgiaidoan;
    private NhiemVu curNhiemVu;
    private String files;
    boolean state; // true = tạo false là view
    private nhiemvuDAO nvuDAO = new nhiemvuDAO();
    private Pngiaidoan pa;

    public TAOnhiemvu(Pngiaidoan pa, NhiemVu nvu, boolean state) { 
        initComponents();
        this.setLocationRelativeTo(null);
        this.state = state;
        setEnoF();
        if (state) {
            this.setTitle("TẠO NHIỆM VỤ");
        } else {
            this.setTitle("nhiệm vụ"); // xem nhiệm vụ
            curNhiemVu = nvu;
            fillForm();
        }
        this.pa = pa;
//        curgiaidoan = gd;
//        System.out.println("giai đoạn hiện tại" + curgiaidoan.getIdGiaiDoan());
    }
    void fillForm(){
        if (curNhiemVu != null) {
            txtennv.setText(curNhiemVu.getTenNVu());
            txtmota.setText(curNhiemVu.getMoTa());
            if (curNhiemVu.getNgatBD()!= null) {
                 jdbatdau.setDate(Xdate.todate(curNhiemVu.getNgatBD(), "yyyy-MM-dd")); 
            }if (curNhiemVu.getDeaLine()!=null) {
                jdketthuc.setDate(Xdate.todate(curNhiemVu.getDeaLine(), "yyyy-MM-dd"));
                
            }
        }
    }
    void setEnoF(){
        btnsuaten.setVisible(!state);
        btnmota.setVisible(!state);
        pnbinhluan.setVisible(!state);
        if (state) {
            
        }
    }
    NhiemVu getNhiemvu() {

        NhiemVu nv = new NhiemVu();
        nv.setTenNVu(txtennv.getText());
        nv.setMoTa(txtmota.getText());
        if (jdbatdau.getDate() != null) {
            nv.setNgatBD(Xdate.toString(jdbatdau.getDate(), "yyyy-MM-dd"));
        }
        if (jdketthuc.getDate() != null) {
            nv.setDeaLine(Xdate.toString(jdketthuc.getDate(), "yyyy-MM-dd"));
        }
        nv.setTrangThai(true);
        // nv.setTGHT(null);
        if (!state) {
            nv.setiDNVu(curNhiemVu.getiDNVu());
        }
        nv.setFileIn(files);
        nv.setIdGiaiDoan(pa.gds.getIdGiaiDoan() );
        return nv;

    }

    boolean checkEmty() {
        if (txtennv.getText().equals("")) {
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtennv = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtmota = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jdbatdau = new com.toedter.calendar.JDateChooser();
        jdketthuc = new com.toedter.calendar.JDateChooser();
        btnmota = new javax.swing.JButton();
        btnsuaten = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cbthanhvien = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        pnlistnv = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnbinhluan = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nhiệm vụ");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(590, 630));

        jPanel3.setPreferredSize(new java.awt.Dimension(260, 560));

        jPanel1.setPreferredSize(new java.awt.Dimension(658, 294));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtennv.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtennv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtennvActionPerformed(evt);
            }
        });
        jPanel1.add(txtennv, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 35, 245, 32));

        jLabel1.setText("Tên nhiệm vụ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 4, 150, 25));

        jLabel2.setText("Mô tả");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 43, 20));

        txtmota.setColumns(20);
        txtmota.setRows(5);
        jScrollPane1.setViewportView(txtmota);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 556, 105));

        jLabel3.setText("Ngày bắt đầu :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 73, 68, -1));

        jLabel4.setText("Ngày kết thúc:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 106, 68, -1));
        jPanel1.add(jdbatdau, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 79, 143, -1));
        jPanel1.add(jdketthuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 106, 146, -1));

        btnmota.setText("Chỉnh sửa");
        jPanel1.add(btnmota, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 94, -1));

        btnsuaten.setText("Chỉnh sửa");
        jPanel1.add(btnsuaten, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 94, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pro1e/icon/icons8_link_24px.png"))); // NOI18N
        jButton3.setText("Ghim file");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 10, 107, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pro1e/icon/icons8_user_24px.png"))); // NOI18N
        jButton4.setText("GIAO CHO");
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 53, -1, 34));

        cbthanhvien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbthanhvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 93, 202, 43));

        jButton5.setText("TẠO");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 10, 77, 77));

        jPanel3.add(jPanel1);

        pnlistnv.setBackground(new java.awt.Color(255, 255, 255));
        pnlistnv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlistnv.setPreferredSize(new java.awt.Dimension(556, 205));

        jLabel5.setText("thêm nhiệm vụ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Trạng thái", "nhiệm vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout pnlistnvLayout = new javax.swing.GroupLayout(pnlistnv);
        pnlistnv.setLayout(pnlistnvLayout);
        pnlistnvLayout.setHorizontalGroup(
            pnlistnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlistnvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlistnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlistnvLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlistnvLayout.setVerticalGroup(
            pnlistnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlistnvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlistnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(pnlistnv);

        jLabel6.setText("viết bình luận");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        javax.swing.GroupLayout pnbinhluanLayout = new javax.swing.GroupLayout(pnbinhluan);
        pnbinhluan.setLayout(pnbinhluanLayout);
        pnbinhluanLayout.setHorizontalGroup(
            pnbinhluanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbinhluanLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel6)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnbinhluanLayout.setVerticalGroup(
            pnbinhluanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbinhluanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnbinhluanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        jPanel3.add(pnbinhluan);

        jScrollPane5.setViewportView(jPanel3);

        getContentPane().add(jScrollPane5, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtennvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtennvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtennvActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (checkEmty()) {
            System.out.println(getNhiemvu().toString());

        } else {
            magbox.mgbox(this, "chưa nhập đủ thông tin");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TAOnhiemvu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TAOnhiemvu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TAOnhiemvu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TAOnhiemvu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                TAOnhiemvu dialog = new TAOnhiemvu(new GiaiDoan(), null, true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmota;
    private javax.swing.JButton btnsuaten;
    private javax.swing.JComboBox<String> cbthanhvien;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JDateChooser jdbatdau;
    private com.toedter.calendar.JDateChooser jdketthuc;
    private javax.swing.JPanel pnbinhluan;
    private javax.swing.JPanel pnlistnv;
    private javax.swing.JTextField txtennv;
    private javax.swing.JTextArea txtmota;
    // End of variables declaration//GEN-END:variables
}
