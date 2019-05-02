package ai.hangman;

import java.util.ArrayList;

public class CharGuess {
    public int value;
    public ArrayList<Integer> position;

    public CharGuess(int value, ArrayList<Integer> position){
        this.value = value;
        this.position = position;
    }

    public CharGuess(){

    }

    public CharGuess clone() throws CloneNotSupportedException {
        super.clone();
        CharGuess charGuess2 = new CharGuess();
        charGuess2.value = this.value;
        charGuess2.position = new ArrayList<>();
        for(Integer i : position){
            charGuess2.position.add(i.intValue());
        }

        return charGuess2;
    }
}
