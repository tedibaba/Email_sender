package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login_page.fxml"));
            Parent root = loader.load();
            Scene scene1 = new Scene(root);
            primaryStage.setScene(scene1);
            primaryStage.setTitle("Email sender");
            primaryStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);

    }
}
