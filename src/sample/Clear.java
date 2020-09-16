package sample;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Clear {
    static void empty(TextArea field){
        field.setText("");
    }
    static void empty(TextField small){
        small.setText("");
    }
}
