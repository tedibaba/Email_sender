package sample;

import java.sql.*;
import java.util.ArrayList;

public class sql_queries {


    //register the email and password to the database
    public static void register_email_and_password(String email, String passe) throws SQLException {
        //connecting to the database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_password?autoReconnect=true&useSSL=false", "root", "password");

        String sql = "insert into account (Email, Identification) values (?, ?)";
        PreparedStatement emailAndPassword = connection.prepareStatement(sql);
        emailAndPassword.setString(1, email);
        emailAndPassword.setString(2, passe);
        emailAndPassword.executeUpdate();
        System.out.println("Account has been registered");
    }

    //Check if the email is already in the database
    public static boolean checkIfEmailAndPasswordIsInDatabase(String email) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_password?autoReconnect=true&useSSL=false", "root", "password");
        String sql = "select * from account where account.Email = ?";
        PreparedStatement check = connection.prepareStatement(sql);
        check.setString(1, email);
        ResultSet rs = check.executeQuery();
        if (rs.next()){
            System.out.println("This already exists in the database");
            return true;
        } else {
            System.out.println("The login does not exist in the database");
            return false;
        }
    }

    public static boolean checkLoginInformation(String email, String password) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_password?autoReconnect=true&useSSL=false", "root", "password");
        String sql = "select * from account where account.Email = ? and account.Identification = ?";
        PreparedStatement check = connection.prepareStatement(sql);
        check.setString(1, email);
        check.setString(2, password);
        ResultSet rs = check.executeQuery();
        if (rs.next()){
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<String> autoComplete(String letters) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_password?autoReconnect=true&useSSL=false", "root", "password");
        String search = "'%" + letters + "%'";
        String sql = "select * from account where account.Email like" + search;
        PreparedStatement check = connection.prepareStatement(sql);
        ArrayList<String> possibleEmails = new ArrayList<>();
        ResultSet rs = check.executeQuery();
        int maxAmountOfResults = 0;
        while (rs.next() && maxAmountOfResults <= 4){
            possibleEmails.add(rs.getString("Email"));
            maxAmountOfResults++;
        }
        return possibleEmails;
    }

}
