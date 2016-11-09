package controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Gabriel Gutierrez on 10/5/2016.
 */

public class LoginController implements Initializable {

    public String text;

    @FXML
    public Button login;

    @FXML
    public TextField agentID;

    @FXML
    public PasswordField password;

    private String upwd; //set User passwrord
    private String uname; // Set user name
    private UserVerification userVerification;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Window deployed");
    }


    public void userVer(Event event) throws IOException {

        upwd = password.getText();
        System.out.println(upwd);
        uname = agentID.getText();

        System.out.println(uname);

        try {
            userVerification = new UserVerification(uname,upwd);
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING, "Login failed. Please try another username/password combination");
            alert.showAndWait();
        }

        if (UserVerification.isVerified==true){
            System.out.println("True");
            newPage();

        }

    }



    private void verTrue(){
        Stage verified = new Stage();



        try {
            HelloWorld.stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void newPage() throws IOException {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../AgentLandingPage.fxml")); //Defines filepath to FXML file.
        newStage.setTitle("Welcome, " + UserVerification.usesh.getUser()); //
        newStage.setScene(new Scene(root));
        newStage.show();
        HelloWorld.stage.close();
    }


}
