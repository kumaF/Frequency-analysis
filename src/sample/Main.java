package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Florijan Klezin-Frekvenčna analiza");
        primaryStage.setScene(new Scene(root, 400, 375));
        primaryStage.show();
    }


    public static void main(String[] args) {

        Message messa_ref = new Message("1referencna_datoteka.txt");
        Message messa_sif = new Message("1sifrirana_datoteka.txt");
        String decriptedM = FrekvencniAnalizator.decrypt(messa_ref,messa_sif);

        launch(args);

    }
}
