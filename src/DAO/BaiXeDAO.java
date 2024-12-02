/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.BaiXeDTO;
import DTO.TongXeDTO;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class BaiXeDAO {

    public static List<BaiXeDTO> findAll() {
        List<BaiXeDTO> ticketDetailsList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "SELECT * FROM baixe";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String ticketId = resultSet.getString("MAVE");
                String vehicleNumber = resultSet.getString("BIENSO");
                String vehicleType = resultSet.getString("LOAIXE");
                String position = resultSet.getString("VITRI");

                // Chuyển đổi từ Date và Time trong CSDL sang LocalDate và LocalTime
                LocalDate receivedDate = resultSet.getDate("NGAYGUI").toLocalDate();
                String time = resultSet.getString("GIOGUI");

                BaiXeDTO ticketDetail = new BaiXeDTO(ticketId, vehicleNumber, vehicleType, position, receivedDate, time);
                ticketDetailsList.add(ticketDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ticketDetailsList;
    }

    public static void nhanXe(BaiXeDTO bx) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Date date = new Date(0000 - 00 - 00);
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "INSERT INTO baixe (MAVE, BIENSO, LOAIXE, VITRI, NGAYGUI, GIOGUI) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            statement = conn.prepareStatement(sql);

            statement.setString(1, bx.getMaVe());
            statement.setString(2, bx.getBienSo());
            statement.setString(3, bx.getLoaiXe());
            statement.setString(4, bx.getViTri());
            statement.setDate(5, date.valueOf(bx.getNgayGui()));
            statement.setString(6, bx.getGioGui());

            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void traXe(String maVe) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "DELETE FROM baixe WHERE MAVE = ?";
            statement = conn.prepareStatement(sql);

            statement.setString(1, maVe);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> getUsedTicketIds() {
        List<String> usedTicketIds = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "SELECT MAVE FROM baixe";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                usedTicketIds.add(rs.getString("mave"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usedTicketIds;
    }

    public List<BaiXeDTO> findByVehicleNumber(String vehicleNumber) {
        Connection connection = null;
        PreparedStatement statement = null;
        List<BaiXeDTO> bx = new ArrayList<>();


        try {
            connection = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);

            String sql = "SELECT * FROM baixe WHERE BIENSO = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, vehicleNumber);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BaiXeDTO bxe = new BaiXeDTO(
                        resultSet.getString("MAVE"),
                        resultSet.getString("BIENSO"),
                        resultSet.getString("LOAIXE"),
                        resultSet.getString("VITRI"),
                        resultSet.getDate("NGAYGUI").toLocalDate(),
                        resultSet.getString("GIOGUI")
                );
                bx.add(bxe);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return bx;
    }
    
    public BaiXeDTO findTicketID(String tID) {
        Connection connection = null;
        PreparedStatement statement = null;
        BaiXeDTO bx = null;


        try {
            connection = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);

            String sql = "SELECT * FROM baixe WHERE MAVE = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, tID);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                bx = new BaiXeDTO(
                        resultSet.getString("MAVE"),
                        resultSet.getString("BIENSO"),
                        resultSet.getString("LOAIXE"),
                        resultSet.getString("VITRI"),
                        resultSet.getDate("NGAYGUI").toLocalDate(),
                        resultSet.getString("GIOGUI")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return bx;
    }
   
    

    private static LocalDate LocalDate(Date date) {
        return LocalDate.parse(date.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
