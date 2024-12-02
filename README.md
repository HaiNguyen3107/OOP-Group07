
# CarePark








## Project Overview
CarePark is an innovative, Java-based parking management system designed to streamline and optimize the management of parking spaces in urban and commercial areas. The application aims to provide users with real-time parking availability, automated ticketing, and easy payment solutions while offering administrators tools to monitor, maintain, and manage parking facilities efficiently.
## Features

Real-Time Parking Updates

- Displays available parking spots in real-time using sensor integration or manual updates.
Admin Dashboard

- staff management
- Tools to manage rates, reservations, and user accounts.



## Technologies Used

- Language : JAVA.
- Paradigm: Object-Oriented Programming (OOP).
- Libraries/Frameworks:
    - Java Standard Edition (Java SE)
    - Java Swing (for GUI, if applicable)
    - JDBC (for database integration)
    - Jcalender
## Project Structure

```

📦OOP-Group07
 ┣ 📂UI
 ┃ ┣ 📜DangKyVeThang.form
 ┃ ┣ 📜DangKyVeThang.java
 ┃ ┣ 📜DangNhap.form
 ┃ ┣ 📜DangNhap.java
 ┃ ┣ 📜HoaDonVN.form
 ┃ ┣ 📜HoaDonVN.java
 ┃ ┣ 📜HoaDonVT.form
 ┃ ┣ 📜HoaDonVT.java
 ┃ ┣ 📜NhanXe.form
 ┃ ┣ 📜NhanXe.java
 ┃ ┣ 📜QuanLyNhanVien.form
 ┃ ┣ 📜QuanLyNhanVien.java
 ┃ ┣ 📜TaiKhoan.form
 ┃ ┣ 📜TaiKhoan.java
 ┃ ┣ 📜ThongKe.form
 ┃ ┣ 📜ThongKe.java
 ┃ ┣ 📜ThongKeLuotGuiXe.form
 ┃ ┣ 📜ThongKeLuotGuiXe.java
 ┃ ┣ 📜ThongKeVeThang.form
 ┃ ┣ 📜ThongKeVeThang.java
 ┃ ┣ 📜TraXe.form
 ┃ ┣ 📜TraXe.java
 ┃ ┣ 📜VeVao.form
 ┃ ┗ 📜VeVao.java
 ┣ 📂src
 ┃ ┣ 📂DTO
 ┃ ┃ ┣ 📜BaiXeDTO.java
 ┃ ┃ ┣ 📜KhuVucDTO.java
 ┃ ┃ ┣ 📜NhanVienDTO.java
 ┃ ┃ ┣ 📜TongDKVeThangDTO.java
 ┃ ┃ ┣ 📜TongXeDTO.java
 ┃ ┃ ┣ 📜VeNgayDTO.java
 ┃ ┃ ┗ 📜VeThangDTO.java
 ┃ ┣ 📂GUI
 ┃ ┃ ┣ 📜AdminUI1.form
 ┃ ┃ ┣ 📜AdminUI1.java
 ┃ ┃ ┣ 📜AdminUI2.form
 ┃ ┃ ┣ 📜AdminUI2.java
 ┃ ┃ ┣ 📜AdminUI3.form
 ┃ ┃ ┣ 📜AdminUI3.java
 ┃ ┃ ┣ 📜AdminUI4.form
 ┃ ┃ ┣ 📜AdminUI4.java
 ┃ ┃ ┣ 📜AdminUI5.form
 ┃ ┃ ┣ 📜AdminUI5.java
 ┃ ┃ ┣ 📜AdminUI6.form
 ┃ ┃ ┣ 📜AdminUI6.java
 ┃ ┃ ┣ 📜DangKiVeThang21.form
 ┃ ┃ ┣ 📜DangKiVeThang21.java
 ┃ ┃ ┣ 📜LogForm.form
 ┃ ┃ ┣ 📜LogForm.java
 ┃ ┃ ┣ 📜Login.form
 ┃ ┃ ┣ 📜Login.java
 ┃ ┃ ┣ 📜NhanXeFrame2.form
 ┃ ┃ ┣ 📜NhanXeFrame2.java
 ┃ ┃ ┣ 📜QuanLyBX.form
 ┃ ┃ ┣ 📜QuanLyBX.java
 ┃ ┃ ┣ 📜QuanLyNV.form
 ┃ ┃ ┣ 📜QuanLyNV.java
 ┃ ┃ ┣ 📜QuanLyVeNgay.form
 ┃ ┃ ┣ 📜QuanLyVeNgay.java
 ┃ ┃ ┣ 📜Sua.form
 ┃ ┃ ┣ 📜Sua.java
 ┃ ┃ ┣ 📜TaiKhoan21.form
 ┃ ┃ ┣ 📜TaiKhoan21.java
 ┃ ┃ ┣ 📜ThemNguoiDung.form
 ┃ ┃ ┣ 📜ThemNguoiDung.java
 ┃ ┃ ┣ 📜ThongKe.form
 ┃ ┃ ┣ 📜ThongKe.java
 ┃ ┃ ┣ 📜ThongKeLuotGuiXe.form
 ┃ ┃ ┣ 📜ThongKeLuotGuiXe.java
 ┃ ┃ ┣ 📜ThongKeVeThang.form
 ┃ ┃ ┣ 📜ThongKeVeThang.java
 ┃ ┃ ┣ 📜ThongTinFrame.form
 ┃ ┃ ┣ 📜ThongTinFrame.java
 ┃ ┃ ┣ 📜TraXeFrame.form
 ┃ ┃ ┣ 📜TraXeFrame21.form
 ┃ ┃ ┣ 📜TraXeFrame21.java
 ┃ ┃ ┣ 📜Uinhanvien.form
 ┃ ┃ ┣ 📜Uinhanvien.java
 ┃ ┃ ┣ 📜hoadon3.form
 ┃ ┃ ┣ 📜hoadon3.java
 ┃ ┃ ┣ 📜hoadon4.form
 ┃ ┃ ┣ 📜hoadon4.java
 ┃ ┃ ┣ 📜hoadonra.form
 ┃ ┃ ┣ 📜hoadonra.java
 ┃ ┃ ┣ 📜hoadonvao.form
 ┃ ┃ ┗ 📜hoadonvao.java
 ┃ ┣ 📂giao dien
 ┃ ┃ ┣ 📜1.1.1.1.jpg
 ┃ ┃ ┣ 📜1.1.1.jpg
 ┃ ┃ ┣ 📜1.1.jpg
 ┃ ┃ ┣ 📜1.jpg
 ┃ ┃ ┣ 📜18310.eps
 ┃ ┃ ┣ 📜18310.jpg
 ┃ ┃ ┣ 📜26663.eps
 ┃ ┃ ┣ 📜26663.jpg
 ┃ ┃ ┣ 📜3x4-1.JPG
 ┃ ┃ ┣ 📜8170240.jpg
 ┃ ┃ ┣ 📜8170639.ai
 ┃ ┃ ┣ 📜8170640.eps
 ┃ ┃ ┣ 📜8211090.ai
 ┃ ┃ ┣ 📜8211090.jpg
 ┃ ┃ ┣ 📜8211091.eps
 ┃ ┃ ┣ 📜8211093.jpg
 ┃ ┃ ┣ 📜A (1).png
 ┃ ┃ ┣ 📜Layer 0.png
 ┃ ┃ ┣ 📜f429fe77-627d-4e13-b1de-4b46a9d2857a.eps
 ┃ ┃ ┣ 📜f429fe77-627d-4e13-b1de-4b46a9d2857a.jpg
 ┃ ┃ ┣ 📜login.jpg
 ┃ ┃ ┣ 📜login1.jpg
 ┃ ┃ ┣ 📜login2.jpg
 ┃ ┃ ┣ 📜logo.png
 ┃ ┃ ┗ 📜logo1.png
 ┃ ┗ 📂icon
 ┃ ┃ ┣ 📜462558659_533689476165386_6132112104520371667_n (1).jpg
 ┃ ┃ ┣ 📜462558659_533689476165386_6132112104520371667_n.jpg
 ┃ ┃ ┣ 📜Logo-PTIT-University.png
 ┃ ┃ ┣ 📜Logo_PTIT_University.png
 ┃ ┃ ┣ 📜Tham-khao-mau-icon-Hello-dac-sac-removebg-preview.png
 ┃ ┃ ┣ 📜adeea4bf-5b6d-434d-863b-94eda618e127.jpg
 ┃ ┃ ┣ 📜bai-do-xe-hoi-min-1638325312-2.jpg
 ┃ ┃ ┣ 📜bai-do-xe-hoi-min-1638325312-2_1.jpg
 ┃ ┃ ┣ 📜banner-mobile (1).jpg
 ┃ ┃ ┣ 📜banner-mobile.webp
 ┃ ┃ ┣ 📜d746925076f7acef40bc89a27ad40b9a-removebg-preview.png
 ┃ ┃ ┣ 📜download-icon-left+previous+icon-1320166862746760425_24.png
 ┃ ┃ ┣ 📜icons8_bank_cards_32px.png
 ┃ ┃ ┣ 📜icons8_bank_cards_32px_1.png
 ┃ ┃ ┣ 📜icons8_car_racing_32px_1.png
 ┃ ┃ ┣ 📜icons8_car_theft_32px.png
 ┃ ┃ ┣ 📜icons8_credit_card_96px.png
 ┃ ┃ ┣ 📜icons8_information_32px.png
 ┃ ┃ ┣ 📜icons8_key_32px_2.png
 ┃ ┃ ┣ 📜icons8_management_32px.png
 ┃ ┃ ┣ 📜icons8_membership_card_32px_1.png
 ┃ ┃ ┣ 📜icons8_parking_128px.png
 ┃ ┃ ┣ 📜icons8_parking_32px_1.png
 ┃ ┃ ┣ 📜icons8_parking_64px.png
 ┃ ┃ ┣ 📜icons8_parking_64px_1.png
 ┃ ┃ ┣ 📜icons8_receipt_dollar_96px.png
 ┃ ┃ ┣ 📜icons8_scorecard_32px.png
 ┃ ┃ ┣ 📜icons8_sedan_32px.png
 ┃ ┃ ┣ 📜icons8_traffic_jam_96px.png
 ┃ ┃ ┣ 📜icons8_user_32px_1.png
 ┃ ┃ ┣ 📜icons8_user_45px.png
 ┃ ┃ ┣ 📜icons8_user_50px.png
 ┃ ┃ ┣ 📜logo_bcvt_transparent_Original_White-background_600px.png
 ┃ ┃ ┣ 📜photo-1617957689233-207e3cd3c610 (1).jpg
 ┃ ┃ ┣ 📜unknown (1).png
 ┃ ┃ ┗ 📜unknown (2).png
 ┗ 📜README.md

```
## Installation

Install my-project with npm

```bash
  git clone https://github.com/HaiNguyen3107/OOP-Group07
  cd my-project
```
    
## Usage

**1. Employee Flow**
    
- Login: Employee can log in. 
- Pickup Car: Vehicle information and ticket information.
- Return Car: Billing and payment.
- Monthly ticket registration.
- Account management.

**2. Admin Flow**
- Employee management:Create Employee account.
- Statistics: Parking and monthly ticket statistics.


## Authors

- [Nguyễn Minh Đức Hải](https://github.com/HaiNguyen3107)
- [Tăng Minh Quang](https://github.com/whyalwaysme2x)
- [Nguyễn Hồng Thăng](https://github.com/Thang7804)
- [Phan Danh Hùng](https://github.com/songkang04)
- [Nguyễn Phương Nam](https://github.com/HaiNguyen3107)

