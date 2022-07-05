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

    /**
     * Chuc nang tra cuu, tim kiem thong tin
     */

    public ArrayList<ArrayList<Object>> thong_tin_phong_ban(String idPhongBan) {
        ArrayList<ArrayList<Object>> phong_ban = new ArrayList<>();
        try {
            this.preparedStatement = connect.prepareStatement("select * from PHONGBAN where MaPhongBan=?");
            this.preparedStatement.setString(1, idPhongBan);
            ResultSet resultSet = this.preparedStatement.executeQuery();
            ArrayList<Object> thong_tin_pb = new ArrayList<>();
            while (resultSet.next()) {
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

            ArrayList<Object> ms_nv_thuoc_phong_ban = new ArrayList<>();
            ArrayList<Object> username_nv_thuoc_phong_ban = new ArrayList<>();
            ArrayList<Object> hoten_nv_thuoc_phong_ban = new ArrayList<>();

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

    public ArrayList<ArrayList<Object>> thong_tin_nhan_vien(Object input /* username or HoTen or MaSoNV */) {
        ArrayList<ArrayList<Object>> ttnv = new ArrayList<>();
        try {
            this.preparedStatement = connect.prepareStatement("select * from THONGTINNV where ? in(MaSoNV, HoTen, username)");
            preparedStatement.setString(1, (String) input);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Object> msnv = new ArrayList<>();
            ArrayList<Object> username = new ArrayList<>();
            ArrayList<Object> name = new ArrayList<>();
            ArrayList<Object> gender = new ArrayList<>();
            ArrayList<Object> birth = new ArrayList<>();
            ArrayList<Object> addr = new ArrayList<>();
            ArrayList<Object> IDjob = new ArrayList<>();
            ArrayList<Object> mspb = new ArrayList<>();
            ArrayList<Object> bhxh = new ArrayList<>();


            while (resultSet.next()) {
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

    public ArrayList<ArrayList<Object>> thong_tin_chuc_vu(Object idChucVu /* id chuc vu */) {
        ArrayList<ArrayList<Object>> ttcv = new ArrayList<>();
        try {
            this.preparedStatement = connect.prepareStatement("select THONGTINNV.IDChucVu, THONGTINNV.MaSoNV, THONGTINNV.HoTen, THONGTINNV.MaPhongBan, PHONGBAN.TenPhong, PHONGBAN.DienThoaiPhong, PHONGBAN.DiaChiPhongBan" +
                    " from THONGTINNV inner join PHONGBAN on THONGTINNV.MaPhongBan=PHONGBAN.MaPhongBan where THONGTINNV.IDChucVu=?");
            preparedStatement.setString(1, (String) idChucVu);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Object> idchucvu = new ArrayList<>();
            ArrayList<Object> msnv = new ArrayList<>();
            ArrayList<Object> hoten = new ArrayList<>();
            ArrayList<Object> mpb = new ArrayList<>();
            ArrayList<Object> tenphong = new ArrayList<>();
            ArrayList<Object> sdt = new ArrayList<>();
            ArrayList<Object> addr = new ArrayList<>();

            while (resultSet.next()) {
                idchucvu.add(resultSet.getString(1));
                msnv.add(resultSet.getString(2));
                hoten.add(resultSet.getString(3));
                mpb.add(resultSet.getString(4));
                tenphong.add(resultSet.getString(5));
                sdt.add(resultSet.getString(6));
                addr.add(resultSet.getString(7));
            }

            ttcv.add(idchucvu);
            ttcv.add(msnv);
            ttcv.add(hoten);
            ttcv.add(mpb);
            ttcv.add(tenphong);
            ttcv.add(sdt);
            ttcv.add(addr);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ttcv;
    }

    public ArrayList<ArrayList<Object>> thong_tin_luong(Object input /* MaCong, MaSoNV */){
        ArrayList<ArrayList<Object>> ttl = new ArrayList<>();
        try{
            this.preparedStatement = connect.prepareStatement("select THONGTINNV.MaSoNV, CHAMCONG.MaCong, CHAMCONG.Thang," +
                    " CHAMCONG.SoNgayLamViec, CHAMCONG.SoGioLamViec, CHUCVU.HSLuong, CHUCVU.Bonus, CHUCVU.PhuCap" +
                    " from CHAMCONG inner join THONGTINNV on THONGTINNV.MaSoNV=CHAMCONG.MaSoNV" +
                    " inner join CHUCVU on THONGTINNV.IDChucVu=CHUCVU.IDChucVu" +
                    " where ? in (CHAMCONG.MaCong, CHAMCONG.MaSoNV)");

            preparedStatement.setString(1, (String)input);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Object> msnv = new ArrayList<>();
            ArrayList<Object> mc = new ArrayList<>();
            ArrayList<Object> thang = new ArrayList<>();
            ArrayList<Object> day = new ArrayList<>();
            ArrayList<Object> hour = new ArrayList<>();
            ArrayList<Object> hsl = new ArrayList<>();
            ArrayList<Object> bonus = new ArrayList<>();
            ArrayList<Object> phucap = new ArrayList<>();

            while(resultSet.next()){
                msnv.add(resultSet.getString(1));
                mc.add(resultSet.getString(2));
                thang.add(resultSet.getString(3));
                day.add(resultSet.getInt(4));
                hour.add(resultSet.getInt(5));
                hsl.add(resultSet.getFloat(6));
                bonus.add(resultSet.getFloat(7));
                phucap.add(resultSet.getFloat(8));
            }

            ttl.add(msnv);
            ttl.add(mc);
            ttl.add(thang);
            ttl.add(day);
            ttl.add(hour);
            ttl.add(hsl);
            ttl.add(bonus);
            ttl.add(phucap);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return ttl;
    }

    /**
     * Chuc nang sua doi, chinh sua databases
     */
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

}
