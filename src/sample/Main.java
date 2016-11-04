package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    protected Message messa_ref;
    protected Message messa_sif;
    //protected String decriptedM = FrequencyAnalyzer.decrypt(messa_sif,messa_ref);

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Florijan Klezin-Frekvenčna analiza");
        Scene mainScene = new Scene(root, 400, 375);



        Button saveFinalDatButton = (Button) mainScene.lookup("#saveFinalDatButton");
        Button runAnalyzerButton = (Button) mainScene.lookup("#runAnalyzerButton");

        Button loadSifDatButton = (Button) mainScene.lookup("#loadSifDatButton");
        TextArea sifDatContent = (TextArea) mainScene.lookup("#sifDatContent");
        loadSifDatButton.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String filePath=GUIFactory.openFileChooserGetFilePath(primaryStage);
                messa_sif = new Message(filePath);
                sifDatContent.setText(messa_sif.getOriginalText());
            }
        });

        Button loadRefDatButton = (Button) mainScene.lookup("#loadRefDatButton");
        TextArea refDatContent = (TextArea) mainScene.lookup("#refDatContent");
        loadRefDatButton.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String filePath=GUIFactory.openFileChooserGetFilePath(primaryStage);
                messa_ref = new Message(filePath);
                refDatContent.setText(messa_ref.getOriginalText());
            }
        });





        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


    public static void main(String[] args) {


        String a=Factory.changeTwoCharsInString('a','b',"ababcdcd");
        launch(args);

    }
}
