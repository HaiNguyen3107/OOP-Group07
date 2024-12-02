/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.VeNgayDTO;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author ASUS
 */
public class VeNgayDAO {

        public static List<VeNgayDTO> findAll() {
            List<VeNgayDTO> dataList = new ArrayList<>();

            Connection connection = null;
            Statement statement = null;

            try {
                connection = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);

                String sql = "select * from vengay";
                statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    VeNgayDTO ticket = new VeNgayDTO(resultSet.getString("mave"));
                    dataList.add(ticket);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return dataList;
        }
}
