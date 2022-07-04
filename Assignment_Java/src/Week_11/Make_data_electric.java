package Week_11;

import java.sql.*;
import java.util.Random;

public class Make_data_electric {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /* Setting to connect mysql */
        String url = "jdbc:mysql://localhost:3306/week11";
        String uname = "root";
        String pass = "1";

        /* Connect database */
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println(">>Driver load successfully");

        Connection connect = DriverManager.getConnection(url, uname, pass);
        System.out.println("\n>>Database Connected\n");

        /* DDL entry */
        Statement statement = connect.createStatement();
        PreparedStatement preparedStatement;

        Random random = new Random();

        /* Value pool to generate database "by electric" */
        String[] first_name_pool = {"Bui", "Tran", "Le", "Nguyen", "Vu", "Trinh", "Dao", "Dam", "Pham", "Thai", "Ho", "Hoang"};
        String[] last_name_pool = {"Tuan Anh", "Quy Hoang", "Thi Van", "Anh Tien", "Quoc Thinh", "Ngoc Thien",
                "Thu Hang", "Van Hung", "Van Nam", "Tuan Sang", "Cong Chuc", "Quang Sang", "Cong Tuyen",
                "Duc Thinh", "Quoc Khanh", "Van Tung", "Cong Son", "Van Anh", "Le Bao", "Thi Ngan", "Thu Quyen",
                "Ngoc Khanh", "Van Bac", "Hien Ho", "Thu Hien", "Thi Nu", "Thao Mai", "Thi Anh", "Anh Vien"};

        String[] gender_pool = {"Nam", "Nu", "Other"};
        int[] classID_pool = {130130, 130131, 130132, 130133, 130134,
                130135, 130136, 130137, 130138, 130139, 130140, 140123, 142540, 139234, 150284, 154982, 111290};

        String[] subject_arr = {"LTNC", "MMT", "KTMT", "HDH", "GT1", "GT2", "GT3", "CSTSL", "DS",
                "DTS", "DTTT1", "DTTT2", "TTS", "XLTHS", "CTDL&GT", "AI", "XLA"};
        int[] semesterCode_pool = {20201, 20202, 20211, 20212, 20221, 20222};

        String[] sqlString = {"Insert into Student" + "(studentID, first_name, last_name, gender, DoB, classID)" + "Values(?,?,?,?,?,?)",
                "Insert into Subject" + "(subjectID, subjectName, credits)" + "Values(?,?,?)",
                "Insert into Class" + "(classID, className, classSize, Note)" + "Values(?,?,?,?)",
                "Insert into Mark" + "(studentID, subjectID, semesterCode, mark)" + "Values((select studentID from Student where studentID = ?) ,(select subjectID from Subject where subjectID = ?),?,?)"
        };


        /* Generate database by electric */
        int i = 1;

        // Student table
        while (i < 101) {
            preparedStatement = connect.prepareStatement(sqlString[0]);
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, first_name_pool[random.nextInt(first_name_pool.length)]);
            preparedStatement.setString(3, last_name_pool[random.nextInt(last_name_pool.length)]);
            preparedStatement.setString(4, gender_pool[random.nextInt(gender_pool.length)]);
            preparedStatement.setString(5, "WTF is that attribute");
            preparedStatement.setInt(6, classID_pool[random.nextInt(classID_pool.length)]);
            i++;
            preparedStatement.executeUpdate();
        }

        // Subject table
        i = 1;
        while (i < subject_arr.length + 1) {
            preparedStatement = connect.prepareStatement(sqlString[1]);
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, subject_arr[i - 1]);
            preparedStatement.setDouble(3, random.nextDouble() * 3000000);
            i++;
            preparedStatement.executeUpdate();
        }
        System.out.println("Insert Subject successful !");

        // Class table
        i = 1;
        while (i < classID_pool.length + 1) {
            preparedStatement = connect.prepareStatement(sqlString[2]);
            preparedStatement.setInt(1, i);
            preparedStatement.setInt(2, classID_pool[i - 1]);
            preparedStatement.setInt(3, random.nextInt(11) + 50);
            preparedStatement.setString(4, "No thing to note");
            i++;
            preparedStatement.executeUpdate();
        }
        System.out.println("Insert Class successful !");

        // Mark table
        i = 1;
        while (i < 100) {
            preparedStatement = connect.prepareStatement(sqlString[3]);
            preparedStatement.setInt(1, random.nextInt(52) + 1);
            preparedStatement.setInt(2, random.nextInt(8) + 1);
            preparedStatement.setInt(3, semesterCode_pool[random.nextInt(semesterCode_pool.length)]);
            preparedStatement.setDouble(4, random.nextDouble() * 10);
            i++;
            preparedStatement.executeUpdate();
        }
        System.out.println("Insert Mark successful !\n");

        System.out.println(">>Insert all tables successful !");
        connect.close();
    }
}
