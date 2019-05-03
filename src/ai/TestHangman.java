package ai;

import ai.hangman.CharGuess;
import ai.hangman.HangmanProblem;
import ai.hangman.HangmanState;
import ai.util.Movement;
import ai.util.MovementNode;
import ai.util.SearchResult;

import java.util.ArrayList;
import java.util.List;

public class TestHangman {
    public static void main(String[] args) {
        ArrayList<char[]> list = new ArrayList<>();
        list.add(new char[]{'w', 'a', 'g', 'n', 'e', 'r'});

        HangmanProblem hangmanProblem = new HangmanProblem(list);

        CharGuess[] guesses = hangmanProblem.charArrayToGuessArray(list.get(0));

        guesses.toString();

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

        MovementNode<HangmanState> result = AIAlgorithm.bfsAStar(hangmanProblem);

        System.out.println("Result:");
        for(HangmanState m : result.getResultStack()){
            System.out.println("Stack");
            m.toString();
            System.out.println();
        }

    }
}
