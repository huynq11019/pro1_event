/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.UI;

import com.pro1e.helper.FunctionHelper;
import duan1.model.MucTieuSK;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import com.pro1e.DAO.MuctieuskDAO;
import com.pro1e.DAO.SukienDAO;
import com.pro1e.helper.JDBChelper;
import com.pro1e.utils.Xdate;
import com.pro1e.utils.auth;
import duan1.model.SuKien;
import java.util.List;

/**
 *
 * @author huyNQph11019
 */
public class QLnhiemvu extends javax.swing.JPanel {

    DefaultTableModel model;
    MuctieuskDAO mtDAO = new MuctieuskDAO();
    SukienDAO skDAO = new SukienDAO();
    List<MucTieuSK> listMT;
    SuKien ev; // sự kiện hiện tại

    /**
     * Creates new form QLnhiemvu
     */
    public QLnhiemvu() { // tham số truyển vào là 1 sự kiện
        initComponents();
        innitSUkien(auth.curSUKIEN);
        
        System.out.println(auth.curSUKIEN);
        FunctionHelper.setColumnWidths(tbmcutieu, 100, 190);
        model = (DefaultTableModel) tbmcutieu.getModel();
        listMT = mtDAO.selectall();
        loadMt();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbtensk = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtmota = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        datebd = new com.toedter.calendar.JDateChooser();
        datekt = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        txtmcutieu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbmcutieu = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1110, 640));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pro1e/icon/icons8_add_new_50px_1.png"))); // NOI18N
        jButton1.setText("Tạo giai đoạn");

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("XÓA SỰ KIỆN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(38, 38, 38)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(514, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbtensk.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbtensk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pro1e/icon/icons8_connection_status_on_32px.png"))); // NOI18N
        lbtensk.setText("TÊN SỰ KIỆN");

        jLabel2.setText("MÔ TẢ");

        txtmota.setColumns(20);
        txtmota.setRows(5);
        txtmota.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtmota);

        jLabel3.setText("NGÀY BẮT ĐẦU:");

        jLabel4.setText("NGÀY KẾT THÚC:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lbtensk)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(22, 22, 22)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datebd, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(datekt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbtensk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(datebd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(datekt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtmcutieu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtmcutieu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MUC TIÊU SỰ KIỆN ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        txtmcutieu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmcutieuKeyPressed(evt);
            }
        });

        tbmcutieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "TRẠNG THÁI", "MUC TIEU"
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
        jScrollPane1.setViewportView(tbmcutieu);
        if (tbmcutieu.getColumnModel().getColumnCount() > 0) {
            tbmcutieu.getColumnModel().getColumn(0).setResizable(false);
            tbmcutieu.getColumnModel().getColumn(0).setHeaderValue("TRẠNG THÁI");
            tbmcutieu.getColumnModel().getColumn(1).setResizable(false);
            tbmcutieu.getColumnModel().getColumn(1).setHeaderValue("MUC TIEU");
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(txtmcutieu))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtmcutieu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 310, 640));
    }// </editor-fold>//GEN-END:initComponents
void innitSUkien(SuKien OBJsukien) {
        lbtensk.setText(OBJsukien.getTenSK());
        txtmota.setText(OBJsukien.getMoTa());
        datebd.setDate(Xdate.todate(OBJsukien.getNgayTao(), "yyyy-MM-dd"));
        datekt.setDate(Xdate.todate(OBJsukien.getNgayKetThuc(), "yyyy-MM-dd"));
    }
    private void txtmcutieuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmcutieuKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (mtDAO.insert(getMT()) > 0) {
                model.addRow(new Object[]{
                    getMT().isTrangThai(), getMT().getMucTieu()
                });
            }

        }
    }//GEN-LAST:event_txtmcutieuKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    void xoaSk(){
        skDAO.delete(WIDTH);
    }
    MucTieuSK getMT() {
        if (!txtmcutieu.getText().equals("")) {
            MucTieuSK mt = new MucTieuSK();
            mt.setIdSK(auth.curSUKIEN.getIDSK());
            mt.setMucTieu(txtmcutieu.getText());
            mt.setTrangThai(false);
            return mt;
        } else {
            return null;
        }
    }

    void loadMt() {
        model.setRowCount(0);
        listMT.forEach(mt -> {
            model.addRow(new Object[]{
                mt.isTrangThai(), mt.getIdMucTieu()
            });
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser datebd;
    private com.toedter.calendar.JDateChooser datekt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbtensk;
    private javax.swing.JTable tbmcutieu;
    private javax.swing.JTextField txtmcutieu;
    private javax.swing.JTextArea txtmota;
    // End of variables declaration//GEN-END:variables
}
