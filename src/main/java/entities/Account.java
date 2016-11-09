package entities;

import controllers.DbConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Gabriel Gutierrez on 10/29/2016.
 */
public class Account {
    private static String username;
    private static String password;
    private static java.sql.Date c_date;

    private DbConnection connection = new DbConnection();

    public Account(String username, String password, Date c_date) throws SQLException {
        this.username=username;
        this.password=password;
        this.c_date = c_date;
        addToDatabase();
    }

    public void addToDatabase() throws SQLException {

        String newUser = "INSERT INTO ACCOUNT(USERNAME, PASSWORD, ROLE, CREATE_DATE) VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt = connection.startConnection().prepareStatement(newUser);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        pstmt.setString(3, "Agent");
        pstmt.setDate(4, c_date);
        pstmt.execute();
        pstmt.close();
        connection.CloseConnection();




    }

}

