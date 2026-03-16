package application;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "UPDATE seller SET BaseSalary = BaseSalary * ? + BaseSalary  WHERE id = ?"
            );

            st.setDouble(1, 0.3);
            st.setInt(2, 7);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! rows affected: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}