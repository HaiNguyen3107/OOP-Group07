/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TongXeDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class TongXeDAO {
     public static void insert(TongXeDTO bx) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Date date = new Date(0000 - 00 - 00);
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "INSERT INTO tongxe (MAVE, BIENSO, LOAIXE, VITRI, NGAYGUI, GIOGUI, NGAYRA, GIORA, TONGTIEN) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            statement = conn.prepareStatement(sql);

            statement.setString(1, bx.getMaVe());
            statement.setString(2, bx.getBienSo());
            statement.setString(3, bx.getLoaiXe());
            statement.setString(4, bx.getViTri());
            statement.setDate(5, date.valueOf(bx.getNgayGui()));
            statement.setString(6, bx.getGioGui());
            statement.setDate(7, date.valueOf(bx.getNgayTra()));
            statement.setString(8, bx.getGioTra());
            statement.setInt(9, bx.getTongTien());

            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<TongXeDTO> findCar(String Loaixe, String TuNgay, String DenNgay) {
        ArrayList<TongXeDTO> tongXelist = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from tongxe where LOAIXE='" + Loaixe + "'and NGAYRA >= '" + TuNgay + "' and NGAYTRA <= '" + DenNgay + "' order by NGAYRA";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            TongXeDTO tv;
            tongXelist.removeAll(tongXelist);
            while (rs.next()) {
                tv = new TongXeDTO(
                        rs.getString("MAVE"), 
                        rs.getString("BIENSO"),  
                        rs.getString("LOAIXE"),  
                        rs.getString("VITRI"), 
                        LocalDate(rs.getDate("NGAYGUI")), 
                        rs.getString("GIOGUI"), 
                        LocalDate(rs.getDate("NGAYRA")), 
                        rs.getString("GIORA"), 
                        rs.getInt("TONGTIEN")
                );
                tongXelist.add(tv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tongXelist;
    }

    public static ArrayList<TongXeDTO> findCarAll(String TuNgay, String DenNgay) {
        ArrayList<TongXeDTO> tongXelist = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from tongxe where NGAYRA >= '" + TuNgay + "' and NGAYRA <= '" + DenNgay + "' order by NGAYRA";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            TongXeDTO tv;
            tongXelist.removeAll(tongXelist);
            while (rs.next()) {
                  tv = new TongXeDTO(
                        rs.getString("MAVE"), 
                        rs.getString("BIENSO"),  
                        rs.getString("LOAIXE"),  
                        rs.getString("VITRI"), 
                        LocalDate(rs.getDate("NGAYGUI")), 
                        rs.getString("GIOGUI"), 
                        LocalDate(rs.getDate("NGAYRA")), 
                        rs.getString("GIORA"), 
                        rs.getInt("TONGTIEN")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tongXelist;
    }

    public static ArrayList<TongXeDTO> loadTableAll() {
        ArrayList<TongXeDTO> tongXelist = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from tongxe order by NGAYRA";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            TongXeDTO tv;
            tongXelist.removeAll(tongXelist);
            while (rs.next()) {
                   tv = new TongXeDTO(
                        rs.getString("MAVE"), 
                        rs.getString("BIENSO"),  
                        rs.getString("LOAIXE"),  
                        rs.getString("VITRI"), 
                        LocalDate(rs.getDate("NGAYGUI")), 
                        rs.getString("GIOGUI"), 
                        LocalDate(rs.getDate("NGAYRA")), 
                        rs.getString("GIORA"), 
                        rs.getInt("TONGTIEN")
                );
                tongXelist.add(tv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tongXelist;
    }

    public String loadCountAll() {
        String nx = null;
        try {
            Connection conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select count(BIENSO) from tongxe";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nx = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nx;
    }

    public String loadCountTimeAll(String TuNgay, String DenNgay) {
        String nx = null;
        try {
            Connection conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select count(BIENSO) from tongxe where NGAYRA >= '" + TuNgay + "' and NGAYRA <= '" + DenNgay + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nx = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nx;
    }

    public String loadCountTime(String Loaixe, String TuNgay, String DenNgay) {
        String nx = null;
        try {
            Connection conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select count(BIENSO) from tongxe where LOAIXE='" + Loaixe + "' and NGAYRA >= '" + TuNgay + "' and NGAYRA <= '" + DenNgay + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nx = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nx;
    }

    public int loadMoneyAll() {
        int nx = 0;
        try {
            Connection conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select Sum(TONGTIEN) from tongxe ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nx = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nx;
    }

    public int loadMoneyTimeAll(String TuNgay, String DenNgay) {
        int nx = 0;
        try {
            Connection conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select Sum(TONGTIEN) from tongxe where NGAYRA >= '" + TuNgay + "' and NGAYRA <= '" + DenNgay + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nx = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nx;
    }

    public int loadMoneyTime(String Loaixe, String TuNgay, String DenNgay) {
        int nx = 0;
        try {
            Connection conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select Sum(TONGTIEN) from tongxe where LOAIXE='" + Loaixe + "' and NGAYRA >= '" + TuNgay + "' and NGAYRA <= '" + DenNgay + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nx = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nx;
    }

    private static LocalDate LocalDate(Date date) {
        return LocalDate.parse(date.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
