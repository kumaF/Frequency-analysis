package sample;

/**
 * Created by fklezin on 4.11.2016.
 */
public class Item implements Comparable<Item>{
    private Character letter;
    private Integer frequency;

    public Item(Character letter, int frequency) {
        this.letter = letter;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Item o) {
        return frequency.compareTo(o.getFrequency());
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }


}
