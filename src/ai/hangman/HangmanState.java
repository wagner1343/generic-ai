package ai.hangman;

public class HangmanState {
    public CharGuess[] guessedChars;

    public HangmanState( CharGuess[] guessedChars){
        this.guessedChars = guessedChars.clone();
    }

    @Override
    public boolean equals(Object o){
        HangmanState state2 = (HangmanState) o;

        for(int x = 0; x < 24; x++){
            if(guessedChars[x] != null && state2.guessedChars[x] == null){
                return  false;
            }
            if(state2.guessedChars[x] != null && guessedChars[x] == null){
                return false;
            }
        }

        return true;
    }
    @Override
    public String toString(){
        for(int x = 0; x < guessedChars.length; x++){

            if(guessedChars[x] != null ){
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
