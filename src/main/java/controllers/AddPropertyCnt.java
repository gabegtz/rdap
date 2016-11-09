package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by kwashley on 11/5/2016.
 *
 * Controller class for the PropertyCreationPage.fxml
 *
 * This class will add properties into the database.
 */
public class AddPropertyCnt implements Initializable {

    //FXML Text fields
    public TextField value;
    public TextField sqFt;
    public TextField neigh_ID;
    public TextField house_Number;
    public TextField street;
    public TextField zipcode;
    public Button addprop;

    //Variables to be used by prepared statement
    private int propValue;
    private int propSqFt;
    private String propNeighID;
    private String propHousenum;
    private String propStreet;
    private String propZipcode;



    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void addProp(ActionEvent actionEvent) throws SQLException {
        DbConnection propCon = new DbConnection();
        Connection con = propCon.startConnection();

        propValue= Integer.parseInt(value.getText());
        propSqFt = Integer.parseInt(sqFt.getText());
        propNeighID = neigh_ID.getText();
        propHousenum = house_Number.getText();
        propStreet = street.getText();
        propZipcode = street.getText();

        String sql ="INSERT INTO dbo.PROPERTY(VALUE, NEIGH_ID, HOUSE_NUMBER, STREET, SQ_FT, ZIPCODE) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement propAdd = con.prepareStatement(sql);
        propAdd.setInt(1,propValue);
        propAdd.setString(2,propNeighID);
        propAdd.setString(3, propHousenum);
        propAdd.setString(4, propStreet);
        propAdd.setInt(5, propSqFt);
        propAdd.setString(6, propZipcode);

        propAdd.execute(); // [x].executeQuery() is used only when there is a ResultSet expected.
        con.close();

    }
}
