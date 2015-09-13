/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03.pkg4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nick
 */
public class SQLiteConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String host = "jdbc:SQLite:C:\SQLite3\TeamMembers";
            Connection con = DriverManager.getConnection(host);
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM TeamMembers";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                int id_col = rs.getInt("ID");
                String first_name = rs.getString("First_Name");
                String last_name = rs.getString("Last_Name");
                String job = rs.getString("Job_Title");
                System.out.println(id_col + " " + first_name + " " + last_name + " " + job);
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
    
}
