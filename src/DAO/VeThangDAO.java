package DAO;

import DTO.VeThangDTO;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VeThangDAO {

    // Thêm vé mới
    public static void insert(VeThangDTO ticket) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Date date = new Date(0000 - 00 - 00);
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "INSERT INTO vethang (tID, TENKH, SDT, BIENSO, LOAIXE, MAUXE, NGAYDK, SOTIEN) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            statement = conn.prepareStatement(sql);

            statement.setString(1, ticket.getMaVe());
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

    // Cập nhật thông tin vé
    public static void update(VeThangDTO ticket) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Date date = new Date(0000 - 00 - 00);
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "UPDATE vethang SET TENKH = ?, SDT = ?, BIENSO = ?, LOAIXE = ?, MAUXE = ? "
                    + "WHERE tID = ?";

            statement = conn.prepareStatement(sql);

            statement.setString(1, ticket.getTenKhach());
            statement.setString(2, ticket.getSdt());
            statement.setString(3, ticket.getBienSo());
            statement.setString(4, ticket.getLoaiXe());
            statement.setString(5, ticket.getMauXe());
            statement.setString(6, ticket.getMaVe());


            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa vé
    public static void delete(String maVe) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "DELETE FROM vethang WHERE tID = ?";
            statement = conn.prepareStatement(sql);

            statement.setString(1, maVe);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static List<VeThangDTO> findAll() {
        List<VeThangDTO> dataList = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "SELECT * FROM vethang order by NGAYDK";
            statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                VeThangDTO ticket = new VeThangDTO(
                        rs.getString("tID"),
                        rs.getString("TENKH"),
                        rs.getString("SDT"),
                        rs.getString("BIENSO"),
                        rs.getString("LOAIXE"),
                        rs.getString("MAUXE"),
                        LocalDate(rs.getDate("NGAYDK")),
                        rs.getInt("SOTIEN")
                );
                dataList.add(ticket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }
   

    private static LocalDate LocalDate(Date date) {
        return LocalDate.parse(date.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
