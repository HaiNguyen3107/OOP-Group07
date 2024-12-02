package UI;

import DAO.BaiXeDAO;
import DAO.KhuVucDAO;
import DAO.VeNgayDAO;
import DAO.VeThangDAO;
import DTO.BaiXeDTO;
import DTO.KhuVucDTO;
import DTO.VeNgayDTO;
import DTO.VeThangDTO;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.DefaultComboBoxModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author quang
 */
public class NhanXe extends javax.swing.JFrame {

    private String ten;
    List<VeNgayDTO> dataList1 = new ArrayList<>();
    List<VeThangDTO> dataList2 = new ArrayList<>();

    public NhanXe(String tenNhanVien) {
        initComponents();
        tenNhanVienTxt.setText(tenNhanVien + " !");
        this.ten = tenNhanVien;
        showCurrentDateTime();
        dataList2 = VeThangDAO.findAll();
        loadParkingSpotData();
        dataList1 = VeNgayDAO.findAll();
        loaiVeBox.addActionListener(e -> updateTicketList());
        loaiXeBox.addActionListener(e -> handleVehicleTypeChange());
        maVeBox.addActionListener(e -> handleMonthlyTicketSelection());
    }

    private void showCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        ngayNhanTxt.setText(now.format(dateFormatter));
        gioNhanTxt.setText(now.format(timeFormatter));
    }

    private void updateTicketList() {
        String selectedType = (String) loaiVeBox.getSelectedItem(); // Lấy loại vé được chọn
        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) maVeBox.getModel();
        comboBoxModel.removeAllElements(); // Xóa các vé cũ trong combo box
        List<String> usedTicketIds = BaiXeDAO.getUsedTicketIds();
        if ("Vé Ngày".equals(selectedType)) {
            bienSoTxt.setEnabled(true);
            loaiXeBox.setEnabled(true); // Kích hoạt comboBox loại xe khi chọn vé ngày            // Thêm vé ngày vào combo box
            for (VeNgayDTO x : dataList1) {
                if (!usedTicketIds.contains(x.getMaVe())) {
                    comboBoxModel.addElement(x.getMaVe());
                }
            }
        } else if ("Vé Tháng".equals(selectedType)) {
            bienSoTxt.setEnabled(false); // Tắt textfield biển số khi chọn vé tháng
            loaiXeBox.setEnabled(false); // Vô hiệu hóa comboBox loại xe khi chọn vé tháng
            // Thêm vé tháng vào combo box
            for (VeThangDTO x : dataList2) {
                if (!usedTicketIds.contains(x.getMaVe())) {
                    comboBoxModel.addElement(x.getMaVe());
                }
            }
        }
    }

    private void handleVehicleTypeChange() {
        String selectedType = (String) loaiXeBox.getSelectedItem(); // Lấy loại xe đã chọn
        if (selectedType == null) {
            return; // Nếu null, không làm gì cả và thoát khỏi phương thức
        }

        if (selectedType.equals("Xe Máy")) {
            // Nếu chọn Xe Máy, chỉ hiển thị Khu Vực và disable Vị Trí
            viTriBox.setEnabled(false);  // Vô hiệu hóa Vị Trí
        } else if (selectedType.equals("Ô Tô")) {
            // Nếu chọn Ô Tô, cho phép chọn cả Khu Vực và Vị Trí
            viTriBox.setEnabled(true);   // Cho phép chọn Vị Trí
        }
    }

    private void handleMonthlyTicketSelection() {
        // Lấy mã vé được chọn từ ComboBox
        String selectedTicketId = (String) maVeBox.getSelectedItem();

        if (selectedTicketId != null) {
            boolean matchFound = false;

            // Duyệt qua danh sách vé tháng
            for (VeThangDTO ticket : dataList2) {
                if (Objects.equals(ticket.getMaVe(), selectedTicketId)) {
                    // Nếu khớp, hiển thị biển số và loại xe
                    bienSoTxt.setText(ticket.getBienSo());
                    loaiXeBox.setSelectedItem(ticket.getLoaiXe());
                    matchFound = true;
                    break;
                }
            }

            if (!matchFound) {
                // Nếu không tìm thấy, xóa dữ liệu
                bienSoTxt.setText("");
                loaiXeBox.setSelectedIndex(-1); // Bỏ chọn loại xe

            }
        }
    }

    private void loadParkingSpotData() {
        // Lấy toàn bộ danh sách chỗ đỗ xe từ CSDL
        List<KhuVucDTO> parkingSpots = KhuVucDAO.findAll();
        List<String> occupiedSpots = KhuVucDAO.findOccupiedSpots();
        // Sử dụng HashSet để lưu các khu vực duy nhất
        Set<String> occupiedSet = new HashSet<>(occupiedSpots);

        // Lấy model của ComboBox viTriBox
        DefaultComboBoxModel<String> viTriModel = (DefaultComboBoxModel<String>) viTriBox.getModel();
        viTriModel.removeAllElements(); // Xóa các mục cũ trong ComboBox

        // Thêm vào ComboBox các vị trí chưa có xe
        for (KhuVucDTO spot : parkingSpots) {
            if (!occupiedSet.contains(spot.getViTri())) { // Nếu vị trí chưa bị chiếm
                viTriModel.addElement(spot.getViTri());
            }
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
        tenNhanVienTxt = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        loaiVeBox = new javax.swing.JComboBox<>();
        maVeBox = new javax.swing.JComboBox<>();
        bienSoTxt = new javax.swing.JTextField();
        loaiXeBox = new javax.swing.JComboBox<>();
        viTriBox = new javax.swing.JComboBox<>();
        ngayNhanTxt = new javax.swing.JTextField();
        gioNhanTxt = new javax.swing.JTextField();
        xacnhanBtn = new javax.swing.JButton();
        lammoiBtn = new javax.swing.JButton();

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
                .addContainerGap(191, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dangkyVTBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(traxeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nhanXeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(taiKhoanBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(20, Short.MAX_VALUE)))
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

        tenNhanVienTxt.setBackground(new java.awt.Color(0, 153, 255));
        tenNhanVienTxt.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        tenNhanVienTxt.setBorder(null);

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
                .addComponent(tenNhanVienTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
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
                    .addComponent(tenNhanVienTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Nhận Xe");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Loại Vé :");

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

        loaiVeBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        loaiVeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vé Ngày", "Vé Tháng" }));
        loaiVeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loaiVeBoxActionPerformed(evt);
            }
        });

        maVeBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        bienSoTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        loaiXeBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        loaiXeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xe Máy", "Ô Tô" }));

        viTriBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ngayNhanTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ngayNhanTxt.setFocusable(false);

        gioNhanTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gioNhanTxt.setFocusable(false);

        xacnhanBtn.setBackground(new java.awt.Color(254, 183, 19));
        xacnhanBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        xacnhanBtn.setText("Xác Nhận");
        xacnhanBtn.setActionCommand("");
        xacnhanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xacnhanBtnActionPerformed(evt);
            }
        });

        lammoiBtn.setBackground(new java.awt.Color(254, 183, 19));
        lammoiBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lammoiBtn.setText("Làm Mới");
        lammoiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lammoiBtnActionPerformed(evt);
            }
        });

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
                        .addGap(551, 551, 551)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(gioNhanTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(ngayNhanTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(viTriBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(xacnhanBtn)
                                .addGap(123, 123, 123)
                                .addComponent(lammoiBtn))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(maVeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bienSoTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(loaiXeBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loaiVeBox, 0, 146, Short.MAX_VALUE)))))
                .addGap(124, 139, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(loaiVeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(viTriBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(maVeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(ngayNhanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(bienSoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(gioNhanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(loaiXeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xacnhanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lammoiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(148, 148, 148))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void loaiVeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loaiVeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loaiVeBoxActionPerformed

    private void xacnhanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xacnhanBtnActionPerformed
        String licensePlate = bienSoTxt.getText();  // Biển số xe
        String vehicleType = (String) loaiXeBox.getSelectedItem();
        String parkingPosition = (String) viTriBox.getSelectedItem();// Loại xe  // Khu vực
        if (vehicleType.equals("Xe Máy")) {
            parkingPosition = null;
        }
        String ticketId = (String) maVeBox.getSelectedItem();  // Mã vé (nếu có)
        LocalTime time = LocalTime.now(); // Lấy thời gian hiện tại
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // Định dạng chỉ giờ:phút:giây
        String formattedTime = time.format(formatter); // Định dạng LocalTime thành chuỗi
        LocalDate td = LocalDate.now();
        BaiXeDTO ticketDetails = new BaiXeDTO();
        ticketDetails.setBienSo(licensePlate);
        ticketDetails.setLoaiXe(vehicleType);
        ticketDetails.setViTri(parkingPosition);
        ticketDetails.setMaVe(ticketId);
        ticketDetails.setNgayGui(td);
        ticketDetails.setGioGui(formattedTime);

        BaiXeDAO.nhanXe(ticketDetails);
        updateTicketList();

        bienSoTxt.setText("");
        loaiXeBox.setSelectedIndex(-1);
        viTriBox.setSelectedIndex(-1);
        maVeBox.setSelectedIndex(-1);
        DefaultComboBoxModel<String> viTriModel = (DefaultComboBoxModel<String>) viTriBox.getModel();
        viTriModel.removeElement(parkingPosition); // Loại bỏ vị trí đã chọn
        new VeVao(ticketId, licensePlate, vehicleType, td, formattedTime).setVisible(true);
    }//GEN-LAST:event_xacnhanBtnActionPerformed

    private void lammoiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lammoiBtnActionPerformed
        showCurrentDateTime();
    }//GEN-LAST:event_lammoiBtnActionPerformed

    private void dangXuatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangXuatBtnActionPerformed
        new DangNhap().setVisible(true);
        this.dispose();
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
    private javax.swing.JTextField bienSoTxt;
    private javax.swing.JButton dangXuatBtn;
    private javax.swing.JButton dangkyVTBtn;
    private javax.swing.JTextField gioNhanTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton lammoiBtn;
    private javax.swing.JComboBox<String> loaiVeBox;
    private javax.swing.JComboBox<String> loaiXeBox;
    private javax.swing.JComboBox<String> maVeBox;
    private javax.swing.JTextField ngayNhanTxt;
    private javax.swing.JButton nhanXeBtn;
    private javax.swing.JButton taiKhoanBtn;
    private javax.swing.JTextField tenNhanVienTxt;
    private javax.swing.JButton traxeBtn;
    private javax.swing.JComboBox<String> viTriBox;
    private javax.swing.JButton xacnhanBtn;
    // End of variables declaration//GEN-END:variables
}
