package sample;

import java.util.ArrayList;

/**
 * Created by fklezin on 3.11.2016.
 */
public class Message {
    private String originalText;
    private String text;
    private String decryptedText;
    private String filepath;
    private ArrayList<Item> frequencyList;


    public Message (String filepath){
        this.filepath = filepath;
        this.originalText = Factory.getFileContentString(this.filepath);
        this.text = originalText.toLowerCase();
        this.frequencyList = FrequencyAnalyzer.getCharFrequency(this.text);
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public ArrayList<Item> getFrequencyList() {
        return frequencyList;
    }

    public void setFrequencyList(ArrayList<Item> frequencyList) {
        this.frequencyList = frequencyList;
    }

    public String getDecryptedText() {
        return decryptedText;
    }

    public void setDecryptedText(String decryptedText) {
        this.decryptedText = decryptedText;
    }
}
