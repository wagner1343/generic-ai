package ai.util;

public class Movement<TState> {
    public TState getFromState() {
        return fromState;
    }

    public TState getToState() {
        return toState;
    }

    private TState fromState;
    private TState toState;

    public Movement(TState fromState, TState toState) {
        this.fromState = fromState;
        this.toState = toState;
    }

    @Override
    public String toString(){
        String str = "";

        str = str.concat("From: " + fromState.toString() + "\n");
        str = str.concat("To: " + toState.toString());

        return str;
    }
}
