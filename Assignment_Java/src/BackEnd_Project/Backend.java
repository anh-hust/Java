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
        ArrayList<ArrayList<String>> phong_ban = new ArrayList<>();
        try {
            this.preparedStatement = connect.prepareStatement("select * from PHONGBAN where MaPhongBan=?");
            this.preparedStatement.setString(1, idPhongBan);
            ResultSet resultSet = this.preparedStatement.executeQuery();
            ArrayList<String> thong_tin_pb = new ArrayList<>();
            while(resultSet.next()) {
                thong_tin_pb.add(resultSet.getString(1));
                thong_tin_pb.add(resultSet.getString(2));
                thong_tin_pb.add(resultSet.getString(3));
                thong_tin_pb.add(resultSet.getString(4));
            }

            this.preparedStatement.clearParameters();
            resultSet.close();

            this.preparedStatement = connect.prepareStatement("select MaSoNV, username, HoTen " +
                    "from THONGTINNV inner join PHONGBAN on THONGTINNV.MaPhongBan=PHONGBAN.MaPhongBan " +
                    "where THONGTINNV.MaPhongBan=?");
            this.preparedStatement.setString(1, idPhongBan);
            ResultSet resultSet1 = this.preparedStatement.executeQuery();

            ArrayList<String> ms_nv_thuoc_phong_ban = new ArrayList<>();
            ArrayList<String> username_nv_thuoc_phong_ban = new ArrayList<>();
            ArrayList<String> hoten_nv_thuoc_phong_ban = new ArrayList<>();

            while (resultSet1.next()) {
                ms_nv_thuoc_phong_ban.add(resultSet1.getString(1));
                username_nv_thuoc_phong_ban.add(resultSet1.getString(2));
                hoten_nv_thuoc_phong_ban.add(resultSet1.getString(3));
            }

            phong_ban.add(thong_tin_pb);
            phong_ban.add(ms_nv_thuoc_phong_ban);
            phong_ban.add(username_nv_thuoc_phong_ban);
            phong_ban.add(hoten_nv_thuoc_phong_ban);

            resultSet1.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return phong_ban;
    }

    public void them_nhan_vien_moi(Object[] account_nv_moi, Object[] nhan_vien_moi) {
        try {
            this.preparedStatement = connect.prepareStatement("insert ignore into ACC values(?,?,?)");

            preparedStatement.setString(1, account_nv_moi[0].toString());
            preparedStatement.setString(2, account_nv_moi[1].toString());
            preparedStatement.setInt(3, (Integer) account_nv_moi[2]);

            preparedStatement.executeUpdate();

            this.preparedStatement = connect.prepareStatement("insert into THONGTINNV values(?,?,?,?,?,?,?,?,?)");
            for (int i = 0; i < nhan_vien_moi.length; i++) {
                if (nhan_vien_moi[i] == null)
                    this.preparedStatement.setString(i + 1, null);
                else
                    this.preparedStatement.setString(i + 1, nhan_vien_moi[i].toString());
            }
            this.preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<ArrayList<String>> thong_tin_nhan_vien(String input /* username or HoTen or MaSoNV */){
        ArrayList<ArrayList<String>> ttnv = new ArrayList<>();
        try {
            this.preparedStatement = connect.prepareStatement("select * from THONGTINNV where ? in(MaSoNV, HoTen, username)");
            preparedStatement.setString(1, input);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<String> msnv = new ArrayList<>();
            ArrayList<String> username = new ArrayList<>();
            ArrayList<String> name = new ArrayList<>();
            ArrayList<String> gender = new ArrayList<>();
            ArrayList<String> birth = new ArrayList<>();
            ArrayList<String> addr = new ArrayList<>();
            ArrayList<String> IDjob = new ArrayList<>();
            ArrayList<String> mspb = new ArrayList<>();
            ArrayList<String> bhxh = new ArrayList<>();


            while (resultSet.next()){
                msnv.add(resultSet.getString(1));
                username.add(resultSet.getString(2));
                name.add(resultSet.getString(3));
                gender.add(resultSet.getString(4));
                birth.add(resultSet.getString(5));
                addr.add(resultSet.getString(6));
                IDjob.add(resultSet.getString(7));
                mspb.add(resultSet.getString(8));
                bhxh.add(resultSet.getString(9));
            }

            ttnv.add(msnv);
            ttnv.add(username);
            ttnv.add(name);
            ttnv.add(gender);
            ttnv.add(birth);
            ttnv.add(addr);
            ttnv.add(IDjob);
            ttnv.add(mspb);
            ttnv.add(bhxh);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ttnv;
    }
}
