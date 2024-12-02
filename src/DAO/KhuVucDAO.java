/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhuVucDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class KhuVucDAO {

    public static List<KhuVucDTO> findAll() {
        List<KhuVucDTO> parkingSpotList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            // Kết nối cơ sở dữ liệu
            connection = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);

            // Câu truy vấn
            String sql = "SELECT VITRI FROM baido";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                KhuVucDTO spot = new KhuVucDTO(
                        resultSet.getString("ViTri")
                );
                parkingSpotList.add(spot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parkingSpotList;
    }

    public static List<String> findOccupiedSpots() {
        List<String> result = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            // Kết nối cơ sở dữ liệu
            connection = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);

            // Câu truy vấn
            String sql = "SELECT VITRI FROM baixe WHERE NGAYRA IS NULL"; 
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                result.add(resultSet.getString("VITRI"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
 
}
