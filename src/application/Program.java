package application;

import db.DB;
import db.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pt = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            conn = DB.getConnection();
            pt = conn.prepareStatement(
                    "INSERT INTO seller " +
                       "(Name, Email, BirthDate, BaseSalary, DepartmentId) " +
                       "VALUES " +
                       "(?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS
            );
            pt.setString(1, "Kayke simao");
            pt.setString(2, "Kayke.simao@gmail.com");
            pt.setDate(3, new Date(sdf.parse("21/08/2004").getTime()));
            pt.setDouble(4, 4800);
            pt.setInt(5, 5);

            int rowAffecteds = pt.executeUpdate();
            if (rowAffecteds > 0) {
                ResultSet rs  = pt.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("DONE insertion ID=" + id);
                }
            } else {
                System.out.println("No row affected");
            }
        } catch (SQLException | ParseException e) {
            throw new DbException(e.getMessage());
        }
    }
}
