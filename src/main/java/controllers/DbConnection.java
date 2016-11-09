package controllers; /**
 * Created by Gabriel Gutierrez on 10/22/2016.
 */
import com.microsoft.sqlserver.jdbc.*;

import java.sql.*;

public class DbConnection {
    Connection conn =null;

    public Connection startConnection(){

        SQLServerDataSource ds = new SQLServerDataSource();
        // ds.setIntegratedSecurity(true);
        // ds.setServerName("COT-CIS3365-06");
        // ds.setPortNumber(1433);
        ds.setDatabaseName("RDAP");
        ds.setUser("application");
        ds.setPassword("Gabodel8*");

        try {
            conn=ds.getConnection();
        } catch (SQLServerException e) {
            e.printStackTrace();
            System.out.println("Exception: " + e);
        }
        System.out.println("Connected");
        return conn;


    }

    public void CloseConnection() throws SQLException {
        conn.close();
        if(conn.isClosed()){
            System.out.println("Connection closed");
        }
        else{System.out.println("Connection is still open, dingus");}
    }

  /*  public void executeQuery(PreparedStatement statement) throws SQLException {
        PreparedStatement stmt = startConnection().prepareStatement(statement);
        stmt.setString();
        stmt.execute();
        results = stmt.executeQuery(statement);
        while (results.next()){
            System.out.println(results.getString(3));

        }
        stmt.close();


        return results;

    }*/





}
