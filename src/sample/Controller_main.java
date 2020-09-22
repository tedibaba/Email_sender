package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller_main {
    @FXML
    private TextArea body;
    @FXML
    private TextField recipient;
    @FXML
    private TextField subject;
    @FXML
    private AnchorPane ap;

    private Desktop desktop = Desktop.getDesktop();

    private ArrayList<ArrayList<String>> image = new ArrayList<>();

    //When the user presses send
     public void Click(ActionEvent event){

         //getting data from the Controller_login
        Node node = (Node) event.getSource();
        Scene scene = ap.getScene();
        Stage stage = (Stage) node.getScene().getWindow();
        User user = (User) stage.getUserData();

        String email = user.getEmail();
        String password = user.getPassword();

         // Getting all the input from the GUI
         String message = body.getText();
         String receiver = recipient.getText();
         String sub = subject.getText();

         //Sending the email
         Sending_the_email.send(receiver, message, sub, email, password, image);

         //Emptying the body for next use
         Clear.empty(body);
         Clear.empty(recipient);
     }

     //Attaching images to the email
     public void attachImages(ActionEvent event){
         Node node = (Node) event.getSource();
         Scene scene = ap.getScene();
         Stage stage = (Stage) node.getScene().getWindow();
         FileChooser filechooser = new FileChooser();
         File file = filechooser.showOpenDialog(stage);
         image.add(fileNameAndPath(file));
         System.out.println(file.getAbsolutePath());
     }

     private ArrayList<String> fileNameAndPath(File file){
         ArrayList<String> pathAndName = new ArrayList<>();
         pathAndName.add(file.getAbsolutePath());
         pathAndName.add(file.getName());
         return pathAndName;
     }

}

