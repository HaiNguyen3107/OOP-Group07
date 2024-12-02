/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class NhanVienDAO {

    public static List<NhanVienDTO> findAll() {
        List<NhanVienDTO> dataList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "SELECT * FROM nhanvien";
            statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                NhanVienDTO ticket = new NhanVienDTO(
                        resultSet.getString("cccd"),
                        resultSet.getString("hoTen"),
                        resultSet.getString("soDienThoai"),
                        resultSet.getString("taiKhoan"),
                        resultSet.getString("matKhau")
                );
                dataList.add(ticket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public static void insert(NhanVienDTO nhanvien) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "INSERT INTO nhanvien (cccd, hoTen, soDienThoai, taiKhoan, matKhau) "
                    + "VALUES (?, ?, ?, ?, ?)";

            statement = connection.prepareStatement(sql);

            statement.setString(1, nhanvien.getCccd());
            statement.setString(2, nhanvien.getTenNhanVien());
            statement.setString(3, nhanvien.getSoDienThoai());
            statement.setString(4, nhanvien.getTaiKhoan());
            statement.setString(5, nhanvien.getMatKhau());

            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void update(NhanVienDTO nhanvien) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "UPDATE nhanvien SET hoTen = ?, soDienThoai = ?, taiKhoan = ?, matKhau = ? "
                    + "WHERE cccd = ?";

            statement = connection.prepareStatement(sql);
            
            statement.setString(1, nhanvien.getTenNhanVien());
            statement.setString(2, nhanvien.getSoDienThoai());
            statement.setString(3, nhanvien.getTaiKhoan());
            statement.setString(4, nhanvien.getMatKhau());
            statement.setString(5, nhanvien.getCccd());
           

            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void delete(String cccd) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "DELETE FROM nhanvien WHERE cccd = ?";
            statement = connection.prepareStatement(sql);

            statement.setString(1, cccd);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static NhanVienDTO login(String taikhoan, String matkhau) {
        NhanVienDTO nhanvien = null;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);

            String sql = "select * from nhanvien where taiKhoan = ? and matKhau = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, taikhoan);
            statement.setString(2, matkhau);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                nhanvien = new NhanVienDTO(
                        resultSet.getString("cccd"),
                        resultSet.getString("hoTen"),
                        resultSet.getString("soDienThoai"),
                        resultSet.getString("taiKhoan"),
                        resultSet.getString("matKhau")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nhanvien;
    }
    
    public static List<NhanVienDTO> findByFullName(String s) {
        List<NhanVienDTO> dataList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from nhanvien";
            if (s != null && !s.isEmpty()) {
                sql += " where hoTen like ?";
            }
            statement = connection.prepareStatement(sql);
            if (s != null && !s.isEmpty()) {
                statement.setString(1, s);
            }
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                NhanVienDTO nhanvien = new NhanVienDTO(
                        resultSet.getString("cccd"),
                        resultSet.getString("hoTen"),
                        resultSet.getString("soDienThoai"),
                        resultSet.getString("taiKhoan"),
                        resultSet.getString("matKhau")
                );
                dataList.add(nhanvien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }

}
