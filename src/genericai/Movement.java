package genericai;

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


}
