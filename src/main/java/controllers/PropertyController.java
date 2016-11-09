package controllers;

import entities.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by gegutier on 11/3/2016.
 *
 * This controller is in charge of extracting information of properties assigned to agents.
 * fxml used: viewProperties.fxml
 *
 * Pulls session from controllers.UserSession
 */

public class PropertyController implements Initializable {
    //FXML components
    public TableColumn h_number;
    public TableColumn s_name;
    public TableColumn status;
    public TableView property_table;


    private String uname = UserVerification.usesh.getUser(); //Gets username
    private int user_id; // Gets userID from dbo.AGENT. Loook at sql statement for more clarity.

    //This shows properties based on user.
    public void propertyList() throws SQLException {
        DbConnection dbHelper = new DbConnection();
        Connection con = dbHelper.startConnection();
        ObservableList<Property> data = FXCollections.observableArrayList();

            PreparedStatement pstmt = con.prepareStatement("SELECT AGENT_ID FROM dbo.AGENT JOIN dbo.ACCOUNT ON dbo.ACCOUNT.USERNAME = dbo.AGENT.USERNAME WHERE dbo.AGENT.USERNAME=?");
            System.out.println(uname);
            pstmt.setString(1, uname);
            System.out.println(pstmt);
            ResultSet userID_results = pstmt.executeQuery();
            System.out.println(pstmt.toString());
            while (userID_results.next()) {
                user_id = userID_results.getInt("AGENT_ID");
                System.out.println(user_id);
            }

            //Here
            /*SELECT * FROM ADDRESS  RIGHT JOIN dbo.PROPERTY ON dbo.PROPERTY.ADDRESS_ID = dbo.ADDRESS.ADDRESS_ID  RIGHT JOIN TRANS_ACTION ON dbo.PROPERTY.PROPERTY_ID = dbo.TRANS_ACTION.PROPERTY_ID WHERE AGENT_ID = ?*/
            PreparedStatement prop_pstmt = con.prepareStatement("SELECT * FROM PROPERTY RIGHT JOIN dbo.TRANS_ACTION ON dbo.PROPERTY.PROPERTY_ID = dbo.TRANS_ACTION.PROPERTY_ID WHERE AGENT_ID = ?");
            prop_pstmt.setInt(1, user_id);
            ResultSet prop_results = prop_pstmt.executeQuery();
            while (prop_results.next()) {
                System.out.println(prop_results.getString("HOUSE_NUMBER") + prop_results.getString("STREET") + prop_results.getString("STATUS"));
                data.add(new Property(prop_results.getString("HOUSE_NUMBER"), prop_results.getString("STREET"), prop_results.getString("STATUS")));

                System.out.println("added");

            }
            property_table.setItems(data);



        }


        @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Populates table cells based on fx:text
        h_number.setCellValueFactory(new PropertyValueFactory("number"));
        s_name.setCellValueFactory(new PropertyValueFactory("street"));
        status.setCellValueFactory(new PropertyValueFactory("status"));
            try {
                propertyList();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
}
