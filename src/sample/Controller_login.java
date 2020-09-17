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

    private Parent root;



    public void Change_scene_and_get_login_info(ActionEvent event) throws IOException {
        String email = username.getText();
        String pass = password.getText();

        //Making sure the email is a gmail one as this only works with gmail
        String requirements = ".*@gmail.*";
        Pattern pattern = Pattern.compile(requirements);
        Matcher match = pattern.matcher(email);
        boolean match_found = match.matches();

            if ((email.length() > 0) & (match_found) & (pass.length() > 0)){

                Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
                Scene scene = new Scene(root);

                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                User user = new User(email, pass);
                stage.setUserData(user);

                //Getting the Stage information

                stage.setScene(scene);
                stage.show();
        } else{
            incorrect.setText("Please use a gmail account");

            username.setText("");
            password.setText("");
        }
    }


    //If the text box is checked, then dark mode is on
    public void dark_theme(ActionEvent event){
        Node node = (Node) event.getSource();
        Scene scene = node.getScene();
        if(dark_mode.isSelected() == true){
            scene.getStylesheets().add(getClass().getResource("login_page.css").toExternalForm());
        }
        else if (dark_mode.isSelected() == false){
            scene.getStylesheets().clear();
        }
    }

    public String Username(){
        return username.getText();
    }


}
