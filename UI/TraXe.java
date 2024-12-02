package UI;

import DAO.BaiXeDAO;
import DAO.TongXeDAO;
import DTO.BaiXeDTO;
import DTO.TongXeDTO;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author quang
 */
public class TraXe extends javax.swing.JFrame {

    private String ten;
    DefaultTableModel tableModel;
    List<BaiXeDTO> dataList = new ArrayList<>();

    public TraXe(String tenNhanVien) {
        initComponents();
        this.ten = tenNhanVien;
        tableModel = (DefaultTableModel) baiXeTable.getModel();
        chaoMungTxt.setText(tenNhanVien + " !");
        showData();
        baiXeTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = baiXeTable.getSelectedRow();
                BaiXeDTO bx = dataList.get(index);
                maVeTxt.setText(bx.getMaVe());
                loaiXeTxt.setText(bx.getLoaiXe());
                bienSoXeTxt.setText(bx.getBienSo());
                viTriTxt.setText(bx.getViTri());
                // Chuyển đổi ngày (Date) thành String với định dạng "dd/MM/yyyy"
                if (bx.getNgayGui() != null) {
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    ngayNhanTxt.setText(dateFormatter.format(bx.getNgayGui()));
                }
                gioNhanTxt.setText(bx.getGioGui());
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
        dataList = BaiXeDAO.findAll();

        tableModel.setRowCount(0);

        for (BaiXeDTO x : dataList) {
            tableModel.addRow(new Object[]{
                x.getMaVe(),
                x.getBienSo(),
                x.getLoaiXe(),
                x.getViTri(),
                x.getNgayGui(),
                x.getGioGui()
            });
        }
    }

