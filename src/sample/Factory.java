package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

    public static ArrayList<Integer> getIndexOfArray (String string,char character){
        ArrayList<Integer> indexesArray = new ArrayList<Integer>();

        int fromIndex=0;
        boolean dowhile = true;
        do {
            int indexOfChar=string.indexOf(character,fromIndex);

            if (indexOfChar==-1){
                dowhile=false;
                }
            else{
                indexesArray.add(indexOfChar);
                fromIndex=indexOfChar+1;
            }

        }while (dowhile);

        return indexesArray;
    }

    public static String changeTwoCharsInString(char first,char second,String string){
        StringBuilder newString = new StringBuilder(string);

        for (Integer index:Factory.getIndexOfArray(string,first)){
            newString.setCharAt(index,second);
        }
        for (Integer index:Factory.getIndexOfArray(string,second)){
            newString.setCharAt(index,first);
        }

        return newString.toString();
    }
}
