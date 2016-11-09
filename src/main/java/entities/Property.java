package entities;

import controllers.DbConnection;
import javafx.beans.property.SimpleStringProperty;

import java.sql.*;


/**
 * Created by Gabriel Gutierrez on 10/29/2016.
 */
public class Property {
    String h_number;
    String h_street;
    public SimpleStringProperty number;
    public SimpleStringProperty street;
    public SimpleStringProperty status;
    //int zip;
    private DbConnection connection = new DbConnection();

    public Property(String h_number, String street, String status){
        this.h_number=h_number;
        this.h_street=street;
        //this.zip=zip;

        this.number = new SimpleStringProperty(h_number);
        this.street = new SimpleStringProperty(street);
        this.status = new SimpleStringProperty(status);
    }

    public SimpleStringProperty numberProperty(){
        return number;
    }

    public SimpleStringProperty streetProperty(){
        return street;
    }

    public SimpleStringProperty statusProperty(){
        return status;
    }
    public void addToDatabase() throws SQLException {
        Connection conn = connection.startConnection();

        String newAddress = "INSERT INTO dbo.ADDRESS(HOUSE_NUMBER, STREET) VALUES(?, ?) ";
        int FK = getAddressId(conn);
        String propertyFK = "INSERT INTO PROPERTY(ADDRESS_ID) VALUES ("+ FK + ");";


        PreparedStatement pstmt = conn.prepareStatement(newAddress);
        Statement propPstmt = conn.createStatement();
        pstmt.setString(1, h_number);
        pstmt.setString(2, h_street);

        //propPstmt.setString(1, h_number);
        //propPstmt.setString(2, street);
        /*pstmt.setString(4, h_number);
        pstmt.setString(5, street);
        pstmt.setInt(6, zip);*/
        pstmt.execute();
        propPstmt.execute(propertyFK);
        connection.CloseConnection();




    }

    public int getAddressId(Connection conn) {
        int addressId;
        try {
            PreparedStatement addressPstmt = conn.prepareStatement("SELECT ADDRESS_ID FROM ADDRESS WHERE HOUSE_NUMBER = ? AND STREET = ?");
            addressPstmt.setString(1, h_number);
            addressPstmt.setString(2, h_street);
            ResultSet addressRs = addressPstmt.executeQuery();
            while(addressRs.next()){
                addressId = addressRs.getInt("ADDRESS_ID");
                return addressId;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

            return 0;

    }
}
