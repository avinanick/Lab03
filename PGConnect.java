/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03.pkg3;

import java.sql.*;

/**
 *
 * @author Nick
 */
public class PGConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String host = "jdbc:postgresql://localhost:5432/";
            String uName = "postgres";
            String uPass = "nra2stoca";
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM \"public\".\"TeamMembers\"";
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();

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
