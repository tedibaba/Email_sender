package sample;

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

import javax.mail.PasswordAuthentication;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller_register {
    @FXML
    private Button register;
    @FXML
    private TextField username;
    @FXML
    private PasswordField passe;
    @FXML
    private Label exists;
    @FXML
    private Button returnToLoginPage;


    public void register(ActionEvent event) throws SQLException, IOException, AddressException {
        String email = username.getText();
        String password = passe.getText();
        //Making sure the email is a gmail one as this only works with gmail
        String requirements = ".*@gmail.com.*";
        Pattern pattern = Pattern.compile(requirements);
        Matcher match = pattern.matcher(email);
        boolean match_found = match.matches();


        if (sql_queries.checkIfEmailAndPasswordIsInDatabase(email) == false && (email.length() > 0) & (match_found) & (password.length() > 0)){
            sql_queries.register_email_and_password(email, password);
            Parent root = FXMLLoader.load(getClass().getResource("login_page.fxml"));
            Scene scene = new Scene(root);
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else {
            Clear.empty(username);
            Clear.empty(passe);
            exists.setText("That email has already been registered");
        }
    }

    // In case the user has accidentally clicked on register
    public void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login_page.fxml"));
        Scene scene = new Scene(root);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
