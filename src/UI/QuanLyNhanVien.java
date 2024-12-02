package UI;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLyNhanVien extends javax.swing.JFrame {

    /**
     * Creates new form NhanXeFrame2
     */
    DefaultTableModel tableModel;
    List<NhanVienDTO> dataList;
    private String ten;

    public QuanLyNhanVien(String tenQuanLy) {
        initComponents();
        this.ten = tenQuanLy;
        setLocationRelativeTo(null);
        chaomungTxt.setText(tenQuanLy + " !");

        tableModel = (DefaultTableModel) nhanVienTable.getModel();
        showData();
        nhanVienTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = nhanVienTable.getSelectedRow();
                NhanVienDTO nhanvien = dataList.get(index);
                cccdTxt.setText(nhanvien.getCccd());
                hoTenTxt.setText(nhanvien.getTenNhanVien());
                soDienThoaiTxt.setText(nhanvien.getSoDienThoai());
                taiKhoanTxt.setText(nhanvien.getTaiKhoan());
                matKhauTxt.setText(nhanvien.getMatKhau());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
    }

    private void showData() {
        dataList = NhanVienDAO.findAll();

        tableModel.setRowCount(0);

        for (NhanVienDTO nhanvien : dataList) {
            tableModel.addRow(new Object[]{
                nhanvien.getCccd(),
                nhanvien.getTenNhanVien(),
                nhanvien.getSoDienThoai(),
                nhanvien.getTaiKhoan(),
                nhanvien.getMatKhau()
            });
        }
    }

    private void updateTable(List<NhanVienDTO> results) {
        tableModel.setRowCount(0); 

        for (NhanVienDTO nhanvien : results) {
            tableModel.addRow(new Object[]{
                nhanvien.getCccd(),
                nhanvien.getTenNhanVien(),
                nhanvien.getSoDienThoai(),
                nhanvien.getTaiKhoan(),
                nhanvien.getMatKhau()
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

        jPanel1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jSeparator7 = new javax.swing.JSeparator();
        quanLyNhanVienBtn4 = new javax.swing.JButton();
        thongKeBtn4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        dangXuatBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        chaomungTxt = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        taiKhoanTxt = new javax.swing.JTextField();
        lammoiBtn = new javax.swing.JButton();
        cccdTxt = new javax.swing.JTextField();
        hoTenTxt = new javax.swing.JTextField();
        matKhauTxt = new javax.swing.JPasswordField();
        themBtn = new javax.swing.JButton();
        suaBtn = new javax.swing.JButton();
        xoaBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        nhanVienTable = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        soDienThoaiTxt = new javax.swing.JTextField();
        timkiemBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1686, 606));

        jPanel12.setBackground(new java.awt.Color(0, 153, 255));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        quanLyNhanVienBtn4.setBackground(new java.awt.Color(254, 183, 19));
        quanLyNhanVienBtn4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        quanLyNhanVienBtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_management_32px.png"))); // NOI18N
        quanLyNhanVienBtn4.setText("Quản Lý Nhân Viên");
        quanLyNhanVienBtn4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        quanLyNhanVienBtn4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        quanLyNhanVienBtn4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        quanLyNhanVienBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanLyNhanVienBtn4ActionPerformed(evt);
            }
        });

        thongKeBtn4.setBackground(new java.awt.Color(254, 183, 19));
        thongKeBtn4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        thongKeBtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_scorecard_32px.png"))); // NOI18N
        thongKeBtn4.setText("Thống Kê");
        thongKeBtn4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thongKeBtn4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        thongKeBtn4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        thongKeBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thongKeBtn4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(quanLyNhanVienBtn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thongKeBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(quanLyNhanVienBtn4)
                        .addGap(42, 42, 42)
                        .addComponent(thongKeBtn4)))
                .addGap(4, 6, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));

        dangXuatBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        dangXuatBtn.setText("Đăng Xuất");
        dangXuatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangXuatBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel2.setText("Chào mừng Quản Lý:");

        chaomungTxt.setBackground(new java.awt.Color(0, 153, 255));
        chaomungTxt.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        chaomungTxt.setBorder(null);
        chaomungTxt.setFocusable(false);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chaomungTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 335, Short.MAX_VALUE)
                .addComponent(dangXuatBtn)
                .addGap(27, 27, 27))
            .addComponent(jSeparator2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dangXuatBtn)
                    .addComponent(jLabel2)
                    .addComponent(chaomungTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Quản Lý Nhân Viên");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Họ và Tên :");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Số Điện Thoại :");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Tài Khoản :");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Mật Khẩu :");

        taiKhoanTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lammoiBtn.setBackground(new java.awt.Color(254, 183, 19));
        lammoiBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lammoiBtn.setText("Làm Mới");
        lammoiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lammoiBtnActionPerformed(evt);
            }
        });

        cccdTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        hoTenTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        matKhauTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        themBtn.setBackground(new java.awt.Color(254, 183, 19));
        themBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        themBtn.setText("Thêm");
        themBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themBtnActionPerformed(evt);
            }
        });

        suaBtn.setBackground(new java.awt.Color(254, 183, 19));
        suaBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        suaBtn.setText("Sửa");
        suaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaBtnActionPerformed(evt);
            }
        });

        xoaBtn.setBackground(new java.awt.Color(254, 183, 19));
        xoaBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        xoaBtn.setText("Xóa");
        xoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaBtnActionPerformed(evt);
            }
        });

        nhanVienTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nhanVienTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CCCD", "Họ Và Tên", "Số Điện Thoại", "Tài Khoản", "Mật Khẩu"
            }
        ));
        jScrollPane1.setViewportView(nhanVienTable);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("CCCD:");

        soDienThoaiTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        timkiemBtn.setBackground(new java.awt.Color(254, 183, 19));
        timkiemBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        timkiemBtn.setText("Tìm Kiếm");
        timkiemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timkiemBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jScrollPane1)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addComponent(jLabel1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel8)
                            .addComponent(themBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(suaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(xoaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hoTenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(soDienThoaiTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                        .addComponent(cccdTxt, javax.swing.GroupLayout.Alignment.TRAILING)))))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(taiKhoanTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(matKhauTxt)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(lammoiBtn)
                                .addGap(47, 47, 47)
                                .addComponent(timkiemBtn)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(taiKhoanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(cccdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(matKhauTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(hoTenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(soDienThoaiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lammoiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timkiemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lammoiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lammoiBtnActionPerformed
        showData();
        cccdTxt.setText("");
        hoTenTxt.setText("");
        soDienThoaiTxt.setText("");
        taiKhoanTxt.setText("");
        matKhauTxt.setText("");
    }//GEN-LAST:event_lammoiBtnActionPerformed

    private void themBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themBtnActionPerformed
        String canCuoc = cccdTxt.getText();
        String tenNhanVien = hoTenTxt.getText();
        String soDienThoai = soDienThoaiTxt.getText();
        String taiKhoan = taiKhoanTxt.getText();
        String matKhau = matKhauTxt.getText();

        NhanVienDTO nhanvien = new NhanVienDTO(canCuoc, tenNhanVien, soDienThoai, taiKhoan, matKhau);
        NhanVienDAO.insert(nhanvien);
        showData();
        lammoiBtnActionPerformed(evt);

    }//GEN-LAST:event_themBtnActionPerformed

    private void suaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaBtnActionPerformed
        String canCuoc = cccdTxt.getText();
        String tenNhanVien = hoTenTxt.getText();
        String soDienThoai = soDienThoaiTxt.getText();
        String taiKhoan = taiKhoanTxt.getText();
        String matKhau = matKhauTxt.getText();

        NhanVienDTO nhanvien = new NhanVienDTO(canCuoc, tenNhanVien, soDienThoai, taiKhoan, matKhau);
        NhanVienDAO.update(nhanvien);
        showData();
        lammoiBtnActionPerformed(evt);
    }//GEN-LAST:event_suaBtnActionPerformed

    private void xoaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaBtnActionPerformed
        int selectedIndex = nhanVienTable.getSelectedRow();
        if (selectedIndex >= 0) {
            NhanVienDTO nhanvien = dataList.get(selectedIndex);

            int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa?");

            if (option == 0) {
                NhanVienDAO.delete(nhanvien.getCccd());

                showData();
                lammoiBtnActionPerformed(evt);

            }
        }
    }//GEN-LAST:event_xoaBtnActionPerformed

    private void dangXuatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangXuatBtnActionPerformed
        new DangNhap().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dangXuatBtnActionPerformed

    private void timkiemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timkiemBtnActionPerformed
        String s = JOptionPane.showInputDialog("Nhập tên cần tìm kiếm");
        if (s.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        
        NhanVienDAO nhanvien = new NhanVienDAO();
        List<NhanVienDTO> results = new ArrayList<>();
        results = nhanvien.findByFullName(s);
        updateTable(results);

    }//GEN-LAST:event_timkiemBtnActionPerformed

    private void quanLyNhanVienBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanLyNhanVienBtn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quanLyNhanVienBtn4ActionPerformed

    private void thongKeBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thongKeBtn4ActionPerformed
        new ThongKe(ten).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_thongKeBtn4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cccdTxt;
    private javax.swing.JTextField chaomungTxt;
    private javax.swing.JButton dangXuatBtn;
    private javax.swing.JTextField hoTenTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JButton lammoiBtn;
    private javax.swing.JPasswordField matKhauTxt;
    private javax.swing.JTable nhanVienTable;
    private javax.swing.JButton quanLyNhanVienBtn4;
    private javax.swing.JTextField soDienThoaiTxt;
    private javax.swing.JButton suaBtn;
    private javax.swing.JTextField taiKhoanTxt;
    private javax.swing.JButton themBtn;
    private javax.swing.JButton thongKeBtn4;
    private javax.swing.JButton timkiemBtn;
    private javax.swing.JButton xoaBtn;
    // End of variables declaration//GEN-END:variables
}
