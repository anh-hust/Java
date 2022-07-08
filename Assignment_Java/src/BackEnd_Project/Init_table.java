package BackEnd_Project;

import java.sql.*;

public class Init_table {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /* Setting to connect mysql */
        String url = "jdbc:mysql://localhost:3306/Java";
        String uname = "root";
        String pass = "1";

        /* Connect database */
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println(">>Driver load successfully");

        Connection connect = DriverManager.getConnection(url, uname, pass);
        System.out.println("\n>>Database Connected");

        /* DDL entry */
        Statement statement = connect.createStatement();
        PreparedStatement preparedStatement;

        /* Delete old database */
        statement = connect.createStatement();
        statement.executeUpdate("drop database Java");
        System.out.println("\n>>Drop successfully !");

        /* Create new one, initialize an empty database with attributes of all table */
        statement.execute("create database Java");

        /* Bảng Account */
        statement.execute("use Java");
        statement.execute("create table ACC(username varchar(20) not null," +
                "password varchar(20) not null," +
                "Quyen int not null," +
                "primary key (username))");
        System.out.println("\n>>ACC table done !");

        /* Bang chuc vu */
        statement.execute("create table CHUCVU(IDChucVu varchar(20) not null," +
                "ChucVu varchar(30) not null unique," +
                "HSLuong float not null," +
                "Bonus float not null," +
                "PhuCap float not null," +
                "primary key (IDChucVu))");
        System.out.println("\n>>CHUCVU table done !");

        /* Bang phong ban */
        statement.execute("create table PHONGBAN(MaPhongBan varchar(20) not null," +
                "TenPhong varchar(50) not null unique," +
                "DienThoaiPhong varchar(15) not null unique," +
                "DiaChiPhongBan varchar(50) not null unique," +
                "primary key (MaPhongBan))");
        System.out.println("\n>>PHONGBAN table done !");

        /* Bang thong tin nhan vien */
        statement.execute("create table THONGTINNV(MaSoNV varchar(20) not null," +
                "username varchar(20) not null unique," +
                "HoTen varchar(30) not null," +
                "GioiTinh char(5)," +
                "NgaySinh DATE," +
                "DiaChi varchar(50)," +
                "IDChucVu varchar(20) not null," +
                "MaPhongBan varchar(20) not null," +
                "BHXH varchar(20)," +
                "primary key (MaSoNV)," +
                "foreign key (MaPhongBan) references PHONGBAN(MaPhongBan) on update cascade," +
                "foreign key (username) references ACC(username) on update cascade," +
                "foreign key (IDChucVu) references CHUCVU(IDChucVu) on update cascade)");
        System.out.println("\n>>THONGTINNV table done !");

        /* Bang cham cong */
        statement.execute("create table CHAMCONG(MaCong varchar(20) not null," +
                "Thang date not null," +
                "SoNgayLamViec int not null," +
                "SoGioLamViec int not null," +
                "MaSoNV varchar(20) not null," +
                "primary key(MaCong)," +
                "foreign key (MaSoNV) references  THONGTINNV(MaSoNV) on update cascade)");
        System.out.println("\n>>CHAMCONG table done !");

        connect.close();
        System.out.println("Close connection. All done !");
    }
}
