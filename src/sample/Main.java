package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    protected Message messa_ref;
    protected Message messa_sif;
    protected String decriptedMsg;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Florijan Klezin-Frekvenčna analiza");
        Scene mainScene = new Scene(root, 1000, 800);



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

        TextArea finalDat = (TextArea) mainScene.lookup("#finalDat");
        Button runAnalyzerButton = (Button) mainScene.lookup("#runAnalyzerButton");
        runAnalyzerButton.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                decriptedMsg=FrequencyAnalyzer.decrypt(messa_sif,messa_ref);
                finalDat.setText(decriptedMsg);
            }
        });


        Button changeButton = (Button) mainScene.lookup("#changeButton");
        TextField changeLet1 = (TextField) mainScene.lookup("#changeLet1");
        TextField changeLet2 = (TextField) mainScene.lookup("#changeLet2");
        changeButton.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                char first  = changeLet1.getText().charAt(0);
                char second = changeLet2.getText().charAt(0);
                decriptedMsg=Factory.changeTwoCharsInString(first,second,decriptedMsg);
                finalDat.setText(decriptedMsg);
            }
        });

        Button saveFinalDatButton = (Button) mainScene.lookup("#saveFinalDatButton");
        saveFinalDatButton.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //@TODO
                File newFile = GUIFactory.saveFileDialog(primaryStage);
                Factory.saveFile(decriptedMsg,newFile);
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
