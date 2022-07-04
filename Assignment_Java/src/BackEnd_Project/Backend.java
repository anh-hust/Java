package BackEnd_Project;

import java.sql.*;
import java.util.ArrayList;

public class Backend {

    private Statement statement;
    private PreparedStatement preparedStatement;
    private Connection connect;

    public Backend() throws SQLException, ClassNotFoundException {
        /* Setting to connect mysql */
        String url = "jdbc:mysql://localhost:3306/Java";
        String uname = "root";
        String pass = "1";

        /* Connect database */
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println(">>Driver load successfully");

        this.connect = DriverManager.getConnection(url, uname, pass);
        System.out.println("\n>>Database Connected\n");

        this.statement = this.connect.createStatement();
    }

    public ArrayList<ArrayList<String>> thong_tin_phong_ban(String idPhongBan) {
        ArrayList<ArrayList<String>> nv_thuoc_phong_ban = null;
        try {
            this.preparedStatement = connect.prepareStatement("select PHONGBAN.*, THONGTINNV.MaSoNV, THONGTINNV.username, THONGTINNV.HoTen " +
                    "from PHONGBAN inner join THONGTINNV on PHONGBAN.MaPhongBan=THONGTINNV.MaPhongBan " +
                    "where THONGTINNV.MaPhongBan=?");
            this.preparedStatement.setString(1, idPhongBan);
            ResultSet resultSet = this.preparedStatement.executeQuery();

            ArrayList<String> ms_nv_thuoc_phong_ban = new ArrayList<>();
            ArrayList<String> username_nv_thuoc_phong_ban = new ArrayList<>();
            ArrayList<String> hoten_nv_thuoc_phong_ban = new ArrayList<>();

            while (resultSet.next()) {
                resultSet.getString(1);
                resultSet.getString(2);
                resultSet.getString(3);
                resultSet.getString(4);
                ms_nv_thuoc_phong_ban.add(resultSet.getString(5));
                username_nv_thuoc_phong_ban.add(resultSet.getString(6));
                hoten_nv_thuoc_phong_ban.add(resultSet.getString(7));
            }
            nv_thuoc_phong_ban = new ArrayList<>();
            nv_thuoc_phong_ban.add(ms_nv_thuoc_phong_ban);
            nv_thuoc_phong_ban.add(username_nv_thuoc_phong_ban);
            nv_thuoc_phong_ban.add(hoten_nv_thuoc_phong_ban);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        /* DDL */
        return nv_thuoc_phong_ban;
    }
}
