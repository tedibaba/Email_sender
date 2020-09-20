package sample;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Clear {
    public static void empty(TextArea field){
        field.setText("");
    }
    public static void empty(TextField small){
        small.setText("");
    }
    public static void empty(PasswordField password){
        password.setText("");
    }
}
