package controllers;

import entities.Agent;
import entities.Property;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;


/**
 * Created by Gabriel Gutierrez on 10/4/2016.
 */
public class HelloWorld  extends Application {


    public static Stage stage;
    public static boolean workaround;
    public static void main(String[] args) throws SQLException {
        launch(args);

        hardCodedWorkaround();

    }

   @Override // Main window deployment
    public void start(Stage primaryStage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("../AgentIDLogin.fxml")); //Defines filepath to FXML file.
       primaryStage.setTitle("Remax Business Process"); //
       primaryStage.setScene(new Scene(root));
       primaryStage.show();
       stage = primaryStage;
   }
       // runTests();
   // }

    private static void hardCodedWorkaround(){
        workaround = true;



    }
    private static void runTests() throws SQLException {
       // Date today = new Date(Calendar.getInstance().getTimeInMillis());
        //Property UH = new Property("5236","Calhoun Rd.", 56000000, 2000);
        //Account newAccount = new Account("gegutier", "123", today);
       // UserVerification uVer = new UserVerification("gegutier","123");
       // Agent gabe = new Agent ("fuckmicrosoft", "123", null);
       // Property x = new Property ("12111", "Test Street", 77082);
        ///x.addToDatabase();
        //connection.StartConnection();
        //        connection.CloseConnection();


        //I've made a change.

    }




}
