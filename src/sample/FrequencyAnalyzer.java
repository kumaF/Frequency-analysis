package sample;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by fklezin on 3.11.2016.
 */
public class FrequencyAnalyzer {

    private static final char [] alphabetsLowercase = {'a','b','c','č','d','e','f','g','h','i','j','k','l','m','n','o','p','r','s','š','t','u','v','z','ž'};
    private final String alphabetsUppercase = "ABCČDEFGHIJKLMNOPRSŠTUVZŽ";

    public static ArrayList<Item> getCharFrequency(String text){

        ArrayList<Item> freqencyList = new ArrayList<Item>();

        for (int i=0 ; i< alphabetsLowercase.length ; i++){

            char letter = alphabetsLowercase[i];
            int frequency=0;
            frequency=StringUtils.countMatches(text, String.valueOf(letter));

            Item item = new Item(letter,frequency);
            freqencyList.add(item);
        }

        Collections.sort(freqencyList);
        return freqencyList;
    }

    public static String decrypt (Message encryptedMsg, Message referenceMsg){
        StringBuilder decryptedText= new StringBuilder(encryptedMsg.getText());


        for (int i=0 ; i<encryptedMsg.getFrequencyList().size(); i++){
            Character encLetter=encryptedMsg.getFrequencyList().get(i).getLetter();
            Character refLetter=referenceMsg.getFrequencyList().get(i).getLetter();

            for (Integer index:Factory.getIndexOfArray(encryptedMsg.getText(),encLetter)){
                decryptedText.setCharAt(index,refLetter);
            }



        }
        return decryptedText.toString();
    }

}
