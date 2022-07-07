package BackEnd_Project;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

import java.sql.*;
import java.util.ArrayList;

public class Backend {
    private Statement statement;
    private PreparedStatement preparedStatement;
    private Connection connect;

    public Backend() {
        /* Setting to connect mysql */
        String url = "jdbc:mysql://localhost:3306/Java";
        String uname = "root";
        String pass = "1";

        try {
            /* Connect database */
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(">>Driver load successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver error !!!");
        }

        try {
            this.connect = DriverManager.getConnection(url, uname, pass);
            System.out.println("\n>>Database Connected\n");

            this.statement = this.connect.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     *  For both staff and admin
     *
     * */

    /**
     * Chuc nang tra cuu, tim kiem thong tin
     */

    public ArrayList<ArrayList<Object>> thong_tin_phong_ban(Object idPhongBan) throws SQLException {

        ArrayList<ArrayList<Object>> phong_ban = new ArrayList<>();

        try {
            /* DDL */
            this.preparedStatement = connect.prepareStatement("select * from PHONGBAN where MaPhongBan=?");

            this.preparedStatement.setString(1, (String) idPhongBan);
            ResultSet resultSet = this.preparedStatement.executeQuery();

            /* Array to store thong tin phong ban */
            ArrayList<Object> thong_tin_pb = new ArrayList<>();

            /* write from database to array */
            while (resultSet.next()) {
                thong_tin_pb.add(resultSet.getString(1));
                thong_tin_pb.add(resultSet.getString(2));
                thong_tin_pb.add(resultSet.getString(3));
                thong_tin_pb.add(resultSet.getString(4));
            }

            /* throw exception if MaPhongBan not exist in database --> array is empty */
            if (thong_tin_pb.isEmpty()) {
                resultSet.close();
                throw new ValueNotAvailableInDatabase("ID Phong Ban doesn't exist !");
            } else {
                this.preparedStatement.clearParameters();
                resultSet.close();

                this.preparedStatement = connect.prepareStatement("select MaSoNV, username, HoTen " +
                        "from THONGTINNV inner join PHONGBAN on THONGTINNV.MaPhongBan=PHONGBAN.MaPhongBan " +
                        "where THONGTINNV.MaPhongBan=?");
                this.preparedStatement.setString(1, (String) idPhongBan);
                ResultSet resultSet1 = this.preparedStatement.executeQuery();

                /* Array to store column by column from data in database */
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
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ValueNotAvailableInDatabase e) {
            System.out.println(e);
        }

        return phong_ban;
    }

    public ArrayList<ArrayList<Object>> thong_tin_nhan_vien(Object input /* username or HoTen or MaSoNV */) {

        ArrayList<ArrayList<Object>> ttnv = new ArrayList<>();

        try {
            /* DDL */
            this.preparedStatement = connect.prepareStatement("select * from THONGTINNV where ? in(MaSoNV, HoTen, username)");

            preparedStatement.setString(1, (String) input);
            ResultSet resultSet = preparedStatement.executeQuery();

            /* Array to store each column from database queried */
            ArrayList<Object> msnv = new ArrayList<>();
            ArrayList<Object> username = new ArrayList<>();
            ArrayList<Object> name = new ArrayList<>();
            ArrayList<Object> gender = new ArrayList<>();
            ArrayList<Object> birth = new ArrayList<>();
            ArrayList<Object> addr = new ArrayList<>();
            ArrayList<Object> IDjob = new ArrayList<>();
            ArrayList<Object> mspb = new ArrayList<>();
            ArrayList<Object> bhxh = new ArrayList<>();

            /* Write into array */
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

            /* Throw exception if Nhan Vien not available in database */
            if (msnv.isEmpty()) {
                resultSet.close();
                throw new ValueNotAvailableInDatabase("Nhan Vien doesn't exist !");
            } else {
                ttnv.add(msnv);
                ttnv.add(username);
                ttnv.add(name);
                ttnv.add(gender);
                ttnv.add(birth);
                ttnv.add(addr);
                ttnv.add(IDjob);
                ttnv.add(mspb);
                ttnv.add(bhxh);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ValueNotAvailableInDatabase e) {
            System.out.println(e);
        }
        return ttnv;
    }

    public ArrayList<ArrayList<Object>> thong_tin_chuc_vu(Object idChucVu /* id chuc vu */) {

        ArrayList<ArrayList<Object>> ttcv = new ArrayList<>();

        try {
            /* DDL */
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

            if (idchucvu.isEmpty()) {
                resultSet.close();
                throw new ValueNotAvailableInDatabase("ID Chuc Vu doesn't exist !");
            } else {
                ttcv.add(idchucvu);
                ttcv.add(msnv);
                ttcv.add(hoten);
                ttcv.add(mpb);
                ttcv.add(tenphong);
                ttcv.add(sdt);
                ttcv.add(addr);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ValueNotAvailableInDatabase e) {
            System.out.println(e);
        }
        return ttcv;
    }

    public ArrayList<ArrayList<Object>> thong_tin_luong(Object input /* MaCong, MaSoNV */) {

        ArrayList<ArrayList<Object>> ttl = new ArrayList<>();

        try {
            /* DDL */
            this.preparedStatement = connect.prepareStatement("select THONGTINNV.MaSoNV, CHAMCONG.MaCong, CHAMCONG.Thang," +
                    " CHAMCONG.SoNgayLamViec, CHAMCONG.SoGioLamViec, CHUCVU.HSLuong, CHUCVU.Bonus, CHUCVU.PhuCap" +
                    " from CHAMCONG inner join THONGTINNV on THONGTINNV.MaSoNV=CHAMCONG.MaSoNV" +
                    " inner join CHUCVU on THONGTINNV.IDChucVu=CHUCVU.IDChucVu" +
                    " where ? in (CHAMCONG.MaCong, CHAMCONG.MaSoNV)");

            preparedStatement.setString(1, (String) input);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Object> msnv = new ArrayList<>();
            ArrayList<Object> mc = new ArrayList<>();
            ArrayList<Object> thang = new ArrayList<>();
            ArrayList<Object> day = new ArrayList<>();
            ArrayList<Object> hour = new ArrayList<>();
            ArrayList<Object> hsl = new ArrayList<>();
            ArrayList<Object> bonus = new ArrayList<>();
            ArrayList<Object> phucap = new ArrayList<>();

            while (resultSet.next()) {
                msnv.add(resultSet.getString(1));
                mc.add(resultSet.getString(2));
                thang.add(resultSet.getString(3));
                day.add(resultSet.getInt(4));
                hour.add(resultSet.getInt(5));
                hsl.add(resultSet.getFloat(6));
                bonus.add(resultSet.getFloat(7));
                phucap.add(resultSet.getFloat(8));
            }

            if (msnv.isEmpty()) {
                resultSet.close();
                throw new ValueNotAvailableInDatabase("ID Nhan Vien or Ma Cong doesn't exist !");
            } else {
                ttl.add(msnv);
                ttl.add(mc);
                ttl.add(thang);
                ttl.add(day);
                ttl.add(hour);
                ttl.add(hsl);
                ttl.add(bonus);
                ttl.add(phucap);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ValueNotAvailableInDatabase e) {
            System.out.println(e);
        }
        return ttl;
    }

    /**
     * Chuc nang sua doi, chinh sua databases
     */

    public Object dang_nhap(Object username, Object password) {
        Object quyen = null;
        try {
            this.preparedStatement = this.connect.prepareStatement("select * from ACC where username=?");

            this.preparedStatement.setString(1, (String) username);
            ResultSet resultSet = this.preparedStatement.executeQuery();

            String user = "";
            String pass = "";


            while (resultSet.next()) {
                user = resultSet.getString(1);
                pass = resultSet.getString(2);
                quyen = resultSet.getInt(3);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quyen;
    }

    public void sua_tai_khoan(Object old_username, Object old_password, Object new_username, Object new_password) {
        try {
            /* Verify old username and password before change */
            this.preparedStatement = this.connect.prepareStatement("select username, password from ACC where username=?");

            this.preparedStatement.setString(1, (String) old_username);
            ResultSet resultSet = this.preparedStatement.executeQuery();

            String username = "";
            String pass = "";

            while (resultSet.next()) {
                username = resultSet.getString(1);
                pass = resultSet.getString(2);
            }

            if (username.isEmpty()) {
                throw new ValueNotAvailableInDatabase("username doesn't exist !!!");
            } else if (!pass.equals((String) old_password)) {
                System.out.println("Verify fail: Wrong password !!!");
                resultSet.close();
                return;

            } else {
                resultSet.close();
                this.preparedStatement = this.connect.prepareStatement("update ACC " +
                        "set username=?, password=? where username=?");

                this.preparedStatement.setString(1, (String) new_username);
                this.preparedStatement.setString(2, (String) new_password);
                this.preparedStatement.setString(3, (String) old_username);

                this.preparedStatement.executeUpdate();
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: New username already exist !!!");
        } catch (ValueNotAvailableInDatabase e) {
            System.out.println(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void sua_thong_tin_nhan_vien_staff(Object maSoNhanVien, Object Hoten, Object gender, Object ngaySinh, Object address, Object BHXH) {
        try {
            /* check if Ma So NV exist in database */
            this.preparedStatement = this.connect.prepareStatement("select MaSoNV from THONGTINNV where MaSoNV=?");

            this.preparedStatement.setString(1, (String) maSoNhanVien);
            ResultSet resultSet = this.preparedStatement.executeQuery();

            String tmp = "";
            while (resultSet.next())
                tmp = resultSet.getString(1);

            if (tmp.isEmpty())
                throw new ValueNotAvailableInDatabase("Ma So Nhan Vien doesn't exist in database !!!");
            else {
                this.preparedStatement = connect.prepareStatement("update THONGTINNV " +
                        "set HoTen=?," +
                        "GioiTinh=?," +
                        "NgaySinh=?," +
                        "DiaChi=?," +
                        "BHXH=? " +
                        "where MaSoNV=?");

                this.preparedStatement.setString(1, (String) Hoten);
                this.preparedStatement.setString(2, (String) gender);
                this.preparedStatement.setString(3, (String) ngaySinh);
                this.preparedStatement.setString(4, (String) address);
                this.preparedStatement.setString(5, (String) BHXH);
                this.preparedStatement.setString(6, (String) maSoNhanVien);

                this.preparedStatement.executeUpdate();
            }
        } catch (ValueNotAvailableInDatabase e) {
            System.out.println(e);
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Ho Ten cann't be null !!!");
        } catch (MysqlDataTruncation e) {
            System.out.println("Ngay Sinh is in the wrong format .Format is YYYY-MM-DD !!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * only for database admin
     */
    public void them_nhan_vien_moi(Object[] account_nv_moi, Object[] nhan_vien_moi) {
        /* insert ACC first */
        try {
            this.preparedStatement = connect.prepareStatement("insert into ACC values(?,?,?)");

            this.preparedStatement.setString(1, account_nv_moi[0].toString());
            this.preparedStatement.setString(2, account_nv_moi[1].toString());
            this.preparedStatement.setInt(3, (Integer) account_nv_moi[2]);

            this.preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("username already exist !!!");
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            this.preparedStatement = connect.prepareStatement("insert into THONGTINNV values(?,?,?,?,?,?,?,?,?)");
            for (int i = 0; i < nhan_vien_moi.length; i++) {
                if (nhan_vien_moi[i] == null)
                    this.preparedStatement.setString(i + 1, null);
                else
                    this.preparedStatement.setString(i + 1, nhan_vien_moi[i].toString());
            }
            this.preparedStatement.executeUpdate();
        } catch (SQLException e) {
            /* if insert Nhan Vien error after insert ACC successfully --> delete account is just created */
            try {
                this.preparedStatement = connect.prepareStatement("delete from ACC where username=?");
                this.preparedStatement.setString(1, (String) account_nv_moi[0]);
                this.preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    public void sua_thong_tin_nhan_vien_admin(Object MaSoNV, Object IDChucVu_new, Object MaPhongBan_new) {
        try {
            /* check if Ma So NV not in database */
            this.preparedStatement = this.connect.prepareStatement("select MaSoNV from THONGTINNV where MaSoNV=?");

            this.preparedStatement.setString(1, (String) MaSoNV);
            ResultSet resultSet = this.preparedStatement.executeQuery();

            String tmp = "";
            while (resultSet.next())
                tmp = resultSet.getString(1);

            if (tmp.isEmpty())
                throw new ValueNotAvailableInDatabase("Ma So Nhan Vien dowsn't exist in database !!!");
            else {
                this.preparedStatement = this.connect.prepareStatement("update THONGTINNV " +
                        "set IDChucVu=?," +
                        "MaPhongBan=?" +
                        " where ? in (MaSoNV)");

                this.preparedStatement.setString(1, (String) IDChucVu_new);
                this.preparedStatement.setString(2, (String) MaPhongBan_new);
                this.preparedStatement.setString(3, (String) MaSoNV);
                this.preparedStatement.executeUpdate();
            }
        } catch (ValueNotAvailableInDatabase e) {
            System.out.println(e);
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("ID Chuc Vu or Ma Phong Ban doesn't exist !!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
