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

    @Override
    public boolean equals(Object o){
        CharGuess c2 = (CharGuess) o;
        if(value != c2.value)
            return false;
        if(!position.equals(c2.position)){
            return false;
        }

        return true;
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
