package UI;

import DAO.BaiXeDAO;
import DAO.TongXeDAO;
import DTO.BaiXeDTO;
import DTO.TongXeDTO;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ThongKeLuotGuiXe extends javax.swing.JFrame {

    private String ten;

    public ThongKeLuotGuiXe(String tenQuanLy) {
        this.ten = tenQuanLy;
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        loadCountAll();
        loadAll();
        loadMoneyAll();

    }

    private void loadCountTimeAll() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String TuNgay = sdf.format(tuNgay.getDate());
        String DenNgay = sdf.format(denNgay.getDate());
        TongXeDAO tk = new TongXeDAO();
        lbCount.setText(tk.loadCountTimeAll(TuNgay, DenNgay));
    }

    private void loadCountTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String TuNgay = sdf.format(tuNgay.getDate());
        String DenNgay = sdf.format(denNgay.getDate());
        TongXeDAO tk = new TongXeDAO();
        lbCount.setText(tk.loadCountTime(loaiXeBox.getSelectedItem().toString(), TuNgay, DenNgay));
    }

    private void loadCountAll() {
        TongXeDAO tk = new TongXeDAO();
        lbCount.setText(tk.loadCountAll());
    }

    private void loadMoneyAll() {
        TongXeDAO tk = new TongXeDAO();
        tongTienTxt.setText(Integer.toString(tk.loadMoneyAll()));
    }

    private void loadMoneyTimeAll() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String TuNgay = sdf.format(tuNgay.getDate());
        String DenNgay = sdf.format(denNgay.getDate());
        TongXeDAO tk = new TongXeDAO();
        tongTienTxt.setText(Integer.toString(tk.loadMoneyTimeAll(TuNgay, DenNgay)));
    }

    private void loadMoneyTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String TuNgay = sdf.format(tuNgay.getDate());
        String DenNgay = sdf.format(denNgay.getDate());
        TongXeDAO tk = new TongXeDAO();
        tongTienTxt.setText(Integer.toString(tk.loadMoneyTime(loaiXeBox.getSelectedItem().toString(), TuNgay, DenNgay)));
    }

    private void find(String Loaixe, String TuNgay, String DenNgay) {
        ArrayList<TongXeDTO> list = TongXeDAO.findCar(Loaixe, TuNgay, DenNgay);
        DefaultTableModel tblModel = (DefaultTableModel) thongkeTable.getModel();
        Object[] row = new Object[9];
        for (int i = tblModel.getRowCount() - 1; i >= 0; i--) {
            tblModel.removeRow(i);
        }
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaVe();
            row[1] = list.get(i).getBienSo();
            row[2] = list.get(i).getLoaiXe();
            row[3] = list.get(i).getViTri();
            row[4] = list.get(i).getNgayGui();
            row[5] = list.get(i).getGioGui();
            row[6] = list.get(i).getNgayTra();
            row[7] = list.get(i).getGioTra();
            row[8] = list.get(i).getTongTien();
            tblModel.addRow(row);
        }
    }

    private void findAll(String TuNgay, String DenNgay) {
        ArrayList<TongXeDTO> list = TongXeDAO.findCarAll(TuNgay, DenNgay);
        DefaultTableModel tblModel = (DefaultTableModel) thongkeTable.getModel();
        Object[] row = new Object[9];
        for (int i = tblModel.getRowCount() - 1; i >= 0; i--) {
            tblModel.removeRow(i);
        }
        for (int i = 0; i < list.size(); i++) {
           row[0] = list.get(i).getMaVe();
            row[1] = list.get(i).getBienSo();
            row[2] = list.get(i).getLoaiXe();
            row[3] = list.get(i).getViTri();
            row[4] = list.get(i).getNgayGui();
            row[5] = list.get(i).getGioGui();
            row[6] = list.get(i).getNgayTra();
            row[7] = list.get(i).getGioTra();
            row[8] = list.get(i).getTongTien();
            tblModel.addRow(row);
        }
    }

    private void loadAll() {
        ArrayList<TongXeDTO> list = TongXeDAO.loadTableAll();
        DefaultTableModel tblModel = (DefaultTableModel) thongkeTable.getModel();
        Object[] row = new Object[9];
        for (int i = tblModel.getRowCount() - 1; i >= 0; i--) {
            tblModel.removeRow(i);
        }
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaVe();
            row[1] = list.get(i).getBienSo();
            row[2] = list.get(i).getLoaiXe();
            row[3] = list.get(i).getViTri();
            row[4] = list.get(i).getNgayGui();
            row[5] = list.get(i).getGioGui();
            row[6] = list.get(i).getNgayTra();
            row[7] = list.get(i).getGioTra();
            row[8] = list.get(i).getTongTien();
            tblModel.addRow(row);
        }
    }

    // Trong ThongKeLuotGuiXe JFrame
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        thongkeTable = new javax.swing.JTable();
        quayLaiBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        loaiXeBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tracuuBtn = new javax.swing.JButton();
        tuNgay = new com.toedter.calendar.JDateChooser();
        denNgay = new com.toedter.calendar.JDateChooser();
        lammoiBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbCount = new javax.swing.JTextField();
        tongTienTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1686, 606));

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        thongkeTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        thongkeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Biển Số Xe", "Loại Xe", "Mã Vé", "Vị Trí", "Ngày Gửi", "Giờ Gửi", "Ngày Trả", "Giờ Trả", "Tổng Tiền"
            }
        ));
        jScrollPane1.setViewportView(thongkeTable);

        quayLaiBtn.setBackground(new java.awt.Color(51, 204, 255));
        quayLaiBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        quayLaiBtn.setText("Quay Lại");
        quayLaiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quayLaiBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Thống Kê Lượt Gửi Xe");

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        loaiXeBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        loaiXeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tổng Xe", "Xe Máy", "Ô Tô" }));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Từ Ngày :");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Đến Ngày :");

        tracuuBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tracuuBtn.setText("Tra Cứu");
        tracuuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tracuuBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(loaiXeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(denNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tracuuBtn)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loaiXeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tuNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(denNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(tracuuBtn))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        lammoiBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lammoiBtn.setText("Làm Mới");
        lammoiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lammoiBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Tổng Tiền :");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Tổng Số Lượt :");

        lbCount.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tongTienTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("VND");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Lượt");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbCount, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(tongTienTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lammoiBtn)))
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(444, 444, 444)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quayLaiBtn))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1))
                    .addComponent(quayLaiBtn))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tongTienTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lammoiBtn)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void quayLaiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quayLaiBtnActionPerformed
        new ThongKe(ten).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_quayLaiBtnActionPerformed

    private void tracuuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tracuuBtnActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (tuNgay.getDate() == null && denNgay.getDate() == null) {

            JOptionPane.showMessageDialog(this, "Chưa nhập thời gian");
        } else if (tuNgay.getDate() == null && denNgay.getDate() != null) {

            JOptionPane.showMessageDialog(this, "Chưa nhập ngày bắt đầu");
        } else if (tuNgay.getDate() != null && denNgay.getDate() == null) {

            JOptionPane.showMessageDialog(this, "Chưa nhập ngày kết thúc");
        } else {
            String TuNgay = sdf.format(tuNgay.getDate());
            String DenNgay = sdf.format(denNgay.getDate());
            if (loaiXeBox.getSelectedItem().toString().equals("Tổng xe")) {
                findAll(TuNgay, DenNgay);
                loadCountTimeAll();
                loadMoneyTimeAll();
            } else {
                find(loaiXeBox.getSelectedItem().toString(), TuNgay, DenNgay);
                loadCountTime();
                loadMoneyTime();
            }

        }
    }//GEN-LAST:event_tracuuBtnActionPerformed

    private void lammoiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lammoiBtnActionPerformed
        tuNgay.setDate(null);
        denNgay.setDate(null);
        loadMoneyAll();
        loadCountAll();
        loadAll();
    }//GEN-LAST:event_lammoiBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser denNgay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lammoiBtn;
    private javax.swing.JTextField lbCount;
    private javax.swing.JComboBox<String> loaiXeBox;
    private javax.swing.JButton quayLaiBtn;
    private javax.swing.JTable thongkeTable;
    private javax.swing.JTextField tongTienTxt;
    private javax.swing.JButton tracuuBtn;
    private com.toedter.calendar.JDateChooser tuNgay;
    // End of variables declaration//GEN-END:variables
}
