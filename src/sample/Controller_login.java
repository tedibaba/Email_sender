package sample;

import com.sun.glass.ui.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.regex.*;
import java.sql.*;

import java.io.IOException;

public class Controller_login{

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Label incorrect;
    @FXML
    private CheckBox dark_mode;
    @FXML
    private Button register;

    private Parent root;

    public void Change_scene_and_get_login_info(ActionEvent event) throws IOException, SQLException {
        String email = username.getText();
        String passe = password.getText();

        //Making sure the email is a gmail one as this only works with gmail
        String requirements = ".*@gmail.com.*";
        Pattern pattern = Pattern.compile(requirements);
        Matcher match = pattern.matcher(email);
        boolean match_found = match.matches();

        if ((email.length() > 0) & (match_found) & (passe.length() > 0)){
                //The account does not exist or the account is entered incorrectly
                if (sql_queries.checkIfEmailAndPasswordIsInDatabase(email) == false){
                    incorrect.setText("That");
                }
                //Getting the Stage information
                Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
                Scene scene = new Scene(root);
                if (dark_theme(event)){
                    scene.getStylesheets().add(getClass().getResource("login_page.css").toExternalForm());
                }
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                User user = new User(email, passe, dark_mode.isSelected());
                stage.setUserData(user);
                stage.setScene(scene);
                stage.show();
        } else{
            incorrect.setText("Please use a gmail account");
            username.setText("");
            password.setText("");
        }
    }


    public void register(ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene scene = new Scene(root);
        if (dark_theme(event)){
            scene.getStylesheets().add(getClass().getResource("login_page.css").toExternalForm());
        }
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    //If the text box is checked, then dark mode is on
    public boolean dark_theme(ActionEvent event){
        Node node = (Node) event.getSource();
        Scene scene = node.getScene();
        if(dark_mode.isSelected() == true){
            scene.getStylesheets().add(getClass().getResource("login_page.css").toExternalForm());
            return true;
        }
        else if (dark_mode.isSelected() == false){
            scene.getStylesheets().clear();
            return false;
        }
        return false;
    }


}
