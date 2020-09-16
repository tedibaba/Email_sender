package sample;

import com.sun.glass.ui.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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


    public String Username(){
        return username.getText();
    }


}
