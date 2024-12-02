/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TongVeThangDTO;
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
public class TongVeThangDAO {
    public static void insert(TongVeThangDTO ticket) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Date date = new Date(0000 - 00 - 00);
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "INSERT INTO tongvethang (tID, TENKH, SDT, BIENSO, LOAIXE, MAUXE, NGAYDK, SOTIEN) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            statement = conn.prepareStatement(sql);

            statement.setString(1, ticket.getMaVeThang());
            statement.setString(2, ticket.getTenKhach());
            statement.setString(3, ticket.getSdt());
            statement.setString(4, ticket.getBienSo());
            statement.setString(5, ticket.getLoaiXe());
            statement.setString(6, ticket.getMauXe());
            statement.setDate(7, date.valueOf(ticket.getNgayDk()));
            statement.setInt(8, ticket.getSoTien());

            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<TongVeThangDTO> loadTableVethang() {
        ArrayList<TongVeThangDTO> tongXelist = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from tongvethang order by NGAYDK";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            TongVeThangDTO tv;
            tongXelist.removeAll(tongXelist);
            while (rs.next()) {
                tv = new TongVeThangDTO(
                        rs.getString("tID"),
                        rs.getString("TENKH"),
                        rs.getString("SDT"),
                        rs.getString("BIENSO"),
                        rs.getString("LOAIXE"),
                        rs.getString("MAUXE"),
                        LocalDate(rs.getDate("NGAYDK")),
                        rs.getInt("SOTIEN"));
                tongXelist.add(tv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tongXelist;
    }

    public static ArrayList<TongVeThangDTO> findDKYVETHANG(String TuNgay, String DenNgay) {
        ArrayList<TongVeThangDTO> tongXelist = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from tongvethang where NGAYDK >= '" + TuNgay + "' and NGAYDK <= '" + DenNgay + "' order by NGAYDK";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            TongVeThangDTO tv;
            tongXelist.removeAll(tongXelist);
            while (rs.next()) {
                tv = new TongVeThangDTO(
                        rs.getString("tID"),
                        rs.getString("TENKH"),
                        rs.getString("SDT"),
                        rs.getString("BIENSO"),
                        rs.getString("LOAIXE"),
                        rs.getString("MAUXE"),
                        LocalDate(rs.getDate("NGAYDK")),
                        rs.getInt("SOTIEN"));
                tongXelist.add(tv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tongXelist;
    }

    public String loadCountTime2(String TuNgay, String DenNgay) {
        String nx = null;
        try {
            Connection conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select count(BIENSO) from tongvethang where NGAYDK >= '" + TuNgay + "' and NGAYDK <= '" + DenNgay + "'";
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

    public String loadCountAll2() {
        String nx = null;
        try {
            Connection conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select count(BIENSO) from tongvethang";
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

    public String loadTien() {
        String nx = null;
        try {
            Connection conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select sum(SOTIEN) from tongvethang";
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

    public String loadTienTime(String TuNgay, String DenNgay) {
        String nx = null;
        try {
            Connection conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select sum(SOTIEN) from tongvethang where NGAYDK >= '" + TuNgay + "' and NGAYDK <= '" + DenNgay + "'";
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

    private static LocalDate LocalDate(Date date) {
        return LocalDate.parse(date.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
