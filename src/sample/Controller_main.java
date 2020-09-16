package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller_main {
    @FXML
    private TextArea body;
    @FXML
    private TextField recipient;
    @FXML
    private TextField subject;

    //When the user presses send
     public void Click(String user, String pass){

         //trying to get data from the Controller_login
         System.out.println(user);
         String username = "email";
         String password = "password";

         // Getting all the input from the GUI
         String message = body.getText();
         String receiver = recipient.getText();
         String sub = subject.getText();

         //Sending the email
         Sending_the_email.send( receiver, message, sub, username, password);

         //Emptying the body for next use
         Clear.empty(body);
         Clear.empty(recipient);

     }



}
