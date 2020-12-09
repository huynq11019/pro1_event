/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pro1e.UI;

import com.pro1e.DAO.ChechListDAO;
import com.pro1e.DAO.ComMentDAO;
import com.pro1e.DAO.NhanvienDAO;
import com.pro1e.DAO.nhiemvuDAO;
import com.pro1e.UI.chill.PNlisstfile;
import com.pro1e.UI.chill.tagcomment;
import com.pro1e.helper.DATEhelper;
import com.pro1e.helper.FunctionHelper;
import com.pro1e.utils.Xdate;
import com.pro1e.utils.auth;
import com.pro1e.utils.magbox;
import duan1.model.CheckListNV;
import duan1.model.Comment;
import duan1.model.GiaiDoan;
import duan1.model.NhiemVu;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 */
public class TAOnhiemvu extends javax.swing.JDialog {

    /**
     * Creates new form TaoNhiemvu
     */
//    private GiaiDoan curgiaidoan;
    protected NhiemVu curNhiemVu;
    private String files;
    boolean state; // true = tạo false là view
    private final nhiemvuDAO nvuDAO = new nhiemvuDAO();
    private Pngiaidoan pa;
    //////////////lít nhiem vu
    private Pnnhiemvu pnNhiemvu;
    private ChechListDAO clDAO = new ChechListDAO();
    private List<CheckListNV> listnv; // list những công việc của nhiệm vụ
    DefaultTableModel modelnv;
///////////comment

    ComMentDAO cmDAO = new ComMentDAO();
    List<Comment> lscoment;

