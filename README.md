
# CarePark








## Project Overview
CarePark is an innovative, Java-based parking management system designed to streamline and optimize the management of parking spaces in urban and commercial areas. The application aims to provide users with real-time parking availability, automated ticketing, and easy payment solutions while offering administrators tools to monitor, maintain, and manage parking facilities efficiently.
## Features

Real-Time Parking Updates

- Displays available parking spots in real-time using sensor integration or manual updates.
Admin Dashboard

- Staff management
- Tools to manage rates, reservations, and user accounts.



## Technologies Used

- Language : JAVA.
- Paradigm: Object-Oriented Programming (OOP).
- Libraries/Frameworks:
    - Java Standard Edition (Java SE)
    - Java Swing (for GUI, if applicable)
    - JDBC (for database integration)
    - Jcalender
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


## Project Structure

```
📦CarePark
 ┣ 📂src
 ┃ ┣ 📂DAO
 ┃ ┃ ┣ 📜BaiXeDAO.java
 ┃ ┃ ┣ 📜Config.java
 ┃ ┃ ┣ 📜KhuVucDAO.java
 ┃ ┃ ┣ 📜NhanVienDAO.java
 ┃ ┃ ┣ 📜TongVeThangDAO.java
 ┃ ┃ ┣ 📜TongXeDAO.java
 ┃ ┃ ┣ 📜VeNgayDAO.java
 ┃ ┃ ┗ 📜VeThangDAO.java
 ┃ ┣ 📂DTO
 ┃ ┃ ┣ 📜BaiXeDTO.java
 ┃ ┃ ┣ 📜KhuVucDTO.java
 ┃ ┃ ┣ 📜NhanVienDTO.java
 ┃ ┃ ┣ 📜TongVeThangDTO.java
 ┃ ┃ ┣ 📜TongXeDTO.java
 ┃ ┃ ┣ 📜VeNgayDTO.java
 ┃ ┃ ┗ 📜VeThangDTO.java
 ┃ ┣ 📂Image
 ┃ ┃ ┣ 📜download-icon-left+previous+icon-1320166862746760425_24.png
 ┃ ┃ ┣ 📜icons8_bank_cards_32px.png
 ┃ ┃ ┣ 📜icons8_bank_cards_32px_1.png
 ┃ ┃ ┣ ...
 ┃ ┣ 📂Libs
 ┃ ┃ ┣ 📜jcalendar-1.4.jar
 ┃ ┃ ┗ 📜mysql-connector-j-9.1.0.jar
 ┃ ┗ 📂UI
 ┃ ┃ ┣ 📜DangKyVeThang.form
 ┃ ┃ ┣ 📜DangKyVeThang.java
 ┃ ┃ ┣ 📜DangNhap.form
 ┃ ┃ ┣ 📜DangNhap.java
 ┃ ┃ ┣ 📜HoaDonVN.form
 ┃ ┃ ┣ 📜HoaDonVN.java
 ┃ ┃ ┣ 📜HoaDonVT.form
 ┃ ┃ ┣ 📜HoaDonVT.java
 ┃ ┃ ┣ 📜NhanXe.form
 ┃ ┃ ┣ 📜NhanXe.java
 ┃ ┃ ┣ 📜QuanLyNhanVien.form
 ┃ ┃ ┣ 📜QuanLyNhanVien.java
 ┃ ┃ ┣ 📜TaiKhoan.form
 ┃ ┃ ┣ 📜TaiKhoan.java
 ┃ ┃ ┣ 📜ThongKe.form
 ┃ ┃ ┣ 📜ThongKe.java
 ┃ ┃ ┣ 📜ThongKeLuotGuiXe.form
 ┃ ┃ ┣ 📜ThongKeLuotGuiXe.java
 ┃ ┃ ┣ 📜ThongKeVeThang.form
 ┃ ┃ ┣ 📜ThongKeVeThang.java
 ┃ ┃ ┣ 📜TraXe.form
 ┃ ┃ ┣ 📜TraXe.java
 ┃ ┃ ┣ 📜VeVao.form
 ┃ ┃ ┗ 📜VeVao.java
 ┣ 📜README.md
 ┗ 📜UML.svg

```
## UML

![UML Diagram](https://github.com/HaiNguyen3107/OOP-Group07/blob/master/UML.svg)

## Authors

- [Nguyễn Minh Đức Hải](https://github.com/HaiNguyen3107)
- [Tăng Minh Quang](https://github.com/whyalwaysme2x)
- [Nguyễn Hồng Thăng](https://github.com/Thang7804)
- [Phan Danh Hùng](https://github.com/songkang04)
- [Nguyễn Phương Nam](https://github.com/Nam2312)

