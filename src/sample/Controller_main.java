package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller_main {
    @FXML
    private TextArea body;
    @FXML
    private TextField recipient;
    @FXML
    private TextField subject;
    @FXML
    private AnchorPane ap;

    //When the user presses send
     public void Click(ActionEvent event){

         //getting data from the Controller_login
        Node node = (Node) event.getSource();
        Scene scene = ap.getScene();
        Stage stage = (Stage) node.getScene().getWindow();
        User user = (User) stage.getUserData();

        String email = user.getEmail();
        String password = user.getPassword();
//        boolean dark_theme = user.isDarkMode();
//
//        System.out.println("Dark theme is " + dark_theme );
//        if (dark_theme){
//            scene.getStylesheets().add(getClass().getResource("login_page.css").toExternalForm());
//        }

         // Getting all the input from the GUI
         String message = body.getText();
         String receiver = recipient.getText();
         String sub = subject.getText();

         //Sending the email
         Sending_the_email.send(receiver, message, sub, email, password);

         //Emptying the body for next use
         Clear.empty(body);
         Clear.empty(recipient);

     }
}