    public TAOnhiemvu(Pngiaidoan pa, Pnnhiemvu pnNvu, boolean state) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.state = state;
        setEnoF();
        if (state) {
            this.setTitle("TẠO NHIỆM VỤ");
        } else {
            this.setTitle("nhiệm vụ"); // xem nhiệm vụ
            curNhiemVu = pnNvu.nvu;
            this.pnNhiemvu = pnNvu;
            btntao.setText("cập nhật");
            fillForm();
            loadchecklist(); // load checklist  
            loadcmt();

        }
        this.pa = pa;
        FunctionHelper.setColumnWidths(tbnhiemvu, 100, 450);
    }

    void fillForm() {
        txtennv.setEnabled(false);
        txtmota.setEnabled(false);
        if (curNhiemVu != null) {
            txtennv.setText(curNhiemVu.getTenNVu());
            txtmota.setText(curNhiemVu.getMoTa());
            if (curNhiemVu.getNgatBD() != null) {
                jdbatdau.setDate(Xdate.todate(curNhiemVu.getNgatBD(), "yyyy-MM-dd"));
            }
            if (curNhiemVu.getDeaLine() != null) {
                jdketthuc.setDate(Xdate.todate(curNhiemVu.getDeaLine(), "yyyy-MM-dd"));

            }
        }
    }

    void setEnoF() {
        btnsuaten.setVisible(!state);
        btnmota.setVisible(!state);
        pnbinhluan.setVisible(!state);
        if (state) {
            pnlistnv.setVisible(!state);
            pnbinhluan.setVisible(!state);
            pnparent.setSize(590, 320);
            this.setSize(590, 320);
        }
    }

    NhiemVu getNhiemvu() {

        NhiemVu nv = new NhiemVu();
        nv.setTenNVu(txtennv.getText());
        nv.setMoTa(txtmota.getText());
        if (jdbatdau.getDate() != null) {
            nv.setNgatBD(Xdate.toString(jdbatdau.getDate(), "yyyy-MM-dd"));
        } else {
            nv.setNgatBD(Xdate.toString(DATEhelper.nowDate(), "yyyy-MM-dd"));
        }
        if (jdketthuc.getDate() != null) {
            nv.setDeaLine(Xdate.toString(jdketthuc.getDate(), "yyyy-MM-dd"));
        }
        if (state) {
            nv.setTrangThai(false);
        } else {
            nv.setTrangThai(curNhiemVu.isTrangThai());
        }
        // nv.setTGHT(null);
        nv.setTGHT(0);
        if (!state) {
            nv.setiDNVu(curNhiemVu.getiDNVu());
            nv.setTGHT(curNhiemVu.getTGHT());
        }
        nv.setFileIn(files);
        nv.setIdGiaiDoan(pa.gds.getIdGiaiDoan());

        return nv;

    }

    boolean checkEmty() {
        if (txtennv.getText().equals("")) {
            return false;
        }
        return true;
    }
    int clDone;

    public void loadTiendo() {
        int tongnv = listnv.size();
        if (tongnv > 0) {
            int tienDo = (clDone * 100) / tongnv;
            // System.out.println(tongnv + "nvht " + nvHT + "tiến độ: " + tienDo);
            pnNhiemvu.prsNhiemvu.setValue(tienDo);
            NhiemVu updateValue = curNhiemVu;
            updateValue.setTGHT(tienDo);
            System.out.println("ghi tiến độ :" + nvuDAO.update(updateValue));
        }
    }

    void loadchecklist() {
        clDone = 0;
        modelnv = (DefaultTableModel) tbnhiemvu.getModel();
        modelnv.setRowCount(0);
        listnv = clDAO.selectbysomething(curNhiemVu.getiDNVu()); //select theo id nhiệm vụ
        for (CheckListNV checkListNV : listnv) {
            modelnv.addRow(new Object[]{
                checkListNV.isTrangThai(), checkListNV.getNoiDungCList()
            });
            if (checkListNV.isTrangThai()) {
                clDone++;
            }

        }
        loadTiendo();
    }

    void loadcmt() {
        lscoment = cmDAO.selectbysomething(curNhiemVu.getiDNVu());////////////////////////////\
        pnbinhluan.removeAll();
        pnbinhluan.add(pnwrite);
        int kichthuoc = 100, kichthuoccha = 700;//pnparent.getHeight();pnbinhluan.getHeight()
        for (Comment cmt : lscoment) {
//            System.out.println(cmt.toString());
            pnbinhluan.add(new tagcomment(cmt));
            pnbinhluan.setPreferredSize(new Dimension(560, kichthuoc += 63));
//            System.out.println("kích thước của pn bình luận " + kichthuoc);
            pnparent.setPreferredSize(new Dimension(560, kichthuoccha += 63));
            pnparent.setSize(new Dimension(560, kichthuoccha += 1));

        }

    }

    Comment getCMT() {
        Comment cmt = new Comment();
        cmt.setIdCMT(WIDTH);
        cmt.setIdNVu(curNhiemVu.getiDNVu());
        cmt.setThoigian(Xdate.toString(DATEhelper.nowDate(), "yyyy-MM-dd"));
        cmt.setNoiDung(txtbinhluan.getText());
        cmt.setTenNV(auth.curentNVien.getTenNV() + "-" + auth.curentNVien.getIdBan());
        return cmt;
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
        pnparent = new javax.swing.JPanel();
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
        btntao = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnlistnv = new javax.swing.JPanel();
        txtnhiemvu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbnhiemvu = new javax.swing.JTable();
        pnbinhluan = new javax.swing.JPanel();
        pnwrite = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtbinhluan = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nhiệm vụ");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(610, 630));

        jScrollPane5.setAutoscrolls(true);
        jScrollPane5.setPreferredSize(new java.awt.Dimension(600, 630));

        pnparent.setOpaque(false);
        pnparent.setPreferredSize(new java.awt.Dimension(560, 700));

        jPanel1.setPreferredSize(new java.awt.Dimension(658, 294));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtennv.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtennv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtennvActionPerformed(evt);
            }
        });
        jPanel1.add(txtennv, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 35, 260, 32));

        jLabel1.setText("Tên nhiệm vụ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 4, 150, 25));

        jLabel2.setText("Mô tả");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 43, 20));

        txtmota.setColumns(20);
        txtmota.setRows(5);
        jScrollPane1.setViewportView(txtmota);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 556, 105));

        jLabel3.setText("Ngày bắt đầu :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 73, 110, -1));

        jLabel4.setText("Ngày kết thúc:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 106, 110, -1));
        jPanel1.add(jdbatdau, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 150, -1));
        jPanel1.add(jdketthuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 150, -1));

        btnmota.setText("Chỉnh sửa");
        btnmota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmotaActionPerformed(evt);
            }
        });
        jPanel1.add(btnmota, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 94, -1));

        btnsuaten.setText("Chỉnh sửa");
        btnsuaten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuatenActionPerformed(evt);
            }
        });
        jPanel1.add(btnsuaten, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 94, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pro1e/icon/icons8_link_24px.png"))); // NOI18N
        jButton3.setText("FILE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 10, 107, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pro1e/icon/icons8_user_24px.png"))); // NOI18N
        jButton4.setText("GIAO CHO");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 53, -1, 34));

        btntao.setText("TẠO");
        btntao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntaoActionPerformed(evt);
            }
        });
        jPanel1.add(btntao, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 10, 90, 77));

        jButton2.setText("CHI TIÊU");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 90, 200, 40));

        pnparent.add(jPanel1);

        pnlistnv.setBackground(new java.awt.Color(255, 255, 255));
        pnlistnv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlistnv.setPreferredSize(new java.awt.Dimension(556, 205));

        txtnhiemvu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnhiemvuKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("danh sách công việc");

        tbnhiemvu.setModel(new javax.swing.table.DefaultTableModel(
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
        tbnhiemvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnhiemvuMouseClicked(evt);
            }
        });
        tbnhiemvu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbnhiemvuKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbnhiemvu);
        if (tbnhiemvu.getColumnModel().getColumnCount() > 0) {
            tbnhiemvu.getColumnModel().getColumn(0).setResizable(false);
            tbnhiemvu.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout pnlistnvLayout = new javax.swing.GroupLayout(pnlistnv);
        pnlistnv.setLayout(pnlistnvLayout);
        pnlistnvLayout.setHorizontalGroup(
            pnlistnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlistnvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlistnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlistnvLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnhiemvu, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlistnvLayout.setVerticalGroup(
            pnlistnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlistnvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlistnvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnhiemvu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnparent.add(pnlistnv);

        pnbinhluan.setBackground(new java.awt.Color(255, 0, 102));
        pnbinhluan.setFocusTraversalPolicyProvider(true);
        pnbinhluan.setPreferredSize(new java.awt.Dimension(560, 100));
        pnbinhluan.setRequestFocusEnabled(false);
        pnbinhluan.setVerifyInputWhenFocusTarget(false);
        pnbinhluan.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 3));

        pnwrite.setPreferredSize(new java.awt.Dimension(560, 100));

        jLabel6.setText("viết bình luận");

        txtbinhluan.setColumns(20);
        txtbinhluan.setRows(5);
        txtbinhluan.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtbinhluan);

        jButton1.setText("ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnwriteLayout = new javax.swing.GroupLayout(pnwrite);
        pnwrite.setLayout(pnwriteLayout);
        pnwriteLayout.setHorizontalGroup(
            pnwriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnwriteLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnwriteLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnwriteLayout.setVerticalGroup(
            pnwriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnwriteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnwriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnbinhluan.add(pnwrite);

        pnparent.add(pnbinhluan);

        jScrollPane5.setViewportView(pnparent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtennvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtennvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtennvActionPerformed

    private void btntaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntaoActionPerformed
        if (checkEmty()) {
            if (state) {
                System.out.println(getNhiemvu().toString());
                if (nvuDAO.insert(getNhiemvu()) > 0) {
                    this.dispose();
                    auth.curqlnhiemvu.loadGD();
                } else {
                    magbox.mgbox(this, "chưa nhập đủ thông tin");
                }
            } else {
                System.out.println(getNhiemvu().toString());
                if (nvuDAO.update(getNhiemvu()) > 0) {
                    magbox.mgbox(this, "đã sửa");
                    this.dispose();
                    auth.curqlnhiemvu.loadGD();

                } else {
                    magbox.mgbox(this, "chưa nhập đủ thông tin");
                }
            }
    }//GEN-LAST:event_btntaoActionPerformed
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//            files =     magbox.prompt(this, "nhập File");
        new PNlisstfile(curNhiemVu).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtnhiemvuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnhiemvuKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !txtnhiemvu.getText().equals("")) {
            if (clDAO.insert(getCongviec()) > 0) {
                txtnhiemvu.setText("");
                loadchecklist();
            }
        }
    }//GEN-LAST:event_txtnhiemvuKeyPressed

    private void tbnhiemvuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbnhiemvuKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            int index = tbnhiemvu.getSelectedRow();
            if (clDAO.delete(listnv.get(index).getIdCList()) > 0) {
                loadchecklist();
            } else {
                magbox.mgbox(this, "không thể xóa");
            }
        }
    }//GEN-LAST:event_tbnhiemvuKeyPressed

    private void tbnhiemvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnhiemvuMouseClicked
        int index = tbnhiemvu.getSelectedRow();
        CheckListNV congviec = listnv.get(index);
        congviec.setTrangThai((boolean) tbnhiemvu.getValueAt(index, 0));
        if (clDAO.update(congviec) <= 0) {
            magbox.mgbox(this, "lỗi check ");
        }
        if (congviec.isTrangThai()) {
            clDone++;
        } else {
            clDone--;
        }
        loadTiendo();
    }//GEN-LAST:event_tbnhiemvuMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new TAOphancong(curNhiemVu.getiDNVu()).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println(getCMT().toString());
        if (cmDAO.insert(getCMT()) > 0 && !txtbinhluan.getText().equals("")) {
            loadcmt();
        } else {
            System.err.println("lỗi viết cmt");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new TAOchitieu(this).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnsuatenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuatenActionPerformed
        txtennv.setEnabled(true);
        txtennv.requestFocus();
    }//GEN-LAST:event_btnsuatenActionPerformed

    private void btnmotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmotaActionPerformed
        txtmota.setEnabled(true);
        txtmota.requestFocus();
    }//GEN-LAST:event_btnmotaActionPerformed
    CheckListNV getCongviec() {
        CheckListNV clist = new CheckListNV();
        clist.setNoiDungCList(txtnhiemvu.getText());
        clist.setIdNVu(curNhiemVu.getiDNVu());
        clist.setTrangThai(false);
        return clist;
    }
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
    private javax.swing.JButton btntao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private com.toedter.calendar.JDateChooser jdbatdau;
    private com.toedter.calendar.JDateChooser jdketthuc;
    private javax.swing.JPanel pnbinhluan;
    private javax.swing.JPanel pnlistnv;
    private javax.swing.JPanel pnparent;
    private javax.swing.JPanel pnwrite;
    private javax.swing.JTable tbnhiemvu;
    private javax.swing.JTextArea txtbinhluan;
    private javax.swing.JTextField txtennv;
    private javax.swing.JTextArea txtmota;
    private javax.swing.JTextField txtnhiemvu;
    // End of variables declaration//GEN-END:variables
}