    private void updateTable(List<BaiXeDTO> results) {
        tableModel.setRowCount(0); // Xóa toàn bộ dữ liệu trong bảng

        for (BaiXeDTO x : results) {
            tableModel.addRow(new Object[]{
                x.getMaVe(),
                x.getBienSo(),
                x.getLoaiXe(),
                x.getViTri(),
                x.getNgayGui(),
                x.getGioGui()
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
        jPanel2 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        nhanXeBtn = new javax.swing.JButton();
        traxeBtn = new javax.swing.JButton();
        dangkyVTBtn = new javax.swing.JButton();
        taiKhoanBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        dangXuatBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        chaoMungTxt = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        baiXeTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        maVeTxt = new javax.swing.JTextField();
        viTriTxt = new javax.swing.JTextField();
        gioNhanTxt = new javax.swing.JTextField();
        traXeBtn = new javax.swing.JButton();
        lamMoiBtn = new javax.swing.JButton();
        bienSoXeTxt = new javax.swing.JTextField();
        loaiXeTxt = new javax.swing.JTextField();
        ngayNhanTxt = new javax.swing.JTextField();
        timkiemBtn = new javax.swing.JButton();
        timKiemBox = new javax.swing.JComboBox<>();
        timKiemTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1686, 606));

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        nhanXeBtn.setBackground(new java.awt.Color(254, 183, 19));
        nhanXeBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nhanXeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_sedan_32px.png"))); // NOI18N
        nhanXeBtn.setText("Nhận Xe");
        nhanXeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nhanXeBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nhanXeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhanXeBtnActionPerformed(evt);
            }
        });

        traxeBtn.setBackground(new java.awt.Color(254, 183, 19));
        traxeBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        traxeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_car_theft_32px.png"))); // NOI18N
        traxeBtn.setText("Trả Xe");
        traxeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        traxeBtn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        traxeBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        traxeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traxeBtnActionPerformed(evt);
            }
        });

        dangkyVTBtn.setBackground(new java.awt.Color(254, 183, 19));
        dangkyVTBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        dangkyVTBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_membership_card_32px_1.png"))); // NOI18N
        dangkyVTBtn.setText("Đăng Kí Vé Tháng");
        dangkyVTBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dangkyVTBtn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        dangkyVTBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        dangkyVTBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangkyVTBtnActionPerformed(evt);
            }
        });

        taiKhoanBtn.setBackground(new java.awt.Color(254, 183, 19));
        taiKhoanBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        taiKhoanBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_user_32px_1.png"))); // NOI18N
        taiKhoanBtn.setText("Tài Khoản");
        taiKhoanBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        taiKhoanBtn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        taiKhoanBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        taiKhoanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taiKhoanBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dangkyVTBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(traxeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nhanXeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(taiKhoanBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(19, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(177, 177, 177)
                    .addComponent(nhanXeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(traxeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(dangkyVTBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(taiKhoanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(178, Short.MAX_VALUE)))
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
        jLabel2.setText("Chào mừng Nhân Viên:");

        chaoMungTxt.setBackground(new java.awt.Color(0, 153, 255));
        chaoMungTxt.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        chaoMungTxt.setBorder(null);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chaoMungTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(chaoMungTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 255));

        baiXeTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        baiXeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Vé", "Biển Số Xe", "Loại Xe", "Vị Trí", "Ngày Nhận", "Giờ Nhận"
            }
        ));
        jScrollPane1.setViewportView(baiXeTable);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Trả Xe");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Mã Vé :");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Biển Số Xe :");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Loại Xe :");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Vị Trí :");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Ngày Nhận :");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Giờ Nhận :");

        maVeTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        viTriTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        gioNhanTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        traXeBtn.setBackground(new java.awt.Color(254, 183, 19));
        traXeBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        traXeBtn.setText("Trả Xe");
        traXeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traXeBtnActionPerformed(evt);
            }
        });

        lamMoiBtn.setBackground(new java.awt.Color(254, 183, 19));
        lamMoiBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lamMoiBtn.setText("Làm Mới");
        lamMoiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamMoiBtnActionPerformed(evt);
            }
        });

        bienSoXeTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        loaiXeTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ngayNhanTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        timkiemBtn.setBackground(new java.awt.Color(254, 183, 19));
        timkiemBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        timkiemBtn.setText("Tìm Kiếm");
        timkiemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timkiemBtnActionPerformed(evt);
            }
        });

        timKiemBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        timKiemBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo Biển Số", "Theo Mã vé" }));

        timKiemTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addComponent(jLabel1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(lamMoiBtn)
                        .addGap(67, 67, 67)
                        .addComponent(timkiemBtn)
                        .addGap(18, 18, 18)
                        .addComponent(timKiemBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timKiemTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(196, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(traXeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGap(69, 69, 69)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maVeTxt)
                    .addComponent(bienSoXeTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(loaiXeTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ngayNhanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(viTriTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gioNhanTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(173, 173, 173))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(maVeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(viTriTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(bienSoXeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(ngayNhanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(loaiXeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(gioNhanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timkiemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lamMoiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timKiemBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timKiemTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(traXeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lamMoiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lamMoiBtnActionPerformed
        timKiemTxt.setText(""); // Xóa nội dung ô tìm kiếm
        timKiemBox.setSelectedIndex(0); // Đặt ComboBox về trạng thái mặc định
        showData(); // Hiển thị lại to
        maVeTxt.setText("");
        loaiXeTxt.setText("");
        bienSoXeTxt.setText("");
        viTriTxt.setText("");
        ngayNhanTxt.setText("");
        gioNhanTxt.setText("");
    }//GEN-LAST:event_lamMoiBtnActionPerformed

    private void traXeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traXeBtnActionPerformed
        int selectedIndex = baiXeTable.getSelectedRow();
        if (selectedIndex >= 0) {
            BaiXeDTO bx = dataList.get(selectedIndex);
            BaiXeDAO.traXe(bx.getMaVe());
            showData();
            lamMoiBtnActionPerformed(evt);
            boolean check = false;
            if (bx.getMaVe().substring(0, 2).equals("VN")) {
                check = true;
            }

            // Tạo thông tin cho frame hóa đơn
            String gioVao = bx.getGioGui();
            String pos = bx.getViTri();
            String ticketId = bx.getMaVe();
            String licensePlate = bx.getBienSo();
            String vehicleType = bx.getLoaiXe();
            LocalDate date = bx.getNgayGui(); // Lấy ngày hiện tại
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Định dạng ngày theo "yyyy-MM-dd"
            String enterDate = date.format(formatter); // Định dạng LocalDate thành chuỗi
            LocalDate edate = LocalDate.now(); // Lấy ngày hiện tại
            String exitDate = edate.format(formatter); // Định dạng LocalDate thành chuỗi
            LocalDateTime now = LocalDateTime.now();

            // Định dạng giờ thành chuỗi
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
            String timeString = now.format(formatter2);
            // Tính tổng tiền
            int totalAmount = 0;
            if (check) {
                totalAmount = vehicleType.equals("Xe Máy") ? 10000 : 100000;
            }
            TongXeDTO tx = new TongXeDTO(licensePlate, vehicleType, ticketId, pos, date, gioVao, edate, timeString, totalAmount);
            TongXeDAO.insert(tx);
            new HoaDonVN(ticketId, licensePlate, vehicleType, enterDate, exitDate, totalAmount).setVisible(true);
        }

    }//GEN-LAST:event_traXeBtnActionPerformed

    private void timkiemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timkiemBtnActionPerformed
        // Lấy tiêu chí tìm kiếm và giá trị nhập vào
        String criteria = timKiemBox.getSelectedItem().toString();
        String searchValue = timKiemTxt.getText();

        if (searchValue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Khởi tạo đối tượng DAO
        BaiXeDAO bx = new BaiXeDAO();
        List<BaiXeDTO> results = new ArrayList<>();

        try {
            if (criteria.equals("Theo Biển Số")) {
                // Tìm kiếm theo biển số
                results = bx.findByVehicleNumber(searchValue);
            } else if (criteria.equals("Theo Mã Vé")) {
                // Tìm kiếm theo mã vé
                BaiXeDTO bxe = bx.findTicketID(searchValue);
                if (bxe != null) {
                    results.add(bxe);
                }
            }

            // Kiểm tra kết quả và cập nhật bảng
            if (results.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả phù hợp!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                updateTable(results);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_timkiemBtnActionPerformed

    private void dangXuatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangXuatBtnActionPerformed
        new DangNhap().setVisible(true);
        dispose();
    }//GEN-LAST:event_dangXuatBtnActionPerformed

    private void nhanXeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhanXeBtnActionPerformed
        new NhanXe(ten).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nhanXeBtnActionPerformed

    private void traxeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traxeBtnActionPerformed
        new TraXe(ten).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_traxeBtnActionPerformed

    private void dangkyVTBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangkyVTBtnActionPerformed
        new DangKyVeThang(ten).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dangkyVTBtnActionPerformed

    private void taiKhoanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taiKhoanBtnActionPerformed
        new TaiKhoan(ten).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_taiKhoanBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable baiXeTable;
    private javax.swing.JTextField bienSoXeTxt;
    private javax.swing.JTextField chaoMungTxt;
    private javax.swing.JButton dangXuatBtn;
    private javax.swing.JButton dangkyVTBtn;
    private javax.swing.JTextField gioNhanTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton lamMoiBtn;
    private javax.swing.JTextField loaiXeTxt;
    private javax.swing.JTextField maVeTxt;
    private javax.swing.JTextField ngayNhanTxt;
    private javax.swing.JButton nhanXeBtn;
    private javax.swing.JButton taiKhoanBtn;
    private javax.swing.JComboBox<String> timKiemBox;
    private javax.swing.JTextField timKiemTxt;
    private javax.swing.JButton timkiemBtn;
    private javax.swing.JButton traXeBtn;
    private javax.swing.JButton traxeBtn;
    private javax.swing.JTextField viTriTxt;
    // End of variables declaration//GEN-END:variables
}
