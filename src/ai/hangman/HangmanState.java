package ai.hangman;

public class HangmanState {
    public CharGuess[] guessedChars;

    public HangmanState( CharGuess[] guessedChars){
        this.guessedChars = guessedChars.clone();
    }

    @Override
    public String toString(){
        for(int x = 0; x < guessedChars.length; x++){

            if(guessedChars[x] != null && guessedChars[x].position.size() != 0){
                System.out.println("x = " + x);
                System.out.println("(char) guesses[x].value = " + (char) guessedChars[x].value);

                for(int y = 0; y < guessedChars[x].position.size(); y++){
                    System.out.println("guesses[x].position.get(y) = " + guessedChars[x].position.get(y));
                }
            }
        }

        return "";
    }
}
