package ai.hangman;

import ai.ProblemWeighted;
import ai.util.Movement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HangmanProblem implements ProblemWeighted<HangmanState> {
    public static int FIRST_CHAR_CODE = 'a';
    public static int LAST_CHAR_CODE = FIRST_CHAR_CODE + 24;
    public List<char[]> wordList;
    public HangmanState finalState;

    public HangmanProblem(List<char[]> wordList){
        this.wordList = wordList;
        char[] finalStateWord = wordList.get(new Random().nextInt(wordList.size()));

        finalState = new HangmanState(charArrayToGuessArray(finalStateWord));
    }

    public CharGuess[] charArrayToGuessArray(char[] finalStateWord) {
        CharGuess[] guessArray = new CharGuess[LAST_CHAR_CODE - FIRST_CHAR_CODE];
        for(int x = 0; x < guessArray.length; x++){
            guessArray[x] = new CharGuess(FIRST_CHAR_CODE + x, new ArrayList<>() );
        }

        for(int y = 0; y < finalStateWord.length; y++){
            guessArray[finalStateWord[y] - FIRST_CHAR_CODE].position.add(y);
        }

        return guessArray;
    }

    @Override
    public int getWeight(HangmanState t) {
        int sum = 0;
        for(int x = 0; x < t.guessedChars.length; x++){
            if(t.guessedChars[x] != null)
                sum += t.guessedChars[x].position.size();
        }
        return sum;
    }

    @Override
    public HangmanState getInitialState() {
        CharGuess[] initialGuesses = new CharGuess[LAST_CHAR_CODE - FIRST_CHAR_CODE];
        for(int x = 0; x < initialGuesses.length; x++){
            initialGuesses[x] = null;
        }
        HangmanState initialState = new HangmanState(initialGuesses);
        return initialState;
    }

    @Override
    public boolean isFinalState(HangmanState hangmanState) {
        for(int x = 0; x < finalState.guessedChars.length; x++){
            if(finalState.guessedChars[x].position.size() != 0){
                if(hangmanState.guessedChars[x] == null){
                    return false;
                }
            }
        }
        return true;
    }



    @Override
    public List<Movement<HangmanState>> mapPossibleMovements(HangmanState hangmanState) {
        List<Movement<HangmanState>> movementList = new ArrayList<>();

        for(int x = 0; x < 24; x++){

            int guessCode = x;
            if(hangmanState.guessedChars[guessCode] == null){
                HangmanState newState = new HangmanState(hangmanState.guessedChars);
                newState.guessedChars[guessCode] = finalState.guessedChars[guessCode];
                movementList.add(new Movement<HangmanState>(hangmanState, newState));
            }

        }

        return movementList;
    }
}
