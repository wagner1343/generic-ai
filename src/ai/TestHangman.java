package ai;

import ai.hangman.CharGuess;
import ai.hangman.HangmanProblem;
import ai.hangman.HangmanState;
import ai.util.Movement;

import java.util.ArrayList;
import java.util.List;

public class TestHangman {
    public static void main(String[] args) {
        ArrayList<char[]> list = new ArrayList<>();
        list.add(new char[]{'w', 'a', 'g', 'n', 'e', 'r'});

        HangmanProblem hangmanProblem = new HangmanProblem(list);

        CharGuess[] guesses = hangmanProblem.charArrayToGuessArray(list.get(0));

        for(int x = 0; x < guesses.length; x++){

            if(guesses[x].position.size() != 0){
                System.out.println("x = " + x);
                System.out.println("(char) guesses[x].value = " + (char) guesses[x].value);

                for(int y = 0; y < guesses[x].position.size(); y++){
                    System.out.println("guesses[x].position.get(y) = " + guesses[x].position.get(y));
                }
            }
        }

        HangmanState initialState = hangmanProblem.getInitialState();

        List<Movement<HangmanState>> mappedMovementList = hangmanProblem.mapPossibleMovements(initialState);
        System.out.println("MappedMovementList:");
        for(Movement<HangmanState> m : mappedMovementList){
            System.out.println("From:");
            m.getFromState().toString();
            System.out.println();
            System.out.println("To");
            m.getToState().toString();
            System.out.println();
        }

    }
}
