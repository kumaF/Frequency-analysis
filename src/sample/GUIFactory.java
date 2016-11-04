package sample;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by fklezin on 4.11.2016.
 */
public class GUIFactory {

    public static String openFileChooserGetFilePath(Stage stage){

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Odpri datoteko");
        fileChooser.getExtensionFilters().addAll
                (
                        new FileChooser.ExtensionFilter("Text Files", "*.txt")
                );

        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            return  selectedFile.getAbsolutePath();
        }

        return "Error";
    }
}
