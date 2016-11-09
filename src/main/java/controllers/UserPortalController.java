package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gabriel Gutierrez on 10/5/2016.
 */

public class UserPortalController implements Initializable {

    
    public Button viewprop;
    public Button retomain;

    private void newWindow(){
        Stage verified = new Stage();



        try {
            HelloWorld.stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void newPage(String filename) throws IOException {

        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../" + filename)); //Defines filepath to FXML file.
        newStage.setTitle("Welcome, " + UserVerification.usesh.getUser()); //
        newStage.setScene(new Scene(root));
        newStage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void openProperties(ActionEvent actionEvent) throws IOException {

        newPage("viewProperties.fxml");
    }
}
