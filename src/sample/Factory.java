package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by fklezin on 3.11.2016.
 */
public class Factory {

    public static String getFileContentString (String filepath){
        String content= new String();
        File file =new File(filepath);

        try {
            content = new Scanner(file).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            System.out.println("Can't read file");
            e.printStackTrace();
        }

        return content;
    }

    public static boolean saveTextToFile (String filepath,String text){

        try {
            PrintWriter out = new PrintWriter(filepath);
            out.println(text);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can't write to file");
            e.printStackTrace();
        }

        return true;
    }
}