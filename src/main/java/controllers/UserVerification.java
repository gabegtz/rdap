package controllers;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserVerification {
	String sql = null;

	DbConnection dbHelp = new DbConnection(); //Instantiating dbHelp
	Connection conn;
    public static UserSession usesh;
    public static boolean isVerified;

    public UserVerification(String username, String password) throws SQLException {
		conn = dbHelp.startConnection();

		sql = "SELECT * FROM dbo.ACCOUNT WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password+"';";
		System.out.println(sql);

		ResultSet userResult = null;

			Statement stmt = conn.createStatement();
			userResult = stmt.executeQuery(sql);
        if(!(userResult.next())){
            throw new SQLException("No fields match.");
        }
       // System.out.println(userResult.next());
        else {
            isVerified = true;
            usesh = new UserSession(username);
        }


		try {
			dbHelp.CloseConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
